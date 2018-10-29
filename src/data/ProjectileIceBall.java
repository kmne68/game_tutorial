package data;

/**
 *
 * @author Keith
 */
public class ProjectileIceBall extends Projectile {
    
    public ProjectileIceBall(ProjectileType type, Enemy target, float x, float y, int width, int height) {
        super(type, target, x, y, width, height);
    }
    
    
    @Override
    public void applyDamage() {
        super.getTarget().setSpeed(4f);
        super.applyDamage();
    }
}
