package info.hccis.tutor.bo;

import info.hccis.tutor.base.EmployeeBase;
import cis.util.CisUtility;
import info.hccis.tutor.base.Taxable;
import java.util.Scanner;

/**
 * Tutoring service invoice
 *
 * @author BJM
 * @since 20200619
 *
 * @modified BJM 20201221 Prepping for A1 CIS1232
 * @modified BJM 20210111 Prepping for A3 CIS1232
 */
public class Invoice implements Taxable{
    // public class Invoice implements Taxable, Comparable<Invoice>{
    // Colocar isso aqui embaixo depois: 
//        @Override
//    public int compareTo(Invoice o) {
//        return this.id - o.id;
//    }

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

    private EmployeeBase employee;

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
        id = getNextId();
        
    }

    /**
     * This constructor will set the attributes.This is mainly used in the 
 initialize method.
     * @param employee
     * @param dateStart
     * @param dateEnd
     * @param hours
     * @since 20210322
     * @author BJM
     */
    public Invoice(EmployeeBase employee, String dateStart, String dateEnd, double[] hours) {
        id = getNextId();
        this.employee = employee;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.hours = hours;
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

        /***********************************************************************
         * 
         * Ask the user which type of employee they would like to create.  First Year, 
         * Second Year, or Past Graduate would be the three options.  Create the 
         * correct type of employee to be assigned to the employee attribute.  
         * 
         ***********************************************************************/
        
        String type = CisUtility.getInputString("Employee type (1: First Year, 2: Second Year, or 3: Past Graduate)?");
        
        switch(type){
            case "1":
                employee = new EmployeeFirstYearStudent();
                break;
            case "2":
                employee = new EmployeeSecondYearStudent();
                break;
            case "3":
                employee = new EmployeePastGraduate();
                break;
        }

        employee.getInformation();

        dateStart = CisUtility.getInputString("Start date");
        dateEnd = CisUtility.getInputString("End date");
        
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
     * @modified BJM 20210315 Prep for assignment 5
     */
    public double getEarnings() {

        double earnings = 0;
        for (int counter = 0; counter < NUMBER_OF_GROUP_SIZES; counter++) {
            earnings += hours[counter] * COSTS[counter];
        }

        /***********************************************************************
         * 
         * This will require you to use the instanceof
         * operator to determine the type of the object. Using if selection
         * structure, determine the type of employee and apply the correct bonus
         * to the earnings.
         * 
         * Note that SecondYearStudentEmployee will get a bonus and 
         * PastGraduateEmployee will get a different bonus.  See the constants in 
         * the Employee class (for the amounts).
         ***********************************************************************/

        
        //code needed
        if(employee instanceof EmployeeSecondYearStudent){
            earnings += earnings*EmployeeBase.BONUS_SECOND_YEAR;
        }else if(employee instanceof EmployeePastGraduate){
            earnings += earnings*EmployeeBase.BONUS_PAST_GRADUATE;
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
        return ++nextId;
    }

    public EmployeeBase getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeBase employee) {
        this.employee = employee;
    }

    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        
        /***********************************************************************
         * Provide large earnings details.
         **********************************************************************/
        String largeEarningsDescription = "";
        double earnings = getEarnings();
        if (earnings > COST_LARGE_ORDER) {
            largeEarningsDescription = " (Large Earnings!)";
        }

        /***********************************************************************
         * Provide hour details.
         **********************************************************************/
        String outputHoursDetails = "";

        //BJM 20210111 - Using another parallel array to allow looping for each group hours display
        for (int counterGroup = 0; counterGroup < NUMBER_OF_GROUP_SIZES; counterGroup++) {
            outputHoursDetails += "Number of '" + GROUP_DESCRIPTIONS[counterGroup] + "' hours: " + hours[counterGroup] + "\n";
        }

        /***********************************************************************
         * Put it all together
         **********************************************************************/

        String output = "Invoice #"+id+" Date of invoice: "+dateStart+" to "+dateEnd
                + "\n\n"
                +employee.toString()
                + "\n"
                + outputHoursDetails
                + "Earnings:  $" + (String.format("%,.2f", earnings)) + " \n"
                + "Tax amount:  $" + (String.format("%,.2f", calculateTaxAmount())) + " \n"
                + "\n";
        return output;
    }

    /**
     * Implementing the abstract method to return the correct tax amount
     * @since 20210325
     * @author BJM
     */
    @Override
    public double calculateTaxAmount() {
        
        //student rate default using constant from implemented interface
        double rate = TAX_PERCENTAGE_STUDENT; 
        
        if(this.employee instanceof EmployeePastGraduate){
            rate = TAX_PERCENTAGE_NON_STUDENT;
        }
        
        //return the earnings * the applicable rate
        return getEarnings()*rate;
    }

}
