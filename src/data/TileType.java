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
