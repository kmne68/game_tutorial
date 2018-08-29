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
    
    static int[][] map = {
            {1, 2, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
            {1, 2, 1, 0, 1, 2, 2, 0, 1, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2},
            {1, 1, 0, 0, 1, 1, 2, 0, 1, 0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 0},
            {1, 2, 1, 0, 1, 2, 2, 0, 1, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0},
            {1, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 2, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0},
            {2, 2, 2, 0, 1, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 0, 0, 0, 0},
            {1, 1, 2, 0, 1, 2, 1, 0, 1, 1, 0, 1, 2, 1, 2, 1, 0, 0, 0, 0},
            {2, 1, 2, 2, 2, 2, 1, 0, 1, 1, 1, 1, 2, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 1, 0, 0, 1, 2, 2, 1, 2, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0},
        };
    
    public static void update() {
        
        switch(gameState) {
            
            case MAINMENU:
                if(mainMenu == null)
                    mainMenu = new MainMenu();
                mainMenu.update();
                break;
            case GAME:
                if(game == null)
                    game = new Game(map);
                game.update();
                break;
            case EDITOR:
                if(editor == null)
                    editor = new Editor();
                editor.update();
                break;
        }
        
        
    }
    
    
    public static void setState(GameState newState) {
        
        gameState = newState;
    }
}
