import org.junit.Test;

import java.util.Random;

/**
 * Created by qiuqian on 9/29/17.
 */
public class TourTest {

    Tour tour = new Tour(10);

    @Test
    public void generateRandomTest(){
        tour.generateRandomTour(42);
        System.out.println(tour);
        Tour newTour = tour.getNeighborSolution(4, 7);
        System.out.println(newTour);
    }
}
