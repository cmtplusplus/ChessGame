package ct.chess.pieces;

import ct.chess.game.Player;

public class Knight extends Piece
{

    public Knight(int row, int col,int offset, final Side pieceSide,
                  final PieceType type, final boolean pieceMoved)
    {
        super(row,col,offset,pieceSide,type, pieceMoved);
    }
    int i = this.getPieceRow();
    int j = this.getPieceCol();
    public int downright(int spaces, int destination, Player player)
    {
        if(spaces == 2)
        {
            if ((this.getPieceRow() - 2 >= 0) && (this.getPieceCol() + 1 < 8) &&
                    ((((this.getPieceRow() - 2) * 8) + ((this.getPieceCol() + 1)+1))) ==
                            destination)
            {
                this.setPieceRow(this.getPieceRow() - 2);
                this.setPieceCol(this.getPieceCol() + 1);
                this.setOffSet(destination);
                return this.getOffSet();
            }
            else
            {
                this.setPieceRow(this.getPieceRow());
                this.setPieceCol(this.getPieceCol());
                this.setOffSet(this.getOffSet());
                return -1;
            }
        }

        else
        {
            this.setPieceRow(this.getPieceRow());
            this.setPieceCol(this.getPieceCol());
            this.setOffSet(this.getOffSet());
            return -1;
        }
    }

    public int horizdownright(int spaces, int destination, Player player)
    {
        if(spaces == 2)
        {
            if ((this.getPieceRow() - 1 >= 0) && (this.getPieceCol() + 2 < 8) &&
                    ((((this.getPieceRow() - 1) * 8) + ((this.getPieceCol() + 2)+1))) ==
                            destination)
            {
                this.setPieceRow(this.getPieceRow() - 1);
                this.setPieceCol(this.getPieceCol() + 2);
                this.setOffSet(destination);
                return this.getOffSet();
            }
            else
            {
                this.setPieceRow(this.getPieceRow());
                this.setPieceCol(this.getPieceCol());
                this.setOffSet(this.getOffSet());
                return -1;
            }
        }

        else
        {
            this.setPieceRow(this.getPieceRow());
            this.setPieceCol(this.getPieceCol());
            this.setOffSet(this.getOffSet());
            return -1;
        }
    }

    public int horizupright(int spaces, int destination, Player player)
    {

        if(spaces == 2)
        {
            if ((this.getPieceRow() + 1 >= 0) && (this.getPieceCol() + 2 < 8) &&
                    ((((this.getPieceRow() + 1) * 8) + ((this.getPieceCol() + 2)+1))) ==
                            destination)
            {
                this.setPieceRow(this.getPieceRow() + 1);
                this.setPieceCol(this.getPieceCol() + 2);
                this.setOffSet(destination);
                return this.getOffSet();
            }
            else
            {
                this.setPieceRow(this.getPieceRow());
                this.setPieceCol(this.getPieceCol());
                this.setOffSet(this.getOffSet());
                return -1;
            }
        }

        else
        {
            this.setPieceRow(this.getPieceRow());
            this.setPieceCol(this.getPieceCol());
            this.setOffSet(this.getOffSet());
            return -1;
        }
    }

    public int horizupleft(int spaces, int destination, Player player)
    {
        if(spaces == 2)
        {
            if ((this.getPieceRow() + 1 >= 0) && (this.getPieceCol() - 2 >= 0) &&
                    ((((this.getPieceRow() + 1) * 8) + ((this.getPieceCol() - 2)+1))) ==
                            destination)
            {
                this.setPieceRow(this.getPieceRow() + 1);
                this.setPieceCol(this.getPieceCol() - 2);
                this.setOffSet(destination);
                return this.getOffSet();
            }
            else
            {
                this.setPieceRow(this.getPieceRow());
                this.setPieceCol(this.getPieceCol());
                this.setOffSet(this.getOffSet());
                return -1;
            }
        }

        else
        {
            this.setPieceRow(this.getPieceRow());
            this.setPieceCol(this.getPieceCol());
            this.setOffSet(this.getOffSet());
            return -1;
        }

    }

    public int horizdownleft(int spaces, int destination, Player player)
    {
        if(spaces == 2)
        {
            if ((this.getPieceRow() - 1 < 8) && (this.getPieceCol() - 2 >= 0) &&
                    ((((this.getPieceRow() - 1) * 8) + ((this.getPieceCol() - 2)+1))) ==
                            destination)
            {
                this.setPieceRow(this.getPieceRow() - 1);
                this.setPieceCol(this.getPieceCol() - 2);
                this.setOffSet(destination);
                return this.getOffSet();
            }
            else
            {
                this.setPieceRow(this.getPieceRow());
                this.setPieceCol(this.getPieceCol());
                this.setOffSet(this.getOffSet());
                return -1;
            }
        }

        else
        {
            this.setPieceRow(this.getPieceRow());
            this.setPieceCol(this.getPieceCol());
            this.setOffSet(this.getOffSet());
            return -1;
        }
    }

    public int downleft(int spaces, int destination, Player player)
    {
        if(spaces == 2)
        {
            if ((this.getPieceRow() - 2 < 8) && (this.getPieceCol() - 1 >= 0) &&
                    ((((this.getPieceRow() - 2) * 8) + ((this.getPieceCol() - 1)+1))) ==
                            destination)
            {
                this.setPieceRow(this.getPieceRow() - 2);
                this.setPieceCol(this.getPieceCol() - 1);
                this.setOffSet(destination);
                return this.getOffSet();
            }
            else
            {
                this.setPieceRow(this.getPieceRow());
                this.setPieceCol(this.getPieceCol());
                this.setOffSet(this.getOffSet());
                return -1;
            }
        }

        else
        {
            this.setPieceRow(this.getPieceRow());
            this.setPieceCol(this.getPieceCol());
            this.setOffSet(this.getOffSet());
            return -1;
        }
    }

    public int upright(int spaces, int destination, Player player)
    {
        if(spaces == 2)
        {
            if ((this.getPieceRow() + 2 < 8) && (this.getPieceCol() + 1 >= 0) &&
                    ((((this.getPieceRow() + 2) * 8) + ((this.getPieceCol() + 1)+1))) ==
                            destination)
            {
                this.setPieceRow(this.getPieceRow() + 2);
                this.setPieceCol(this.getPieceCol() + 1);
                this.setOffSet(destination);
                return this.getOffSet();
            }
            else
            {
                this.setPieceRow(this.getPieceRow());
                this.setPieceCol(this.getPieceCol());
                this.setOffSet(this.getOffSet());
                return -1;
            }
        }

        else
        {
            this.setPieceRow(this.getPieceRow());
            this.setPieceCol(this.getPieceCol());
            this.setOffSet(this.getOffSet());
            return -1;
        }
    }

    public int upleft(int spaces, int destination, Player player)
    {
        if(spaces == 2)
        {
            if ((this.getPieceRow() + 2 < 8) && (this.getPieceCol() - 1 >= 0) &&
                    ((((this.getPieceRow() + 2) * 8) + ((this.getPieceCol() - 1)+1))) ==
                            destination)
            {
                this.setPieceRow(this.getPieceRow() + 2);
                this.setPieceCol(this.getPieceCol() - 1);
                this.setOffSet(destination);
                return this.getOffSet();
            }
            else
            {
                this.setPieceRow(this.getPieceRow());
                this.setPieceCol(this.getPieceCol());
                this.setOffSet(this.getOffSet());
                return -1;
            }
        }

        else
        {
            this.setPieceRow(this.getPieceRow());
            this.setPieceCol(this.getPieceCol());
            this.setOffSet(this.getOffSet());
            return -1;
        }
    }






}
