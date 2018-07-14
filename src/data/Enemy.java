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
    
    public Enemy(Texture texture, Tile startTile, int width, int height, float speed) {
        
        this.texture = texture;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.width = width;
        this.height = height;
        this.speed = speed;
        
        
    }
    
    
    public void update() {
        
        if(first == true)
            first = false;      // prevent first delta from being huge; set to false on first call
        else {
            x += delta() * speed;
    
        }
    }
    
    
    public void draw() {
        
        drawQuadTex(texture, x, y, width, height);
    }
}
