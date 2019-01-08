package ct.chess.game;
import ct.chess.pieces.Piece;

public abstract class Tile
{

   protected final int tileLoc;
   protected final int tRow;
   protected final int  tCol;

/*
   public static Tile createOccupiedTile(final int tileLoc, final Piece piece)
   {
       return piece != null ? new OccupiedTile(tileLoc, piece) : EMPTY_TILES.get(tileLoc);
   }
*/
   public static Tile createEmptyTile(final int tRow, final int tCol, final int tileLoc)
   {
       return new EmptyTile(tRow,tCol,tileLoc);
   }

   public static Tile createOccupiedTile(final int tRow, final int tCol, final int tileLoc, Piece piece)
   {
       return new OccupiedTile(tRow,tCol,tileLoc,piece);
   }

   public int getTileRow()
   {
       return this.tRow;
   }

   public int getTileCol()
   {
       return this.tCol;
   }

   public int getTileOffSet()
   {
       return ((this.tRow*8)+((this.tCol)+1));
   }

    public Tile removePiece(int row, int col, Piece piece)
    {
        piece = null;
        EmptyTile eTile = new EmptyTile(row,col,((row*8)+(col+ 1)));
        return eTile;
    }

    public Tile addPiece(int row, int col, Piece piece)
    {
        OccupiedTile fTile = new OccupiedTile(row,col,((row*8)+(col+1)),piece);
        return fTile;
    }


    private Tile(int tRow, int tCol, int tileLoc)
    {
        this.tileLoc = tileLoc;
        this.tRow = tRow;
        this.tCol = tCol;

    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();



    public static final class EmptyTile extends Tile
    {
        private EmptyTile(final int tRow, final int tCol, final int tileLoc)
        {
            super(tRow, tCol,tileLoc);
        }

        @Override
        public boolean isTileOccupied()
        {
            return false;
        }

        @Override
        public Piece getPiece()
        {
            return null;
        }

       // @Override

    }

    public static final class OccupiedTile extends Tile
    {
       private final Piece pTile;
       private OccupiedTile(final int tRow, final int tCol, final int tileLoc, Piece pTile)
        {
            super(tRow,tCol,tileLoc);
            this.pTile = pTile;
        }

        @Override
        public boolean isTileOccupied()
        {
            return true;
        }
        @Override
        public Piece getPiece()
        {
            return this.pTile;
        }






    }



}
