package ct.chess.game;

import ct.chess.pieces.Piece;
import ct.chess.pieces.PieceType;
import ct.chess.pieces.Side;

public abstract class Player extends Board {


    protected boolean turn;
    protected Side playerSide;
    protected Piece playerPiece;
    protected MoveChecker.CheckMove moveChecker;
    protected Move.Movement  movementCheck;
    protected int bkingCol = 0;
    protected int bkingRow = 0;
    protected int wkingCol = 0;
    protected int wkingRow = 0;

    public Player(Side playerSide, boolean turn, MoveChecker.CheckMove moveChecker, Move.Movement movementCheck)
    {
        this.playerSide = playerSide;
        this.turn = turn;
        this.moveChecker = moveChecker;
        this.movementCheck = movementCheck;

        for(int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if(Board[i][j].isTileOccupied() == true && Board[i][j].getPiece().getType() == PieceType.KING
                        && Board[i][j].getPiece().getSide() == Side.BLACK)
                {
                    this.bkingCol = i;
                    this.bkingRow = j;
                }
               else if(Board[i][j].isTileOccupied() == true && Board[i][j].getPiece().getType() == PieceType.KING
                        && Board[i][j].getPiece().getSide() == Side.WHITE)
                {
                    this.wkingCol = i;
                    this.wkingRow = j;
                }
            }
        }
    }

    public int getKingRow()
    {
        if (this.getPlayerSide() == Side.BLACK)
        {
            return this.bkingRow;
        }
        else
        {
            return this.wkingRow;
        }
    }

    public int getKingCol()
    {
        if (this.getPlayerSide() == Side.BLACK)
        {
            return this.bkingCol;
        }
        else
        {
            return this.wkingCol;
        }
    }

    public boolean getTurn() {
        return turn;
    }
    public void setTurn(boolean turn)
    {
        if(turn == false)
        {
            this.turn = false;
        }
        else
        {
            this.turn = true;
        }
    }

    public void nextTurn() {
        if (this.getTurn() == true) {
            this.turn = false;
        } else {
            this.turn = true;
        }
    }

    public Side getPlayerSide()
    {
        return this.playerSide;
    }

    public void setPlayerSide(Side newPlayerSide)
    {
        this.playerSide = newPlayerSide;
    }

    public Player getPlayer()
    {
        return this;
    }

    public void setMoveChecker(MoveChecker.CheckMove newMoveChecker)
    {
        this.moveChecker = newMoveChecker;
    }

    public void setMovementCheck(Move.Movement newMovementCheck)
    {
        this.movementCheck = newMovementCheck;
    }

    public void playerMove( Piece playerPiece, final int spaces, int a, int b, int x,
                           int y, final int destination)
    {

        movementCheck.movePiece(playerPiece, spaces, a, b, x, y, destination,this);
        /*
        if(this.moveChecker.canMove(x,y) == true)
        {
            movementCheck.movePiece(playerPiece, spaces, a, b, x, y, destination);
        }
        else
        {
            System.out.println("invalid move");
        }
        */
    }



    public static final class BlackPlayer extends Player
    {
        public BlackPlayer(Side playerSide, boolean turn, MoveChecker.CheckMove moveChecker, Move.Movement movementCheck)
        {
            super(playerSide, turn, moveChecker, movementCheck);
            this.setTurn(false);
            this.setPlayerSide(Side.BLACK);
        }

        public int getBlackKingCol()
        {
            return this.bkingCol;
        }

        public void setBlackKingCol(int newKingCol)
        {
            this.bkingCol = newKingCol;
        }

        public int getBlackKingRow()
        {
            return this.bkingRow;
        }

        public void setBlackKingRow(int newKingRow)
        {
            this.bkingRow = newKingRow;
        }
    }

    public static final class WhitePlayer extends Player
    {
        public WhitePlayer(Side playerSide, boolean turn, MoveChecker.CheckMove moveChecker, Move.Movement movementCheck)
        {
            super(playerSide, turn, moveChecker, movementCheck);
            this.setTurn(true);
            this.setPlayerSide(Side.WHITE);
        }

        public int getWhiteKingCol()
        {
            return this.wkingCol;
        }

        public void setWhiteKingCol(int newKingCol)
        {
            this.wkingCol = newKingCol;
        }

        public int getWhiteKingRow()
        {
            return this.wkingRow;
        }

        public void setWhiteKingRow(int newKingRow)
        {
            this.wkingRow = newKingRow;
        }


    }

}
