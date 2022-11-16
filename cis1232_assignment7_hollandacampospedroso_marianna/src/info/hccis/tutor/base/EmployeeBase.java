package info.hccis.tutor.base;

import java.util.Objects;
import java.util.Scanner;

/**
 * Class represents an employee for tutorial services
 *
 * @author bjm
 * @since 2020-06-19
 */
public abstract class EmployeeBase {

    public static final double BONUS_SECOND_YEAR = 0.1;
    public static final double BONUS_PAST_GRADUATE = 0.2;

    private int id; //Unique sequential id for this employee
    private String name;
    private String phoneNumber;
    private String email;

    private static int nextId;  //Used to hold the next available id

    /**
     * Default constructor
     *
     * @since 2020-06-19
     * @author BJM
     */
    public EmployeeBase() {
        //Increment the next id and assign it to this employees id.
        this.id = ++nextId;
    }

    /**
     * Custom constructor
     *
     * @param name
     * @since 2020-06-19
     * @author BJM
     */
    public EmployeeBase(String name) {
        //Increment the next id and assign it to this employees id.
        this.id = ++nextId;
        this.name = name;
    }

    /**
     * Custom constructor which accepts all attributes
     *
     * @param name
     * @param email
     * @since 20210322
     * @author BJM
     */
    public EmployeeBase(String name, String phone, String email) {
        this(name); //use the constructor that accepts name
        this.email = email; //Also set the email
        this.phoneNumber = phone; //Also set the phone number
    }

    /**
     * Get information from the user
     *
     * @since 2020-06-19
     * @author BJM
     */
    public void getInformation() {

        //DONE Obtain values for the EmployeeBase attributes to match the class diagram
        Scanner input = new Scanner(System.in);
        System.out.println("Tutor’s name?");
        //DONE Name entered is firstname and lastname as one String entry
        //DONE Validate first letters are uppercase, rest are lowercase
        name = input.nextLine();
        System.out.println("Email address:");
        email = input.nextLine();

        System.out.println("Phone number (No spaces or hyphens):");
        phoneNumber = input.nextLine();

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
        EmployeeBase.nextId = nextId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {

        String output = "Name: " + name + "\n"
                + "Phone number: " + phoneNumber + "\n"
                + "Email: " + email + "\n";
        return output;
    }
}
