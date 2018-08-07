/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author kemery
 */
public enum TileType {
    
    Grass("grass", true),
    Earth("earth", true),
    Water("water", false),
    NULL("water", false);
    
    String textureName;
    boolean buildable;
    
    TileType(String textureName, boolean buildable) {

        this.textureName = textureName;
        this.buildable = buildable;
    }
}
