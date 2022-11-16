package cis.comparator;

import cis.bo.RegistrationBase;
import java.util.Comparator;

/**
 * Comparator By Birth Year Class
 *
 * @author Marianna Hollanda
 * @since 20210406
 */
public class ComparatorByBirthYear implements Comparator<RegistrationBase> {

    @Override
    public int compare(RegistrationBase b1, RegistrationBase b2) {
//            int RegistrationBaseB1 = b1.getBirthYear();
//            int RegistrationBaseB2 = b2.getBirthYear();
//            return RegistrationBaseB1-RegistrationBaseB2;  
        return b1.getBirthYear() - b2.getBirthYear();
    }
}
