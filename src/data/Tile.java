package data;

import static helpers.Artist.*;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author kemery
 */
public class Tile {
    
    private float x, y;
    int width, height;
    private Texture texture;
    private TileType type;
    private boolean occupied;
    
    public Tile(float x, float y, int width, int height, TileType type) {
        
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
        this.texture = quickLoad(type.textureName);
        
        if(type.buildable) { occupied = false; }
        else { occupied = true; }
    }
    
    
    public void drawTile() {
        
        drawQuadTex(texture, x, y, width, height);
    }

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }
    
    
    // Adjust for tile width
    public int getXPlace() {
        
        return (int) x / TILE_SIZE;
    }
    
    
    // Adjust for tile height
    public int getYPlace() {
        
        return (int) y / TILE_SIZE;
    }
    

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the texture
     */
    public Texture getTexture() {
        return texture;
    }

    /**
     * @param texture the texture to set
     */
    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    /**
     * @return the type
     */
    public TileType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(TileType type) {
        this.type = type;
    }

    /**
     * @return the occupied
     */
    public boolean isOccupied() {
        return occupied;
    }

    /**
     * @param occupied the occupied to set
     */
    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }  

    
}
