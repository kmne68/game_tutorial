/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static helpers.Clock.delta;
import static helpers.Artist.*;
import org.newdawn.slick.opengl.Texture;


/**
 *
 * @author Keith
 */
public class Projectile {
    
    private Texture texture;
    private float x, y;
    private float speed;
    private int damage;
    
    
    public Projectile(Texture texture, float x, float y, float speed, int damage) {
        
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.damage = damage;
        
    }
    
    
    public void draw() {
        
        drawQuadTex(texture, x, y, 32, 32);
    }
    
    
    public void update() {
        
        x += delta() * speed;
        draw();
    }
}
