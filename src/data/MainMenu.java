package data;

import org.newdawn.slick.opengl.Texture;

import static helpers.Artist.*;
import helpers.StateManager;
import static helpers.StateManager.gameState;
import org.lwjgl.input.Mouse;
import ui.UI;

/**
 *
 * @author Keith
 */
public class MainMenu {

    private Texture background;
    private UI menuUI;

    public MainMenu() {

        background = quickLoad("mainmenu");
        menuUI = new UI();
        menuUI.addButton("Play", "playButton", WIDTH / 2 - 128, (int) (HEIGHT * 0.45f)); // last parameter places button 45% of the way down the screen
        menuUI.addButton("Editor", "editorButton", WIDTH / 2 - 128, (int) (HEIGHT * 0.55f));
        menuUI.addButton("Quit", "quitButton", WIDTH / 2 - 128, (int) (HEIGHT * 0.65f));
    }

    private void updateButtons() {

        if (Mouse.isButtonDown(0)) {
            if (menuUI.isButtonClicked("Play")) {
                StateManager.setState(gameState.GAME);
            }
            if (menuUI.isButtonClicked("Editor")) {
                StateManager.setState(gameState.EDITOR);
            }
            if (menuUI.isButtonClicked("Quit")) {
                System.exit(0);
            }
        }
    }

    
    // Check whether a button has been clicked by the user and perform accordingly
    public void update() {

        drawQuadTex(background, 0, 0, 2048, 1024);
        menuUI.draw();
        updateButtons();
    }
}
