// All work work herein was produced through collaboration between Luc Hayward, 
// Stuart Mesham and Keegan White during the Entelect UniChallenge 2018.

/**
 * Simple coordinate class to store x,y values and simplify other areas of the program.
 */
public class Coordinate {
	
	public static int distanceBetween(Coordinate a, Coordinate b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
	
	public int x, y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

//	public int getX() {
//		return x;
//	}
//
//	public void setX(int x) {
//		this.x = x;
//	}
//
//	public int getY() {
//		return y;
//	}
//
//	public void setY(int y) {
//		this.y = y;
//	}

	public void addX(int amount) {
		x += amount;
	}

	public void addY(int amount) {
		y += amount;
	}

	@Override
	public String toString() {
		return "Coordinate{ x: " + x + ", y: " + y + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Coordinate that = (Coordinate) o;
		return x == that.x && y == that.y;
	}


}
