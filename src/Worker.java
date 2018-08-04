import java.util.ArrayList;

public class Worker {
	public char letter;
	public int capacity;
	public ArrayList<String> heldItems;
	public ArrayList<Integer> visitedPoints;
	
	public Worker(char letter, int capacity) {
		this.letter = letter;
		this.capacity = capacity;
		this.heldItems = new ArrayList<>();
	}
	
	public int itemCount() {
		return heldItems.size();
	}
	
	public void visit(int index) {
		visitedPoints.add(index);
	}
	
	@Override
	public String toString() {
		return "";
	}
}
