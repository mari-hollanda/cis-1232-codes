package cis.bo;

import cis.util.CisUtility;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Represents a player
 *
 * @author bjmac
 * @since 2-Mar-2021
 */
public class Student {

    private String name = "";
    private String phone;
    private String instrument;
    private String dateOfBirth;

    //Constructors
    public Student() {
    }
    public Student(String name, String phone, String instrument, String dateOfBirth) {
        this.name = name;
        this.phone = phone;
        this.instrument = instrument;
        this.dateOfBirth = dateOfBirth;
    }
    
    public void getInformation() {

        name = CisUtility.getInputString("Enter name");
        phone = CisUtility.getInputString("Enter phone number");
        instrument = CisUtility.getInputString("Position (Guitar, Piano, Violin)");
        dateOfBirth = CisUtility.getInputString("Date of birth");
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String output = "Name:" + name + "\n"
                + "Phone:" + phone + "\n"
                + "Instrument:" + instrument + "\n"
                + "Date of birth:" + dateOfBirth + "\n";


        return output;
    }

    @Override
    public int hashCode() {
        int hash = name.length();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;

        boolean namesMatch = this.name.equalsIgnoreCase(other.getName());

        return namesMatch;
    }

}
