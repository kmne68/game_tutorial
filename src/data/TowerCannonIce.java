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
public class TowerCannonIce extends Tower {
    
    public TowerCannonIce(TowerType type, Tile startTile, CopyOnWriteArrayList<Enemy> enemies) {
        super(type, startTile, enemies);
    }
    
    
    
    @Override
    public void shoot(Enemy target) {
        super.projectiles.add(new ProjectileIceBall(super.type.projectileType, super.target, super.getX(), super.getY(), 32, 32) );
        super.target.reduceHiddenHealth(super.type.projectileType.damage);
    }
   
}
