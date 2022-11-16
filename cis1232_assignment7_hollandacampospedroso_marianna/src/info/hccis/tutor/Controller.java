package info.hccis.tutor;

import cis.util.CisUtility;
import info.hccis.tutor.base.EmployeeBase;
import info.hccis.tutor.bo.EmployeeFirstYearStudent;
import info.hccis.tutor.bo.Invoice;
import info.hccis.tutor.bo.EmployeePastGraduate;
import info.hccis.tutor.bo.EmployeeSecondYearStudent;
import java.util.ArrayList;
import java.util.Collections; 
import java.util.Comparator; 
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
     * DONE Make Employee abstract The Employee class is currently a normal Java
     * class which is used for inheritance and is the base class for the three
     * types of Employees which are possible in the project. Make Employee an
     * abstract class and refactor it to be named EmployeeBase
     * *************************************************************************
     */
    /**
     * *************************************************************************
     * DONE 2 Taxable Interface Create an Interface called Taxable which has an
     * abstract method and two constants. Note that the constants are static (as
     * usual). Create this interface in the appropriate base package. See below
     * for interface details:
     *
     * +calculateTaxAmount: double //abstract method +TAX_PERCENTAGE_STUDENT:
     * double = 0.15 +TAX_PERCENTAGE_NON_STUDENT: double = 0.20
     *
     **************************************************************************
     */
    /**
     * *************************************************************************
     * DONE 3 Make Invoice Taxable Have the Invoice class implement the
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
     * @modified by Marianna Hollanda
     * @since 20210401
     * Source: https://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/
     */
    public static void showAllInvoices() {

/*----------------------------------------------------------------------
- DONE 1: Sort options menu
- Give the user the option to sort by 1-id or 2-start date of invoice
- or 3) sort by name.
-----------------------------------------------------------------------*/

 /* ----------------------------------------------------------------------
- DONE 2 Comparable - Order by id
- give the option to show invoice sorted in two different ways.
- The first approach is to have the invoice class define the natural ordering
- of invoices.  This is to be defined as ordred by id.  The Comparable 
- interface is to be implemented and the compareTo method to return its value
- based on the id of the invoice.
-----------------------------------------------------------------------*/

 /* ----------------------------------------------------------------------
- DONE 3 Order by Start
 - Use a comparator to provide the functionalit to show ordered 
- by start date of the invoice.
-----------------------------------------------------------------------*/

 /* ----------------------------------------------------------------------
- DONE 4 Order by employee name
 - Use a comparator to provide the functionality to show ordered 
- by name of the employee contained in the invoice.
-----------------------------------------------------------------------*/

       String sortMethod = CisUtility.getInputString("Sort Option: \n"
                + "1-sort by id \n"
                + "2-sort by start date of invoice \n"
                + "3-sort by name of employee in invoice");
        
        switch(sortMethod){
            case "1":
                Collections.sort(invoices, IdComparator);
                // Collections.sort(invoices);
                break;
            case "2":
               Collections.sort(invoices, DateComparator);
               // Collections.sort(invoices, new ComparatorInvoiceStartDate());
                break;
            case "3":
                Collections.sort(invoices, NameComparator);
                // Collections.sort(invoices, new ComparatorInvoiceName());
                break;
        }

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

    //Sort by ID
    public static Comparator<Invoice> IdComparator = new Comparator<Invoice>() {
	public int compare(Invoice i1, Invoice i2) {
            int invoiceId1 = i1.getId();
            int invoiceId2 = i2.getId();
            return invoiceId1-invoiceId2;  
    }  
    };
    
    //Sort by Starting Date
    public static Comparator<Invoice> DateComparator = new Comparator<Invoice>() {
	public int compare(Invoice d1, Invoice d2) {
	   String InvoiceDate1 = d1.getDateStart().toUpperCase();
	   String InvoiceDate2 = d2.getDateStart().toUpperCase();
           return InvoiceDate1.compareTo(InvoiceDate2);          
    }         
    };
    
    //Sort by Employee Name
    public static Comparator<Invoice> NameComparator = new Comparator<Invoice>() {
	public int compare(Invoice e1, Invoice e2) {
	   String EmployeeName1 = e1.getEmployee().getName().toUpperCase();
	   String EmployeeName2 = e2.getEmployee().getName().toUpperCase();
           return EmployeeName1.compareTo(EmployeeName2);   
    }          
    };
}



// Em uma outra classe que não é o Controller (Criar uma):
//public class ComparatorInvoiceStartDate implements Comparator<Invoice> {
//
//    @Override
//    public int compare(Invoice o1, Invoice o2) {
//        return o1.getDateStart().compareTo(o2.getDateStart());
//    }
//    
//}

//Em outra também que não é nenhuma das duas:
//public class ComparatorInvoiceName implements Comparator<Invoice>{
//
//    @Override
//    public int compare(Invoice o1, Invoice o2) {
//        return o1.getEmployee().getName().compareTo(o2.getEmployee().getName());
//    }
//    
//}


