package data;

/**
 *
 * @author Keith
 */
public class Checkpoint {
    
    private Tile tile;
    private int xDirection;
    private int yDirection;
    
    
    public Checkpoint(Tile tile, int xDirection, int yDirection) {
        
        this.tile = tile;
        this.xDirection = xDirection; // Direction from enemies current position to next checkpoint.
        this.yDirection = yDirection;
        
    }

    /**
     * @return the tile
     */
    public Tile getTile() {
        return tile;
    }

    /**
     * @param tile the tile to set
     */
    public void setTile(Tile tile) {
        this.tile = tile;
    }

    /**
     * @return the xDirection
     */
    public int getxDirection() {
        return xDirection;
    }

    /**
     * @param xDirection the xDirection to set
     */
    public void setxDirection(int xDirection) {
        this.xDirection = xDirection;
    }

    /**
     * @return the yDirection
     */
    public int getyDirection() {
        return yDirection;
    }

    /**
     * @param yDirection the yDirection to set
     */
    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
    }
    
    
    
}
