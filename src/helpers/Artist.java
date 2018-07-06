/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.io.IOException;
import java.io.InputStream;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

/**
 *
 * @author kemery
 */
public class Artist {
    
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 960;
    
    
    public static void beginSession() {
        
        Display.setTitle("Tower Defense");

        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);     // Set up camera
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_TEXTURE_2D);
    }
    
    public static void drawQuad(float x, float y, float width, float height) {
                    
            glBegin(GL_QUADS);
            glVertex2f(x, y);
            glVertex2f(x + width, y);
            glVertex2f(x + width, y + height);
            glVertex2f(x, y + height);
            glEnd();
    }
    
    
    public static void drawQuadTex(Texture tex, float x, float y, float width, float height) {
        
        tex.bind();
        glTranslatef(x, y, 0);  // translates so that the quad coordinates are no longer relative to screen top left
        glBegin(GL_QUADS);
        glTexCoord2f(0, 0);     // top left
        glVertex2f(0, 0);       // top left
        
        glTexCoord2f(1, 0);     // top right
        glVertex2f(width, 0);       // top right
        
        glTexCoord2f(1, 1);         // bottom right
        glVertex2f(width, height);  // bottom right     
        
        glTexCoord2f(0, 1);         // bottom left
        glVertex2f(0, height);      // bottom left
        
        glEnd();
        glLoadIdentity();
        
    }
    
    
    public static Texture loadTexture(String path, String fileType) {
        
        Texture tex = null;
        InputStream in = ResourceLoader.getResourceAsStream(path);
        try {
            tex = TextureLoader.getTexture(fileType, in);
        } catch(IOException e) {
            e.printStackTrace();
        }        
        return tex;
        
    }
    
    
    public static Texture quickLoad(String name) {
        
         Texture tex = null;
         tex = loadTexture("res/" + name + ".png", "PNG");
         return tex;
    }
}
