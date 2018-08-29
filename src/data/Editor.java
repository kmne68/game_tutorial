/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static helpers.Artist.HEIGHT;

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

        this.grid = new TileGrid();
        this.index = 0;
        
        this.types = new TileType[3];
        this.types[0] = TileType.Grass;
        this.types[1] = TileType.Earth;
        this.types[2] = TileType.Water;
    }

    private void moveIndex() {

        index++;
        if (index > types.length - 1) {

            index = 0;
        }
    }

    private void setTile() {

        grid.setTile((int) Math.floor(Mouse.getX() / 64),
                (int) Math.floor((HEIGHT - Mouse.getY() - 1) / 64), types[index]);
    }

    public void update() {

        grid.draw();

        // handle Mouse input
        if (Mouse.isButtonDown(0)) {

            setTile();
        }

        // handle Keyboard input
        while (Keyboard.next()) {
            if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
                moveIndex();
            }
            if (Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState()) {
                moveIndex();
            }
        }
    }
}
