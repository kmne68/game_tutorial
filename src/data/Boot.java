package data;

import org.lwjgl.opengl.Display;
import static org.lwjgl.opengl.GL11.*;

import static helpers.Artist.*;
import helpers.Clock;
import helpers.StateManager;
import org.lwjgl.opengl.GL11;

/**
 *
 * @author kemery
 */
public class Boot {
        
    public Boot() {

        // Call static method in Artist class to initialize OpenGL calls
        beginSession();
        
        // Main game loop
        while(!Display.isCloseRequested()) {

//            glClear(GL11.GL_COLOR_BUFFER_BIT);      // added to stop background flicker
            
            Clock.update();            
            StateManager.update();            
            Display.update();
            Display.sync(60);
        }
    
        Display.destroy();
    }
    
    public static void main (String[] args) {
        
        new Boot();
    }
}
