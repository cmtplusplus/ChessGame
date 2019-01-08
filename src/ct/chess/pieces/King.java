package ct.chess.pieces;

import ct.chess.game.Player;

public class King extends Piece
{

    public King(int row, int col, int offset, final Side pieceSide,
                final PieceType type, final boolean pieceMoved)
    {
        super(row,col,offset,pieceSide,type, pieceMoved);
    }
    int i = this.getPieceRow();
    int j = this.getPieceCol();
    public int up(int spaces, int destination, Player player)
    {
      if(spaces == 1)
      {
          if ((this.getPieceRow() + spaces < 8) && (this.getOffSet() + (spaces*8) ==
              destination))
          {
              this.setPieceRow(this.getPieceRow() + spaces);
              this.setOffSet(destination);
              return this.getOffSet();
          }
          else
          {
              this.setPieceRow(this.getPieceRow());
              this.setOffSet(this.getOffSet());
              return -1;
          }
      }

      else
      {
          this.setPieceRow(this.getPieceRow());
          this.setOffSet(this.getOffSet());
          return -1;
      }
    }

    public int down(int spaces, int destination, Player player)
    {
        if(spaces == 1)
        {
            if ((this.getPieceRow() - spaces >= 0) && (this.getOffSet() - (spaces*8) ==
                    destination))
            {
                this.setPieceRow(this.getPieceRow() - spaces);
                this.setOffSet(destination);
                return this.getOffSet();
            }
            else
            {
                this.setPieceRow(this.getPieceRow());
                this.setOffSet(this.getOffSet());
                return -1;
            }
        }

        else
        {
            this.setPieceRow(this.getPieceRow());
            this.setOffSet(this.getOffSet());
            return -1;
        }
    }

    public int right(int spaces, int destination, Player player)
    {
        if (spaces == 1)
        {
            if ((this.getPieceCol() + spaces < 8) && (this.getOffSet() + (spaces) ==
                    destination))
            {
                this.setPieceCol(this.getPieceCol() + spaces);
                this.setOffSet(destination);
                return this.getOffSet();
            }
            else
            {
                this.setPieceCol(this.getPieceCol());
                this.setOffSet(this.getOffSet());
                return -1;
            }
        }
        else
        {
            this.setPieceCol(this.getPieceCol());
            this.setOffSet(this.getOffSet());
            return -1;
        }
    }
    public int left(int spaces, int destination, Player player)
    {
        if (spaces == 1)
        {
            if ((this.getPieceCol() - spaces >= 0) && (this.getOffSet() - (spaces) ==
                destination))
            {
                this.setPieceCol(this.getPieceCol() - spaces);
                this.setOffSet(destination);
                return this.getOffSet();
            }
            else
            {
                this.setPieceCol(this.getPieceCol());
                this.setOffSet(this.getOffSet());
                return -1;
            }
        }
        else
        {
            this.setPieceCol(this.getPieceCol());
            this.setOffSet(this.getOffSet());
            return -1;
        }

    }

    public int diagonalUpLeft(int spaces, int destination, Player player)
    {
        if(spaces == 1)
        {

            if ((this.getPieceRow() + spaces < 8) && (this.getPieceCol() - spaces >= 0) &&
                    ((((this.getPieceRow() + spaces) * 8) + ((this.getPieceCol()-spaces)+1)) ==
                                destination))
            {
                this.setPieceRow(this.getPieceRow() + spaces);
                this.setPieceCol(this.getPieceCol() - spaces);
                this.setOffSet(destination);
                return this.getOffSet();
            }
            else {
                this.setPieceRow(this.getPieceRow());
                this.setOffSet(this.getOffSet());
                return -1;
            }


        }

        else
        {
            this.setPieceRow(this.getPieceRow());
            this.setOffSet(this.getOffSet());
            return -1;
        }


    }

    public int diagonalUpRight(int spaces, int destination, Player player)
    {
        if(spaces == 1)
        {

            if ((this.getPieceRow() + spaces < 8) && (this.getPieceCol() + spaces < 8) &&
                    ((((this.getPieceRow() + spaces) * 8) + ((this.getPieceCol()+spaces)+1)) ==
                            destination))
            {
                this.setPieceRow(this.getPieceRow() + spaces);
                this.setPieceCol(this.getPieceCol() + spaces);
                this.setOffSet(destination);
                return this.getOffSet();
            }
            else {
                this.setPieceRow(this.getPieceRow());
                this.setOffSet(this.getOffSet());
                return -1;
            }


        }

        else
        {
            this.setPieceRow(this.getPieceRow());
            this.setOffSet(this.getOffSet());
            return -1;
        }


    }

    public int diagonaldownRight(int spaces, int destination, Player player)
    {
        if(spaces == 1)
        {

            if ((this.getPieceRow() - spaces >= 0) && (this.getPieceCol() + spaces < 8) &&
                    ((((this.getPieceRow() - spaces) * 8) + ((this.getPieceCol()+spaces)+1)) ==
                            destination))
            {
                this.setPieceRow(this.getPieceRow() - spaces);
                this.setPieceCol(this.getPieceCol() + spaces);
                this.setOffSet(destination);
                return this.getOffSet();
            }
            else {
                this.setPieceRow(this.getPieceRow());
                this.setOffSet(this.getOffSet());
                return -1;
            }


        }

        else
        {
            this.setPieceRow(this.getPieceRow());
            this.setOffSet(this.getOffSet());
            return -1;
        }


    }

    public int diagonalDownLeft(int spaces, int destination, Player player)
    {
        if(spaces == 1)
        {

            if ((this.getPieceRow() - spaces >= 0) && (this.getPieceCol() - spaces >= 0) &&
                    ((((this.getPieceRow() - spaces) * 8) + ((this.getPieceCol()-spaces)+1)) ==
                            destination))
            {
                this.setPieceRow(this.getPieceRow() - spaces);
                this.setPieceCol(this.getPieceCol() - spaces);
                this.setOffSet(destination);
                return this.getOffSet();
            }
            else {
                this.setPieceRow(this.getPieceRow());
                this.setOffSet(this.getOffSet());
                return -1;
            }


        }

        else
        {
            this.setPieceRow(this.getPieceRow());
            this.setOffSet(this.getOffSet());
            return -1;
        }


    }
}
