/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static helpers.Artist.quickLoad;

/**
 *
 * @author Keith
 */
public class Game {
    
    private TileGrid grid;
    private Player player;
    private WaveManager waveManager;
    public static final int TILE_SIZE = 64;
    
    // Temp variables
    // TowerCannon tower;
    
    
    public Game(int[][] map){
        
        grid = new TileGrid(map);
        waveManager = new WaveManager(new Enemy(quickLoad("enemy"), grid.getTile(10, 8), grid, 64, 64, 70, 25), 2, 2);
        
        player = new Player(grid, waveManager);
        
        
        // tower used for testing
//        tower = new TowerCannon(quickLoad("cannonBase"), grid.getTile(10, 8), 10);
    }
    
    
    public void update() {
        
        grid.draw();
        waveManager.update();
        player.update();
//        tower.update();   // used in testing
    }
    
}
