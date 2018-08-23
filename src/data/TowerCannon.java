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
 * @author Keith
 */
public class TowerCannon {
    
    private float x, y, timeSinceLastShot, firingSpeed;
    private float firingAngle;
    private int width, height, damage;
    private Texture baseTexture, cannonTexture;
    private Tile startTile;
    private ArrayList<Projectile> projectiles;
    private ArrayList<Enemy> enemies;
    private Enemy target;
    
    
    public TowerCannon(Texture baseTexture, Tile startTile, int damage, ArrayList<Enemy> enemies) {
        
        this.baseTexture = baseTexture;
        this.cannonTexture = quickLoad("cannonGun");
        this.startTile = startTile;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.damage = damage;
        this.width = (int) startTile.getWidth();
        this.height = (int) startTile.getHeight();
        this.firingSpeed = 2;
        this.timeSinceLastShot = 0;
        this.projectiles = new ArrayList<Projectile>();
        this.enemies = enemies;
        this.target = acquireTarget();
        this.firingAngle = calculateAngle();
        
    }
    
    
    public void draw() {
        
        drawQuadTex(baseTexture, x, y, width, height);
        drawQuadTexRotate(cannonTexture, x, y, width, height, firingAngle);
    }
    
    
    private Enemy acquireTarget() {
        
        return enemies.get(0);
        
    }
    
    
    private float calculateAngle() {
        
        double angleTemp = Math.atan2(target.getY() - y, target.getX() - x);
        
        return (float) Math.toDegrees(angleTemp) - 90;
    }
    
    
    public void shoot() {
        
        timeSinceLastShot = 0;
        projectiles.add(new Projectile(quickLoad("bullet"), target, (x + (Game.TILE_SIZE / 2) - (Game.TILE_SIZE / 4)), y + ((Game.TILE_SIZE / 2) - (Game.TILE_SIZE / 4)), 900, 10));
        
    }    
        
    public void update() {
        
        timeSinceLastShot += delta();
        if(timeSinceLastShot > firingSpeed) {
            shoot();
        }
        
        for(Projectile p: projectiles) {
            p.update();
        }
        
        firingAngle = calculateAngle();
        draw();
    }

}
