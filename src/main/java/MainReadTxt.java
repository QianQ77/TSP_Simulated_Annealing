import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * The second interface that reads input parameters from a file and is capable to run the system for multiple test cases.
 */
public class MainReadTxt extends Main{

    public static void main(String[] args) {

        Path inputPath = Paths.get("input.txt");
        File inputFile = new File(inputPath.toString());

        Path outputPath = Paths.get("output.txt");


        try{
            Scanner scanner = new Scanner(inputFile);

            if(Files.exists(outputPath)){
                Files.delete(outputPath);
            }

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                line = line.trim();
                if(line.length() > 0){
                    String[] words = line.split("\\s+");
                    if(words.length != 5 && words.length != 4){
                        throw new Exception("The content of input file is not valid: " + line);
                    }
                    String strategy = words[0];
                    String costFunction = words[1];
                    int n = Integer.valueOf(words[2]);
                    int MEB = Integer.valueOf(words[3]);

                    TSP tsp;

                    if(strategy.equalsIgnoreCase("sim")){
                        tsp = new SIM(n, costFunction, MEB);

                    }else{
                        int seed = Integer.valueOf(words[4]);
                        tsp = new SOPH(n, costFunction, MEB, seed);
                    }

                    long startTime = System.currentTimeMillis();
                    Tour tour = tsp.findMinTSP();
                    long endTime = System.currentTimeMillis();
                    long timeCost = endTime - startTime;
                    tsp.outputResult(outputPath, tour, timeCost);

                }


            }
            System.out.println("Success! The results have been written to output.txt.");
        }catch (Exception ex){
            ex.printStackTrace();
        }



    }

}
