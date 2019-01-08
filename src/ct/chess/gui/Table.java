package ct.chess.gui;

import ct.chess.game.*;
import ct.chess.pieces.Piece;
import ct.chess.pieces.PieceType;
import ct.chess.pieces.Side;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Table {
        private final JFrame gameFrame;
        private final BoardPanel boardPanel;
        private Color lightTileColor = Color.WHITE;
        private Color darkTileColor = Color.LIGHT_GRAY;
        private Color moveColor = Color.GREEN;
        private Color checkColor = Color.RED;
        private Color tileColor;
        private final Board chessboard;
        private Tile sourceTile;
        private Tile destinationTile;
        private Piece playerPiece;
        protected Player.BlackPlayer blackPlayer;
        protected Player.WhitePlayer whitePlayer;
        protected MoveChecker.CheckMove checkingMove;
        protected Move.Movement moveCheck;



        private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(600,600);
        private final static Dimension BOARD_PANEL_DIMENSION = new Dimension(400,350);
        private final static Dimension TILE_PANEL_DIMENSION = new Dimension(10,10);
        private static String defaultPieceImagePath = "chess pieces/";

        public Table()
        {

            blackPlayer = new Player.BlackPlayer(Side.BLACK,false,checkingMove, moveCheck);
            whitePlayer = new Player.WhitePlayer(Side.WHITE,true,checkingMove,moveCheck);

            this.gameFrame = new JFrame("CT Chess");
            this.gameFrame.setLayout(new BorderLayout());
            final JMenuBar tableMenuBar = createTableMenuBar();
            this.gameFrame.setJMenuBar(tableMenuBar);
            this.gameFrame.setSize(OUTER_FRAME_DIMENSION);
            chessboard = new Board();
            this.boardPanel = new BoardPanel();
            this.gameFrame.add(this.boardPanel,BorderLayout.CENTER);
            this.gameFrame.setVisible(true);


        }
        public JMenuBar createTableMenuBar()
        {
            final JMenuBar tableMenuBar = new JMenuBar();
            tableMenuBar.add(createOptionsMenu());
            return tableMenuBar;
        }

        public JMenu createOptionsMenu()
        {
            final JMenu optionsMenu = new JMenu("Options");
            final JMenuItem optionsReset = new JMenuItem("Reset");
            optionsReset.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    System.out.println("Give options to user");
                }
            });
            final JMenuItem exit = new JMenuItem("Exit");
            exit.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    System.exit(0);
                }
            });

            optionsMenu.add(optionsReset);
            optionsMenu.add(exit);
            return optionsMenu;
        }

        private class BoardPanel extends JPanel
        {
            final List<TilePanel> boardTiles;

            BoardPanel()
            {
                super(new GridLayout(8,8));
                this.boardTiles = new ArrayList<>();

                for(int i = 0; i < 8; i++)
                {
                    for(int j = 0; j < 8; j++)
                    {
                        final TilePanel tilePanel = new TilePanel(this, i,j,((8*i) + (j+1)), false);
                        this.boardTiles.add(tilePanel);
                        add(tilePanel);
                    }
                }

                setPreferredSize(BOARD_PANEL_DIMENSION);
                validate();
            }

            public void drawBoard(final Board board)
            {
                removeAll();
                for(final TilePanel tilePanel : boardTiles)
                {
                    tilePanel.drawTile(chessboard);
                    add(tilePanel);
                }
                validate();
                repaint();
            }
        }

        private class TilePanel extends JPanel {
            private final int tileOffSet;
            private final int rowCord;
            private final int colCord;
            private boolean clicked;

            TilePanel(final BoardPanel boardPanel, final int rowCord,
                      final int colCord, final int tileOffSet, boolean clicked)
            {
                super(new GridBagLayout());
                this.rowCord = rowCord;
                this.colCord = colCord;
                this.tileOffSet = tileOffSet;
                this.clicked = clicked;

                setPreferredSize(TILE_PANEL_DIMENSION);
                assignTileColor();
                assignTilePieceIcon();
                validate();

                addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(final MouseEvent e)
                    {
                     //first click
                        if(SwingUtilities.isRightMouseButton(e))
                        {
                            destinationTile = null;
                            sourceTile = null;
                            playerPiece = null;
                            TilePanel.this.setClickTile(false);
                        }
                        else if(SwingUtilities.isLeftMouseButton(e))
                        {
                            //DEBUG CODE HERE GETTING NULL POINTERS, PIECES NOT MOVING


                            if(chessboard.getBoard()[rowCord][colCord].isTileOccupied() == true && sourceTile == null)
                            {
                                sourceTile = chessboard.getBoard()[rowCord][colCord];
                                getTilePanel().setClickTile(true);
                                playerPiece = sourceTile.getPiece();
                            }
                            //second click
                            else if(sourceTile != null)
                            {
                                destinationTile = chessboard.getBoard()[rowCord][colCord];
                                getTilePanel().setClickTile(true);
                                //System.out.println(destinationTile.getTileOffSet());
                                if(whitePlayer.getTurn() == true && (sourceTile.getPiece().getSide() ==
                                        whitePlayer.getPlayerSide()))
                                {
                                    double oldDiagSpaces = 0;
                                    int spaces = (int)Math.round((Math.sqrt(Math.pow((Math.abs(destinationTile.getTileCol()-sourceTile.getTileCol())
                                    ),2) + Math.pow((Math.abs(destinationTile.getTileRow()-sourceTile.getTileRow())
                                    ),2))));
                                    double squareroot = Math.sqrt(Math.pow((destinationTile.getTileCol()-sourceTile.getTileCol()
                                    ),2) + Math.pow((destinationTile.getTileRow()-sourceTile.getTileRow()
                                    ),2));

                                    if(sourceTile.getPiece().getType() != PieceType.PAWN &&
                                            sourceTile.getPiece().getType() != PieceType.KNIGHT
                                            && sourceTile.getTileCol() != destinationTile.getTileCol()
                                            && sourceTile.getTileRow() != destinationTile.getTileRow()
                                            && spaces != 1)
                                    {
                                       spaces = Math.abs(destinationTile.getTileRow() - sourceTile.getTileRow());
                                    }

                                    playerPiece = sourceTile.getPiece();
                                    checkingMove = new MoveChecker.CheckMove(whitePlayer,playerPiece,spaces,destinationTile.getTileOffSet());
                                    whitePlayer.setMoveChecker(checkingMove);
                                    moveCheck = new Move.Movement(playerPiece,spaces, destinationTile.getTileOffSet());
                                    whitePlayer.setMovementCheck(moveCheck);
                                    whitePlayer.playerMove(playerPiece,spaces,sourceTile.getTileRow(),sourceTile.getTileCol(),
                                            destinationTile.getTileRow(), destinationTile.getTileCol(), destinationTile.getTileOffSet());
                                    whitePlayer.setTurn(false);
                                    blackPlayer.setTurn(true);
                                    playerPiece = null;
                                }
                                else if(whitePlayer.getTurn() == false && (sourceTile.getPiece().getSide() ==
                                    blackPlayer.getPlayerSide()) == true)
                                {
                                    int spaces = (int)Math.round((Math.sqrt(Math.pow((Math.abs(destinationTile.getTileCol()-sourceTile.getTileCol())
                                    ),2) + Math.pow((Math.abs(destinationTile.getTileRow()-sourceTile.getTileRow())
                                    ),2))));
                                    if(sourceTile.getPiece().getType() != PieceType.PAWN &&
                                            sourceTile.getPiece().getType() != PieceType.KNIGHT
                                            && sourceTile.getTileCol() != destinationTile.getTileCol()
                                            && sourceTile.getTileRow() != destinationTile.getTileRow()
                                            && spaces != 1)
                                    {
                                        spaces = Math.abs(destinationTile.getTileRow() - sourceTile.getTileRow());
                                    }

                                    playerPiece = sourceTile.getPiece();
                                    checkingMove = new MoveChecker.CheckMove(blackPlayer,playerPiece,spaces,destinationTile.getTileOffSet());
                                    blackPlayer.setMoveChecker(checkingMove);
                                    moveCheck = new Move.Movement(playerPiece,spaces, destinationTile.getTileOffSet());
                                    blackPlayer.setMovementCheck(moveCheck);

                                    blackPlayer.playerMove(playerPiece,spaces,sourceTile.getTileRow(),sourceTile.getTileCol(),
                                            destinationTile.getTileRow(), destinationTile.getTileCol(), destinationTile.getTileOffSet());
                                    blackPlayer.setTurn(false);
                                    whitePlayer.setTurn(true);
                                    playerPiece = null;
                                }



                            }


                        }
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                boardPanel.drawBoard(chessboard);
                            }
                        });

                    }

                    @Override
                    public void mousePressed(final MouseEvent e)
                    {

                    }

                    @Override
                    public void mouseReleased(final MouseEvent e)
                    {

                    }

                    @Override
                    public void mouseEntered(final MouseEvent e)
                    {

                    }

                    @Override
                    public void mouseExited(final MouseEvent e)
                    {

                    }
                });
            }
            public TilePanel getTilePanel()
            {
                return this;
            }

            public boolean isClicked()
            {
                return this.clicked;
            }

            public void setClickTile(boolean input)
            {
                this.clicked = input;
            }

            public void drawTile(final Board board)
            {


                //GETTING RUNTIME ERROR WITH THIS IF STATEMENT, FIGURE OUT HOW TO PROPERLY ACCESS
                //A TILE PANEL FROM UP ABOVE AND MODIFY IT


                if(this.isClicked() == true)
                {
                    if(sourceTile != null && this.colCord == sourceTile.getTileCol() &&
                            this.rowCord == sourceTile.getTileRow())
                    {
                        if(destinationTile != null)
                        {
                            assignTileColor();
                        }
                        else
                        {
                            this.setBackground(moveColor);
                        }
                    }
                    if(destinationTile != null && this.colCord == destinationTile.getTileCol() &&
                            this.rowCord == destinationTile.getTileRow())
                    {
                            this.setBackground(moveColor);
                            destinationTile = null;
                            sourceTile = null;

                    }


                    this.setClickTile(false);
                }
                else
                {
                    assignTileColor();
                }
                assignTilePieceIcon();


                validate();
                repaint();
            }
            private void assignTilePieceIcon()
            {
                this.removeAll();
                if(chessboard.getBoard()[this.rowCord][this.colCord].isTileOccupied() == true)
                {
                    try {
                        String pieceimages = "";
                        if(chessboard.getBoard()[this.rowCord][this.colCord].getPiece().getType() == PieceType.KNIGHT)
                        {
                            pieceimages = defaultPieceImagePath + chessboard.getBoard()[this.rowCord][this.colCord].getPiece()
                                    .getSide().toString().substring(0,1) + "N" +".gif";
                        }
                        else {
                            pieceimages = defaultPieceImagePath + chessboard.getBoard()[this.rowCord][this.colCord].getPiece().getSide().toString()
                                    .substring(0, 1) + chessboard.getBoard()[this.rowCord][this.colCord].getPiece().getType().toString().substring(0, 1) + ".gif";
                        }

                        final BufferedImage pieceImage = ImageIO.read(new File
                                (pieceimages));
                        add(new JLabel(new ImageIcon(pieceImage)));
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }


            private void assignTileColor() {

                if (Board.Board[this.rowCord][this.colCord].getTileRow() == 0||
                        Board.Board[this.rowCord][this.colCord].getTileRow() == 2 ||
                        Board.Board[this.rowCord][this.colCord].getTileRow() == 4 ||
                        Board.Board[this.rowCord][this.colCord].getTileRow() == 6)
                {
                    setBackground(this.tileOffSet % 2 != 0 ? lightTileColor : darkTileColor);
                }
                else if(Board.Board[this.rowCord][this.colCord].getTileRow() == 1 ||
                        Board.Board[this.rowCord][this.colCord].getTileRow() == 3 ||
                        Board.Board[this.rowCord][this.colCord].getTileRow() == 5 ||
                        Board.Board[this.rowCord][this.colCord].getTileRow() == 7)
                {
                    setBackground(this.tileOffSet % 2 == 0 ? lightTileColor : darkTileColor);
                }

            }
        }

    }





