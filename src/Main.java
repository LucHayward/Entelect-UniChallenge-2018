import java.util.ArrayList;
import java.util.List;

public class Main {
	static int[][] map;
	List<Location> locations;


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
	
	private static void getWorkerNearestAction(Worker worker) {
    
    }

}
