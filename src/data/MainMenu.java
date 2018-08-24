/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import org.newdawn.slick.opengl.Texture;

import static helpers.Artist.*;

/**
 *
 * @author Keith
 */
public class MainMenu {
    
    private Texture background;
    
    public MainMenu() {
        
        background = quickLoad("mainmenu");
    }
    
    
    public void update() {
        
        drawQuadTex(background, 0, 0, 2048, 1024);
    }
}
