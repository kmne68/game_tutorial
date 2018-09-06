/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import data.Tile;
import data.TileGrid;
import data.TileType;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Keith
 */
public class Leveler {

    public static void saveMap(String mapName, TileGrid grid) {

        String mapData = "";

        for (int i = 0; i < grid.getTilesWide(); i++) {
            for (int j = 0; j < grid.getTilesHigh(); j++) {
                mapData += getTileID(grid.getTile(i, j));
            }
        }
        System.out.println("mapData = " + mapData);
        try {
            // File file = new File("C:\\" + mapName);
            File file = new File("C:\\Users\\Keith\\Documents\\NetBeansProjects\\game_tutorial\\" + mapName);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(mapData);
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static TileType getTileType(String id) {

        TileType type = TileType.NULL;

        switch (id) {
            case "0":
                type = TileType.Grass;
                break;
            case "1":
                type = TileType.Earth;
                break;
            case "2":
                type = TileType.Water;
                break;
            case "3":
                type = TileType.NULL;
                break;
        }

        return type;
    }

    public static TileGrid loadMap(String mapName) {

        TileGrid grid = new TileGrid();

        try {
            BufferedReader br = new BufferedReader(new FileReader(mapName));
            String data = br.readLine();
            
            for (int i = 0; i < grid.getTilesWide(); i++) {
                for (int j = 0; j < grid.getTilesHigh(); j++) {
                    grid.setTile(i, j, getTileType(data.substring(i * grid.getTilesHigh() + j, i * grid.getTilesHigh() + j + 1)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return grid;
    }

    public static String getTileID(Tile tile) {

        String ID = "E";        // "E" is simply a flag that lets us know an error has occurred if the ID isn't found

        switch (tile.getType()) {
            case Grass:
                ID = "0";
                break;
            case Earth:
                ID = "1";
                break;
            case Water:
                ID = "2";
                break;
            case NULL:
                ID = "3";
                break;

        }

        return ID;
    }

}
