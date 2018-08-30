/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import static helpers.Artist.*;
import java.util.ArrayList;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Keith
 */
public class UI {
    
    private ArrayList<Button> buttonList;
    
    
    public UI() {
        
        buttonList = new ArrayList<Button>();
    }
    
    public void addButton(String name, String textureName, int x, int y) {
        
        buttonList.add(new Button(name, quickLoad(textureName), x, y));
        
    }
    
    
    public boolean isButtonClicked(String buttonName) {
        
        Button button = getButton(buttonName);
        float mouseY = HEIGHT - Mouse.getY() - 1;
        
        if(Mouse.getX() > button.getX() && Mouse.getX() < button.getX() + button.getWidth() &&
                mouseY > button.getY() && mouseY < button.getY() + button.getHeight()) {
            return true;
        }
        return false;    
    }
    
    
    private Button getButton(String buttonName) {
        
        for(Button b : buttonList) {
            if(b.getName().equals(buttonName)) {
                return b;
            }
        }
        return null;
    }
    
    
    public void draw() {
        
        for(Button b : buttonList) {
            drawQuadTex(b.getTexture(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
        }
    }
}