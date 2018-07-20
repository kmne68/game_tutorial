/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static helpers.Artist.*;
import static helpers.Clock.*;
import org.newdawn.slick.opengl.Texture;


/**
 *
 * @author kemery
 */
public class Enemy {
    
    private int width, height, health;
    private float speed, x, y;
    private Texture texture;
    private Tile startTile;
    private boolean first = true;
    private TileGrid grid;
    
    public Enemy(Texture texture, Tile startTile, TileGrid grid, int width, int height, float speed) {
        
        this.texture = texture;
        this.startTile = startTile;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.grid = grid;
        
    }
    
    
    public void update() {
        
        if(first == true)
            first = false;      // prevent first delta from being huge; set to false on first call
        else {
            if(pathContinues()) {
                x += delta() * speed;
            }
        }
    }
    
    
    private boolean pathContinues() {
        
        boolean answer = true;
        
        Tile currentTile = grid.getTile((int) (x / 64), (int) (y / 64)); // every 64 pixels equals a new tile so x or y divided by 64 tells us which tile we're on
        Tile nextTile = grid.getTile((int) (x / 64) + 1, (int) (y / 64));
        
        if (currentTile.getType() != nextTile.getType()) {
            answer = false;
        }
            
        return answer;
    }
    
    
    public void draw() {
        
        drawQuadTex(texture, x, y, width, height);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Tile getStartTile() {
        return startTile;
    }

    public void setStartTile(Tile startTile) {
        this.startTile = startTile;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }
    
    
    public TileGrid getTileGrid() {
        
        return this.grid;
    }
    
}
