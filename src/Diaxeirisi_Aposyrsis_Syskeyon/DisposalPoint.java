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
public class DisposalPoint {
 
    private String address;
    private String floor;
    private String description;

    //κατασκευαστής όταν ο χρήστης εισαγει ΜΟΝΟ δ/νση και όροφο σημείου διακομιδής
    public DisposalPoint(String address, String floor) {
        this.address = address;
        this.floor = floor;
    }

    //κατασκευαστής όταν ο χρήστης εισάγει και μια σύντομη περιγραφή
    public DisposalPoint(String address, String floor, String description) {
        this.address = address;
        this.floor = floor;
        this.description = description;
    }
    
    //geeters
    public String getAddress() {
        return address;
    }
    
    public String getFloor() {
        return floor;
    }
    
    public String getDescription() {
        return description;
    }

    // setters
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setFloor(String floor) {
        this.floor = floor;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ΣΗΜΕΙΟ ΑΠΟΚΟΜΙΔΗΣ{" + "Δ/νση=" + address + ", Όροφος=" + floor + ", Περιγραφή=" + description + '}';
    }

    

}
