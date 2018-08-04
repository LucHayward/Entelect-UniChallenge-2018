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
    static int numHaulers;


	public static void main(String[] args) {
		getInput("input.txt");
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
	@SuppressWarnings("Duplicates")
	public static void getInput(String fileName) {
		String temp;
		File f;
		try {
			f = new File(fileName);
			Scanner data = new Scanner(f);

			// process the input file
			R = data.nextInt(); // height
			C = data.nextInt(); // width
			map = new int[R][C];

			workers = new ArrayList<>();

			// get number of miners
			numMiners = data.nextInt();

			// loop through miners
			for (int i = 0; i < numMiners; i++) {
				workers.add(new Worker('M', 1));
			}

			// get number of excavators
			numExcavators = data.nextInt();

			// loop through excavators
			for (int i = 0; i < numExcavators; i++) {
				workers.add(new Worker('E', 3));
			}

            // get number of haulers
            numHaulers = data.nextInt();

			// loop through haulers
			for (int i = 0; i < numHaulers; i++) {
				workers.add(new Worker('H', 5));
			}

			// get number of mines
			MN = data.nextInt();

			// get number of factories
			F = data.nextInt();

			//get budget
			Budget = data.nextLong();

            List<Location> locations = new ArrayList<>();
            // loop through mines
            for (int i = 0; i < MN; i++) {
                    int I = data.nextInt();
                    String T = data.next();
                    int x = data.nextInt();
                    int y = data.nextInt();
                    int resources = data.nextInt();
                    Coordinate xy = new Coordinate(x, y);
                    Location location = new Location(I, T, xy, resources);
                    locations.add(location);
            }
            // loop through factories
            for (int i = 0; i < F; i++) {
                    int index = data.nextInt();
                    String tag = data.next();
                    int xcoord = data.nextInt();
                    int ycoord = data.nextInt();
                    Coordinate xy = new Coordinate(xcoord, ycoord);
                    Location location2 = new Location(index, tag, xy, 0);
                    locations.add(location2);
            }
        }
        catch(Exception e){
			e.printStackTrace();
                System.out.println(e);
            }

	}

	/**
	 * Find most effective next move for a given worker.
	 *
	 * @param worker the worker to be analysed
	 * @return the next loation for that worker.
	 */
	public static Location getWorkerNearestAction(Worker worker) {

		Location nearestActionLocation = null;
		int minDistance = Integer.MAX_VALUE;

		for (Location location : locations) {

			if (Coordinate.distanceBetween(location.coordinate, worker.position) < minDistance) {
				//If we want to visit this place
				if ((location.isMine() && !location.isEmpty() && !worker.heldItems.contains(location.symbol.toLowerCase()))
						|| worker.heldItems.contains(location.symbol)) {

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
