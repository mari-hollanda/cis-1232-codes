package info.hccis.tutor.bo;

import info.hccis.tutor.base.EmployeeBase;

/**
 * Represents a first year student
 * @author bjmac
 * @since 15-Mar-2021
 */
public class EmployeeFirstYearStudent extends EmployeeBase{

    public EmployeeFirstYearStudent(){
        //default constructor
    }

    /**
     * Custom constructor
     * @param name Name
     * @param phone Phone Number
     * @param email Email Address
     * @since 20210322
     * @author BJM
     */
    public EmployeeFirstYearStudent(String name, String phone, String email) {
        super(name, phone, email);
    }
    
    @Override
    public String toString(){
        return "Employee: First Year Student\n"+super.toString();
    }
    
}
