package data;

/**
 *
 * @author Keith
 */
public class WaveManager {
    
    private float timeSinceLastWave;
    private float timeBetweenEnemies;
    private int waveNumber;
    private int enemiesPerWave;
    private Enemy enemyType;
    private Wave currentWave;
    
    public WaveManager(Enemy enemyType, float timeBetweenEnemies, int enemiesPerWave) {
        
        this.enemyType = enemyType;
        this.enemiesPerWave = enemiesPerWave;
        this.timeBetweenEnemies = timeBetweenEnemies;
        this.timeSinceLastWave = 0;
        this.waveNumber = 0;
        
        this.currentWave = null;
        
        newWave();
    }
    
    
    public void update() {
        
        if(!currentWave.isCompleted()) {
            
            currentWave.update();
        } else {
            newWave();
        }
    }
    
    
    private void newWave() {
        
        currentWave = new Wave(enemyType, timeBetweenEnemies, enemiesPerWave);
        waveNumber++;
        System.out.println("Beginning wave: " + waveNumber);
    }
    
    
    public Wave getCurrentWave() {
        
        return currentWave;
    }

}
