package ct.chess.game;

import ct.chess.pieces.*;


public abstract class MoveChecker
{


    protected Piece movePiece;
    protected Piece pKing;
    protected Piece attackP;
    protected final int spaces;
    protected final int destination;
    protected Player movePlayer;

    public  MoveChecker(Player player ,final Piece movePiece, final int spaces, final int destination)
    {

        this.movePiece = movePiece;
        this.spaces = spaces;
        this.destination = destination;
        this.movePlayer = player;
    }

    public static final class CheckMove extends MoveChecker
    {
        public CheckMove( Player player ,final Piece movePiece, final int spaces, final int destination)
        {
            super(player, movePiece, spaces, destination);
        }

        public boolean inCheck(Player player)
        {
            int kingDestination = (player.getKingRow() * 8 + (player.getKingCol() + 1));

            if(player.getTurn() == true)
            {
              for(int i = 0; i < 8; i++)
              {
                  for(int j = 0; j < 8; j++)
                  {
                      if(Board.Board[i][j].isTileOccupied() == true &&
                              Board.Board[i][j].getPiece().getSide() != player.getPlayerSide())
                      {
                          Piece enemyPiece = Board.Board[i][j].getPiece();

                          if(enemyPiece.getType() == PieceType.PAWN)
                          {
                              Pawn tPawn = new Pawn(enemyPiece.getPieceRow(), enemyPiece.getPieceCol(), enemyPiece.getOffSet(),
                                      enemyPiece.getSide(), enemyPiece.getType(),false);
                              if(tPawn.diagonalRight(1,kingDestination,player) == kingDestination)
                              {
                                  return true;
                              }
                              else if(tPawn.diagonalRight(1,kingDestination,player) == kingDestination)
                              {
                                  return true;
                              }

                          }
                          else if(enemyPiece.getType() == PieceType.BISHOP)
                          {
                              Bishop tBishop = new Bishop(enemyPiece.getPieceRow(), enemyPiece.getPieceCol(), enemyPiece.getOffSet(),
                                      enemyPiece.getSide(), enemyPiece.getType(),false);
                              while(tBishop.getPieceRow() < 8 && tBishop.getPieceCol() >= 0)
                              {
                                  if(Board.Board[tBishop.getPieceRow()][tBishop.getPieceCol()].isTileOccupied()
                                          == true && Board.Board[tBishop.getPieceRow()][tBishop.getPieceCol()].getPiece().getSide()
                                         == player.getPlayerSide())
                                  {
                                      break;
                                  }
                                  else
                                  {
                                      if(tBishop.diagonaldownleft(1, kingDestination,player) == kingDestination)
                                      {
                                          return true;
                                      }
                                  }
                              }
                              tBishop.setPieceRow(i);
                              tBishop.setPieceCol(j);
                              tBishop.setOffSet((i*8)+(j+1));
                              while(tBishop.getPieceRow() < 8 && tBishop.getPieceCol() < 8)
                              {
                                  if(Board.Board[tBishop.getPieceRow()][tBishop.getPieceCol()].isTileOccupied()
                                          == true && Board.Board[tBishop.getPieceRow()][tBishop.getPieceCol()].getPiece().getSide()
                                          == player.getPlayerSide())
                                  {
                                      break;
                                  }
                                  else
                                  {
                                      if(tBishop.diagonaldownright(1, kingDestination,player) == kingDestination)
                                      {
                                          return true;
                                      }
                                  }
                              }
                              tBishop.setPieceRow(i);
                              tBishop.setPieceCol(j);
                              tBishop.setOffSet((i*8)+(j+1));
                              while(tBishop.getPieceRow() >= 0 && tBishop.getPieceCol() >= 0)
                              {
                                  if(Board.Board[tBishop.getPieceRow()][tBishop.getPieceCol()].isTileOccupied()
                                          == true && Board.Board[tBishop.getPieceRow()][tBishop.getPieceCol()].getPiece().getSide()
                                          == player.getPlayerSide())
                                  {
                                      break;
                                  }
                                  else
                                  {
                                      if(tBishop.diagonalupleft(1, kingDestination,player) == kingDestination)
                                      {
                                          return true;
                                      }
                                  }
                              }
                              tBishop.setPieceRow(i);
                              tBishop.setPieceCol(j);
                              tBishop.setOffSet((i*8)+(j+1));
                              while(tBishop.getPieceRow() >= 0 && tBishop.getPieceCol() < 8)
                              {
                                  if(Board.Board[tBishop.getPieceRow()][tBishop.getPieceCol()].isTileOccupied()
                                          == true && Board.Board[tBishop.getPieceRow()][tBishop.getPieceCol()].getPiece().getSide()
                                          == player.getPlayerSide())
                                  {
                                      break;
                                  }
                                  else
                                  {
                                      if(tBishop.diagonalupright(1, kingDestination,player) == kingDestination)
                                      {
                                          return true;
                                      }
                                  }
                              }
                          }

                          else if(enemyPiece.getType() == PieceType.QUEEN)
                          {
                              Queen tQueen = new Queen(enemyPiece.getPieceRow(), enemyPiece.getPieceCol(), enemyPiece.getOffSet(),
                                      enemyPiece.getSide(), enemyPiece.getType(),false);
                              while(tQueen.getPieceRow() < 8 && tQueen.getPieceCol() >= 0)
                              {
                                  if(Board.Board[tQueen.getPieceRow()][tQueen.getPieceCol()].isTileOccupied()
                                          == true && Board.Board[tQueen.getPieceRow()][tQueen.getPieceCol()].getPiece().getSide()
                                          == player.getPlayerSide())
                                  {
                                      break;
                                  }
                                  else
                                  {
                                      if(tQueen.diagonaldownleft(1, kingDestination,player) == kingDestination)
                                      {
                                          return true;
                                      }
                                  }
                              }
                              tQueen.setPieceRow(i);
                              tQueen.setPieceCol(j);
                              tQueen.setOffSet((i*8)+(j+1));
                              while(tQueen.getPieceRow() < 8 && tQueen.getPieceCol() < 8)
                              {
                                  if(Board.Board[tQueen.getPieceRow()][tQueen.getPieceCol()].isTileOccupied()
                                          == true && Board.Board[tQueen.getPieceRow()][tQueen.getPieceCol()].getPiece().getSide()
                                          == player.getPlayerSide())
                                  {
                                      break;
                                  }
                                  else
                                  {
                                      if(tQueen.diagonaldownright(1, kingDestination,player) == kingDestination)
                                      {
                                          return true;
                                      }
                                  }
                              }
                              tQueen.setPieceRow(i);
                              tQueen.setPieceCol(j);
                              tQueen.setOffSet((i*8)+(j+1));
                              while(tQueen.getPieceRow() >= 0 && tQueen.getPieceCol() >= 0)
                              {
                                  if(Board.Board[tQueen.getPieceRow()][tQueen.getPieceCol()].isTileOccupied()
                                          == true && Board.Board[tQueen.getPieceRow()][tQueen.getPieceCol()].getPiece().getSide()
                                          == player.getPlayerSide())
                                  {
                                      break;
                                  }
                                  else
                                  {
                                      if(tQueen.diagonalupright(1, kingDestination,player) == kingDestination)
                                      {
                                          return true;
                                      }
                                  }
                              }
                              tQueen.setPieceRow(i);
                              tQueen.setPieceCol(j);
                              tQueen.setOffSet((i*8)+(j+1));
                              while(tQueen.getPieceRow() >= 0 && tQueen.getPieceCol() < 8)
                              {
                                  if(Board.Board[tQueen.getPieceRow()][tQueen.getPieceCol()].isTileOccupied()
                                          == true && Board.Board[tQueen.getPieceRow()][tQueen.getPieceCol()].getPiece().getSide()
                                          == player.getPlayerSide())
                                  {
                                      break;
                                  }
                                  else
                                  {
                                      if(tQueen.diagonalupleft(1, kingDestination,player) == kingDestination)
                                      {
                                          return true;
                                      }
                                  }
                              }
                              tQueen.setPieceRow(i);
                              tQueen.setPieceCol(j);
                              tQueen.setOffSet((i*8)+(j+1));
                              while(tQueen.getPieceRow() < 8)
                              {
                                  if(Board.Board[tQueen.getPieceRow()][tQueen.getPieceCol()].isTileOccupied()
                                          == true && Board.Board[tQueen.getPieceRow()][tQueen.getPieceCol()].getPiece().getSide()
                                          == player.getPlayerSide())
                                  {
                                      break;
                                  }
                                  else
                                  {
                                      if(tQueen.up(1, kingDestination,player) == kingDestination)
                                      {
                                          return true;
                                      }
                                  }
                              }
                              tQueen.setPieceRow(i);
                              tQueen.setPieceCol(j);
                              tQueen.setOffSet((i*8)+(j+1));
                              while(tQueen.getPieceRow() >= 0)
                              {
                                  if(Board.Board[tQueen.getPieceRow()][tQueen.getPieceCol()].isTileOccupied()
                                          == true && Board.Board[tQueen.getPieceRow()][tQueen.getPieceCol()].getPiece().getSide()
                                          == player.getPlayerSide())
                                  {
                                      break;
                                  }
                                  else
                                  {
                                      if(tQueen.down(1, kingDestination,player) == kingDestination)
                                      {
                                          return true;
                                      }
                                  }
                              }
                              tQueen.setPieceRow(i);
                              tQueen.setPieceCol(j);
                              tQueen.setOffSet((i*8)+(j+1));
                              while(tQueen.getPieceCol() < 8)
                              {
                                  if(Board.Board[tQueen.getPieceRow()][tQueen.getPieceCol()].isTileOccupied()
                                          == true && Board.Board[tQueen.getPieceRow()][tQueen.getPieceCol()].getPiece().getSide()
                                          == player.getPlayerSide())
                                  {
                                      break;
                                  }
                                  else
                                  {
                                      if(tQueen.right(1, kingDestination,player) == kingDestination)
                                      {
                                          return true;
                                      }
                                  }
                              }
                              tQueen.setPieceRow(i);
                              tQueen.setPieceCol(j);
                              tQueen.setOffSet((i*8)+(j+1));
                              while(tQueen.getPieceCol() >= 0)
                              {
                                  if(Board.Board[tQueen.getPieceRow()][tQueen.getPieceCol()].isTileOccupied()
                                          == true && Board.Board[tQueen.getPieceRow()][tQueen.getPieceCol()].getPiece().getSide()
                                          == player.getPlayerSide())
                                  {
                                      break;
                                  }
                                  else
                                  {
                                      if(tQueen.left(1, kingDestination,player) == kingDestination)
                                      {
                                          return true;
                                      }
                                  }
                              }
                              tQueen.setPieceRow(i);
                              tQueen.setPieceCol(j);
                              tQueen.setOffSet((i*8)+(j+1));

                          }

                          else if(enemyPiece.getType() == PieceType.KNIGHT)
                          {
                              Knight tKnight = new Knight(enemyPiece.getPieceRow(), enemyPiece.getPieceCol(), enemyPiece.getOffSet(),
                                      enemyPiece.getSide(), enemyPiece.getType(),false);
                              if(tKnight.downleft(2,kingDestination,player) == kingDestination)
                              {
                                  return true;
                              }
                              else if(tKnight.downright(2,kingDestination,player) == kingDestination)
                              {
                                  return true;
                              }
                              else if(tKnight.horizdownleft(2,kingDestination,player) == kingDestination)
                              {
                                  return true;
                              }
                              else if(tKnight.horizdownright(2,kingDestination,player) == kingDestination)
                              {
                                  return true;
                              }
                              else if(tKnight.horizupleft(2,kingDestination,player) == kingDestination)
                              {
                                  return true;
                              }
                              else if(tKnight.horizupright(2,kingDestination,player) == kingDestination)
                              {
                                  return true;
                              }
                              else if(tKnight.upleft(2,kingDestination,player) == kingDestination)
                              {
                                  return true;
                              }
                              else if(tKnight.upright(2,kingDestination,player) == kingDestination)
                              {
                                  return true;
                              }
                          }
                          else if(enemyPiece.getType() == PieceType.ROOK)
                          {
                              Rook tRook = new Rook(enemyPiece.getPieceRow(), enemyPiece.getPieceCol(), enemyPiece.getOffSet(),
                                      enemyPiece.getSide(), enemyPiece.getType(),false);
                              while(tRook.getPieceRow() < 8)
                              {
                                  if(Board.Board[tRook.getPieceRow()][tRook.getPieceCol()].isTileOccupied()
                                          == true && Board.Board[tRook.getPieceRow()][tRook.getPieceCol()].getPiece().getSide()
                                          == player.getPlayerSide())
                                  {
                                      break;
                                  }
                                  else
                                  {
                                      if(tRook.up(1, kingDestination,player) == kingDestination)
                                      {
                                          return true;
                                      }
                                  }
                              }
                              tRook.setPieceRow(i);
                              tRook.setPieceCol(j);
                              tRook.setOffSet((i*8)+(j+1));
                              while(tRook.getPieceRow() >= 0)
                              {
                                  if(Board.Board[tRook.getPieceRow()][tRook.getPieceCol()].isTileOccupied()
                                          == true && Board.Board[tRook.getPieceRow()][tRook.getPieceCol()].getPiece().getSide()
                                          == player.getPlayerSide())
                                  {
                                      break;
                                  }
                                  else
                                  {
                                      if(tRook.down(1, kingDestination,player) == kingDestination)
                                      {
                                          return true;
                                      }
                                  }
                              }
                              tRook.setPieceRow(i);
                              tRook.setPieceCol(j);
                              tRook.setOffSet((i*8)+(j+1));
                              while(tRook.getPieceCol() < 8)
                              {
                                  if(Board.Board[tRook.getPieceRow()][tRook.getPieceCol()].isTileOccupied()
                                          == true && Board.Board[tRook.getPieceRow()][tRook.getPieceCol()].getPiece().getSide()
                                          == player.getPlayerSide())
                                  {
                                      break;
                                  }
                                  else
                                  {
                                      if(tRook.right(1, kingDestination,player) == kingDestination)
                                      {
                                          return true;
                                      }
                                  }
                              }
                              tRook.setPieceRow(i);
                              tRook.setPieceCol(j);
                              tRook.setOffSet((i*8)+(j+1));
                              while(tRook.getPieceCol() >= 0)
                              {
                                  if(Board.Board[tRook.getPieceRow()][tRook.getPieceCol()].isTileOccupied()
                                          == true && Board.Board[tRook.getPieceRow()][tRook.getPieceCol()].getPiece().getSide()
                                          == player.getPlayerSide())
                                  {
                                      break;
                                  }
                                  else
                                  {
                                      if(tRook.left(1, kingDestination,player) == kingDestination)
                                      {
                                          return true;
                                      }
                                  }
                              }
                              tRook.setPieceRow(i);
                              tRook.setPieceCol(j);
                              tRook.setOffSet((i*8)+(j+1));

                          }
                          else if(enemyPiece.getType() == PieceType.KING)
                          {
                              King tKing = new King(enemyPiece.getPieceRow(), enemyPiece.getPieceCol(), enemyPiece.getOffSet(),
                                      enemyPiece.getSide(), enemyPiece.getType(),false);
                              if(tKing.up(1,kingDestination,player) == kingDestination)
                              {
                                  return true;
                              }
                              else if(tKing.down(1,kingDestination,player) == kingDestination)
                              {
                                  return true;
                              }
                              else if(tKing.left(1,kingDestination,player) == kingDestination)
                              {
                                  return true;
                              }
                              else if(tKing.right(1,kingDestination,player) == kingDestination)
                              {
                                  return true;
                              }
                              else if(tKing.diagonalDownLeft(1,kingDestination,player) == kingDestination)
                              {
                                  return true;
                              }
                              else if(tKing.diagonaldownRight(1,kingDestination,player) == kingDestination)
                              {
                                  return true;
                              }
                              else if(tKing.diagonalUpLeft(1,kingDestination,player) == kingDestination)
                              {
                                  return true;
                              }
                              else if(tKing.diagonalUpRight(1,kingDestination,player) == kingDestination)
                              {
                                  return true;
                              }
                          }
                      }
                  }
              }

            }
        return false;


        }

        public boolean canMove(int x1, int x2) {
            if (inCheck(this.movePlayer) == true) {
                return false;
            } else if (Board.Board[x1][x2].isTileOccupied() == true) {
                return false;
            } else if (x1 > 8 || x2 > 8) {
                return false;
            }
            return true;
        }



        public boolean checkmate() {
            if (this.movePlayer.getPlayerSide() == Side.WHITE) {
                if (inCheck(this.movePlayer) == true) {
                    for(int i = 0; i < 8; i++)
                    {
                        for(int j = 0; j < 8; j++)
                        {
                            if(Board.Board[i][j].getPiece().getType() == PieceType.KING &&
                                    Board.Board[i][j].getPiece().getSide() == Side.WHITE)
                            {
                                pKing = new King(i,j,((i*8)+(j+1)),Side.WHITE,PieceType.KING,false);
                                break;
                            }
                        }
                    }
                    //Check ct.chess.pieces.King's 8 possible moves to escape check.

                    //Check up
                    if (canMove(pKing.getPieceCol(), pKing.getPieceRow() + 1) == false) {
                        return true;
                    }
                    //Check horizontal left
                    else if (canMove(pKing.getPieceCol() - 1, pKing.getPieceRow()) == false) {
                        return true;
                    }
                    //Check horizontal right
                    else if (canMove(pKing.getPieceCol() + 1, pKing.getPieceRow()) == false) {
                        return true;
                    }
                    //Check down
                    else if (canMove(pKing.getPieceCol(), pKing.getPieceRow() - 1) == false) {
                        return true;
                    }
                    //Check diagonal up-right
                    else if (canMove(pKing.getPieceCol() + 1, pKing.getPieceRow() + 1) == false) {
                        return true;
                    }
                    //Check diagonal up-left
                    else if (canMove(pKing.getPieceCol() - 1, pKing.getPieceRow() + 1) == false) {
                        return true;
                    }
                    //Check diagonal down-left
                    else if (canMove(pKing.getPieceCol() - 1, pKing.getPieceRow() - 1) == false) {
                        return true;
                    }
                    //Check diagonal down-right
                    else if (canMove(pKing.getPieceCol() + 1, pKing.getPieceRow() - 1) == false) {
                        return true;
                    }
                }
            } else if (this.movePlayer.getPlayer().getPlayerSide() == Side.BLACK) {
                if (inCheck(this.movePlayer) == true) {
                    for(int i = 0; i < 8; i++)
                    {
                        for(int j = 0; j < 8; j++)
                        {
                            if(Board.Board[i][j].getPiece().getType() == PieceType.KING &&
                                    Board.Board[i][j].getPiece().getSide() == Side.BLACK)
                            {
                                pKing = new King(i,j,((i*8)+(j+1)),Side.BLACK,PieceType.KING,false);
                                break;
                            }
                        }
                    }
                    //Check ct.chess.pieces.King's 8 possible moves to escape check.

                    //Check up
                    if (canMove(pKing.getPieceCol(), pKing.getPieceRow() + 1) == false) {
                        return true;
                    }
                    //Check horizontal left
                    else if (canMove(pKing.getPieceCol() - 1, pKing.getPieceRow()) == false) {
                        return true;
                    }
                    //Check horizontal right
                    else if (canMove(pKing.getPieceCol() + 1, pKing.getPieceRow()) == false) {
                        return true;
                    }
                    //Check down
                    else if (canMove(pKing.getPieceCol(), pKing.getPieceRow() - 1) == false) {
                        return true;
                    }
                    //Check diagonal up-right
                    else if (canMove(pKing.getPieceCol() + 1, pKing.getPieceRow() + 1) == false) {
                        return true;
                    }
                    //Check diagonal up-left
                    else if (canMove(pKing.getPieceCol() - 1, pKing.getPieceRow() + 1) == false) {
                        return true;
                    }
                    //Check diagonal down-left
                    else if (canMove(pKing.getPieceCol() - 1, pKing.getPieceRow() - 1) == false) {
                        return true;
                    }
                    //Check diagonal down-right
                    else if (canMove(pKing.getPieceCol() + 1, pKing.getPieceRow() - 1) == false) {
                        return true;
                    }

                }
            }
            return false;

        }







    }





}
