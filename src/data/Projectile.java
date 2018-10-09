package data;

import helpers.Artist;
import static helpers.Clock.delta;
import static helpers.Artist.*;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Keith
 */
public abstract class Projectile implements Entity {

    private Texture texture;
    private float x, y;
    private int width, height;
    private float xVelocity, yVelocity;     // projectile velocity
    private float speed;
    private int damageAmount;
    private Enemy target;
    private boolean isBulletAlive;

    public Projectile(Texture texture, Enemy target, float x, float y, int width, int height, float speed, int damageAmount) {

        this.texture = texture;
        this.target = target;
        this.isBulletAlive = true;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.damageAmount = damageAmount;
        this.xVelocity = 0f;
        this.yVelocity = 0f;

        calculateDirection();

    }

    private void calculateDirection() {

        float totalAllowedMovement = 1.0f;
        // x and y are position of projectile
        float xDistanceFromTarget = Math.abs(target.getX() - x - (TILE_SIZE / 4) + TILE_SIZE / 2);
        float yDistanceFromTarget = Math.abs(target.getY() - y - (TILE_SIZE / 4) + TILE_SIZE / 2);
        float totalDistanceFromTarget = xDistanceFromTarget + yDistanceFromTarget;
        float xPercentOfMovement = xDistanceFromTarget / totalDistanceFromTarget;

        xVelocity = xPercentOfMovement;
        yVelocity = totalAllowedMovement - xPercentOfMovement;

        if (target.getX() < x) {
            xVelocity *= -1;        // the target is to our tower's left so shoot in the negative x direction (left)
        }
        if (target.getY() < y) {
            yVelocity *= -1;        // the target is above the tower so shoot in the negative y direction (up)
        }
    }

    public void draw() {

        drawQuadTex(texture, x, y, 32, 32);
    }

    // Tutorial calls this method simply 'damage'
    public void applyDamage() {

        target.damage(damageAmount);
        // System.out.println("projectile hit the target");    
        isBulletAlive = false;

    }

    public void update() {

        if (isBulletAlive) {

            x += xVelocity * speed * delta();
            y += yVelocity * speed * delta();
            if (checkCollision(x, y, width, height, target.getX(), target.getY(), target.getWidth(), target.getHeight())) {

                applyDamage();
            }

            draw();
        }
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }
    
    
    public Enemy getTarget() {
        return target;
    }
    
    
    public void setIsAlive(boolean status) {
        
        isBulletAlive = status;
         
    }
}
