package inheritanceconstructors;

import cis.util.CisUtility;
import info.hccis.tutor.bo.Employee;

/**
 * Past Graduate Class
 *
 * @since 20210322
 * @author marianna hollanda
 */
public class PastGraduateEmployee extends Employee {

    private int yearGraduated;

    /**
     * Get information from the user
     *
     * @since 20210322
     * @author marianna hollanda
     */
    @Override
    public void getInformation() {
        super.getInformation();
        yearGraduated = CisUtility.getInputInt("Year gratuated?");
    }

    @Override
    public String toString() {
        String output = "Employee: Past Graduate \n" + super.toString();
        output += "Year gratuated: " + yearGraduated;
        return output;
    }

    public int getYearGraduated() {
        return yearGraduated;
    }

    public void setYearGraduated(int yearGraduated) {
        this.yearGraduated = yearGraduated;
    }

}
