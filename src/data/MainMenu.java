/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import org.newdawn.slick.opengl.Texture;

import static helpers.Artist.*;
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
        menuUI.addButton("Play", "playButton", WIDTH / 2 - 128, (int)(HEIGHT * 0.45)); // last parameter places button 45% of the way down the screen

    }
    
    
    public void update() {
        
        drawQuadTex(background, 0, 0, 2048, 1024);
        menuUI.draw();
    }
}
