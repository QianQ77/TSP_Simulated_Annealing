import java.util.List;

/**
 * Cost class takes charge of calculating costs using specific cost funtion
 * For two cities or an array of cities or a list of cities
 */
public class Cost {

    /**
     *
     * @param x
     * @param y
     * @return cost between city x and city y using c1 cost Function
     */
    public static int c1(int x, int y){
        if(x == y){
            return 0;
        }else if(x < 3 && y < 3){
            return 1;
        }else if(x < 3 || y < 3){
            return 200;
        }else if (x % 7 == y % 7){
            return 2;
        }
        return Math.abs(x - y) + 3;
    }

    /**
     *
     * @param x
     * @param y
     * @return cost between city x and city y using c2 cost Function
     */
    public static int c2(int x, int y){
        if(x == y){
            return 0;
        }else if(x + y < 10){
            return Math.abs(x - y) + 4;
        }else if((x + y) % 11 == 0){
            return 3;
        }
        return (int)Math.pow(Math.abs(x - y), 2) + 10;
    }

    /**
     *
     * @param x
     * @param y
     * @return cost between city x and city y using c3 cost Function
     */
    public static int c3(int x, int y){
        if(x == y){
            return 0;
        }
        return (int)Math.pow(x + y, 2);
    }

    /**
     * Calculate total cost for a path which is denoted by an int[] array using cost function which is chosen according to functionName
     * Note that we should add the cost from last city to first city in order to complete the tour
     * @param array
     * @param functionName
     * @return
     */
    public static int cost(int[] array, String functionName){
        int cost = 0;
        functionName = functionName.toLowerCase();
        switch (functionName){
            case "c1":
                for(int i = 0; i < array.length - 1; i++){
                    cost += c1(array[i], array[i + 1]);
                }
                cost += c1(array[array.length - 1], array[0]);
                break;
            case "c2":
                for(int i = 0; i < array.length - 1; i++){
                    cost += c2(array[i], array[i + 1]);
                }
                cost += c2(array[array.length - 1], array[0]);
                break;
            case "c3":
                for(int i = 0; i < array.length - 1; i++){
                    cost += c3(array[i], array[i + 1]);
                }
                cost += c3(array[array.length - 1], array[0]);
                break;
        }
        return cost;
    }

    /**
     * Calculate total cost for a path which is denoted by an List<Integer></> using cost function which is chosen according to functionName
     * Note that we should add the cost from last city to first city in order to complete the tour
     * @param list
     * @param functionName
     * @return
     */
    public static int cost(List<Integer> list, String functionName){
        int cost = 0;
        switch (functionName){
            case "c1":
                for(int i = 0; i < list.size() - 1; i++){
                    cost += c1(list.get(i), list.get(i + 1));
                }
                cost += c1(list.get(list.size() - 1), list.get(0));
                break;
            case "c2":
                for(int i = 0; i < list.size() - 1; i++){
                    cost += c2(list.get(i), list.get(i + 1));
                }
                cost += c2(list.get(list.size() - 1), list.get(0));
                break;
            case "c3":
                for(int i = 0; i < list.size() - 1; i++){
                    cost += c3(list.get(i), list.get(i + 1));
                }
                cost += c3(list.get(list.size() - 1), list.get(0));
                break;
        }
        return cost;
    }

    /**
     * Generate a matrix costs[][] according to costFunction
     * costs[i][j] denotes the cost from city i to city j
     * @param n : Number of cities
     * @param costFunction
     * @return
     */
    public static int[][] generateCosts(int n, String costFunction){
        int[][] costs = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j<= i; j++){
                if(costFunction.equals("c1")){
                    costs[i][j] = Cost.c1(i, j);
                }else if(costFunction.equals("c2")){
                    costs[i][j] = Cost.c2(i, j);
                }else{
                    costs[i][j] = Cost.c3(i, j);
                }
                costs[j][i] = costs[i][j];
            }
        }
        return costs;
    }
}
