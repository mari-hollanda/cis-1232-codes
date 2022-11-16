package info.hccis.tutor.bo;

import java.util.Scanner;

/**
 * Class represents an employee for tutorial services
 *
 * @author bjm
 * @since 2020-06-19
 */
public class Employee {

    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_FIRST_YEAR = 1;
    public static final int TYPE_SECOND_YEAR = 2;
    public static final int TYPE_PAST_GRADUATE = 3;

    public static final double BONUS_SECOND_YEAR = 0.1;
    public static final double BONUS_PAST_GRADUATE = 0.2;

    private int id; //Unique sequential id for this employee
    private String name;
    private int employeeType = 0;
    private String phoneNumber = "";
    private String email;

    private static int nextId;  //Used to hold the next available id

    /**
     * Default constructor
     *
     * @since 2020-06-19
     * @author BJM
     */
    public Employee() {
        //Increment the next id and assign it to this employees id.
        this.id = ++nextId;
    }

    /**
     * Custom constructor
     *
     * @since 2020-06-19
     * @author BJM
     */
    public Employee(String name, int employeeType) {
        //Increment the next id and assign it to this employees id.
        this.id = ++nextId;
        this.name = name;
        this.employeeType = employeeType;
    }

    /**
     * Get information from the user
     *
     * @since 2020-06-19
     * @author BJM
     * 
     * @modified mdw to capture and validate email, phone number, and First Last
     * name format per A6 requirements
     * @modified BJM 2021221 Prepping for A1
     */
    public void getInformation() {

        //DONE Obtain values for the Employee attributes to match the class diagram
        Scanner input = new Scanner(System.in);
        System.out.println("Tutor’s name?");
        //DONE Name entered is firstname and lastname as one String entry
        //DONE Validate first letters are uppercase, rest are lowercase
        name = input.nextLine();
        System.out.println("Email address:");
        email = input.nextLine();

        System.out.println("Phone number (No spaces or hyphens):");
        phoneNumber = input.nextLine();

        System.out.println("Employee Type (1=First Year 2=Second Year 3=Past Graduate)?");
        employeeType = input.nextInt();
        input.nextLine();  //burn

        System.out.println(""); //Empty line for formatting
    }

    //New getters and setters added for new attributes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Employee.nextId = nextId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(int employeeType) {
        this.employeeType = employeeType;
    }

    public void display() {
        System.out.println(this.toString());
    }

    public String toString() {

        String employeeTypeDescription = "Unknown";
        switch (employeeType) {
            case TYPE_FIRST_YEAR:
                employeeTypeDescription = "First Year";
                break;
            case TYPE_SECOND_YEAR:
                employeeTypeDescription = "Second Year";
                break;
            case TYPE_PAST_GRADUATE:
                employeeTypeDescription = "Past Graduate";
                break;
        }

        String output = "Summary for " + name
                + "\n"
                + "Employee type: " + employeeTypeDescription
                + "\n";
        return output;
    }
}
