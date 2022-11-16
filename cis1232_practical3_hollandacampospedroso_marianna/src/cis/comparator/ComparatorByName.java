package cis.comparator;

import cis.bo.RegistrationBase;
import java.util.Comparator;

/**
 * Comparator By Name Class
 *
 * @author Marianna Hollanda
 * @since 20210406
 */
public class ComparatorByName implements Comparator<RegistrationBase> {

    @Override
    public int compare(RegistrationBase n1, RegistrationBase n2) {
//        String EmployeeName1 = n1.getName().toUpperCase();
//        String EmployeeName2 = n2.getName().toUpperCase();
//        return EmployeeName1.compareTo(EmployeeName2);
        return n1.getName().compareTo(n2.getName());
    }
}
