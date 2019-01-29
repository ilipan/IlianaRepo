/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diaxeirisi_Aposyrsis_Syskeyon;

/**
 *
 * @author Iliana
 * η κλάση Employee είναι αφηρημένη υπερκλάση των κλάσεων Driver, Transporter και Officer
 * 
 */
public abstract class Employee {
    
    private int id;    //αριθμός μητρώου κάθε υπαλλήλου
    private String name; //Ονοματεπώνυμο υπαλληλού
    private String job_type; //Ειδικότητα υπαλλήλου
    
    /*
    Construstor που αποδιδει τιμές σε όλα τα πεδία της κλάσης. 
    Επειδή είναι αφηρημένη κλάση δεν καλείται για δημιουργία αντικ/νων, καλείται μέσω της super από τις υποκλάσεις για την αρχικοποίηση των κοινών
    τους πεδίων κατά την κατασκευή αυτών των κλάσεων
    */
    public Employee(int id, String name, String job_type){
        this.id=id;
        this.name=name;
        this.job_type=job_type;
    }
    //getters
    public String getJob_type() {
        return job_type;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    
    //setters
    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }    
    public void setName(String name) {
        this.name = name;
    }    
    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "id : " +id+" , Όνομα υπαλλήλου: " + name+ " , Ειδικότητα : " + job_type;
    }
}
