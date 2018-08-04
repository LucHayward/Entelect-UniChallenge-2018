import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int[][] map;
	List<Location> locations;
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
			data = new Scanner(f);
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
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

	private static void getWorkerNearestAction(Worker worker) {

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
