# TSP_Simulated_Annealing

## Problem Description

In this Project, we need to design two search strategies SIM and SOPH that solve N-city Traveling Salesman Problems(TSP) with cities being numbered 0, …, N-1.
Then, we should design a software system that implements SIM and SOPH and provides the capability to run the SIM and SOPH for 3 given cost functions. 

The software has an interactive interface that allows uses to select search strategy, cost function, number of cities N, maximal effort bound MEB, and an integer random number if the search strategy is randomized. 
The software runs the selected search strategy with the selected parameters exploring at most MEB states and reports in an output file the best solution found, its cost, and other summaries about the search conducted.

## Search Strategies

### SIM - Nearest Neighbor Search

Nearest Neighbor Search is to find the point in a given set that is closest to a given point. There are various solutions to the NNS problem. I used the simplest solution to NNS problem – Linear Search, which means computing the distance from the query point to every other point in the database, keeping track of the “best so far” [1].

This algorithm costs O(n^2) time.

The space complexity is O(n^2).

It is guaranteed to find a solution. However, the solution may not be optimal.

### **SOPH - Simulated Annealing Algorithm**

The advantages of Simulated Annealing are that it is good at avoiding the problem of getting caught in a local optimum and good at find an approximate global optimum.

#### •	Main idea of Simulated Annealing 

We have a Temperature variable to simulate the heating process;

We assign it a high initial value and then slowly cool it as the algorithm runs;

We more frequently accept worse solutions than our current solution as long as the Temperature variable is still high. By doing this, we allow the algorithm to jump out any local optimums;

The chance of accepting worse solutions will reduce as the Temperature decreases;

By doing this, we allow the algorithm to slowly focus on an area of the search space in which a close to optimum solution can be found.


#### •	Acceptance Probability Function
The way we decide which solutions to accept is as following:

(1)	If the neighbor solution is better than our current solution, we accept it unconditionally;

(2)	If not, we need to consider two factors: 

- How much worse the neighbor solution is; 

- How high the current Temperature is.

Basically, the smaller the change in energy(cost), and the higher the Temperature, the more likely it is for the algorithm to accept the solution.


# How To Run
There are two interfaces to use. You may either manually input parameters or let the program read an input file and generate results. The input.txt is in TSP file folder.
The results would be written to output.txt.

1. How to run Interface I in command line:
  java -jar build/libs/TSP-1.0.jar
Then you can input parameters as instruction.

2. How to run Interface II in command line:
  java -jar build/libs/TSP_ReadTxt-1.0.jar
