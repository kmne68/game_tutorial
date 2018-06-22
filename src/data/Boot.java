/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 *
 * @author kemery
 */
public class Boot {
    
    public Boot() {
        Display.setTitle("Tower Defense");
        
        try {
            Display.setDisplayMode(new DisplayMode(600, 400));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main (String[] args) {
        
        new Boot();
    }
}
