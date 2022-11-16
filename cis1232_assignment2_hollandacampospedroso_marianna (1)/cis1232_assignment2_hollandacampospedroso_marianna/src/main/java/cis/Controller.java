package cis;

import cis.util.CisUtility;
import java.util.Scanner;

/**
 * A program to score a bowling game with arrays for Assignment 2.
 *
 * @author marianna hollanda
 * @since 20210201
 */
public class Controller {

    private static final int NUMBER_OF_PLAYERS = 4;
    private static final int NUMBER_OF_ENDS = 10;
    private static String[] players = new String[NUMBER_OF_PLAYERS];

    public static final String[] PLAYER_NUMBER = {"#1", "#2", "#3", "#4"};

    private static int[][] playerScore = new int[NUMBER_OF_PLAYERS][NUMBER_OF_ENDS];
    private static int[] totals = new int[NUMBER_OF_PLAYERS];

    public static void main(String[] args) {
        getInformation();
        getScores();
        showFinalScores();

    }

    /**
     * Get Information for the user for Assignment 2.
     *
     * @author marianna hollanda
     * @since 20210201
     */
    public static void getInformation() {
        Scanner input = new Scanner(System.in);

        //Use the getPlayerName method to get the name of the player for the bowling game
        for (int playerCounter = 0; playerCounter < players.length; playerCounter++) {
            System.out.println("Enter player" + PLAYER_NUMBER[playerCounter] + " name:");
            players[playerCounter] = input.nextLine();  //burn

        }

    }

    /**
     * Get Scores for the user for Assignment 2.
     *
     * @author marianna hollanda
     * @since 20210201
     */
    public static void getScores() {

        int score = 0;

        for (int endCounter = 0; endCounter < NUMBER_OF_ENDS; endCounter++) {
            for (int playerCounter = 0; playerCounter < NUMBER_OF_PLAYERS; playerCounter++) {
                score = CisUtility.getInputInt("Enter score for " + players[playerCounter] + " :");
                playerScore[playerCounter][endCounter] = score;
                totals[playerCounter] += score;
                displayCurrentScores();
            }
        }
    }

    /**
     * Display Current Scores for Assignment 2.
     *
     * @author marianna hollanda
     * @since 20210201
     */
    public static void displayCurrentScores() {

        System.out.println("Current Scores:");

        for (int playerCounter = 0; playerCounter < NUMBER_OF_PLAYERS; playerCounter++) {

            System.out.print(players[playerCounter] + "\t");
            for (int endCounter = 0; endCounter < NUMBER_OF_ENDS; endCounter++) {
                //changed println to print
                System.out.print(playerScore[playerCounter][endCounter] + "\t");
            }
            System.out.print("| " + totals[playerCounter]);
            System.out.println("");
        }

    }

    /**
     * Show Final Scores for Assignment 2.
     *
     * @author marianna hollanda
     * @since 20210201
     */
    public static void showFinalScores() {
        String winner = "";

        if (totals[0] > totals[1] && totals[0] > totals[2] && totals[0] > totals[3]) {
            winner = players[0];
        } else if (totals[1] > totals[0] && totals[1] > totals[2] && totals[1] > totals[3]) {
            winner = players[1];
        } else if (totals[2] > totals[0] && totals[2] > totals[1] && totals[2] > totals[3]) {
            winner = players[2];
        } else if (totals[3] > totals[0] && totals[3] > totals[1] && totals[3] > totals[2]) {
            winner = players[3];
        }
        System.out.println("Congratulations " + winner);
    }
}
