package inheritanceconstructors;

import info.hccis.tutor.bo.Employee;

/**
 * Second Year Class
 * 
 * @since 20210322
 * @author marianna hollanda
 */
public class SecondYearStudentEmployee extends Employee {

    @Override
    public String toString() {
        String output = "Employee: Second Year Student \n" + super.toString();
        return output;
    }

}
