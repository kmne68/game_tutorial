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
    private boolean leftMouseButtonDown, rightMouseButtonDown;
    public static int Funds, Lives;         // capitalized because they are static

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

    public void setup() {
        Funds = 50;
        Lives = 10;
    }

    public void update() {

        for (Tower t : towerList) {
            t.update();
            t.draw();
            t.updateEnemyList(waveManager.getCurrentWave().getEnemyList());
        }

        // handle Mouse input
        if (Mouse.isButtonDown(0) && !leftMouseButtonDown) {

            if (modifyFunds(-20)) {  // only place this tower if we have at least the amount in parenthesis in funds
                towerList.add(new TowerCannonBlue(TowerType.CannonBlue, grid.getTile(Mouse.getX() / TILE_SIZE, (HEIGHT - Mouse.getY() - 1) / TILE_SIZE), waveManager.getCurrentWave().getEnemyList()));
            }
        }
        if (Mouse.isButtonDown(1) && !rightMouseButtonDown) {

            if (modifyFunds(-55)) // only place this tower if we have at least the amount in parenthesis in funds
            {
                towerList.add(new TowerIce(TowerType.CannonIce, grid.getTile(Mouse.getX() / TILE_SIZE, (HEIGHT - Mouse.getY() - 1) / TILE_SIZE), waveManager.getCurrentWave().getEnemyList()));
            }
        }
        leftMouseButtonDown = Mouse.isButtonDown(0);        // this is used to ensure only one mouse click is registered per click
        rightMouseButtonDown = Mouse.isButtonDown(1);

        // handle Keyboard input
        while (Keyboard.next()) {
            if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
                //moveIndex();
                Clock.changeMultiplier(0.2f);
            }
            if (Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState()) {
                //moveIndex();
                Clock.changeMultiplier(-0.2f);
            }
        }
    }
}
