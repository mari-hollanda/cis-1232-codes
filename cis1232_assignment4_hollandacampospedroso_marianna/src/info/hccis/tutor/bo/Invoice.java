package info.hccis.tutor.bo;

import java.util.Scanner;

/**
 * Tutoring service invoice
 *
 * @author BJM
 * @since 20200619
 * @modified mdw to add attributes per A6 requirements
 * @modified BJM 20201221 Prepping for A1 CIS1232
 * @modified BJM 20210111 Prepping for A3 CIS1232
 */
public class Invoice {

    //BJM 20210111 Using array to hold the costs
    public static final int NUMBER_OF_GROUP_SIZES = 4;

    //Costs stored in an array
    public static final double[] COSTS = {15, 17, 20, 25};

    //Group descriptions
    public static final String[] GROUP_DESCRIPTIONS = {"Individual", "Small Group", "Large Group", "Full Class"};

    //These can be used as index for the array
    public static final int INDIVIDUAL = 0;
    public static final int SMALL_GROUP = 1;
    public static final int LARGE_GROUP = 2;
    public static final int FULL_CLASS_GROUP = 3;

    public static final double COST_LARGE_ORDER = 200;
    public static final double BONUS_SECOND_YEAR = 0.1;
    public static final double BONUS_PAST_GRADUATE = 0.2;

    private Employee employee;

    //BJM 20210111 Asst#1 new data structure
    private double[] hours = new double[NUMBER_OF_GROUP_SIZES];
    private double total;
    private String dateStart, dateEnd;
    private int id;
    private static int nextId;

    /**
     * Default constructor
     *
     * @since 2020-12-02
     * @author mdw
     */
    public Invoice() {

        this.employee = new Employee();
    }

    /**
     * Get information from the user
     *
     * @since 2020-06-19
     * @author BJM
     *
     * @modified BJM 20210111 Using arrays for assignment#1
     */
    public void getInformation() {
        Scanner input = new Scanner(System.in);

        //Use the getInformation method from the employee object to get 
        //the attributes of the employee associated with this invoice.
        employee.getInformation();

        //BJM 20210111 - Using another parallel array to allow looping for each group hours entry
        for (int counterGroup = 0; counterGroup < NUMBER_OF_GROUP_SIZES; counterGroup++) {
            System.out.println("How many '" + GROUP_DESCRIPTIONS[counterGroup] + "' hours?");
            hours[counterGroup] = input.nextDouble();
            input.nextLine();  //burn

            if (hours[counterGroup] < 0) {
                System.out.println("Invalid entry, " + GROUP_DESCRIPTIONS[counterGroup] + " hours being set to 0");
                hours[counterGroup] = 0;
            }
        }

        System.out.println(""); //Empty line for formatting
    }

    /**
     * Returns the calculated earnings for this employee
     *
     * @since 2020-06-19
     * @author BJM
     *
     * @modified BJM 20210111 Using arrays for earnings details.
     */
    public double getEarnings() {

        double earnings = 0;
        for (int counter = 0; counter < NUMBER_OF_GROUP_SIZES; counter++) {
            earnings += hours[counter] * COSTS[counter];
        }

        //Apply bonus using a switch statement.  Multiply the earnings by 1+ the 
        //appropriate bonus amount and assign to the earnings.
        switch (employee.getEmployeeType()) {
            case Employee.TYPE_SECOND_YEAR:
                earnings *= (1 + BONUS_SECOND_YEAR);
                break;
            case Employee.TYPE_PAST_GRADUATE:
                earnings *= (1 + BONUS_PAST_GRADUATE);
                break;

        }
        return earnings;
    }

    //New getters and setters added per A6 requirements
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Invoice.nextId = nextId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void display() {
        System.out.println(this.toString());
    }

    public String toString() {
        String largeEarningsDescription = "";
        double earnings = getEarnings();
        if (earnings > COST_LARGE_ORDER) {
            largeEarningsDescription = " (Large Earnings!)";
        }

        String outputHoursDetails = "";
        
        //BJM 20210111 - Using another parallel array to allow looping for each group hours display
        for (int counterGroup = 0; counterGroup < NUMBER_OF_GROUP_SIZES; counterGroup++) {
            outputHoursDetails += "Number of '" + GROUP_DESCRIPTIONS[counterGroup] + "' hours: " + hours[counterGroup]+"\n";
        }

        String output = "Summary for " + employee.getName() + largeEarningsDescription
                + "\n"
                //Added calls to return attributes collected in Employee class
                + "Phone number: " + employee.getPhoneNumber()
                + "\n"
                + "Email address: " + employee.getEmail()
                + "\n"
                + "Employee type: " + employee.getEmployeeType()
                + "\n"
                +outputHoursDetails
                + "Earnings:  $" + (String.format("%,.2f", earnings)) + " \n"
                + "\n";
        return output;
    }

}
