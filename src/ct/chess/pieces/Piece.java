package ct.chess.pieces;
public abstract class Piece
    {
        /*
        private String color;
        private String type;
        private int rowIndex;
        private int colIndex;
        */
        protected int pieceRow;
        protected int pieceCol;
        protected final Side pieceSide;
        protected final PieceType type;
        protected int offset;
        protected boolean pieceMoved;

        public Piece(int pieceRow, int pieceCol, int offset, final Side pieceSide, final PieceType type, final boolean
                     pieceMoved)
        {
            this.pieceSide = pieceSide;
            this.type = type;
            this.pieceRow = pieceRow;
            this.pieceCol = pieceCol;
            this.pieceMoved = pieceMoved;
            this.offset = offset;
        }

        public Side getSide()
        {
            return this.pieceSide;
        }

        public PieceType getType()
        {
            return this.type;
        }
        public int getPieceRow()
        {
            return this.pieceRow;
        }

        public void setPieceRow(int newRow)
        {
            this.pieceRow = newRow;
        }

        public int getPieceCol()
        {
            return this.pieceCol;
        }

        public void setPieceCol(int newCol)
        {
            this.pieceCol = newCol;
        }

        public int getOffSet()
        {
            return this.offset;
        }

        public void setOffSet(int newOffSet)
        {
            this.offset = newOffSet;
        }

        public boolean didPieceMove()
        {
            return this.pieceMoved;
        }

        public void setPieceMove(boolean pieceMoved)
        {
            this.pieceMoved = pieceMoved;
        }


       // public abstract List<Move> legalMovePath(final Board Board);



       /*
        public int getRow()
        {
            return rowIndex;
        }

        public void setRow(int r)
        {
            if(r <= 8)
            {
                rowIndex = r;
            }
            else
            {
                rowIndex = rowIndex;
            }
        }

        public int getCol()
        {
            return colIndex;
        }

        public void setCol(int c)
        {
            if(c <= 8)
            {
                colIndex = c;
            }
            else
            {
                colIndex = colIndex;
            }
        }

        public String getType()
        {
            return this.type;
        }

        public void setType(String newType)
        {

            this.type = newType;
        }

        public String getColor()
        {
            return this.color;
        }

        public void setColor(String newColor)
        {
            if(newColor.equalsIgnoreCase("Black") || newColor.equalsIgnoreCase("White"))
            {
                this.color = newColor;
            }
        }
    */





    }



