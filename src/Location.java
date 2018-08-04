public class Location {
    public String symbol;
    public Coordinate coordinate;
    public int resources;
    
    public Location(String symbol, Coordinate coordinate, int resources) {
        this.symbol = symbol;
        this.coordinate = coordinate;
        this.resources = resources;
    }
    
    public boolean isMine() {
        return Character.isUpperCase(symbol.charAt(0));
    }
    
    public boolean isEmpty() {
        return resources <= 0;
    }
}
