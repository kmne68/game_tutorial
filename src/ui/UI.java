/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import static helpers.Artist.drawQuadTex;
import static helpers.Artist.quickLoad;
import java.util.ArrayList;
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
    
    
    public void draw() {
        
        for(Button b : buttonList) {
            drawQuadTex(b.getTexture(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
        }
    }
}
