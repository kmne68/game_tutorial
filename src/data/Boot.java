/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

import static helpers.Artist.*;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author kemery
 */
public class Boot {
    
//    private static int WIDTH = 400;
//    private static int HEIGHT = 600;
    
    public Boot() {

        BeginSession();
        
//        float x = 100;
//        float y = 100;
//        float width = 50;
//        float height = 50;
    
        Texture earth = loadTexture("res/earth.png", "PNG");
        Texture grass = loadTexture("res/grass.png", "PNG");
        Texture water = loadTexture("res/water.png", "PNG");
        
        // Game loop
        while(!Display.isCloseRequested()) {
            
            DrawQuadTex(earth, 0, 0, 64, 64);
            DrawQuadTex(grass, 0, 64, 64, 64);
            DrawQuadTex(water, 0, 128, 64, 64);
            
//            glBegin(GL_LINES);
//            glVertex2f(10, 10);
//            glVertex2f(100, 100);
//            glEnd();

            //drawQuad(50, 50, 100, 100);
            //drawQuad(150, 150, 100, 100);
            
            Display.update();
            Display.sync(60);
        }
    
        Display.destroy();
    }
    
    public static void main (String[] args) {
        
        new Boot();
    }
}
