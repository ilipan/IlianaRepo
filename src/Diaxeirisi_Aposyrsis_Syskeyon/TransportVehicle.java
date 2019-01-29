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
public class TransportVehicle {
   
    private int code; // ο κωδικός του φορτηγού
    private double volume; //η χωρητικότητα του φορτηγού σε όγκο
    private double weight; //η χωρητικότητα του φορτηγού σε βάρος
    //κάθε φορτηγό επανδρώνεται από 1 οδηγό και 2 μεταφορείς
    private Driver driver; 
    private Transporter transporter_1;
    private Transporter transporter_2;
    
    //Κατασκευαστής που αρχικοποιεί όλα τα πεδία 
    public TransportVehicle(int code, double volume, double weight, Driver driver, Transporter transporter_1, Transporter transporter_2) {
        this.code = code;
        this.volume = volume;
        this.weight = weight;
        this.driver = driver;
        this.transporter_1 = transporter_1;
        this.transporter_2 = transporter_2;
    }
 
    // getters
    public int getCode() {
        return code;
    }
    
    public double getVolume() {
        return volume;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public Driver getDriver() {
        return driver;
    }
    
    public Transporter getTransporter_1() {
        return transporter_1;
    }
    
    public Transporter getTransporter_2() {
        return transporter_2;
    }
    
    //setters
    public void setCode(int code) {
        this.code = code;
    }
    
    public void setVolume(double volume) {
        this.volume = volume;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    
    public void setTransporter_1(Transporter transporter_1) {
        this.transporter_1 = transporter_1;
    }
    
    public void setTransporter_2(Transporter transporter_2) {
        this.transporter_2 = transporter_2;
    }

    @Override
    public String toString() {
        return "OXHMA ΜΕΤΑΦΟΡΑΣ{" + "κωδικός φορτηγού=" + code + ", χωρητικότητα_σε_όγκο=" + volume + ", χωρητικότητα_σε_βάρος=" + weight + ", οδηγός=" + driver + ", μεταφορέας_1=" + transporter_1 + ", μεταφορέας_2=" + transporter_2 + '}';
    }
    
}
