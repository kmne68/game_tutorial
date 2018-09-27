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
    
    CannonRed(new Texture[]{quickLoad("cannonBase"), quickLoad("cannonGun")}, 10),
    CannonBlue(new Texture[]{quickLoad("cannonBaseBlue"), quickLoad("cannonGunBlue")}, 30);
    
    Texture[] textures;
    int damage;
   
    TowerType(Texture[] textures, int damage) {
        this.textures = textures;
        this.damage = damage;
    }
}
