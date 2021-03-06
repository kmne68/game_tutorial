package data;

import static helpers.Artist.*;
import static helpers.Clock.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Keith
 */
public class TowerCannon {
    
    private float x, y, timeSinceLastShot, firingSpeed;
    private float firingAngle;
    private int width, height, range;
    private Texture baseTexture, cannonTexture;
    private ArrayList<Projectile> projectiles;
    private CopyOnWriteArrayList<Enemy> enemies;
    private Enemy target;
    private boolean targeted;
    
    
    public TowerCannon(Texture baseTexture, Tile startTile, int damage, int range, CopyOnWriteArrayList<Enemy> enemies) {
        
        this.baseTexture = baseTexture;
        this.cannonTexture = quickLoad("cannonGunBlue");
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.range = range;
        this.width = (int) startTile.getWidth();
        this.height = (int) startTile.getHeight();
        this.firingSpeed = 2;
        this.timeSinceLastShot = 0;
        this.projectiles = new ArrayList<Projectile>();
        this.enemies = enemies;
        this.targeted = false;        
    }
    
    
    public void draw() {
        
        drawQuadTex(baseTexture, x, y, width, height);
        drawQuadTexRotate(cannonTexture, x, y, width, height, firingAngle);
    }
    
    
    private Enemy acquireTarget() {
        
        Enemy closest = null;
        float closestDistance = 10000;  // 10000 is an arbitrary distance within which all enemys should exist
        
        for(Enemy e: enemies) {
            if(isInRange(e) && (findDistance(e) < closestDistance)) {
                closestDistance = findDistance(e);
                closest = e;
            }           
        } 
        if(closest != null) {
            targeted = true;
        }
        return closest;
        
    }
    
    
    private boolean isInRange(Enemy e) {
        
        float xDistance = Math.abs(e.getX() - x);
        float yDistance = Math.abs(e.getY() - y);
        
        if(xDistance < range && yDistance < range) {
            return true;
        } else {
            return false;
        }       
    }
    
    
    private float findDistance(Enemy e) {
        
        float xDistance = Math.abs(e.getX() - x);
        float yDistance = Math.abs(e.getY() - y);
        
        return xDistance + yDistance;
    }
    
    
    private float calculateAngle() {
        
        double angleTemp = Math.atan2(target.getY() - y, target.getX() - x);
        
        return (float) Math.toDegrees(angleTemp) - 90;
    }
    
    
    public void shoot() {
        
        timeSinceLastShot = 0;
    //    projectiles.add(new ProjectileIceBall(quickLoad("bullet"), target, (x + (TILE_SIZE / 2) - (TILE_SIZE / 4)), y + ((TILE_SIZE / 2) - (TILE_SIZE / 4)), 32, 32, 900, 10));
        
    }    
    
    
    public void updateEnemyList(CopyOnWriteArrayList<Enemy> newList) {
        
        enemies = newList;
    }
    
        
    public void update() {
        
        if(!targeted) {
            target = acquireTarget();
        }
        
        if(target == null || target.isAlive() == false) {
            targeted = false;
        }
        
        
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
