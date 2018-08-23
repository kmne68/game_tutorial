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
    private float xVelocity, yVelocity;     // projectile velocity
    private float speed;
    private int damage;
    private Enemy target;
    
    
    public Projectile(Texture texture, Enemy target, float x, float y, float speed, int damage) {
        
        this.texture = texture;
        this.target = target;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.damage = damage;
        this.xVelocity = 0f;
        this.yVelocity = 0f;
        
        calculateDirection();
        
    }
    
    
    private void calculateDirection() {
        
        float totalAllowedMovement = 1.0f;
        // x and y are position of projectile
        float xDistanceFromTarget = Math.abs(target.getX() - x - (Game.TILE_SIZE / 4) + Game.TILE_SIZE / 2);
        float yDistanceFromTarget = Math.abs(target.getY() - y - (Game.TILE_SIZE / 4) + Game.TILE_SIZE / 2);
        float totalDistanceFromTarget = xDistanceFromTarget + yDistanceFromTarget;
        float xPercentOfMovement = xDistanceFromTarget / totalDistanceFromTarget;
        
        xVelocity = xPercentOfMovement;
        yVelocity = totalAllowedMovement - xPercentOfMovement;
        
        if(target.getX() < x) {
            xVelocity *= -1;        // the target is to our tower's left so shoot in the negative x direction (left)
        }
        if(target.getY() < y) {
            yVelocity *= -1;        // the target is above the tower so shoot in the negative y direction (up)
        }
    }

    
    public void draw() {
        
        drawQuadTex(texture, x, y, 32, 32);
    }
    
    
    public void update() {
        
        x += xVelocity * speed * delta();
        y += yVelocity * speed * delta();
        draw();
    }
}
