package cis.bo;
import cis.util.CisUtility;

/**
 * RegistrationHockey Class
 *
 * @author Marianna Hollanda
 * @since 20210406
 */
public class RegistrationHockey extends RegistrationBase {
    
    protected String concussion;
    protected String position;
    
    /**
     * Default constructor
     *
     * @author Marianna Hollanda
     * @since 20210406
     */    
    public RegistrationHockey(){  
    }
    
     /**
     * Custom constructor 
     * @param name Name
     * @param address
     * @param birthYear
     * @author Marianna Hollanda
     * @since 20210406
     */
    public RegistrationHockey(String name, String address, int birthYear){
        super(name, address, birthYear);
        this.concussion = concussion;
        this.position = position;
    }

    public String getConcussion() {
        return concussion;
    }

    public void setConcussion(String concussion) {
        this.concussion = concussion;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    /**
     * Get information from the user
     *
     * @author Marianna Hollanda
     * @since 20210406
     */
    @Override
    public void getInformation(){
        super.getInformation();
        concussion = CisUtility.getInputString("Had Concussion (Y/N):");
        position = CisUtility.getInputString("Position:");
        
        System.out.println(""); //Empty line for formatting
    }
    
    @Override
    public String toString(){
        return super.toString() + "Had Concussion (Y/N): " + concussion + "\n" + "Position: " + position + "\n";
    }
    
}
