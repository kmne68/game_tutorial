/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author kmne68
 */
public class EnemyUFO extends Enemy {
    
    public EnemyUFO(int tileX, int tileY, TileGrid grid) {
        super(tileX, tileY, grid);
        this.setTexture("enemy");
        this.setSpeed(80);
    }
    
}
