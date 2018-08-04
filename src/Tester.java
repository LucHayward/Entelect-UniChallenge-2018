import java.util.ArrayList;

public class Tester {
	private static boolean allTestPassed = true;
	
	public static void main(String[] args) {
		
		// ----------All the tests go in here:----------
		
		Main.locations = new ArrayList<>();
		
		Main.locations.add(new Location(0, "HE", new Coordinate(3, 6), 2));
		Main.locations.add(new Location(1, "LI", new Coordinate(3, 5), 2));
		Main.locations.add(new Location(2, "he", new Coordinate(3, 1), 0));
		Main.locations.add(new Location(3, "li", new Coordinate(3, 2), 0));
		
		Worker worker = new Worker('M', 1);
		
		Location nearestActionLocation = Main.getWorkerNearestAction(worker);
		
		assertThat("getWorkerNearestAction 1", nearestActionLocation.id,1);
		
		worker.visit(nearestActionLocation);
		
		assertThat("worker.visit 1", nearestActionLocation.resources, 1);
		assertThat("worker.visit 2", worker.heldItems.get(0), "li");
		
		nearestActionLocation = Main.getWorkerNearestAction(worker);
		
		assertThat("getWorkerNearestAction 2", nearestActionLocation.id, 0);
		
		worker.visit(nearestActionLocation);
		nearestActionLocation = Main.getWorkerNearestAction(worker);
		
		assertThat("getWorkerNearestAction 3", nearestActionLocation.id, 3);
		
		worker.visit(nearestActionLocation);
		
		assertThat("worker.visit 3", nearestActionLocation.resources, 1);
		assertThat("worker.visit 4", worker.heldItems.size(), 1);
		
		nearestActionLocation = Main.getWorkerNearestAction(worker);
		
		assertThat("getWorkerNearestAction 4", nearestActionLocation.id, 2);
		
		
		
		// ------------------------------------------------
		
		if (allTestPassed) {
			System.out.println("All tests passed");
		}
	}
	
	private static void assertThat(String testName, Object actualValue, Object expectedValue) {
		if (!(actualValue.equals(expectedValue))) {
			System.out.println(testName + " is not working");
			System.out.println("Expected: " + expectedValue);
			System.out.println("Got: " + actualValue);
			allTestPassed = false;
		}
	}
}
