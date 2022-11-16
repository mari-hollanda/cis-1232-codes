package info.hccis.tutor.bo;

import info.hccis.tutor.base.EmployeeBase;
import cis.util.CisUtility;

/**
 * Represents a 
 * @author bjmac
 * @since 15-Mar-2021
 */
public class EmployeePastGraduate extends EmployeeBase{

    //default constructor
    public EmployeePastGraduate() {
    }

    /**
     * Custom constructor 
     * @param name Name
     * @param phone Phone Number
     * @param email Email Address
     * @param yearGraduated Year of graduation
     * @since 20210322
     * @author BJM
     */
    public EmployeePastGraduate(String name, String phone, String email, int yearGraduated) {
        super(name, phone, email);
        this.yearGraduated = yearGraduated;
    }

    
    
    
    protected int yearGraduated;

    public int getYearGraduated() {
        return yearGraduated;
    }

    public void setYearGraduated(int yearGraduated) {
        this.yearGraduated = yearGraduated;
    }
    
    @Override
    public void getInformation(){
        super.getInformation();
        yearGraduated = CisUtility.getInputInt("Year graduated?");
    }
    
    @Override
    public String toString(){
        return "Employee: Past Graduate\n"+super.toString()+"Year graduated: "+yearGraduated+"\n";
    }
    
}
