package data;

import static helpers.Artist.quickLoad;
import static helpers.Artist.drawQuadTex;
import static helpers.Artist.TILE_SIZE;
import org.lwjgl.input.Mouse;
import ui.Button;
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
    
    
    public Game(TileGrid grid){
        
        this.grid = grid;
        waveManager = new WaveManager(new Enemy(quickLoad("enemy"), grid.getTile(3, 8), grid, TILE_SIZE, TILE_SIZE, 70, 25), 2, 2);
        
        player = new Player(grid, waveManager);
        player.setup();
        setupUI();
    }
    
    
    private void setupUI() {
        
        gameUI = new UI();
//        towerPickerUI.addButton("CannonBlue", "cannonBaseBlue", 0, 0);
//        towerPickerUI.addButton("CannonIce", "cannonIceFull", 64, 0);
        gameUI.createMenu("TowerPicker", 1280, 100, 192, 960, 2, 0);
        towerPickerMenu = gameUI.getMenu("TowerPicker");
        towerPickerMenu.quickAdd("Blue Cannon", "cannonBlueFull");
        towerPickerMenu.quickAdd("Ice Cannon", "cannonIceFull");
        
    }
    
    
    private void updateUI() {
        
        gameUI.draw();
        
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
        
        drawQuadTex(quickLoad("menu_background2"), 1280, 0, 192, 960);
        grid.draw();
        waveManager.update();
        player.update();
//        tower.update();   // used in testing
        updateUI();
    }
    
}
