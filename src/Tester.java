import java.util.ArrayList;

public class Tester {
	private static boolean allTestPassed = true;
	
	public static void main(String[] args) {
		Main.locations = new ArrayList<>();
		
		Main.locations.add(new Location(0, "HE", new Coordinate(3, 6), 2));
		Main.locations.add(new Location(1, "LI", new Coordinate(3, 5), 2));
		Main.locations.add(new Location(2, "he", new Coordinate(3, 4), 0));
		Main.locations.add(new Location(3, "li", new Coordinate(3, 2), 0));
		
		Worker worker = new Worker('M', 1);
		
		Location nearestActionLocation = Main.getWorkerNearestAction(worker);
		
		assertThat("getWorkerNearestAction 1", nearestActionLocation.id == 1);
		
		if (allTestPassed) {
			System.out.println("All tests passed");
		}
	}
	
	private static void assertThat(String testName, boolean bool) {
		if (!bool) {
			System.out.println(testName + " is not working");
			allTestPassed = false;
		}
	}
}
