/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static helpers.Artist.*;
import static helpers.Clock.*;
import static data.Checkpoint.*;
import java.util.ArrayList;
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
    
    private ArrayList<Checkpoint> checkpoints;
    private int[] directions;
    
    public Enemy(Texture texture, Tile startTile, TileGrid grid, int width, int height, float speed) {
        
        this.texture = texture;
        this.startTile = startTile;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.grid = grid;
        
        this.checkpoints = new ArrayList<Checkpoint>();
        this.directions = new int[2];
        this.directions[0] = 0;
        this.directions[1] = 0;
        directions = findNextDirection(startTile);
    }
    
    
    public void update() {
        
        if(first == true)
            first = false;      // prevent first delta from being huge; set to false on first call
        else {
            
            x += delta() * directions[0];
            y += delta() * directions[1];
//            if(pathContinues()) {
//                x += delta() * speed;
//            }
        }
    }
    
    
    private Checkpoint findNextCheckpoint(Tile tile, int[] dir) {
        
        Tile next = null;
        Checkpoint checkpoint = null;
        boolean found = false;          // boolean to decide if next checkpoint is found
        int counter = 1;                // integer to increment each loop
        
        while(!found) {
            
            if(tile.getType() != grid.getTile(tile.getXPlace() + dir[0] * counter, tile.getYPlace() + dir[1] * counter).getType()) {
                
                found = true;
                counter -= 1;           // move counter back one to give the last tile of the previous type
                next = grid.getTile(tile.getXPlace() + dir[0] * counter, tile.getYPlace() + dir[1] * counter);
            }
            
            counter++;
        }
        checkpoint = new Checkpoint(next, dir[0], dir[1]);
        return checkpoint;
    }
    
    
    private int[] findNextDirection(Tile tile) {
        
        int[] dir = new int[2];
        
        Tile up =    grid.getTile(tile.getXPlace(), tile.getYPlace() - 1);
        Tile right = grid.getTile(tile.getXPlace() + 1, tile.getYPlace());
        Tile down =  grid.getTile(tile.getXPlace(), tile.getYPlace() + 1);
        Tile left =  grid.getTile(tile.getXPlace() - 1, tile.getYPlace());
        
        if(tile.getType() == up.getType()) {
            dir[0] = 0;
            dir[1] = -1;
        } else if(tile.getType() == right.getType()) {
            dir[0] = 1;
            dir[1] = 0;
        } else if(tile.getType() == down.getType()) {
            dir[0] = 0;
            dir[1] = 1;
        } else if(tile.getType() == left.getType()) {
            dir[0] = -1;
            dir[1] = 0;
        } else {
            System.out.println("NO DIRECTION FOUND");
        }
        
        return dir;
    }
    
    /*
    private boolean pathContinues() {
        
        boolean answer = true;
        
        Tile currentTile = grid.getTile((int) (x / 64), (int) (y / 64)); // every 64 pixels equals a new tile so x or y divided by 64 tells us which tile we're on
        Tile nextTile = grid.getTile((int) (x / 64) + 1, (int) (y / 64));
        
        if (currentTile.getType() != nextTile.getType()) {
            answer = false;
        }
            
        return answer;
    }
*/
    
    
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
