import java.util.ArrayList;

public class Worker {
	public char letter;
	public int capacity;
	public ArrayList<String> heldItems;
	public ArrayList<Integer> visitedPoints;
	public Coordinate position;
	
	public Worker(char letter, int capacity) {
		this.letter = letter;
		this.capacity = capacity;
		this.heldItems = new ArrayList<>();
		this.visitedPoints = new ArrayList<>();
	}
	
	public int itemCount() {
		return heldItems.size();
	}
	
	public void visit(int index) {
		visitedPoints.add(index);
	}
	
	@Override
	public String toString() {
		String s = letter + "|" + visitedPoints.get(0);
		for (int i = 1; i < visitedPoints.size(); i++) {
			s += "," + visitedPoints.get(i);
		}
		return s;
	}
}
