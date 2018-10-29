package data;

import static helpers.Artist.*;
import static helpers.Leveler.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

/**
 *
 * @author Keith
 */
public class Editor {

    private TileGrid grid;
    private int index;
    private TileType[] types;

    public Editor() {

        this.grid = loadMap("C:\\Users\\Keith\\Documents\\NetBeansProjects\\game_tutorial\\NewMapToRead");
    //    this.grid = loadMap("NewMapToRead");
        this.index = 0;
        
        this.types = new TileType[3];
        this.types[0] = TileType.Grass;
        this.types[1] = TileType.Earth;
        this.types[2] = TileType.Water;
    }

    
    // Allows editor to change which TileType is selected
    private void moveIndex() {

        index++;
        if (index > types.length - 1) {

            index = 0;
        }
    }

    
    private void setTile() {

        grid.setTile((int) Math.floor(Mouse.getX() / TILE_SIZE),
                (int) Math.floor((HEIGHT - Mouse.getY() - 1) / TILE_SIZE), types[index]);
    }

    
    public void update() {

        grid.draw();

        // Handle Mouse input
        if (Mouse.isButtonDown(0)) {

            setTile();
        }

        // Handle Keyboard input
        while (Keyboard.next()) {
            if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
                moveIndex();
            }
            if (Keyboard.getEventKey() == Keyboard.KEY_S && Keyboard.getEventKeyState()) {
                saveMap("NewMapToRead", grid);
                System.out.println("S Key pressed");
            }
        }
    }
}
