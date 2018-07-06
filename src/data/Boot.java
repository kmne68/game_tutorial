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
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author kemery
 */
public class Boot {
    
//    private static int WIDTH = 400;
//    private static int HEIGHT = 600;
    
    public Boot() {

        beginSession();
        
        int[][] map = {
            {1, 2, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {1, 2, 1, 0, 1, 2, 2, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1, 1, 2, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {1, 2, 1, 0, 1, 2, 2, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {1, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1, 2, 1, 0, 1, 2, 2, 1, 0, 0, 1, 0, 0, 0, 0, 0},
            {1, 2, 1, 0, 1, 2, 1, 0, 1, 1, 2, 1, 0, 1, 2, 1, 0, 0, 0, 0},
            {1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 1, 0, 1, 2, 0, 0, 0, 0, 0},
            {1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 1, 0, 1, 2, 1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 1, 0, 0, 1, 2, 2, 1, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        
//        float x = 100;
//        float y = 100;
//        float width = 50;
//        float height = 50;
    
        
//        Texture earth = quickLoad("earth"); //("res/earth.png", "PNG");
//        Texture grass = quickLoad("grass");
//        Texture water = quickLoad("water");
        
//        Tile grass = new Tile(0, 0, 64, 64, TileType.Grass);
//        Tile earth = new Tile(64, 0, 64, 64, TileType.Earth);
//        Tile water = new Tile(128, 0, 64, 64, TileType.Water);
        
        TileGrid grid = new TileGrid(map);
        grid.setTile(1, 9, grid.getTile(2, 9).getType());
        Enemy e = new Enemy(quickLoad("enemy"), grid.getTile(10, 10), 64, 64, 2);
        
        // Game loop
        while(!Display.isCloseRequested()) {
            
            
            glClear(GL11.GL_COLOR_BUFFER_BIT);      // added to stop background flicker
            
            grid.draw();
            
            e.Draw();
//            grass.drawTile();
//            earth.drawTile();
//            water.drawTile();
            
//            drawQuadTex(grass.getTexture(), grass.getX(), grass.getY(), grass.getWidth(), grass.getHeight());
//            drawQuadTex(earth.getTexture(), earth.getX(), earth.getY(), earth.getWidth(), earth.getHeight());
//            drawQuadTex(water.getTexture(), water.getX(), water.getY(), water.getWidth(), water.getHeight());
            
//            drawQuadTex(earth, 0, 0, 64, 64);
//            drawQuadTex(grass, 0, 64, 64, 64);
//            drawQuadTex(water, 0, 128, 64, 64);
            
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
