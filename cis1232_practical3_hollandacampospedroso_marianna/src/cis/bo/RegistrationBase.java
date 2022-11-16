package cis.bo;

import cis.base.CisStandardBO;
import cis.util.CisUtility;

/**
 * RegistrationBase Class
 *
 * @author Marianna Hollanda
 * @since 20210406
 */
public abstract class RegistrationBase implements CisStandardBO {
    private String name;
    private String address;
    private int birthYear;

    /**
     * Default constructor
     *
     * @author Marianna Hollanda
     * @since 20210406
     */
    public RegistrationBase() {

    }

    /**
     * Custom constructor which accepts all attributes
     *
     * @param name
     * @param address
     * @param birthYear
     * @author Marianna Hollanda
     * @since 20210406
     */
    public RegistrationBase(String name, String address, int birthYear) {
        this.name = name; //use the constructor that accepts name
        this.address = address; //Also set the email
        this.birthYear = birthYear; //Also set the phone number
    }

     /**
     * Get information from the user
     *
     * @author Marianna Hollanda
     * @since 20210406
     */
    @Override
    public void getInformation(){      
        name = CisUtility.getInputString("Name:");
        address = CisUtility.getInputString("Address:");
        birthYear = CisUtility.getInputInt("BirthYear (ie. 2009):");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
  
    @Override
    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {

        String output = "Name: " + name + "\n"
                + "Address: " + address + "\n"
                + "Birth Year: " + birthYear + "\n";
        return output;
    }
    
}
