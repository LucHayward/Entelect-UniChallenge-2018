public class Location {
    public String symbol;
    public Coordinate coordinate;
    
    public Location(String symbol, Coordinate coordinate) {
        this.symbol = symbol;
        this.coordinate = coordinate;
    }
    
    public boolean isMine() {
        return Character.isUpperCase(symbol.charAt(0));
    }
}
