/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diaxeirisi_Aposyrsis_Syskeyon;

/**
 *
 * @author Iliana
 */
public class Application {

    private int protocol_num; //αριθμός πρωτοκόλλου αίτησης
    private String location; //Τοποθεσία 
    private boolean served; //παιρνεί τιμή TRUE όταν ειναι εξυπηρετημένη αλλιώς FALSE 
    private Appliance appliance_1;
    private Appliance appliance_2;
 
    //Κατασκευαστής που αρχικοποιεί όλα τα πεδία   
    public Application(int protocol_num, String location, boolean served, Appliance appliance_1, Appliance appliance_2) {
        this.protocol_num = protocol_num;
        this.location = location;
        this.served = served;
        this.appliance_1 = appliance_1;
        this.appliance_2 = appliance_2;
    }
    
    //getters
    public int getProtocol_num() {
        return protocol_num;
    }
    
    public String getLocation() {
        return location;
    }
    
    public boolean isServed() {
        return served;
    }
    
    public Appliance getAppliance_1() {
        return appliance_1;
    }
    
    public Appliance getAppliance_2() {
        return appliance_2;
    }
    
    //setters
    public void setProtocol_num(int protocol_num) {
        this.protocol_num = protocol_num;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public void setServed(boolean served) {
        this.served = served;
    }
    
    public void setAppliance_1(Appliance appliance_1) {
        this.appliance_1 = appliance_1;
    }
    
    public void setAppliance_2(Appliance appliance_2) {
        this.appliance_2 = appliance_2;
    }

    @Override
    public String toString() {
        return "ΑΙΤΗΣΗ{" + "αριθμός πρωτοκόλου=" + protocol_num + ", τοποθεσία=" + location + ", εξυπηρετημένη=" + served + ", συσκευή_1=" + appliance_1 + ", συσκευή_2=" + appliance_2 + '}';
    }
    
}
