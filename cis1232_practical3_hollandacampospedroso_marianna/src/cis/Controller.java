package cis;

import cis.util.CisUtility;
import cis.base.CisStandards;
import cis.bo.RegistrationBase;
import cis.bo.RegistrationHockey;
import cis.bo.RegistrationSquash;
import cis.comparator.ComparatorByBirthYear;
import cis.comparator.ComparatorByName;
import java.util.ArrayList;
import java.util.Collections;

/**
 * P3. Main Class
 *
 * @author bjmaclean
 * @since 20210401
 * @modified by Marianna Hollanda
 * @since 20210406
 * Added requirements for practical 3
 */
public class Controller implements CisStandards {

    public static ArrayList<RegistrationBase> registration = new ArrayList();
    
    public static final String EXIT = "X";

    /*
        Note that the constants for colors are used to color the output in the console.
    */
    private static final String MENU
            = LINEFEED+BLUE + "-------------------------"+LINEFEED
            + BLUE + "-" + BLACK + " CIS Registration Menu"+LINEFEED
            + BLUE + "-" + BLACK + " A-Register Hockey Player"+LINEFEED
            + BLUE + "-" + BLACK + " B-Register Squash Player"+LINEFEED
            + BLUE + "-" + BLACK + " C-Show all registrations sorted by name"+LINEFEED
            + BLUE + "-" + BLACK + " D-Show all registrations sorted by birth year"+LINEFEED
            + BLUE + "-" + BLACK + " X-eXit"+LINEFEED
            + BLUE + "-------------------------"+LINEFEED
            + BLUE + "Option" + BLACK;

    public static void main(String[] args) {

        String option = "";
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
     * @modified by Marianna Hollanda
     * @since 20200406
     *
     */
    public static void processMenuOption(String option) {
        //Add a switch to process the option
        switch (option.toUpperCase()) {
            case "A":
                CisUtility.display("Register Hockey Player");
                RegistrationHockey hockey = new RegistrationHockey();
                hockey.getInformation();
                hockey.display();
                registration.add(hockey);
                break;
            case "B":
                CisUtility.display("Register Squash Player");
                RegistrationSquash squash = new RegistrationSquash();
                squash.getInformation();
                squash.display();
                registration.add(squash);
                break;
            case "C":
                CisUtility.display("Show all registrations sorted by name");
                Collections.sort(registration, new ComparatorByName());
                System.out.println(registration);
                break;
            case "D":
                CisUtility.display("Show all registrations sorted by birth year");
                Collections.sort(registration, new ComparatorByBirthYear());
                System.out.println(registration);
                break;
            case "X":
                CisUtility.display("Goodbye");
                break;
            default:
                CisUtility.display("Invalid entry");
        }
    }
}
