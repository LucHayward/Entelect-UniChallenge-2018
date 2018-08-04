public class Utils {
	public static int getDistance(Coordinate A, Coordinate B) {
		return Math.abs(B.getX() - A.getX()) + Math.abs(B.getY() - A.getY());
	}

}
