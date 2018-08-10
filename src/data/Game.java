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
    private Wave wave;
    
    // Temp variables
    TowerCannon tower;
    
    
    public Game(int[][] map){
        
        grid = new TileGrid(map);
        player = new Player(grid);
        wave = new Wave(20, new Enemy(quickLoad("enemy"), grid.getTile(10, 8), grid, 64, 64, 6));
        
        tower = new TowerCannon(quickLoad("cannonBase"), grid.getTile(10, 8), 10);
    }
    
    
    public void update() {
        
        grid.draw();
        wave.update();
        player.update();
        tower.update();
    }
    
}
