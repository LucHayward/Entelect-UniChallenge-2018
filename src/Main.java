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
	static int height;
	static int width;
	static int numExcavators;
	static List<Worker> workers;


	public static void main(String[] args) {
		getInput("");
	}

	private static void getInput(String fileName) {
		String temp;
		File f;
		try {
			f = new File(fileName);
			Scanner data = new Scanner(f);

			data.useDelimiter(" ");

			while (data.hasNext()) // process the input file
			{
				int R = Integer.parseInt(data.next()); // height
				int C = Integer.parseInt(data.next()); // width
				map = new int[R][C];

				// get number of miners
				int numMiners = Integer.parseInt(data.next());
				workers = new ArrayList<>();

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
                for(int i = 0; i<numHaulers; i++) {
                    workers.add(new Worker('H',5));
                }
			int numMines = Integer.parseInt(data.next());
                int numFactories = Integer.parseInt(data.next());
                int budget = Integer.parseInt(data.next());}
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

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

	private static void createSubmission() {
		BufferedWriter output = null;
		try {
			File file = new File("output.txt");
			output = new BufferedWriter(new FileWriter(file));
			output.write("Something");

			//loop over workers
			for ()

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
