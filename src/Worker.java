import java.util.ArrayList;

public class Worker {
	public char letter;
	public int capacity;
	public ArrayList<String> heldItems;
	public ArrayList<Location> visitedLocations;
	public Coordinate position;
	
	public Worker(char letter, int capacity) {
		this.letter = letter;
		this.capacity = capacity;
		this.heldItems = new ArrayList<>();
		this.visitedLocations = new ArrayList<>();
		this.position = new Coordinate(0, 0);
	}
	
	public int itemCount() {
		return heldItems.size();
	}
	
	public void visit(Location location) {
		visitedLocations.add(location);
		
		if (location.isMine()) {
			heldItems.add(location.symbol.toLowerCase());
		}
		
		position = location.coordinate;
	}
	
	@Override
	public String toString() {
		String s = letter + "|" + visitedLocations.get(0).id;
		for (int i = 1; i < visitedLocations.size(); i++) {
			s += "," + visitedLocations.get(i).id;
		}
		return s;
	}

}
