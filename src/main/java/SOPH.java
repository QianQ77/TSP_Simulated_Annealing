import java.util.ArrayList;
import java.util.Random;

/**
 * Sophisticated strategy to deal with TSP problem
 * Using Simulated Annealing Algorithm
 */
public class SOPH extends TSP{

    private double Temperature = 10000;
    private double coolingRate = 0.0001;
    private double stopTemperature = 0.00001;

    public SOPH(int n, String costFunction, int MEB, int seed){
        this.n = n;
        this.costFunction = costFunction;
        this.MEB = MEB;
        this.seed = seed;
        strategy = "SOPH";
    }

    @Override
    public Tour findMinTSP(){
        Tour currentTour = new Tour(n);
        currentTour.generateRandomTour(seed);

        int cost = Cost.cost(currentTour.getTour(), costFunction);
        currentTour.setCost(cost);

        Tour result = new Tour(currentTour);

        Random random = new Random(seed);

        while(steps < MEB && Temperature > stopTemperature){
            int random_i = random.nextInt(n);
            int random_j = random.nextInt(n);

            while(random_i == random_j){
                random_j = random.nextInt(n);
            }

            Tour neighborTour = currentTour.getNeighborSolution(random_i, random_j);

            int neighborCost = Cost.cost(neighborTour.getTour(), costFunction);
            neighborTour.setCost(neighborCost);

            //get a random double value between 0.0(inclusive) to 1.0(exclusive)
            double randomDouble = random.nextDouble();

            double acceptProb = acceptanceProbability(currentTour.getCost(), neighborTour.getCost(), Temperature);

            if( acceptProb > randomDouble){
                currentTour = new Tour(neighborTour);
                steps++;
            }

            if(currentTour.getCost() < result.getCost()){
                result = new Tour(currentTour);
            }

            Temperature *= 1 - coolingRate;
        }

        return result;

    }


    public double acceptanceProbability(int cost, int neighborCost, double T){

        //If new solution is better, we accept it
        if(neighborCost < cost){
            return 1.0;
        }

        return Math.exp((cost - neighborCost) / T);
    }

    public static void main(String[] args) throws Exception{
        SOPH soph = new SOPH(120, "c1", 200000, 7);

        soph.findMinTSP();

    }
}
