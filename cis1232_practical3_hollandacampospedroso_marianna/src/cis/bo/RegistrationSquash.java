/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis.bo;

import cis.util.CisUtility;

/**
 * RegistrationSquash Class
 *
 * @author Marianna Hollanda
 * @since 20210406
 */
public class RegistrationSquash extends RegistrationBase {
    
    protected int years;
    protected String racket;
    
     /**
     * Default constructor
     *
     * @author Marianna Hollanda
     * @since 20210406
     */   
    public RegistrationSquash(){
    }
    
     /**
     * Custom constructor
     *
     * @param name
     * @param address
     * @param birthYear
     * @author Marianna Hollanda
     * @since 20210406
     */
    public RegistrationSquash(String name, String address, int birthYear){
        super(name, address, birthYear);
        this.years = years;
        this.racket = racket;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getRacket() {
        return racket;
    }

    public void setRacket(String racket) {
        this.racket = racket;
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
        years = CisUtility.getInputInt("Number of years played:");
        racket = CisUtility.getInputString("Has Racket (Y/N):");
        
        System.out.println(""); //Empty line for formatting
    }
    
    @Override
    public String toString(){
        return super.toString() + "Number of years played: " + years + "\n" + "Has Racket (Y/N): " + racket + "\n";
    }
    
}
