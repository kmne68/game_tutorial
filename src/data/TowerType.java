/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static helpers.Artist.quickLoad;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Keith
 */
public enum TowerType {
    
    CannonRed(new Texture[]{quickLoad("cannonBase"), quickLoad("cannonGun")}, ProjectileType.CannonBall, 10, 1000, 3),
    CannonBlue(new Texture[]{quickLoad("cannonBaseBlue"), quickLoad("cannonGunBlue")}, ProjectileType.CannonBall,30, 1000, 3),
    CannonIce(new Texture[] {quickLoad("cannonIceBase"), quickLoad("cannonIceGun2")}, ProjectileType.IceBall, 30, 1000, 3);
    
    Texture[] textures;
    ProjectileType projectileType;
    int damage, range;
    float firingSpeed;
   
    TowerType(Texture[] textures, ProjectileType projectileType, int damage, int range, float firingSpeed) {
        this.textures = textures;
        this.projectileType = projectileType;
        this.damage = damage;
        this.range = range;
        this.firingSpeed = firingSpeed;
    }
}
