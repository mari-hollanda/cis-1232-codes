package info.hccis.tutor;

import cis.util.CisUtility;
import info.hccis.tutor.bo.Invoice;
import java.util.ArrayList;

/**
 * CIS Tutoring Software
 *
 * @author bjmaclean
 * @since 20210111
 */
public class Controller {
    
    public static final String EXIT = "X";
    
    private static final String MENU
            = "-------------------------\n"
            + "- CIS Menu\n"
            + "- 1-Add An Invoice\n"
            + "- 2-Show Total So Far\n"
            + "- X-eXit\n"
            + "-------------------------\n"
            + "Option-->";
    
    private static double totalSoFar = 0;
    
    public static void main(String[] args) {

        //**********************************************************************
        //Add a loop below to continuously promput the user for their choice 
        //until they choose to exit.
        //**********************************************************************
        String option = "";

        CisUtility.display("Welcome to CIS Tutoring ("+CisUtility.getCurrentDate(null)+")");
        
        
        do {
            option = CisUtility.getInputString(MENU);
            processMenuOption(option);
        } while (!option.equalsIgnoreCase(EXIT));
        
    }

    /**
     * This method will process the menu option specified in the input
     * parameter. It will call appropriate functionality based on its value.
     *
     * @param option The menu option
     * @since 20171102
     * @author cis1201b
     *
     */
    public static void processMenuOption(String option) {
        //Add a switch to process the option
        switch (option.toUpperCase()) {
            case "1":
                CisUtility.display("Add an invoice");
                Invoice invoice = new Invoice();
                invoice.getInformation();
                invoice.display();
                totalSoFar += invoice.getEarnings();
                break;
            case "2":
                CisUtility.display("Show total so far");
                System.out.println("Total so far: $"+totalSoFar);
                break;
            case "X":
                CisUtility.display("Thanks for using the program.  ");
                break;
            default:
                CisUtility.display("Invalid entry");
        }
    }
    
}
