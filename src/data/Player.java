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
    private WaveManager waveManager;
    private ArrayList<Tower> towerList;
    private boolean leftMouseButtonDown, rightMouseButtonDown, holdingTower;
    public static int Funds, Lives;         // capitalized because they are static
    private Tower tempTower;

    
    public Player(TileGrid grid, WaveManager waveManager) {

        this.grid = grid;
        this.types = new TileType[3];
        this.types[0] = TileType.Grass;
        this.types[1] = TileType.Earth;
        this.types[2] = TileType.Water;
        this.waveManager = waveManager;
        this.towerList = new ArrayList<Tower>();
        this.leftMouseButtonDown = false;
        this.rightMouseButtonDown = false;
        this.tempTower = null;
        this.holdingTower = false;
        Funds = 0;
        Lives = 0;
    }

    
    public static boolean modifyFunds(int amount) {

        if (Funds + amount >= 0) {
            Funds += amount;
            System.out.println("Funds: " + Funds);
            
            return true;
        }        
        System.out.println("Funds: " + Funds);
        return false;
    }

    
    public static void modifyLives(int amount) {

        Lives += amount;
    }

    
    // Initialize Cash and Lives values for player
    public void setup() {
        Funds = 200;
        Lives = 10;
    }

    
    public void update() {
        
        // Update holding tower
        if(holdingTower) {
            
            tempTower.setX(getMouseTile().getX());
            tempTower.setY(getMouseTile().getY());
            tempTower.draw();
        }

        // Update all towers in the game
        for (Tower t : towerList) {
            t.update();
            t.draw();
            t.updateEnemyList(waveManager.getCurrentWave().getEnemyList());
        }

        // Handle Mouse input
        if (Mouse.isButtonDown(0) && !leftMouseButtonDown) {
           placeTower();
        }
        if (Mouse.isButtonDown(1) && !rightMouseButtonDown) {

            if (modifyFunds(-55)) // Only place this tower if we have at least the amount in parenthesis in funds
            {
                System.out.println("Right mouse button clicked.");
            }
        }
        leftMouseButtonDown = Mouse.isButtonDown(0);        // This is used to ensure only one mouse click is registered per click
        rightMouseButtonDown = Mouse.isButtonDown(1);

        // Handle Keyboard input
        while (Keyboard.next()) {
            if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
                Clock.changeMultiplier(0.2f);
            }
            if (Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState()) {
                Clock.changeMultiplier(-0.2f);
            }
        }
    }
    
    
    private void placeTower() {
        
        if(holdingTower) {
             if (modifyFunds(-20)) {  // Only place this tower if we have at least the amount in parenthesis in funds
                towerList.add(tempTower);
            }
        }
        holdingTower = false;
        tempTower = null;
    }
    
    
    public void pickTower(Tower t) {
        
        tempTower = t;
        holdingTower = true;
    }
    
    
    private Tile getMouseTile() {
        
        return grid.getTile(Mouse.getX() / TILE_SIZE, (HEIGHT - Mouse.getY() - 1) / TILE_SIZE);
    }

}
