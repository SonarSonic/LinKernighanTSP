package linktsp;

import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

public class LinkTSP {

    public static Logger logger = Logger.getLogger("Linked TSP");

    public static void main(String[] args) {
        logger.info("Running Test");

        File folder = new File("data/");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            String name = listOfFiles[i].getName();
            if (listOfFiles[i].isFile() && name.substring(name.length() - 3).equalsIgnoreCase("tsp")) {
                System.out.println("  [" + i + "] " + listOfFiles[i].getName());
            }
        }

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        int idx;
        do {
            System.out.print("Select the dataset to test: ");
            idx = scanner.nextInt();
        } while(idx >= listOfFiles.length || idx < 0);


        // Read the file
        FileInterpreter in = new FileInterpreter(listOfFiles[idx]);

        // Create the instance of the problem
        LinKernighan lk = new LinKernighan(in.getCoordinates(), in.getIds());

        // Time keeping
        long start;
        start = System.currentTimeMillis();

        // Show the results even if shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.printf("The solution took: %dms\n", System.currentTimeMillis()-start);
            System.out.println("The solution is: ");
            System.out.println(lk);
        }));

        lk.runTSP();

    }




}
