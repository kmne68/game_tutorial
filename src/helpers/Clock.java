package helpers;

import org.lwjgl.Sys;

/**
 *
 * @author Keith
 */
public class Clock {
    
    private static boolean paused = false;
    private static long lastFrame, totalTime;
    public static float delta = 0;              // time between last update and now
    public static float multiplier = 1;
    
    
    public static long getTime() {
        
        return Sys.getTime() * 1000 / Sys.getTimerResolution();
    }
    
    
    public static float getDelta() {
        
        long currentTime = getTime();
        int delta = (int) (currentTime - lastFrame);
        lastFrame = getTime();
        
        // System.out.println(delta * 0.01f);
        
        if(delta * 0.001f > 0.05f) {
            return 0.05f;
        }
        return delta * 0.001f;
    }
    
    
    public static float delta() {
        
        if(paused)
            return 0;
        else
            return delta * multiplier;
    }
    
    
    public static float totalTime() {
        
        return multiplier;
    }
    
    
    public static void update() {
        
        delta = getDelta();
        totalTime += delta;
    }
    
    
    public static void changeMultiplier(float change) {
        
        if(multiplier + change < -1 || multiplier + change > 7) {
            // ???
        } else {
            multiplier += change;
        }
    }
    
    
    public static void pause() {
        if(paused) {
            paused = false;
        } else {
            paused = true;
        }
    }
}
