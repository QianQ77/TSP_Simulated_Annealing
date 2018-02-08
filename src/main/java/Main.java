import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * The interactive interface that allows you to input:
 * the search strategy (either SIM or SOPH)
 * the cost function (either c1 or c2 or c3)
 * the number of cities N for which the TSP should be solved
 * a maximal effort bound  MEB (maximum number of states searched)
 * an integer random number
 *
 */
public class Main {

    /**
     * Check whether the strategy parameter is valid or not
     * @param strategy
     * @return
     */
    public static boolean strategyValid(String strategy){
        if(strategy.equalsIgnoreCase("SIM") || strategy.equalsIgnoreCase("SOPH")){
            return true;
        }
        return false;
    }

    /**
     * Check whether the costFunction parameter is valid or not
     * @param costFunction
     * @return
     */
    public static boolean costFunctionValid(String costFunction){
        if(costFunction.equalsIgnoreCase("c1") ||
                costFunction.equalsIgnoreCase("c2") ||
                costFunction.equalsIgnoreCase("c3")){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strategy;
        String costFunction;
        int n;
        int MEB;


        do{
            System.out.println("Please input the search strategy: (Either SIM or SOPH)");
            strategy = scanner.next();
        }while(!strategyValid(strategy));

        System.out.println("Please input the number of cities:");
        n = scanner.nextInt();

        do{
            System.out.println("Please input the cost function : (c1, c2 or c3)");
            costFunction = scanner.next();
        }while(!costFunctionValid(costFunction));

        System.out.println("Please input a maximal effort bound MEB:");
        MEB = scanner.nextInt();

        TSP tsp;

        /*
        strategy = "SOPH";
        n = 10;
        MEB = 10000;
        costFunction = "c1";
        //seed = 23;
        */

        if(strategy.equalsIgnoreCase("SIM")){
            tsp = new SIM(n, costFunction, MEB);

        }else{
            System.out.println("Please input an integer random number:");
            int seed = scanner.nextInt();
            tsp = new SOPH(n, costFunction, MEB, seed);
        }

        Path outputPath = Paths.get("output.txt");

        try{
            if(Files.exists(outputPath)){
                Files.delete(outputPath);
            }
            long startTime = System.currentTimeMillis();
            Tour tour = tsp.findMinTSP();
            long endTime = System.currentTimeMillis();
            long timeCost = endTime - startTime;
            tsp.outputResult(outputPath, tour, timeCost);
            System.out.println("Success! The results have been written to output.txt.");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
