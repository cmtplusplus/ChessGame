package ct.chess.pieces;

import ct.chess.game.Player;

public class Rook extends Piece
{

    public Rook(int row, int col,int offset, final Side pieceSide,
                final PieceType type, final boolean pieceMoved)
    {
        super(row,col,offset,pieceSide,type, pieceMoved);
    }
    int i = this.getPieceRow();
    int j = this.getPieceCol();
    public int up(int spaces, int destination, Player player)
    {
        if ((this.getPieceRow() - spaces >= 0) &&
        ((((this.getPieceRow() - spaces) * 8) + ((this.getPieceCol())+1))) ==
                destination)
        {
            this.setPieceRow(this.getPieceRow() - spaces);
            this.setOffSet(destination);
            return this.getOffSet();
        }
        else if(spaces == 1 && this.getPieceRow() + 1 < 8 &&
                ((player.getKingRow() * 8) + (player.getKingCol() + 1) == destination))
        {
            this.setPieceRow(this.getPieceRow() + 1);
            this.setOffSet((this.getPieceRow()*8) + (this.getPieceCol()+1));
            return this.getOffSet();
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
        if ((this.getPieceRow() + spaces < 8) &&
        ((((this.getPieceRow() + spaces) * 8) + ((this.getPieceCol())+1))) ==
                destination)
        {
            this.setPieceRow(this.getPieceRow() + spaces);
            this.setOffSet(destination);
            return this.getOffSet();
        }
        else if(spaces == 1 && this.getPieceRow() - 1 >= 0 &&
                ((player.getKingRow() * 8) + (player.getKingCol() + 1) == destination))
        {
            this.setPieceRow(this.getPieceRow() - 1);
            this.setOffSet((this.getPieceRow()*8) + (this.getPieceCol()+1));
            return this.getOffSet();
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
        if((this.getPieceCol() + spaces < 8) &&
        ((((this.getPieceRow()) * 8) + ((this.getPieceCol() + spaces)+1))) ==
                destination)
        {
            this.setPieceCol(this.getPieceCol() + spaces);
            this.setOffSet(destination);
            return this.getOffSet();
        }
        else if(spaces == 1 && this.getPieceCol() + 1 < 8 &&
                ((player.getKingRow() * 8) + (player.getKingCol() + 1) == destination))
        {
            this.setPieceRow(this.getPieceCol() + 1);
            this.setOffSet((this.getPieceRow()*8) + (this.getPieceCol()+1));
            return this.getOffSet();
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
        if((this.getPieceCol() - spaces >= 0) &&
        ((((this.getPieceRow()) * 8) + ((this.getPieceCol() - spaces)+1))) ==
                destination)
        {
            this.setPieceCol(this.getPieceCol() - spaces);
            this.setOffSet(destination);
            return this.getOffSet();
        }
        else if(spaces == 1 && this.getPieceCol() - 1 >= 0 &&
                ((player.getKingRow() * 8) + (player.getKingCol() + 1) == destination))
        {
            this.setPieceRow(this.getPieceCol() - 1);
            this.setOffSet((this.getPieceRow()*8) + (this.getPieceCol()+1));
            return this.getOffSet();
        }
        else
        {
            this.setPieceCol(this.getPieceCol());
            this.setOffSet(this.getOffSet());
            return -1;
        }
    }
}
