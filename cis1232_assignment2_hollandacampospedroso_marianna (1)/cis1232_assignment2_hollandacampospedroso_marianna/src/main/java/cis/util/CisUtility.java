package cis.util;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Class containing utility methods that are useful for our projects.
 *
 * @author bjmaclean
 * @since 20181115
 */
public class CisUtility {

    private static Scanner input = new Scanner(System.in);

    //The isGUI will be used to determine if JOptionPane is used or console
    private static boolean isGUI = false;

    public static void setIsGUI(boolean isGUI) {
        CisUtility.isGUI = isGUI;
    }


    /*
    Methods to get input from the user
     */
    /**
     * Method which will prompt the user and return the value entered as a
     * String.
     *
     * @author BJ MacLean
     * @param prompt The user prompt
     * @return The String entered by the user
     * @since 20181121
     */
    public static String getInputString(String prompt) {

        String userOption;

        if (isGUI) {
            userOption = JOptionPane.showInputDialog(prompt);
        } else {
            System.out.println(prompt);
            userOption = input.nextLine();
        }

        return userOption;
    }

    /**
     * Method which will prompt the user and return an int value.
     *
     * @author BJ MacLean
     * @param prompt The user prompt
     * @return The number entered by the user
     * @since 20181121
     */
    public static int getInputInt(String prompt) {
        String enteredString = getInputString(prompt);
        int entered = Integer.parseInt(enteredString);
        return entered;
    }

    /**
     * Method which will prompt the user and return a double value.
     *
     * @author BJ MacLean
     * @param prompt The user prompt
     * @return The number entered by the user
     * @since 20181121
     */
    public static double getInputDouble(String prompt) {
        String enteredString = getInputString(prompt);
        double entered = Double.parseDouble(enteredString);
        return entered;
    }

    /**
     * Method to display a string for the user
     *
     * @param output The string that will be displayed to the user
     * @since 20181115
     * @author BJM
     */
    public static void display(String output) {
        //System.out.println(output);
        if (isGUI) {
            JOptionPane.showMessageDialog(null, output);
        } else {
            System.out.println(output);
        }
    }

    /**
     * This will nicely display an array.
     * @author BJ MacLean
     * @since 20190116
     */
    
    public static String display(int[] theArray) {

        boolean isFirstElement = true;
        
        String output = "[";
        for (int current : theArray) {
            if(!isFirstElement){
                output += ",";
            }
            output += current;
            isFirstElement = false;            
        }
        output += "]";
        display(output);
        return output;
    }

    /**
     * This method will use the Math class to get a random number between 1 and
     * the max inclusive.
     *
     * @author BJ MacLean
     * @param max The upper limit for the random number (inclusive)
     * @since 20181121
     */
    public static int getRandom(int max) {
        return 1 + (int) (Math.random() * max);
    }

}
