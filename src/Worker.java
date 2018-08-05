// All work work herein was produced through collaboration between Luc Hayward, 
// Stuart Mesham and Keegan White during the Entelect UniChallenge 2018.

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
			//Pick up resource
			heldItems.add(location.symbol.toLowerCase());
			location.resources--;
		} else {
			//Drop off resource
			for (int i = 0; i < heldItems.size(); i++) {
				if (heldItems.get(i).equals(location.symbol)) {
					location.resources++;
					heldItems.remove(i);
					break;
				}
			}
		}
		
		position = location.coordinate;
	}
	
	public boolean isEmpty() {
		return heldItems.size() == 0;
	}
	
	@Override
	public String toString() {
		if(visitedLocations.isEmpty()) return letter + "|";

		String s = letter + "|" + visitedLocations.get(0).id;
		for (int i = 1; i < visitedLocations.size(); i++) {
			s += "," + visitedLocations.get(i).id;
		}
		return s;
	}

}
