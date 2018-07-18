/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

import static helpers.Clock.*;

/**
 *
 * @author Keith
 */
public class Wave {
    
    private float timeSinceLastSpawn;
    private float spawnTime;
    private Enemy enemyType;
    private ArrayList<Enemy> enemyList;
    
    public Wave(float spawnTime, Enemy enemyType) {
        
        this.enemyType = enemyType;
        this.spawnTime = spawnTime;
        timeSinceLastSpawn = 0;
        enemyList = new ArrayList<Enemy>();
        
    }
    
    
    public void update() {
        
        timeSinceLastSpawn += delta();
        
        if(timeSinceLastSpawn > spawnTime) {
            
            spawn();
            timeSinceLastSpawn = 0;
        }
        
        for (Enemy e : enemyList) {
            
            e.update();
            e.draw();
        }
    }
    
    
    private void spawn() {
        
        enemyList.add(new Enemy(enemyType.getTexture(), enemyType.getStartTile(), 64, 64, enemyType.getSpeed()));
    }
            
}
