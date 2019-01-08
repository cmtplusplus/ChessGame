package ct.chess.game;

import ct.chess.pieces.*;

public abstract class Move
{


    protected final Piece movePiece;
    protected final int spaces;
    protected final int destination;

    private Move(final Piece movePiece, final int spaces, final int destination)
    {

        this.movePiece = movePiece;
        this.spaces = spaces;
        this.destination = destination;

    }

    public static class Movement extends Move
    {
        public Movement(final Piece movePiece, final int spaces, final int destination)
        {
            super( movePiece, spaces, destination);
        }

        public void set(int x, int y, Piece piece) {
            Board.Board[x][y] = Board.Board[x][y].addPiece(x,y, piece);
        }

        public void remove(int x, int y, Piece piece) {
            Board.Board[x][y] = Board.Board[x][y].removePiece(x,y, piece);
        }

        public boolean movePiece(Piece movePiece, final int spaces, int a, int b, int x,
                              int y, final int destination, Player player) {
            boolean sidecheck = true;
            boolean destinationreached = false;
            if(Board.Board[x][y].isTileOccupied()== true)
            {
                if(Board.Board[x][y].getPiece().getSide() == Board.Board[a][b].getPiece().getSide())
                {
                    sidecheck = false;
                }
            }

            if (Board.Board[a][b].getPiece() != null && sidecheck == true)
            {

                movePiece = Board.Board[a][b].getPiece();

                if (movePiece.getType() == PieceType.PAWN) {
                    Pawn tPawn = new Pawn(movePiece.getPieceRow(), movePiece.getPieceCol(), movePiece.getOffSet(),
                            movePiece.getSide(), movePiece.getType(),false);
                    if (Board.Board[x][y].isTileOccupied() == true) {
                        if (tPawn.diagonalRight(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                            movePiece.setOffSet(destination);
                            movePiece.setPieceRow(x);
                            movePiece.setPieceCol(y);
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                            destinationreached = true;
                            tPawn = null;
                        } else if (tPawn.diagonalLeft(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                            movePiece.setOffSet(destination);
                            movePiece.setPieceRow(x);
                            movePiece.setPieceCol(y);
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                            destinationreached = true;
                            tPawn = null;
                        }

                    } else if (Board.Board[x][y].isTileOccupied() == false) {
                        if (tPawn.up(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                            movePiece.setOffSet(destination);
                            movePiece.setPieceRow(x);
                            movePiece.setPieceCol(y);
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                            destinationreached = true;
                            tPawn = null;
                        } else if (tPawn.doubleup(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                            movePiece.setOffSet(destination);
                            movePiece.setPieceRow(x);
                            movePiece.setPieceCol(y);
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                            destinationreached = true;
                            tPawn = null;
                        }
                    }
                } else if (movePiece.getType() == PieceType.KNIGHT) {

                    Knight tKnight = new Knight(movePiece.getPieceRow(), movePiece.getPieceCol(), movePiece.getOffSet(),
                            movePiece.getSide(), movePiece.getType(),false);
                    if (tKnight.horizdownleft(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tKnight = null;
                    } else if (tKnight.horizdownright(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tKnight = null;
                    } else if (tKnight.horizupright(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tKnight = null;
                    } else if (tKnight.horizupleft(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tKnight = null;
                    } else if (tKnight.upright(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tKnight = null;
                    } else if (tKnight.upleft(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tKnight = null;
                    }
                    else if (tKnight.downleft(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tKnight = null;
                    }
                    else if (tKnight.downright(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tKnight = null;
                    }
                }
                else if (movePiece.getType() == PieceType.BISHOP) {
                    Bishop tBishop = new Bishop(movePiece.getPieceRow(), movePiece.getPieceCol(), movePiece.getOffSet(),
                            movePiece.getSide(), movePiece.getType(),false);
                    if (tBishop.diagonaldownleft(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tBishop = null;
                    } else if (tBishop.diagonaldownright(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tBishop = null;
                    } else if (tBishop.diagonalupleft(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tBishop = null;
                    } else if (tBishop.diagonalupright(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tBishop = null;
                    }

                } else if (movePiece.getType() == PieceType.QUEEN) {
                    Queen tQueen = new Queen(movePiece.getPieceRow(), movePiece.getPieceCol(), movePiece.getOffSet(),
                            movePiece.getSide(), movePiece.getType(),false);
                    if (tQueen.up(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tQueen = null;
                    }

                    else if (tQueen.down(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tQueen = null;
                    }

                    else if (tQueen.left(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tQueen = null;
                    }

                    else if (tQueen.right(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tQueen = null;
                    }

                    else if (tQueen.diagonaldownleft(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tQueen = null;
                    }

                    else if (tQueen.diagonaldownright(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tQueen = null;
                    }

                    else if (tQueen.diagonalupleft(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tQueen = null;
                    }

                    else if (tQueen.diagonalupright(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tQueen = null;
                    }
                } else if (movePiece.getType() == PieceType.ROOK) {
                    Rook tRook = new Rook(movePiece.getPieceRow(), movePiece.getPieceCol(), movePiece.getOffSet(),
                            movePiece.getSide(), movePiece.getType(),false);
                    if (tRook.up(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tRook = null;
                    } else if (tRook.down(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tRook = null;
                    } else if (tRook.left(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tRook = null;
                    } else if (tRook.right(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tRook = null;
                    }
                } else if (movePiece.getType() == PieceType.KING) {
                    King tKing = new King(movePiece.getPieceRow(), movePiece.getPieceCol(), movePiece.getOffSet(),
                            movePiece.getSide(), movePiece.getType(),false);
                    if (tKing.up(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tKing = null;
                    } else if (tKing.down(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tKing = null;
                    } else if (tKing.left(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tKing = null;
                    } else if (tKing.right(spaces, destination, player) == Board.Board[x][y].getTileOffSet()) {
                        movePiece.setOffSet(destination);
                        movePiece.setPieceRow(x);
                        movePiece.setPieceCol(y);
                        if (Board.Board[x][y].isTileOccupied() == true) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        } else if (Board.Board[x][y].isTileOccupied() == false) {
                            remove(a, b, Board.Board[x][y].getPiece());
                            set(x, y, movePiece);
                        }
                        destinationreached = true;
                        tKing = null;
                    }
                }
                else {
                    System.out.println("You must select one of your pieces to move!");
                }

            }

            else
            {
                System.out.println("You must select one of your pieces to move!");
            }
            return destinationreached;
        }


    }









}
