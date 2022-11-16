package info.hccis.tutor.bo;

import java.util.Scanner;

/**
 * Tutoring service invoice
 *
 * @author BJM
 * @since 20200619
 * @modified mdw to add attributes per A6 requirements
 * @modified BJM 20201221 Prepping for A1 CIS1232
 * @modified Marianna Hollanda 20210116 Replaced the old attributes to new array attributes 
 * @modified Marianna Hollanda 20210116 Added a Full Cass option for the Invoice.
 */
public class Invoice {

    //DONE Add Invoice attributes per A6
    //  public static final double COST_INDIVIDUAL = 15;
    //  public static final double COST_SMALL_GROUP = 17;
    // public static final double COST_LARGE_GROUP = 20;
    public static final double COST_LARGE_ORDER = 200;

    private double[] hours = new double[4];
    public static final double[] COSTS = {15, 17, 20,25};
    public static final String[] DESCRIPTION_GROUPS = {"Individual", "Small Group", "Large Group", "Full Class"};
    public static final int INDIVIDUAL = 0;  //These can be used as index for the array
    public static final int SMALL_GROUP = 1;
    public static final int LARGE_GROUP = 2;
    public static final int FULL_CLASS = 3;

    public static final double BONUS_SECOND_YEAR = 0.1;
    public static final double BONUS_PAST_GRADUATE = 0.2;

    private Employee employee;

    private double hoursIndividual, hoursSmallGroup, hoursLargeGroup, hoursFullClass;
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
     * @modified Marianna Hollanda 20210116 Added a loop to modify the way it populates the values in the hours array.
     */
    public void getInformation() {
        Scanner input = new Scanner(System.in);

        //Use the getInformation method from the employee object to get 
        //the attributes of the employee associated with this invoice.
        employee.getInformation();

        for (int i = 0; i < 4; i++) {

            System.out.println("How many '" + DESCRIPTION_GROUPS[i] + "' hours?");
            hours[i] = input.nextDouble();
            input.nextLine();  //burn

            if (hours[i] < 0) {
                System.out.println("Invalid entry, " + DESCRIPTION_GROUPS[i] + " hours being set to 0");
                hours[i] = 0;
            }

        }

        System.out.println(""); //Empty line for formatting
    }

    /**
     * Returns the calculated earnings for this employee
     *
     * @since 2020-06-19
     * @author BJM
     * @modified Marianna Hollanda 20210116 Added a loop to modify the way it sets the initial earnings amount
     */
    public double getEarnings() {
        double earnings = 0;
        
        for(int i = 0; i < 4; i++){
            earnings+= hours[i] * COSTS[i];
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

    public double getHoursIndividual() {
        return hours[0];
    }

    public void setHoursIndividual(double hoursIndividual) {
        this.hours[0] = hoursIndividual;
    }

    public double getHoursSmallGroup() {
        return hours[1];
    }

    public void setHoursSmallGroup(double hoursSmallGroup) {
        this.hours[1] = hoursSmallGroup;
    }

    public double getHoursLargeGroup() {
        return hours[2];
    }

    public void setHoursLargeGroup(double hoursLargeGroup) {
        this.hours[2] = hoursLargeGroup;
    }

    public double getHoursFullClass() {
        return hours[3];
    }

    public void setHoursFullClass(double hoursFullClass) {
        this.hours[3] = hoursFullClass;
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
        String output = "Summary for " + employee.getName() + largeEarningsDescription
                + "\n"
                //Added calls to return attributes collected in Employee class
                + "Phone number: " + employee.getPhoneNumber()
                + "\n"
                + "Email address: " + employee.getEmail()
                + "\n"
                + "Employee type: " + employee.getEmployeeType()
                + "\n"
                + "Number of 'Individual' hours: " + hours[0]
                + "\n"
                + "Number of 'Small Group' hours: " + hours[1]
                + "\n"
                + "Number of 'Large Group' hours: " + hours[2]
                + "\n"
                + "Number of 'Full Class' hours: " + hours[3]
                + "\n"
                //DONE Currency amount format: $3,456.75
                //Solution format() method adopted from https://stackoverflow.com/questions/2379221/java-currency-number-format
                + "Earnings:  $" + (String.format("%,.2f", earnings)) + " \n"
                + "\n";
        return output;
    }

}
