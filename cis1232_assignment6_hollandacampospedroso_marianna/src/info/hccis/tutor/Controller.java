package info.hccis.tutor;

import cis.util.CisUtility;
import info.hccis.tutor.base.EmployeeBase;
import info.hccis.tutor.bo.EmployeeFirstYearStudent;
import info.hccis.tutor.bo.Invoice;
import info.hccis.tutor.bo.EmployeePastGraduate;
import info.hccis.tutor.bo.EmployeeSecondYearStudent;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * CIS Tutoring Software
 *
 * @author bjmaclean
 * @since 20210111
 */
public class Controller {

    /**
     * *************************************************************************
     * todo 1 Make Employee abstract The Employee class is currently a normal
     * Java class which is used for inheritance and is the base class for thre
     * three types of Employees which are possible in the project. Make Employee
     * an abstract class and refactor it to be named EmployeeBase
     * *************************************************************************
     */
    /**
     * *************************************************************************
     * todo 2 Taxable Interface Create an Interface called Taxable which has an
     * abstract method and two constants. Note that the constants are static (as
     * usual). Create this interface in the appropriate base package. See below
     * for interface details:
     *
     * +calculateTaxAmount: double      //abstract method
     * +TAX_PERCENTAGE_STUDENT: double = 0.15
     * +TAX_PERCENTAGE_NON_STUDENT: double = 0.20
     *
     **************************************************************************
     */
    /**
     * *************************************************************************
     * todo 3 Make Invoice Taxable Have the Invoice class implement the
     * interface. When implementing the abstract method in the Invoice class,
     * use the constants to determine the applicable amount of tax. When showing
     * the details on an Invoice in the toString method - after the amount of
     * earnings, show the amount of tax which will be withheld.
     *
     * The calculateTaxAmount method should use the constants to determine the
     * tax amount based on the tax percentage constants. First year and second
     * year student employee types have a 15 percent tax rate while past
     * graduates have 20 percent tax rate. The amount of tax is the applicable
     * rate multiplied by their earnings.
     *
     * Ie. If their earnings are $140 for a past graduate their tax amount would
     * be $28.
     *
     **************************************************************************
     */
    public static final String EXIT = "X";

    private static final String MENU
            = "-------------------------\n"
            + "- CIS Menu\n"
            + "- 1-Add An Invoice\n"
            + "- 2-Show Total So Far\n"
            + "- 3-Show All Invoices\n"
            + "- 4-Show All Invoices for past graduates\n"
            + "- X-eXit\n"
            + "-------------------------\n"
            + "Option-->";

    private static ArrayList<Invoice> invoices = new ArrayList();

    public static void main(String[] args) {

        //Load initial test data
        initialize(invoices);

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
                invoices.add(invoice);
                break;
            case "2":
                CisUtility.display("Show total so far");
                //Add up total
                double total = 0;
                for (Invoice current : invoices) {
                    total += current.getEarnings();
                }
                System.out.println("Total so far: $" + total);
                break;
            case "3":
                showAllInvoices();
                break;
            case "4":
                showInvoiceForPastGraduates();
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
     */
    public static void showAllInvoices() {
        System.out.println(""); //empty line
        System.out.println("Invoice List (" + invoices.size() + " invoices)");
        System.out.println(""); //empty line
        for (Invoice current : invoices) {
            current.display();
        }
    }

    /**
     * Show all invoices for past graduate employee types.
     *
     * @since 20210315
     * @author BJM
     */
    public static void showInvoiceForPastGraduates() {

        /**
         * *********************************************************************
         *
         * The following will show all invoices. Make changes to the code to
         * allow only invoices that contain employees whom are instances of
         * PostGraduateEmployees
         * *****************************************************************
         */
        for (Invoice current : invoices) {
            if (current.getEmployee() instanceof EmployeePastGraduate) {
                current.display();
            }
        }
    }

    /**
     * Add some test data.
     *
     * @since 20210322
     * @author BJM
     */
    public static void initialize(ArrayList<Invoice> invoices) {

        EmployeeBase e1 = new EmployeeFirstYearStudent("Jon Smith", "9022223456", "jsmith@gmail.com");
        EmployeeBase e2 = new EmployeeSecondYearStudent("Phil Myers", "9022228855", "pmyers@gmail.com");
        EmployeeBase e3 = new EmployeePastGraduate("George Donovan", "9022227777", "gdonovan@gmail.com", 2019);

        double[] hours1 = {2, 1, 1, 1};
        double[] hours1b = {1, 0, 0, 0};
        double[] hours2 = {2, 0, 0, 0};
        double[] hours3 = {0, 0, 3, 0};

        Invoice i1 = new Invoice(e1, "2021-02-01", "2021-02-28", hours1);
        Invoice i1b = new Invoice(e1, "2021-03-01", "2021-03-31", hours1b);
        Invoice i2 = new Invoice(e2, "2021-02-01", "2021-02-28", hours2);
        Invoice i3 = new Invoice(e3, "2021-02-01", "2021-02-28", hours3);

        invoices.add(i1);
        invoices.add(i1b);
        invoices.add(i2);
        invoices.add(i3);
    }
}
