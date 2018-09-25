package data;

import static helpers.Artist.quickLoad;
import static helpers.Artist.TILE_SIZE;

/**
 *
 * @author Keith
 */
public class Game {
    
    private TileGrid grid;
    private Player player;
    private WaveManager waveManager;
    private TowerCannonBlue blueTower;
    
    
    public Game(int[][] map){
        
        grid = new TileGrid(map);
        waveManager = new WaveManager(new Enemy(quickLoad("enemy"), grid.getTile(10, 8), grid, TILE_SIZE, TILE_SIZE, 70, 25), 2, 2);
        
        player = new Player(grid, waveManager);
        blueTower = new TowerCannonBlue(quickLoad("cannonBaseBlue"), 128, 128, 64, 64);
    }
    
    
    public void update() {
        
        grid.draw();
        blueTower.draw();
        waveManager.update();
        player.update();
//        tower.update();   // used in testing
    }
    
}
