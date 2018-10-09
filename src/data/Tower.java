package data;

import static helpers.Artist.TILE_SIZE;
import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.drawQuadTex;
import static helpers.Artist.drawQuadTexRotate;
import static helpers.Artist.quickLoad;
import static helpers.Clock.delta;
import java.util.ArrayList;

/**
 *
 * @author Keith
 */
public abstract class Tower implements Entity {

    private float x, y, timeSinceLastShot, firingSpeed, firingAngle;
    private int width, height;
    private Enemy target;
    private int damage;
    private Texture[] textures;
    private ArrayList<Enemy> enemies;
    private boolean targeted;
    private int range;
    private ArrayList<Projectile> projectiles;

    public Tower(TowerType type, Tile startTile, ArrayList<Enemy> enemies) {

        this.textures = type.textures;
        this.damage = type.damage;
        this.range = type.range;
        this.firingSpeed = type.firingSpeed;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.width = startTile.getWidth();
        this.height = startTile.getHeight();
        this.enemies = enemies;
        this.targeted = false;
        this.timeSinceLastShot = 0f;
        this.projectiles = new ArrayList<Projectile>();
        this.firingAngle = 0f;
    }

    private Enemy acquireTarget() {

        Enemy closest = null;
        float closestDistance = 10000;  // 10000 is an arbitrary distance within which all enemys should exist

        for (Enemy e : enemies) {
            if (isInRange(e) && (findDistance(e) < closestDistance)) {
                closestDistance = findDistance(e);
                closest = e;
            }
        }
        if (closest != null) {
            targeted = true;
        }
        return closest;
    }

    private float calculateAngle() {

        double angleTemp = Math.atan2(target.getY() - y, target.getX() - x);

        return (float) Math.toDegrees(angleTemp) - 90;
    }

    private boolean isInRange(Enemy e) {

        float xDistance = Math.abs(e.getX() - x);
        float yDistance = Math.abs(e.getY() - y);

        if (xDistance < range && yDistance < range) {
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

    public void shoot() {

        timeSinceLastShot = 0;
        projectiles.add(new ProjectileIceBall(quickLoad("bullet"), target, (x + (TILE_SIZE / 2) - (TILE_SIZE / 4)), y + ((TILE_SIZE / 2) - (TILE_SIZE / 4)), 32, 32, 900, 10));

    }

    public void updateEnemyList(ArrayList<Enemy> newList) {

        enemies = newList;
    }

    public void update() {

        if (!targeted) {
            target = acquireTarget();
        }

        if (target == null || target.isAlive() == false) {
            targeted = false;
        }

        timeSinceLastShot += delta();
        if (timeSinceLastShot > firingSpeed) {
            shoot();
        }

        for (Projectile p : projectiles) {
            p.update();
        }

        firingAngle = calculateAngle();
        draw();
    }

    public void draw() {
        
        drawQuadTex(textures[0], x, y, width, height);  // draw tower base
        if(textures.length > 1)
        for (int i = 1; i < textures.length; i++) {

            drawQuadTexRotate(textures[i], x, y, width, height, firingAngle);   // rotate subsequent textures (that are on top of base)
        }
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public Enemy getTarget() {
        return target;
    }

}
