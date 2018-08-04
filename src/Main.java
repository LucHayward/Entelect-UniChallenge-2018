import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[][] map;
    List<Location> locations;


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

            // process the input file

            int R = Integer.parseInt(data.next()); // height
            int C = Integer.parseInt(data.next()); // width
            map = new int[R][C];

            List<Worker> workers = new ArrayList<>();

            // get number of miners
            int numMiners = Integer.parseInt(data.next());

            // loop through miners
            for (int i = 0; i < numMiners; i++) {
                workers.add(new Worker('M', 1));
            }

            // get number of excavators
            int numExcavators = Integer.parseInt(data.next());

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

            int MN = Integer.parseInt(data.next());
            int F = Integer.parseInt(data.next());
            int Budget = Integer.parseInt(data.next());

            List<Location> locations = new ArrayList<>();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static void getWorkerNearestAction(Worker worker) {

    }

}
