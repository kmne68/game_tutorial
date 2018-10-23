/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Keith
 */
public class TowerIce extends Tower {
    
    public TowerIce(TowerType type, Tile startTile, CopyOnWriteArrayList<Enemy> enemies) {
        super(type, startTile, enemies);
    }
    
    
    
    @Override
    public void shoot(Enemy target) {
        super.projectiles.add(new ProjectileIceBall(super.type.projectileType, super.target, super.getX(), super.getY(), 32, 32) );
    }
    
    
}
