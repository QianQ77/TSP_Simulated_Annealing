import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Denotes a Tour in TSP problem : Each city is passed through only once
 * List<Integer> tour : a tour which is a list of cities wigh no duplicates
 * n : number of cities
 * cost : the total cost of this Tour, including the cost from the last city to the first city
 */

public class Tour {
    private List<Integer> tour = new ArrayList<Integer>();
    private int n;
    private int cost;

    public Tour(int n){
        this.n = n;
    }

    public Tour(List<Integer> tour){
        this.tour = new ArrayList<>(tour);
        this.n = tour.size();
    }

    public Tour(List<Integer> tour, int cost){
        this.tour = new ArrayList<>(tour);
        this.n = tour.size();
        this.cost = cost;
    }

    public Tour(Tour tour){
        this.tour = new ArrayList<>(tour.getTour());
        this.cost = tour.getCost();
        this.n = this.tour.size();
    }


    public List<Integer> getTour(){
        return tour;
    }

    public int getCost(){
        return cost;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    /**
     * Generates a random Tour using seed
     * @param seed
     */
    public void generateRandomTour(int seed){
        tour = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            tour.add(i);
        }

        //Reorder the tour randomly
        Collections.shuffle(tour, new Random(seed));
    }

    /**
     * Get a Neighbor Tour by reversing subpath between city i and city j in current Tour
     * @param i
     * @param j
     * @return
     */
    public Tour getNeighborSolution(int i, int j){
        ArrayList<Integer> newTour = new ArrayList<>(tour);

        int min = Integer.min(i, j);
        int max = Integer.max(i, j);
        int end = max;
        for(int start = min; start <= min + (max - min) / 2; start++){
            int temp = newTour.get(end);
            newTour.set(end, newTour.get(start));
            newTour.set(start, temp);
            end--;
        }
        return new Tour(newTour);
    }

    /**
     * get a Neighbor Tour by exchange the position of i and j
     * @param i
     * @param j
     * @return
     */
    public Tour getNeighborSolution2(int i, int j){
        ArrayList<Integer> newTour = new ArrayList<>(tour);
        int temp = newTour.get(j);
        newTour.set(j, newTour.get(i));
        newTour.set(i, temp);

        return new Tour(newTour);
    }

    /**
     * Return a string contains easy-reading path and total cost of the Tour
     * @return
     */
    public String toString(){
        StringBuilder builder = new StringBuilder();
        if(!tour.isEmpty()){
            for(int i : tour){
                builder.append(i + " -> ");
            }
        }
        builder.append(tour.get(0));
        builder.append("\n");
        builder.append("Cost: " + cost);
        return builder.toString();
    }

}
