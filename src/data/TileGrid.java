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
    
    private int rows = 20;
    private int cols = 15;
    public Tile[][] map;
    
    public TileGrid() {
        
        map = new Tile[rows][cols];
        
        for(int row = 0; row < map.length; row++) {
            for(int col = 0; col < map[row].length; col++) {
                map[row][col] = new Tile(row * 64, col * 64, 64, 64, TileType.Water);
            } 
        }
    }
    
    
    public void draw() {
        
        for(int row = 0; row < map.length; row++) {
            for(int col = 0; col < map[row].length; col++) {
                Tile t = map[row][col];
                drawQuadTex(t.getTexture(), t.getX(), t.getY(), t.getWidth(), t.getHeight());
            }
        }
        
    }
}
