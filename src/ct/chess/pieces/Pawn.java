package ct.chess.pieces;

import ct.chess.game.Board;
import ct.chess.game.Player;

public class Pawn extends Piece
{

    public Pawn(int row, int col,int offset, final Side pieceSide,
                final PieceType type, final boolean pieceMoved)
    {
        super(row,col,offset,pieceSide,type,pieceMoved);
    }
    int i = this.getPieceRow();
    int j = this.getPieceCol();

    public int up(int spaces, int destination, Player player)
    {
        if(spaces == 1)
        {
          if(this.getSide() == Side.WHITE)
          {
              if ((this.getPieceRow() + spaces < 8) && (((this.getPieceRow() + spaces) * 8) +
                      (this.getPieceCol()+1))== destination)
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
              if ((this.getPieceRow() - spaces >= 0) && (((this.getPieceRow() - spaces) * 8) +
                      (this.getPieceCol() + 1))== destination)
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
        }

        else
        {
            this.setPieceRow(this.getPieceRow());
            this.setOffSet(this.getOffSet());
            return -1;
        }
    }

    public int doubleup(int spaces, int destination, Player player)
    {
        if(spaces == 2)
        {
           if(this.getSide() == Side.WHITE)
           {
               if ((this.getPieceRow() + spaces < 8) && (((this.getPieceRow() + spaces)*8) +
                       (this.getPieceCol()+1)) ==
                       destination) {
                   this.setPieceRow(this.getPieceRow() + spaces);
                   this.setOffSet(destination);
                   return this.getOffSet();
               } else {
                   this.setPieceRow(this.getPieceRow());
                   this.setOffSet(this.getOffSet());
                   return -1;
               }
           }
           else
           {
               if ((this.getPieceRow() - spaces >= 0) && (((this.getPieceRow() - spaces) * 8) +
                       (this.getPieceCol()+1))==
                       destination) {
                   this.setPieceRow(this.getPieceRow() - spaces);
                   this.setOffSet(destination);
                   return this.getOffSet();
               } else {
                   this.setPieceRow(this.getPieceRow());
                   this.setOffSet(this.getOffSet());
                   return -1;
               }
           }
        }

        else
        {
            this.setPieceRow(this.getPieceRow());
            this.setOffSet(this.getOffSet());
            return -1;
        }
    }

    public int diagonalLeft(int spaces, int destination, Player player)
    {
        if(spaces == 1)
        {
            if(this.getSide() == Side.WHITE)
            {
                if ((this.getPieceRow() + spaces < 8) && (this.getPieceCol() + spaces < 8) &&
                        ((((this.getPieceRow() + spaces) * 8) + ((this.getPieceCol() + spaces)+1)) ==
                                destination)
                        && (Board.Board[i + spaces][j + spaces].isTileOccupied() != false))
                {
                    this.setPieceRow(this.getPieceRow() + spaces);
                    this.setPieceCol(this.getPieceCol() + spaces);
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
                if ((this.getPieceRow() - spaces >= 0) && (this.getPieceCol() - spaces >= 0) &&
                        ((((this.getPieceRow() - spaces)*8) + ((this.getPieceCol() - spaces)+1)) ==
                                destination)
                        && (Board.Board[i - spaces][j - spaces].isTileOccupied() != false))
                {
                    this.setPieceRow(this.getPieceRow() - spaces);
                    this.setPieceCol(this.getPieceCol() - spaces);
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

        }

        else
        {
            this.setPieceRow(this.getPieceRow());
            this.setOffSet(this.getOffSet());
            return -1;
        }


    }

    public int diagonalRight(int spaces, int destination, Player player)
    {
        if(spaces == 1)
        {
           if(this.getSide() == Side.WHITE)
           {
               if ((this.getPieceRow() + spaces < 8) && (this.getPieceCol() - spaces >= 0) &&
                       ((((this.getPieceRow() + spaces) * 8) + ((this.getPieceCol()-spaces)+1)) ==
                               destination)
                       && (Board.Board[i + spaces][j - spaces].isTileOccupied() != false))
               {
                   this.setPieceRow(this.getPieceRow() + spaces);
                   this.setPieceCol(this.getPieceCol() - spaces);
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
               if ((this.getPieceRow() - spaces >= 0) && (this.getPieceCol() + spaces < 8) &&
                       ((((this.getPieceRow() - spaces) * 8) + ((this.getPieceCol() + spaces)+1)) ==
                               destination)
                       && (Board.Board[i - spaces][j + spaces].isTileOccupied() != false))
               {
                   this.setPieceRow(this.getPieceRow() - spaces);
                   this.setPieceCol(this.getPieceCol() + spaces);
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

        }

        else
        {
            this.setPieceRow(this.getPieceRow());
            this.setOffSet(this.getOffSet());
            return -1;
        }


    }

}
