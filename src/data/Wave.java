package data;

import static helpers.Clock.*;
import static helpers.Artist.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Keith
 */
public class Wave {

    private float timeSinceLastSpawn;
    private float spawnTime;
    private Enemy enemyType;
    private CopyOnWriteArrayList<Enemy> enemyList;
    private int enemiesPerWave, enemiesSpawned;
    private boolean waveCompleted;

    public Wave(Enemy enemyType, float spawnTime, int enemiesPerWave) {

        this.enemyType = enemyType;
        this.spawnTime = spawnTime;
        this.enemiesPerWave = enemiesPerWave;
        this.enemiesSpawned = 0;
        this.timeSinceLastSpawn = 0;
        this.enemyList = new CopyOnWriteArrayList<Enemy>();
        this.waveCompleted = false;

        spawn();
    }

    public void update() {

        // Assume all enemies are dead until live ones are detected
        boolean allEnemiesDead = true;

        if (enemiesSpawned < enemiesPerWave) {

            timeSinceLastSpawn += delta();

            if (timeSinceLastSpawn > spawnTime) {

                spawn();
                timeSinceLastSpawn = 0;
            }
        }
        for (Enemy e : enemyList) {

            if (e.isAlive()) {
                allEnemiesDead = false;
                e.update();
                e.draw();
            }
        }
        if(allEnemiesDead)
            waveCompleted = true;
    }

    private void spawn() {

        enemyList.add(new Enemy(enemyType.getTexture(), enemyType.getStartTile(), enemyType.getTileGrid(), TILE_SIZE, TILE_SIZE, enemyType.getSpeed(), enemyType.getHealth()));
        enemiesSpawned++;
    }

    public boolean isCompleted() {
        return waveCompleted;
    }

    
    public CopyOnWriteArrayList<Enemy> getEnemyList() {
        
        return enemyList;
    }
}
