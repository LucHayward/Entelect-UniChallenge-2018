// All work work herein was produced through collaboration between Luc Hayward, 
// Stuart Mesham and Keegan White during the Entelect UniChallenge 2018.

import java.util.ArrayList;

public class Tester {
	private static boolean allTestPassed = true;
	
	public static void main(String[] args) {
		
		// ----------All the tests go in here:----------
		
		Main.locations = new ArrayList<>();
		Main.workers = new ArrayList<>();
		
		Main.locations.add(new Location(0, "HE", new Coordinate(3, 6), 2));
		Main.locations.add(new Location(1, "LI", new Coordinate(3, 5), 2));
		Main.locations.add(new Location(2, "he", new Coordinate(3, 1), 0));
		Main.locations.add(new Location(3, "li", new Coordinate(3, 2), 0));
		
		Worker worker = new Worker('M', 1);
		Main.workers.add(worker);
		
		Main.MN = 2;
		Main.F = 2;
		Main.E = 1;
		
		assertThat("isFinished 1", Main.isFinished(), false);
		
		Location nearestActionLocation = Main.getWorkerNearestAction(worker);
		
		assertThat("getWorkerNearestAction 1", nearestActionLocation.id,1);
		
		worker.visit(nearestActionLocation);
		
		assertThat("worker.visit 1", nearestActionLocation.resources, 1);
		assertThat("worker.visit 2", worker.heldItems.get(0), "li");
		assertThat("worker.visit 3", worker.visitedLocations.get(0).id, nearestActionLocation.id);
		
		
		nearestActionLocation = Main.getWorkerNearestAction(worker);
		
		assertThat("getWorkerNearestAction 2", nearestActionLocation.id, 0);
		
		worker.visit(nearestActionLocation);
		nearestActionLocation = Main.getWorkerNearestAction(worker);
		
		assertThat("getWorkerNearestAction 3", nearestActionLocation.id, 3);
		
		worker.visit(nearestActionLocation);
		
		assertThat("worker.visit 4", worker.heldItems.size(), 1);
		assertThat("worker.visit 5", worker.visitedLocations.get(2).id, nearestActionLocation.id);
		
		
		nearestActionLocation = Main.getWorkerNearestAction(worker);
		
		assertThat("getWorkerNearestAction 4", nearestActionLocation.id, 2);
		
		assertThat("isFinished 2", Main.isFinished(), false);
		
		worker.visit(nearestActionLocation);
		
		nearestActionLocation = Main.getWorkerNearestAction(worker);
		worker.visit(nearestActionLocation);
		nearestActionLocation = Main.getWorkerNearestAction(worker);
		worker.visit(nearestActionLocation);
		nearestActionLocation = Main.getWorkerNearestAction(worker);
		worker.visit(nearestActionLocation);
		nearestActionLocation = Main.getWorkerNearestAction(worker);
		worker.visit(nearestActionLocation);
		
		assertThat("resources count 1", Main.locations.get(0).resources, 0);
		assertThat("resources count 2", Main.locations.get(1).resources, 0);
		
		assertThat("worker.isEmpty 1", worker.isEmpty(), true);
		assertThat("isFinished 3", Main.isFinished(), true);
		
		
		
		
		//Some file reader tests
		
		Main.getInput("old_map_1.input");
		
		assertThat("getInput 1", Main.map.length, 10);
		assertThat("getInput 2", Main.map[0].length, 10);
		assertThat("getInput 3", Main.workers.size(), 6);
		assertThat("getInput 4", Main.MN, 8);
		assertThat("getInput 5", Main.F, 10);
		assertThat("getInput 6", Main.locations.size(), 18);
		assertThat("getInput 7", Main.Budget, 100000000000000l);
		Location location2 = Main.locations.get(1); //A mine
		assertThat("getInput 8", location2.id, 1);
		assertThat("getInput 9", location2.symbol, "NI");
		assertThat("getInput 10", location2.coordinate, new Coordinate(7, 3));
		assertThat("getInput 11", location2.resources, 11);
		Location location12 = Main.locations.get(10); //A factory
		assertThat("getInput 12", location12.id, 10);
		assertThat("getInput 13", location12.symbol, "tm");
		assertThat("getInput 14", location12.coordinate, new Coordinate(2, 0));
		
		
		
		
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
