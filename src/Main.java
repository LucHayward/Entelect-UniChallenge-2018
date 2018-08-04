import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static List<Location> locations;


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

            while(data.hasNext()) // process the input file
            {
                int R = Integer.parseInt(data.next()); // height
                int C = Integer.parseInt(data.next()); // width
                 map = new int[R][C];

                List<Worker> workers = new ArrayList<>();

                // get number of miners
                int numMiners = Integer.parseInt(data.next());

                // loop through miners
                for(int i = 0; i<numMiners; i++) {
                    workers.add(new Worker('M',1));
                }

                // get number of excavators
                int numExcavators = Integer.parseInt(data.next());

                // loop through excavators
                for(int i = 0; i<numExcavators; i++) {
                    workers.add(new Worker('E',3));
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
	
	private static Location getWorkerNearestAction(Worker worker) {
     
	    Location nearestActionLocation = null;
        int minDistance = Integer.MAX_VALUE;
	    
        for (Location location : locations) {
            
            if (Coordinate.distanceBetween(location.coordinate, worker.position) < minDistance) {
                //If we want to visit this place
                if (location.isMine() || worker.heldItems.contains(location.symbol)) {
                    minDistance = Coordinate.distanceBetween(location.coordinate, worker.position);
                    nearestActionLocation = location;
                }
            }
            
        }
        
        return nearestActionLocation;
    }

}
