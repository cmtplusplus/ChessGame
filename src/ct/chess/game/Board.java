package ct.chess.game;

import ct.chess.pieces.*;


public class Board {
    private static final int BOARDLENGTH = 8;
    public static Tile[][] Board = new Tile[BOARDLENGTH][BOARDLENGTH];


    public Board() {

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < BOARDLENGTH; j++) {
                int offSet = (i*8)+(j+1);
                Board[i][j] =  Tile.createOccupiedTile(i,j, offSet,new Pawn(i, j, offSet, Side.WHITE, PieceType.PAWN,false));

            }
        }

        for (int i = 6; i < 8; i++) {
            for (int j = 0; j < BOARDLENGTH; j++) {
                int offSet = (i*8)+(j+1);
                Board[i][j] = Tile.createOccupiedTile(i,j,offSet, new Pawn(i, j, offSet, Side.BLACK, PieceType.PAWN,false));
            }
        }

        Board[0][0] = Tile.createOccupiedTile(0,0,0, new Rook(0, 0, (0 * 8 + 0), Side.WHITE, PieceType.ROOK,false));
        Board[0][7] = Tile.createOccupiedTile(0,7,0 * 8 + 8, new Rook(0, 7, (0 * 8 + 8), Side.WHITE, PieceType.ROOK,false));
        Board[7][0] = Tile.createOccupiedTile(7,0,7 * 8 + 0, new Rook(7, 0, (7 * 8 + 0), Side.BLACK, PieceType.ROOK,false));
        Board[7][7] = Tile.createOccupiedTile(7,7,7 * 8 + 8, new Rook(7, 7, (7 * 8 + 8), Side.BLACK, PieceType.ROOK,false));

        Board[0][1] = Tile.createOccupiedTile(0,1,0 + 2, new Knight(0, 1, (0 * 8 + 2), Side.WHITE, PieceType.KNIGHT,false));
        Board[0][6] = Tile.createOccupiedTile(0,6,0 + 7, new Knight(0, 6, (0 * 8 + 7), Side.WHITE, PieceType.KNIGHT,false));
        Board[7][1] = Tile.createOccupiedTile(7,1,7 * 8 + 2, new Knight(7, 1, (7 * 8 + 2), Side.BLACK, PieceType.KNIGHT,false));
        Board[7][6] = Tile.createOccupiedTile(7,6,7 * 8 + 7, new Knight(7, 6, (7 * 8 + 7), Side.BLACK, PieceType.KNIGHT,false));

        Board[0][2] = Tile.createOccupiedTile(0,2,0 + 3, new Bishop(0, 2, (0 * 8 + 3), Side.WHITE, PieceType.BISHOP,false));
        Board[0][5] = Tile.createOccupiedTile(0,5,0 + 6, new Bishop(0, 5, (0 * 8 + 6), Side.WHITE, PieceType.BISHOP,false));
        Board[7][2] = Tile.createOccupiedTile(7,2,7 * 8 + 3, new Bishop(7, 2, (7 * 8 + 3), Side.BLACK, PieceType.BISHOP,false));
        Board[7][5] = Tile.createOccupiedTile(7,5,7 * 8 + 6, new Bishop(7, 5, (7 * 8 + 6), Side.BLACK, PieceType.BISHOP,false));

        Board[0][4] = Tile.createOccupiedTile(0,4,0 + 5, new King(0, 4, (0 * 8 + 5), Side.WHITE, PieceType.KING,false));
        Board[7][4] = Tile.createOccupiedTile(7,4,7 * 8 + 5, new King(7, 4, (7 * 8 + 5), Side.BLACK, PieceType.KING,false));

        Board[0][3] = Tile.createOccupiedTile(0,3,0 + 4, new Queen(0, 3, (0 * 8 + 4), Side.WHITE, PieceType.QUEEN,false));
        Board[7][3] = Tile.createOccupiedTile(7,3,7 * 8 + 4, new Queen(7, 3, (7 * 8 + 4), Side.BLACK, PieceType.QUEEN,false));

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < BOARDLENGTH; j++) {
                int offSet = (i*8)+(j+1);
                Board[i][j] = Tile.createEmptyTile(i,j,offSet);
            }
        }


    }
        public Tile[][] getBoard()
        {
            return Board;
        }






}
    /*
public class Board
{
    private static final int NUM_TILES = 64;
    private static Tile [] gameBoard;

    private Board(Builder builder)
    {
        this.gameBoard = createGameBoard(builder);
    }
    public Tile getTile(final int tileLoc)
    {
        return null;
    }

    private static Tile [] createGameBoard(final Builder builder)
    {
        for(int i = 0; i < NUM_TILES; i++)
        {
            gameBoard[i] =  Tile.createOccupiedTile(i, builder.boardSetup.get(i));
        }
        return gameBoard;

    }

    public static Board createStandardBoard()
    {
        final Builder builder = new Builder;

    }
    public static class Builder
    {
        Map<Integer,Piece> boardSetup;
        Side nextToMove;

        public Builder()
        {
            this.boardSetup = new HashMap<>();
        }

        public Builder setPiece(final Piece piece)
        {
            this.boardSetup.put(piece.getPiecePosition(), piece);
            return this;
        }

        public Builder setNextToMove(final Side side)
        {
            this.nextToMove = side;
            return this;
        }

        public Board build()
        {
            return new Board(this);
        }

    }

*/







