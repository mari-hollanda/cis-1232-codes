package info.hccis.tutor.bo;

import cis.util.CisUtility;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Contains the login information.
 * 
 * @since 20210305
 * @author marianna hollanda
 */
public class Login {

    public static String userNameCheck;
    public static String userPasswordCheck;

    private static final HashMap<String, String> userMap = new HashMap<String, String>();
  
    public static boolean login() {

        Scanner input = new Scanner(System.in);

        boolean isValid = false;

        CisUtility.display("Username:");
        userNameCheck = input.nextLine();

        if (!userMap.containsKey(userNameCheck)) {
            CisUtility.display("Invalid login, please try again.");
            isValid = false;
        } else if (userMap.containsKey(userNameCheck)) {
            CisUtility.display("Password:");
            userPasswordCheck = input.nextLine();
            if (userMap.get(userNameCheck).equals(userPasswordCheck)) {
                CisUtility.display("");
                CisUtility.display("Welcome " + userNameCheck);
                CisUtility.display("");
                isValid = true;
            } else {
                CisUtility.display("Invalid login, please try again.");
                isValid = false;
            }
        }

        return isValid;

    }

    public void loadCredentials(String[] userNameArray, String[] passwordArray) {
        for (int credentials = 0; credentials < userNameArray.length; credentials++) {
            userMap.put(userNameArray[credentials], passwordArray[credentials]);
        }
    }

}
