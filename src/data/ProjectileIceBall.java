/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Keith
 */
public class ProjectileIceBall extends Projectile {
    
    public ProjectileIceBall(Texture texture, Enemy target, float x, float y, int width, int height, float speed, int damageAmount) {
        super(texture, target, x, y, width, height, speed, damageAmount);
    }
    
    
    @Override
    public void applyDamage() {
        super.getTarget().setSpeed(4f);
        super.applyDamage();
    }
}
