/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diaxeirisi_Aposyrsis_Syskeyon;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Iliana
 */
public class PickUp {
    
    private Date disposalDate; // Ημερομηνία αποκομιδής
    private int disposalNumber; // αριθμός αποκομιδής
    private Officer officer; // υπάλληλος γραφείου
    private double sumVolume; //Συνολικός ογκος
    private double sumWeight; // συνολικό βάρος
    private DisposalPoint disposalPoint;

    
    private List<Application> applications; // Λίστα αιτήσεων
    private TransportVehicle transportVehicle; //όχημα μεταφοράς που θα εκτελέσει την αποκομιδή

    public PickUp(Date disposalDate, int disposalNumber, Officer officer, double sumVolume, double sumWeight, List<Application> applications, TransportVehicle transportVehicle, DisposalPoint disposalPoint) {
        this.disposalDate = disposalDate;
        this.disposalNumber = disposalNumber;
        this.officer = officer;
        this.sumVolume = sumVolume;
        this.sumWeight = sumWeight;
        this.applications = applications;
        this.transportVehicle = transportVehicle;
        this.disposalPoint = disposalPoint;
    }

       
    //getters
    public Date getDisposalDate() {
        return disposalDate;
    }  
    
    public int getDisposalNumber() {
        return disposalNumber;
    }
    
    public Officer getOfficer() {
        return officer;
    }
    
    public double getSumVolume() {
        return sumVolume;
    }
    
    public double getSumWeight() {
        return sumWeight;
    }
    
    public List<Application> getApplications() {
        return applications;
    }
    
    public TransportVehicle getTransportVehicle() {
        return transportVehicle;
    }
    
    public DisposalPoint getDisposalPoint() {
        return disposalPoint;
    }
    //setters
    public void setDisposalDate(Date disposalDate) {
        this.disposalDate = disposalDate;
    }
    
    public void setDisposalNumber(int disposalNumber) {
        this.disposalNumber = disposalNumber;
    }
    
    public void setOfficer(Officer officer) {
        this.officer = officer;
    }
    
    public void setSumVolume(double sumVolume) {
        this.sumVolume = sumVolume;
    }
    public void setSumWeight(double sumWeight) {
        this.sumWeight = sumWeight;
    }
    
    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public void setTransportVehicle(TransportVehicle transportVehicle) {
        this.transportVehicle = transportVehicle;
    }
    
    public void setDisposalPoint(DisposalPoint disposalPoint) {
        this.disposalPoint = disposalPoint;
    }
    
    @Override
    public String toString() {
        return "ΑΠΟΚΟΜΙΔΗ{" + "Ημ/νία αποκομιδής=" + disposalDate + ", Αριθμός αποκομιδής=" + disposalNumber + ", Υπάλληλος γραφείου=" + officer + ", Συνολικός όγκος=" + sumVolume + ", Συνολικό βάρος=" + sumWeight + ", αιτήσεις=" + applications + ", όχημα μεταφοράς=" + transportVehicle + ", Σημείο αποκομιδής=" + disposalPoint +'}' + "\n";
    }

    
}
