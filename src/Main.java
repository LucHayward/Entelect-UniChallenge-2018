import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static List<Location> locations;
	static int R;
	static int C;
	static int E;
	static List<Worker> workers;
	static int MN;
	static int F;
	static long Budget;
	static int numMiners;
	static int numExcavators;


	public static void main(String[] args) {
		getInput("map_1.input");
		simulate();
	}

	/**
	 * Simulates all problem
	 */
	private static void simulate() {
	}

	/**
	 * Get input and update all environment variables.
	 *
	 * @param fileName file to get input for
	 */
	private static void getInput(String fileName) {
		String temp;
		File f;
		try {
			f = new File(fileName);
			Scanner data = new Scanner(f);
			data.useDelimiter(" ");

			// process the input file
			R = Integer.parseInt(data.next()); // height
			C = Integer.parseInt(data.next()); // width
			map = new int[R][C];

			workers = new ArrayList<>();

			// get number of miners
			numMiners = Integer.parseInt(data.next());

			// loop through miners
			for (int i = 0; i < numMiners; i++) {
				workers.add(new Worker('M', 1));
			}

			// get number of excavators
			numExcavators = Integer.parseInt(data.next());

			// loop through excavators
			for (int i = 0; i < numExcavators; i++) {
				workers.add(new Worker('E', 3));
			}

			// get number of haulers
			int numHaulers = Integer.parseInt(data.next());

			// loop through haulers
			for (int i = 0; i < numHaulers; i++) {
				workers.add(new Worker('H', 5));
			}

			// get number of mines
			MN = Integer.parseInt(data.next());

			// get number of factories
			F = Integer.parseInt(data.next());

			//get budget
			Budget = Long.parseLong(data.next());

			// loop through mine

			List<Location> locations = new ArrayList<>();
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * Find most effective next move for a given worker.
	 *
	 * @param worker the worker to be analysed
	 * @return the next loation for that worker.
	 */
	private static Location getWorkerNearestAction(Worker worker) {

		Location nearestActionLocation = null;
		int minDistance = Integer.MAX_VALUE;

		for (Location location : locations) {

			if (Coordinate.distanceBetween(location.coordinate, worker.position) < minDistance) {
				//If we want to visit this place
				if ((location.isMine() && !location.isEmpty()) || worker.heldItems.contains(location.symbol)) {
					minDistance = Coordinate.distanceBetween(location.coordinate, worker.position);
					nearestActionLocation = location;
				}
			}

		}

		return nearestActionLocation;
	}

	/**
	 * Creates a visual representation of the map state
	 */
	private static void createRepresentation() {
		System.out.println(map);
	}

	/**
	 * Creates an output file for submission.
	 */
	private static void createSubmission() {
		BufferedWriter output = null;
		try {
			File file = new File("output.txt");
			output = new BufferedWriter(new FileWriter(file));
			output.write("Something");


			//loop over workers
			for (Worker worker : workers) {
				output.write(worker.toString());
			}

		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (output != null) {
				try {
					output.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
