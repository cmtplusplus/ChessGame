package ct.chess.pieces;

import ct.chess.game.Player;

public class Bishop extends Piece
{

    public Bishop(int row, int col, int offset, final Side pieceSide, final PieceType type, final boolean pieceMoved)
    {
        super(row,col, offset,pieceSide,type,pieceMoved);
    }
    int i = this.getPieceRow();
    int j = this.getPieceCol();

    public int diagonalupright(int spaces, int destination,Player player)
    {

      if((this.getPieceCol() + spaces < 8) && (this.getPieceRow() - spaces >= 0) &&
              ((((this.getPieceRow() - spaces) * 8) + ((this.getPieceCol() + spaces)+1))) ==
              destination)
      {
          this.setPieceCol(this.getPieceCol() + spaces);
          this.setPieceRow(this.getPieceRow() - spaces);
          this.setOffSet(destination);
          return this.getOffSet();
      }
      else if(spaces == 1 && this.getPieceCol() + 1 < 8 && this.getPieceRow() - 1 >= 0 &&
              ((player.getKingRow() * 8) + (player.getKingCol() + 1) == destination))
      {
          this.setPieceCol(this.getPieceCol() + 1);
          this.setPieceRow(this.getPieceRow() - 1);
          this.setOffSet((this.getPieceRow()*8) + (this.getPieceCol()+1));
          return this.getOffSet();
      }
      else
      {
          this.setPieceCol(this.getPieceCol());
          this.setPieceRow(this.getPieceRow());
          this.setOffSet(this.getOffSet());
          return -1;
      }
    }

    public int diagonalupleft(int spaces, int destination, Player player)
    {
        if((this.getPieceCol() - spaces >= 0) && (this.getPieceRow() - spaces >= 0) &&
                ((((this.getPieceRow() - spaces) * 8) + ((this.getPieceCol() - spaces)+1))) ==
            destination)
        {
            this.setPieceCol(this.getPieceCol() - spaces);
            this.setPieceRow(this.getPieceRow() - spaces);
            this.setOffSet(destination);
            return this.getOffSet();
        }
        else if(spaces == 1 && this.getPieceCol() - 1 >= 0 && this.getPieceRow() - 1 >= 0 &&
                ((player.getKingRow() * 8) + (player.getKingCol() + 1) == destination))
        {
            this.setPieceCol(this.getPieceCol() - 1);
            this.setPieceRow(this.getPieceRow() - 1);
            this.setOffSet((this.getPieceRow()*8) + (this.getPieceCol()+1));
            return this.getOffSet();
        }
        else
        {
            this.setPieceCol(this.getPieceCol());
            this.setPieceRow(this.getPieceRow());
            this.setOffSet(this.getOffSet());
            return -1;
        }
    }

    public int diagonaldownleft(int spaces, int destination, Player player)
    {
        if((this.getPieceRow() + spaces < 8) && (this.getPieceCol() - spaces >= 0) &&
                ((((this.getPieceRow() + spaces) * 8) + ((this.getPieceCol() - spaces)+1))) ==
                        destination)
        {
            this.setPieceCol(this.getPieceCol() - spaces);
            this.setPieceRow(this.getPieceRow() + spaces);
            this.setOffSet(destination);
            return this.getOffSet();
        }
        else if(spaces == 1 && this.getPieceCol() - 1 >= 0 && this.getPieceRow() + 1 < 8 &&
                ((player.getKingRow() * 8) + (player.getKingCol() + 1) == destination))
        {
            this.setPieceCol(this.getPieceCol() - 1);
            this.setPieceRow(this.getPieceRow() + 1);
            this.setOffSet((this.getPieceRow()*8) + (this.getPieceCol()+1));
            return this.getOffSet();
        }
        else
        {
            this.setPieceCol(this.getPieceCol());
            this.setPieceRow(this.getPieceRow());
            this.setOffSet(this.getOffSet());
            return -1;
        }
    }

    public int diagonaldownright(int spaces, int destination, Player player)
    {
        if((this.getPieceCol() + spaces < 8) && (this.getPieceRow() + spaces < 8) &&
                ((((this.getPieceRow() + spaces) * 8) + ((this.getPieceCol() + spaces)+1))) ==
                        destination)
        {
            this.setPieceCol(this.getPieceCol() + spaces);
            this.setPieceRow(this.getPieceRow() + spaces);
            this.setOffSet(destination);
            return this.getOffSet();
        }
        else if(spaces == 1 && this.getPieceCol() + 1 < 8 && this.getPieceRow() + 1 < 8 &&
                ((player.getKingRow() * 8) + (player.getKingCol() + 1) == destination))
        {
            this.setPieceCol(this.getPieceCol() + 1);
            this.setPieceRow(this.getPieceRow() + 1);
            this.setOffSet((this.getPieceRow()*8) + (this.getPieceCol()+1));
            return this.getOffSet();
        }
        else
        {
            this.setPieceCol(this.getPieceCol());
            this.setPieceRow(this.getPieceRow());
            this.setOffSet(this.getOffSet());
            return -1;
        }
    }


}
