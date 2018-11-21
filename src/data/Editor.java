package data;

import static helpers.Artist.*;
import static helpers.Leveler.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import ui.UI;
import ui.UI.Menu;

/**
 *
 * @author Keith
 */
public class Editor {

    private TileGrid grid;
    private int index;
    private TileType[] types;
    private UI editorUI;
    private Menu tilePickerMenu;

    public Editor() {

        this.grid = LoadMap("C:\\Users\\Keith\\Documents\\NetBeansProjects\\game_tutorial\\NewMapToRead");

        this.index = 0;
        
        this.types = new TileType[3];
        this.types[0] = TileType.Grass;
        this.types[1] = TileType.Earth;
        this.types[2] = TileType.Water;
        setupUI();
    }
    
    
    private void setupUI() {
        
        editorUI = new UI();
        editorUI.createMenu("TilePicker", 1280, 100, 192, 960, 2, 0);
        tilePickerMenu = editorUI.getMenu("TilePicker");
        tilePickerMenu.quickAdd("Grass", "grass");
        tilePickerMenu.quickAdd("Earth", "earth");
        tilePickerMenu.quickAdd("Water", "water");
        
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

        draw();

        // Handle Mouse input
        if(Mouse.next()) {
            boolean mouseClicked = Mouse.isButtonDown(0);
            if(mouseClicked) {
                if(tilePickerMenu.isButtonClicked("Grass")) {
                    index = 0;
                } else if (tilePickerMenu.isButtonClicked("Earth")) {
                    index = 1;
                } else if (tilePickerMenu.isButtonClicked("Water")) {
                    index = 2;
                }
                else {
                    setTile();
                }
                
                
            }
        }

        // Handle Keyboard input
        while (Keyboard.next()) {
            if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
                moveIndex();
            }
            if (Keyboard.getEventKey() == Keyboard.KEY_S && Keyboard.getEventKeyState()) {
                SaveMap("NewMapToRead", grid);
                System.out.println("S Key pressed");
            }
        }
    }
    
    
    private void draw() {
        
        drawQuadTex(quickLoad("menu_background_editor"), 1280, 0, 192, 960);
        grid.draw();
        editorUI.draw();
    }
}
