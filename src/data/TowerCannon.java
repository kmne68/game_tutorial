/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static helpers.Artist.drawQuadTex;

import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Keith
 */
public class TowerCannon {
    
    private float x, y;
    private int width, height, damage;
    private Texture texture;
    private Tile startTile;
    
    
    public TowerCannon(Texture texture, Tile startTile, int damage) {
        
        this.texture = texture;
        this.startTile = startTile;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.damage = damage;
        this.width = (int) startTile.getWidth();
        this.height = (int) startTile.getHeight();
    }
    
    
    public void update() {
        
    }
    
    
    public void draw() {
        
        drawQuadTex(texture, x, y, width, height);
    }
}
