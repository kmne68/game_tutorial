package data;

import static helpers.Artist.quickLoad;
import static helpers.Artist.drawQuadTex;
import static helpers.Artist.TILE_SIZE;
import helpers.StateManager;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import ui.UI;
import ui.UI.Menu;

/**
 *
 * @author Keith
 */
public class Game {
    
    private TileGrid grid;
    private Player player;
    private WaveManager waveManager;
    private TowerCannonBlue blueTower;
    private UI gameUI;
    private Menu towerPickerMenu;
    private Texture menuBackground;
    
    
    public Game(TileGrid grid){
        
        this.grid = grid;
        waveManager = new WaveManager(new Enemy(quickLoad("floatingEnemy"), grid.getTile(3, 8), grid, TILE_SIZE, TILE_SIZE, 70, 25), 2, 2);
        
        player = new Player(grid, waveManager);
        player.setup();
        this.menuBackground = quickLoad("menu_background2");
        setupUI();
    }
    
    
    private void setupUI() {
        
        gameUI = new UI();
        gameUI.createMenu("TowerPicker", 1280, 100, 192, 960, 2, 0);
        towerPickerMenu = gameUI.getMenu("TowerPicker");
        towerPickerMenu.quickAdd("Blue Cannon", "cannonBlueFull");
        towerPickerMenu.quickAdd("Ice Cannon", "cannonIceFull");
        
    }
    
    
    private void updateUI() {
        
        gameUI.draw();
        gameUI.drawString(1310, 600, "Wave: " + waveManager.getWaveNumber());
        gameUI.drawString(1310, 650, "Lives: " + Player.Lives);
        gameUI.drawString(1310, 700, "Cash: " + Player.Funds);
        gameUI.drawString(0, 0, StateManager.framesInLastSecond + " fps");
        
        if(Mouse.next()) {
            boolean mouseClicked = Mouse.isButtonDown(0);
            if(mouseClicked) {
                if(towerPickerMenu.isButtonClicked("Blue Cannon")) {
                    player.pickTower(new TowerCannonBlue(TowerType.CannonBlue, grid.getTile(0, 0), waveManager.getCurrentWave().getEnemyList()));
                } 
                if(towerPickerMenu.isButtonClicked("Ice Cannon")) {
                    player.pickTower(new TowerCannonIce(TowerType.CannonIce, grid.getTile(0, 0), waveManager.getCurrentWave().getEnemyList()));
                }
            }
        }
    }
    
    
    public void update() {
        
        drawQuadTex(menuBackground, 1280, 0, 192, 960);
        grid.draw();
        waveManager.update();
        player.update();
//        tower.update();   // used in testing
        updateUI();
    }
    
}
