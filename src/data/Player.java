/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import org.lwjgl.input.Mouse;
import static helpers.Artist.*;
import java.util.ArrayList;
import org.lwjgl.input.Keyboard;

/**
 *
 * @author Keith
 */
public class Player {
    
    private TileGrid grid;
    private TileType[] types;
    private int index;
    private WaveManager waveManager;
    private ArrayList<TowerCannon> towerList;
    
    
    public Player(TileGrid grid, WaveManager waveManager) {
        
        this.grid = grid;
        this.types = new TileType[3];
        this.types[0] = TileType.Grass;
        this.types[1] = TileType.Earth;
        this.types[2] = TileType.Water;
        this.index = 0;
        this.waveManager = waveManager;
        this.towerList = new ArrayList<TowerCannon>();
        
    }
    
    
    public void setTile() {
        
        grid.setTile((int) Math.floor(Mouse.getX() / 64), 
                (int) Math.floor((HEIGHT - Mouse.getY() - 1) / 64), types[index]);
    }
    
    
    public void update() {
        
        for(TowerCannon tc : towerList) {
            tc.update();
        }
        
        // handle Mouse input
        if (Mouse.isButtonDown(0)) {
            setTile();
        }
        
        // handle Keyboard input
        while(Keyboard.next()) {
            if(Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
                moveIndex();
            }
            if(Keyboard.getEventKey() == Keyboard.KEY_T && Keyboard.getEventKeyState()) {
                towerList.add(new TowerCannon(quickLoad("cannonbase"), grid.getTile(6, 14), 10, waveManager.getCurrentWave().getEnemyList()));
            }
                
        }
    }
    
    
    private void moveIndex() {
        
        index++;
        if(index > types.length - 1) {
            
            index = 0;
        }
    }
}
