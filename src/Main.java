import java.util.ArrayList;
import java.util.List;

public class Main {
	static int[][] map;
	static List<Location> locations;


	public static void main(String[] args) {
		//getInput();
		map = new int[1000][1000];
		for (int i = 0; i < 1000; i++) {
			for (int x = 0; x < 1000; x++) {
				map[i][x] = i * x;
			}
		}
		System.out.println();
	}

	private static void getInput() {

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
