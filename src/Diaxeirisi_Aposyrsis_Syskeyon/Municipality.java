/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diaxeirisi_Aposyrsis_Syskeyon;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Iliana ***
 * 
 */
public class Municipality {
   
    private String name; //Όνομο Δήμου
    private ArrayList<Employee> employees; //Οι υπάλληλοι του Δήμου
    private ArrayList<Application> applications; // Οι εξυπηρετούμενες αιτήσεις
    
    /*Κατασκευαστής που αρχικοποιεί όλα τα πεδία 
     */ 
    public Municipality(String name, ArrayList<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }
    
    //getters    
    public String getName() {
        return name;
    }
    public ArrayList<Employee> getEmployees() {
        return employees;
    }
    
    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setEloyees(ArrayList<Employee> employees){
        this.employees = employees;
    } 
    public ArrayList<Application> getApplications(){
        return this.applications;
    }

    @Override
    public String toString() {
        return "Δήμος: " + name + ", employees=" + employees + '}';
    }
    
    // μέθοδος createPickUp που δημιουργεί τις αποκομιδές
    public PickUp createPickUp (Officer officer, 
                                Date disposalDate, 
                                int disposalNumber,
                                DisposalPoint disposalPoint,
                                List<Application> applications,
                                TransportVehicle transportVehicle){

        return new PickUp(disposalDate, 
                            disposalNumber, 
                            officer,
                            transportVehicle.getVolume(), transportVehicle.getWeight(), 
                            applications, transportVehicle, disposalPoint);
    }
    
}
