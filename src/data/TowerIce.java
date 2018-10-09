/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author Keith
 */
public class TowerIce extends Tower {
    
    public TowerIce(TowerType type, Tile startTile, ArrayList<Enemy> enemies) {
        super(type, startTile, enemies);
    }
    
    
//    @Override
//    public void shoot() {
//        super.shoot();  // first, do the regular shooting stuff        
//        super.getTarget().setSpeed(4);
//    }
    
}
