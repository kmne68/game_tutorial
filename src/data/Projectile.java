package data;

import helpers.Artist;
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
    private float width, height;
    private float xVelocity, yVelocity;     // projectile velocity
    private float speed;
    private int damageAmount;
    private Enemy target;
    private boolean alive;

    public Projectile(Texture texture, Enemy target, float x, float y, float width, float height, float speed, int damageAmount) {

        this.texture = texture;
        this.target = target;
        this.alive = true;
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

    public void update() {

        if (alive) {

            x += xVelocity * speed * delta();
            y += yVelocity * speed * delta();
            if (checkCollision(x, y, width, height, target.getX(), target.getY(), target.getWidth(), target.getHeight())) {

                target.damage(damageAmount);
                // System.out.println("projectile hit the target");    
                alive = false;
            }

            draw();
        }
    }
}
