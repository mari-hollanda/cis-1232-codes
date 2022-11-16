package cis.util;

import cis.bo.Student;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Utility methods specific to this application
 * @author bjm
 * @since 4-Mar-2021
 */
public class StudentTrackerUtility {

    public static final String EXIT = "X";
    public static final String INSTRUCTIONS = "I";
    public static final String GREEN = "\033[32m";  //Codes used to color text in console
    public static final String BLACK = "\033[30m";
    public static final String MENU
            = BLACK+"-------------------------\n"
            + ""+BLACK+"- "+GREEN+"CIS Menu\n"
            + ""+BLACK+"- "+GREEN+"A-Add a student\n"
            + ""+BLACK+"- "+GREEN+"B-Show the students\n"
            + ""+BLACK+"- "+GREEN+"C-Get students based on instrument\n"
            + ""+BLACK+"- "+GREEN+"D-Find a student\n"
            + ""+BLACK+"- "+GREEN+""+INSTRUCTIONS+"-Show instructions\n"
            + ""+BLACK+"- "+GREEN+""+EXIT+"-End program\n"
            + ""+BLACK+"-------------------------\n"
            + ""+BLACK+"Option";

    
    
    /**
     * Display instructions for P2
     * @since 20210303
     * @author BJM
     */
    public static void showInstructions(){
        String instructions = 
                  "--------------------------------\n"
                + "\033[30m---  \033[32m Practical #2 CIS1232 \033[30m  ---\n"
                + "--------------------------------\n"
                + "The focus of this activity is to use collections to provide \n"
                + "functionality related to a music school administration. \n"
                + "--------------------------------------------------------------\n"
                + "The comments in the code provide details about what is needed \n"
                + "to be done.  You can find the location by viewing the todo \n"
                + "comments in the code (see Window/Action Items in Netbeans). \n"
                + "There are collections which are specified to be used and these\n"
                + "are required to be used as requested.\n"
                + "--------------------------------------------------------------\n"
                + "To get started spend some time studying the code and how the\n"
                + "program works.  \n"
                + "Any questions/clarifications needed - please ask.\n"
                + "Happy coding.";
        System.out.println(instructions);
    }
        
    
    /**
     * This method will load the collections with test data that can be used when testing 
     * the program.
     * @since 2021-03-03
     * @author BJM
     */
    public static void initialize(ArrayList studentList, HashMap instrumentTeacherMap) {
        studentList.add(new Student("Colin", "902-569-1234", "Guitar", "1999-05-01"));
        studentList.add(new Student("Andres", "902-569-5214", "Guitar", "1995-05-18"));
        studentList.add(new Student("Rob", "902-569-3453", "Guitar", "1980-06-28"));
        studentList.add(new Student("Marianna", "902-569-7788", "Piano", "1989-05-22"));
        studentList.add(new Student("Francisco", "902-569-8899", "Piano", "2002-05-18"));
        studentList.add(new Student("Hunter", "902-569-8765", "Piano", "1993-05-23"));
        studentList.add(new Student("Michael", "902-569-4598", "Violin","1990-05-37"));
        studentList.add(new Student("Steve", "902-569-1288", "Violin", "1992-02-30"));
        studentList.add(new Student("Donnie", "902-569-5541", "Violin", "1988-11-18"));

        instrumentTeacherMap.put("Guitar", "Mike MacDonald");
        instrumentTeacherMap.put("Piano", "Joey Kitson");
        instrumentTeacherMap.put("Violin", "Gaylene Nicholson");
        
        
    }

    
    
}
