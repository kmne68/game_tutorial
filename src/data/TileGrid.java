/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static helpers.Artist.drawQuadTex;

/**
 *
 * @author kemery
 */
public class TileGrid {
    
    public static final int TILE_WIDTH = 64;
    public static final int TILE_HEIGHT = 64;
    
//    private int rows = 20;
//    private int cols = 15;
    
    private int tilesWide, tilesHigh;
    
    public Tile[][] map;
    
    public TileGrid() {
                
        map = new Tile[tilesWide][tilesHigh];
        
        for(int row = 0; row < map.length; row++) {
            for(int col = 0; col < map[row].length; col++) {
                map[row][col] = new Tile(row * TILE_HEIGHT, col * TILE_WIDTH, TILE_WIDTH, TILE_HEIGHT, TileType.Water);
            } 
        }
    }
    
    
    public TileGrid(int[][] newMap) {
        
        this.tilesWide = newMap[0].length;
        this.tilesHigh = newMap.length;
        
        map = new Tile[tilesWide][tilesHigh];
        
        for(int row = 0; row < map.length; row++) {
            for(int col = 0; col < map[row].length; col++) {

                switch(newMap[col][row]) {
                    case 0:
                        map[row][col] = new Tile(row * TILE_HEIGHT, col * TILE_WIDTH, TILE_WIDTH, TILE_HEIGHT, TileType.Grass);
                        break;
                    case 1:
                        map[row][col] = new Tile(row * TILE_HEIGHT, col * TILE_WIDTH, TILE_WIDTH, TILE_HEIGHT, TileType.Earth);
                        break;
                    case 2:
                        map[row][col] = new Tile(row * TILE_HEIGHT, col * TILE_WIDTH, TILE_WIDTH, TILE_HEIGHT, TileType.Water);
                        break;
                }
            } 
        }
    }
    
    
    public void setTile(int xCoord, int yCoord, TileType type) {
        
        map[xCoord][yCoord] = new Tile(xCoord * TILE_WIDTH, yCoord * TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT, type);
    }
    
    
    public Tile getTile(int xPlace, int yPlace) {
        
        if(xPlace < getTilesWide() && yPlace < getTilesHigh() && xPlace > -1 && yPlace > -1) {
        
            return map[xPlace][yPlace];
    
        } else {
            return new Tile(0, 0, 0, 0, TileType.NULL);
        }
    }
    
    
    public void draw() {
        
        for(int row = 0; row < map.length; row++) {
            for(int col = 0; col < map[row].length; col++) {
                
                map[row][col].drawTile();
            }
        }
        
    }

    /**
     * @return the tilesWide
     */
    public int getTilesWide() {
        return tilesWide;
    }

    /**
     * @param tilesWide the tilesWide to set
     */
    public void setTilesWide(int tilesWide) {
        this.tilesWide = tilesWide;
    }

    /**
     * @return the tilesHigh
     */
    public int getTilesHigh() {
        return tilesHigh;
    }

    /**
     * @param tilesHigh the tilesHigh to set
     */
    public void setTilesHigh(int tilesHigh) {
        this.tilesHigh = tilesHigh;
    }
}
