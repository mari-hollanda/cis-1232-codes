package inheritanceconstructors;

import info.hccis.tutor.bo.Employee;

/**
 * First Year Class
 * 
 * @since 20210322
 * @author marianna hollanda
 */
public class FirstYearStudentEmployee extends Employee {

    @Override
    public String toString() {
        String output = "Employee: First Year Student \n" + super.toString();
        return output;
    }

}
