package info.hccis.tutor;

import cis.util.CisUtility;
import info.hccis.tutor.bo.Employee;
import info.hccis.tutor.bo.Invoice;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * CIS Tutoring Software
 *
 * @author bjmaclean
 * @since 20210111
 * @modified by Marianna Hollanda
 * @since 20210219 Added the requirements from Assignment 3
 */
public class Controller {

    public static final String EXIT = "X";

    private static final String MENU
            = "-------------------------\n"
            + "- CIS Menu\n"
            + "- 1-Add An Invoice\n"
            + "- 2-Show Total So Far\n"
            + "- 3-Show All Invoices\n"
            + "- 4-Show All Distinct Employees\n"
            + "- X-eXit\n"
            + "-------------------------\n"
            + "Option-->";

    private static double totalSoFar = 0;

    private static ArrayList<Invoice> invoiceList = new ArrayList();

    public static void main(String[] args) {

        //**********************************************************************
        //Add a loop below to continuously promput the user for their choice 
        //until they choose to exit.
        //**********************************************************************
        String option = "";

        CisUtility.display("Welcome to CIS Tutoring (" + CisUtility.getCurrentDate(null) + ")");

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
     * @since 20210219 Added invoiceList.add(invoice) to keep the invoices in
     * the collection.
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
                invoiceList.add(invoice);
                break;
            case "2":
                CisUtility.display("Show total so far");
                System.out.println("Total so far: $" + totalSoFar);
                break;
            case "3":
                showAllInvoices();
                break;
            case "4":
                showDistinctEmployees();
                break;
            case "X":
                CisUtility.display("Thanks for using the program.  ");
                break;
            default:
                CisUtility.display("Invalid entry");
        }
    }

    /**
     * Show all the invoices in the invoices list
     *
     * @since 20210111
     * @author BJM
     * @modified by Marianna Hollanda
     * @since 20210219 Created an forEach for an ArrayList.
     */
    public static void showAllInvoices() {
        System.out.println("Invoice List (" + invoiceList.size() + " invoices)");
        System.out.println("");

        invoiceList.forEach((invoice) -> {
            System.out.println(invoice.toString());
        });

    }

    /**
     * Show a distinct list of employees that exist in the invoices list
     *
     * @since 20210111
     * @author BJM
     * @modified by Marianna Hollanda
     * @since 20210219 Created two forEach for an ArrayList.
     */
    public static void showDistinctEmployees() {
        System.out.println("Distinct employee list \n");

        HashSet<Employee> employees = new HashSet();

        invoiceList.forEach((invoice) -> {
            employees.add(invoice.getEmployee());
        });

        employees.forEach((element) -> {

            System.out.println(element.toString());
        });
    }

}
