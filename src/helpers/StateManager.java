/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import data.Editor;
import data.Game;
import data.MainMenu;

/**
 *
 * @author Keith
 */
public class StateManager {
    
    public static enum GameState {
        
        MAINMENU, GAME, EDITOR
    }
    
    public static GameState gameState = GameState.MAINMENU;
    public static MainMenu mainMenu;
    public static Game game;
    public static Editor editor;
    
    public static void update() {
        
        switch(gameState) {
            
            case MAINMENU:
                if(mainMenu == null)
                    mainMenu = new MainMenu();
                mainMenu.update();
                break;
            case GAME:
                
                break;
            case EDITOR:
                
                break;
        }
        
        
    }
}
