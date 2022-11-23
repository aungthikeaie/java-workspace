package _8_puzzle_in_various_search;

/**
 * Created by HABDOLLA on 1/13/2016.
 */


public class App {
    final static private String EASY = "134862705";
    final static private String MEDIUM = "281043765";
    final static private String HARD = "567408321";
    final static private String GOAL_STATE = "123804765";



    public static void main(String[] args) {
        String rootState = HARD;
        long startTime = System.currentTimeMillis();

        SearchTree search = new SearchTree(new Node(rootState), GOAL_STATE);
        search.breadthFirstSearch();

        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - startTime;
        System.out.println("Time  :" + totalTime);


    }
}
