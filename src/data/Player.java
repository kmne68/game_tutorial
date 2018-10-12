/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import org.lwjgl.input.Mouse;
import static helpers.Artist.*;
import helpers.Clock;
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
    private boolean leftMouseButtonDown;
    
    
    public Player(TileGrid grid, WaveManager waveManager) {
        
        this.grid = grid;
        this.types = new TileType[3];
        this.types[0] = TileType.Grass;
        this.types[1] = TileType.Earth;
        this.types[2] = TileType.Water;
        this.index = 0;
        this.waveManager = waveManager;
        this.towerList = new ArrayList<TowerCannon>();
        this.leftMouseButtonDown = false;
        
    }
    
    
    public void update() {
        
        for(TowerCannon tc : towerList) {
            tc.update();
        }
        
        // handle Mouse input
        if (Mouse.isButtonDown(0) && !leftMouseButtonDown) {
            
            towerList.add(new TowerCannon(quickLoad("cannonbase"), grid.getTile(Mouse.getX() / 64, (HEIGHT - Mouse.getY() - 1) / 64), 10, waveManager.getCurrentWave().getEnemyList()));
            // TEST LINE: System.out.println("Mouse button 0 down.");
            // setTile();
        }
        leftMouseButtonDown = Mouse.isButtonDown(0);        // this is used to ensure only one mouse click is registered per click
        
        
        // handle Keyboard input
        while(Keyboard.next()) {
            if(Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
                //moveIndex();
                Clock.changeMultiplier(0.2f);
            }
            if(Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState()) {
                //moveIndex();
                Clock.changeMultiplier(-0.2f);
            }
            if(Keyboard.getEventKey() == Keyboard.KEY_T && Keyboard.getEventKeyState()) {
                towerList.add(new TowerCannon(quickLoad("cannonbase"), grid.getTile(6, 14), 10, waveManager.getCurrentWave().getEnemyList()));
            }
                
        }
    }
}
