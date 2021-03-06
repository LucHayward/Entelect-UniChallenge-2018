// All work work herein was produced through collaboration between Luc Hayward, 
// Stuart Mesham and Keegan White during the Entelect UniChallenge 2018.

public class Location {
    public int id;
    public String symbol;
    public Coordinate coordinate;
    public int resources;
    
    public Location(int id, String symbol, Coordinate coordinate, int resources) {
        this.id = id;
        this.symbol = symbol;
        this.coordinate = coordinate;
        this.resources = resources;
    }
    
    public boolean isMine() {
        return Character.isUpperCase(symbol.charAt(0));
    }
    
    public boolean isEmpty() {
        return resources == 0;
    }
}
