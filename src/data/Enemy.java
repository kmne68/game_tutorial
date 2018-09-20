/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static helpers.Artist.*;
import static helpers.Clock.*;
import java.util.ArrayList;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author kemery
 */
public class Enemy implements Entity {

    private int width, height, health, currentCheckpoint;
    private float speed, x, y;
    private Texture texture;
    private Tile startTile;
    private boolean first = true;
    private boolean alive = true;
    private TileGrid grid;

    private ArrayList<Checkpoint> checkpoints;
    private int[] directions;

    public Enemy(Texture texture, Tile startTile, TileGrid grid, int width, int height, float speed, int health) {

        this.texture = texture;
        this.startTile = startTile;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.health = health;
        this.grid = grid;

        this.checkpoints = new ArrayList<Checkpoint>();
        this.directions = new int[2];
        this.directions[0] = 0;     // x direction
        this.directions[1] = 0;     // y direction
        this.currentCheckpoint = 0;
        directions = findNextDirection(startTile);
        this.currentCheckpoint = 0;
        populateCheckpointList();
    }

    public void update() {

        if (first == true) {
            first = false;      // prevent first delta from being huge; set to false on first call
        } else {

            if (checkpointReached()) {
                if (currentCheckpoint + 1 == checkpoints.size()) {
                    die();
                    System.out.println("Enemy reached end of maze.");
                } else {
                    currentCheckpoint++;
                }
            } else {

                x += delta() * checkpoints.get(currentCheckpoint).getxDirection() * speed;
                y += delta() * checkpoints.get(currentCheckpoint).getyDirection() * speed;
            }
        }
    }

    private boolean checkpointReached() {

        boolean reached = false;

        Tile tile = checkpoints.get(currentCheckpoint).getTile();

        // check whether enemy reached checkpoint within a variance of 3 
        if (x > tile.getX() - 3
                && x < tile.getX() + 3
                && y > tile.getY() - 3
                && y < tile.getY() + 3) {

            reached = true;
            x = tile.getX();
            y = tile.getY();
        }

        return reached;
    }

    private void populateCheckpointList() {

        // first checkpoint is a special case
        checkpoints.add(findNextCheckpoint(startTile, directions = findNextDirection(startTile)));

        // find remaining checkpoints
        int counter = 0;
        boolean cont = true;
        while (cont) {

            int[] currentDirection = findNextDirection(checkpoints.get(counter).getTile());
            // check if a next direction/checkpoint exists, end after 20 checkpoints (arbitrary)
            if (currentDirection[0] == 2 || counter == 20) {
                cont = false;
            } else {
                checkpoints.add(findNextCheckpoint(checkpoints.get(counter).getTile(),
                        directions = findNextDirection(checkpoints.get(counter).getTile())));
            }
            counter++;
        }
    }

    private Checkpoint findNextCheckpoint(Tile tile, int[] dir) {

        Tile next = null;
        Checkpoint checkpoint = null;
        boolean found = false;          // boolean to decide if next checkpoint is found
        int counter = 1;                // integer to increment each loop

        while (!found) {

            if (tile.getXPlace() + dir[0] * counter == grid.getTilesWide() ||
                    tile.getYPlace() + dir[1] * counter == grid.getTilesHigh() ||
                    tile.getType() != grid.getTile(tile.getXPlace() + dir[0] * counter, tile.getYPlace() + dir[1] * counter).getType()) {

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
        // find which direction we are going to head once we hit a checkpoint
        int[] dir = new int[2];

        Tile up = grid.getTile(tile.getXPlace(), tile.getYPlace() - 1);
        Tile right = grid.getTile(tile.getXPlace() + 1, tile.getYPlace());
        Tile down = grid.getTile(tile.getXPlace(), tile.getYPlace() + 1);
        Tile left = grid.getTile(tile.getXPlace() - 1, tile.getYPlace());

        if (tile.getType() == up.getType() && directions[1] != 1) {
            dir[0] = 0;
            dir[1] = -1;
        } else if (tile.getType() == right.getType() && directions[0] != -1) {
            dir[0] = 1;
            dir[1] = 0;
        } else if (tile.getType() == down.getType() && directions[1] != -1) {
            dir[0] = 0;
            dir[1] = 1;
        } else if (tile.getType() == left.getType() && directions[0] != 1) {
            dir[0] = -1;
            dir[1] = 0;
        } else {
            dir[0] = 2;
            dir[1] = 2;
        }

        return dir;
    }

 
    public void damage(int damageAmount) {
        
        health -= damageAmount;
        if(health <= 0) {
            die();
        }
    }
    
    
    private void die() {
        alive = false;
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
    
    public boolean isAlive() {
        
        return alive;
    }

}
