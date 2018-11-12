package ui;

import static helpers.Artist.*;
import java.util.ArrayList;
import org.lwjgl.input.Mouse;

/**
 *
 * @author Keith
 */
public class UI {

    private ArrayList<Button> buttonList;
    private ArrayList<Menu> menuList;

    public UI() {

        buttonList = new ArrayList<>();
        menuList = new ArrayList<Menu>();
    }

    public void addButton(String name, String textureName, int x, int y) {

        buttonList.add(new Button(name, quickLoad(textureName), x, y));

    }

    public boolean isButtonClicked(String buttonName) {

        Button button = getButton(buttonName);
        float mouseY = HEIGHT - Mouse.getY() - 1;

        if (Mouse.getX() > button.getX() && Mouse.getX() < button.getX() + button.getWidth()
                && mouseY > button.getY() && mouseY < button.getY() + button.getHeight()) {
            return true;
        }
        return false;
    }

    private Button getButton(String buttonName) {

        for (Button b : buttonList) {
            if (b.getName().equals(buttonName)) {
                return b;
            }
        }
        return null;
    }

    public void createMenu(String name, int x, int y) {

        menuList.add(new Menu(name, x, y));
    }

    public Menu getMenu(String name) {

        for (Menu m : menuList) {
            if (name.equals(m.getName())) {
                return m;
            }
        }
        return null;
    }

    public void draw() {

        for (Button b : buttonList) {
            drawQuadTex(b.getTexture(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
        }
        for (Menu m : menuList) {
            m.draw();
        }
    }

    public class Menu {

        String name;
        private ArrayList<Button> menuButtons;
        private int x, y, buttonCount;      // tutorial uses buttonAmmount rather than buttonCount

        public Menu(String name, int x, int y) {

            this.name = name;
            this.x = x;
            this.y = y;
            this.buttonCount = 0;
            this.menuButtons = new ArrayList<Button>();
        }

        public void addButton(Button b) {

            b.setX(x + buttonCount * TILE_SIZE);        // place button
            buttonCount++;
            menuButtons.add(b);
        }

        public void draw() {

            for (Button b : menuButtons) {
                drawQuadTex(b.getTexture(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
            }
        }

        public String getName() {

            return name;
        }

        public boolean isButtonClicked(String buttonName) {

            Button button = getButton(buttonName);
            float mouseY = HEIGHT - Mouse.getY() - 1;

            if (Mouse.getX() > button.getX() && Mouse.getX() < button.getX() + button.getWidth()
                    && mouseY > button.getY() && mouseY < button.getY() + button.getHeight()) {
                return true;
            }
            return false;
        }

        private Button getButton(String buttonName) {

            for (Button b : menuButtons) {
                if (b.getName().equals(buttonName)) {
                    return b;
                }
            }
            return null;
        }
    }
}
