package info.hccis.tutor.bo;

import info.hccis.tutor.base.EmployeeBase;

/**
 * Represents a 
 * @author bjmac
 * @since 15-Mar-2021
 */
public class EmployeeSecondYearStudent extends EmployeeBase{

    //default constructor
    public EmployeeSecondYearStudent() {
    }

    /**
     * Custom constructor
     * @param name Name
     * @param phone Phone Number
     * @param email Email Address
     * @since 20210322
     * @author BJM
     */
    public EmployeeSecondYearStudent(String name, String phone, String email) {
        super(name, phone, email);
    }
    
    @Override
    public String toString(){
        return "Employee: Second Year Student\n"+super.toString();
    }
    
}
