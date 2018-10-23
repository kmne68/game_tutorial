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
public class ProjectileCannonball extends Projectile{
    
   
    public ProjectileCannonball(ProjectileType type, Enemy target, float x, float y, int width, int height) {
        super(type, target, x, y, width, height);
    }
    
    
    @Override
    public void applyDamage() {
        // super.getTarget().setSpeed(4f);
        super.applyDamage();
    }
}
