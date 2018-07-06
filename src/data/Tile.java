/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author kemery
 */
public class Tile {
    
    private float x, y, width, height;
    private Texture texture;
    
    public Tile(float x, float y, float width, float height, Texture texture) {
        
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
                
    }
}
