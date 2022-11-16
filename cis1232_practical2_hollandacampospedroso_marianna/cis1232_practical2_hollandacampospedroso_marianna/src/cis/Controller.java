package cis;

import cis.bo.Student;
import cis.util.CisUtility;
import cis.util.StudentTrackerUtility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * A music teacher's administration project
 *
 * @author bjmaclean
 * @since 20210303
 * @modified by marianna hollanda
 * @since 20210309
 */
public class Controller {
    
    //**************************************************************************
    //This data structure will hold all of the music students
    //**************************************************************************
    private static ArrayList<Student> studentList = new ArrayList();

    //**************************************************************************
    //This map will have the instrument name as the key and the applicable teacher
    //as the value
    //**************************************************************************
    private static HashMap<String, String> instrumentTeacherMap = new HashMap();

    
    public static void main(String[] args) {

        //**********************************************************************
        //load test data into the list and maps.  This method will load the two 
        //collections with test values.  After this method is called the collections
        //will have test data in them.
        //**********************************************************************
        StudentTrackerUtility.initialize(studentList, instrumentTeacherMap);

        String option = "";
        do {
            option = CisUtility.getInputString(StudentTrackerUtility.MENU);
            processMenuOption(option);
        } while (!option.equalsIgnoreCase(StudentTrackerUtility.EXIT));

    }

    /**
     * This method will process the menu option specified in the input
     * parameter. It will call appropriate functionality based on its value.
     *
     * @param option The menu option
     * @since 20171102
     * @author cis1201b
     *
     */
    public static void processMenuOption(String option) {
        //*******************************************************
        //Add a switch to process the option
        //*******************************************************
        switch (option.toUpperCase()) {
            case "A":
                CisUtility.display("Add a student");
                addAStudent();
                break;
            case "B":
                CisUtility.display("Show all students");
                showStudents();
                break;
            case "C":
                CisUtility.display("Find students by instrument");
                HashSet<Student> foundStudents = findStudentBasedOnInstrument();
                CisUtility.display("There were "+foundStudents.size()+" students found for that instrument");
                break;
            case "D":
                CisUtility.display("Find a student by name");
                Student student = findAStudent();
                break;
            case "E":
                CisUtility.display("Find a teacher for a given instrument");
                String instrument = CisUtility.getInputString("Instrument");
                String teacher = getTeacherForInstrument(instrument);
                System.out.println("The teacher for "+ instrument+" is "+teacher);
                break;
            case StudentTrackerUtility.INSTRUCTIONS:
                StudentTrackerUtility.showInstructions();
                break;
            case StudentTrackerUtility.EXIT:
                CisUtility.display("Good-bye");
                break;
            default:
                CisUtility.display("Invalid entry");
        }
    }

    /**
     * Add a student
     * Provide the ability to add a student to the studentList.
     * @since 20210309
     * @author marianna hollanda
     */
    public static void addAStudent() {
        Student student = new Student();
        student.getInformation();
        studentList.add(student);
            }

    /**
     * Show students
     * Show all the students that are in the list
     * @since 20210309
     * @author marianna hollanda
     */
    public static void showStudents() {
        System.out.println(studentList);
    }

    /**
     * Find students based on their instrument
     * @return Set of students that match the instrument entered
     * @since 20210309
     * @author marianna hollanda
     */
    public static HashSet<Student> findStudentBasedOnInstrument() {

        
        String specifiedInstrument = CisUtility.getInputString("Instrument");
         
        HashSet<Student> foundStudents = new HashSet();

       if (studentList.contains(specifiedInstrument)){
            System.out.println(foundStudents); 
        }
 
        return foundStudents;
    }

     /**
     * Find a student by their name
     * @return The student found or null if not found
     * @since 20210309
     * @author marianna hollanda
     */
    public static Student findAStudent() {

        Student studentFound = null;
        
        if(studentList.contains(studentFound)){
            System.out.println(studentFound + "is on the list.");
       }
        
        return studentFound;
        
    }

    /**
     * Show the teacher associated with a specified instrument.
     * @since 20210309
     * @author marianna hollanda
     */
    public static String getTeacherForInstrument(String instrument){
        
        String teacher = null;

        if (instrumentTeacherMap.containsKey(instrument)){
            System.out.println(teacher);
        } 
    return teacher;
    }
    

}
