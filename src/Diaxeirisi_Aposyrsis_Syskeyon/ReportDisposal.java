package Diaxeirisi_Aposyrsis_Syskeyon;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportDisposal {
    //δήλωση μεταβλήτης τύπου λίστας pickUps
    private ArrayList<PickUp> pickUps;
    
    //κατασκευαστής που αρχικοποιεί την λίστα από pickUps
    public ReportDisposal(ArrayList<PickUp> pickUps){
        this.pickUps = pickUps;
    }
    //μέθοδος createDisposalXML() που καλείται απ'την Main, για να δημιουργήσει το αρχειο
    public boolean createDisposalXML(){
        //μεταβλητές που χρειαζεται η μέθοδος 
        String dataLine = ""; //στην dataline θα αποθηκεύονται όλες οι πληροφορίες που θα γραφτούν στο αρχείο
        boolean result = false;
        
        //loop που σαρώνει μία-μία τις εγγραφές της λίστας 
        for(PickUp pickUp : this.pickUps){
            dataLine += "<ΑΠΟΚΟΜΙΔΗ>\n";
                dataLine += "<ΑΡΙΘΜΟΣ_ΑΠΟΚΟΜΙΔΗΣ>" + String.valueOf(pickUp.getDisposalNumber()) + "</ΑΡΙΘΜΟΣ_ΑΠΟΚΟΜΙΔΗΣ>\n";
                dataLine += "<ΗΜΕΡΟΜΗΝΙΑ_ΑΠΟΚΟΜΙΔΗΣ>" + String.valueOf(pickUp.getDisposalDate()) + "</ΗΜΕΡΟΜΗΝΙΑ_ΑΠΟΚΟΜΙΔΗΣ>\n";
                dataLine += "<ΟΓΚΟΣ_ΑΠΟΚΟΜΙΔΗΣ>" + String.valueOf(pickUp.getSumVolume()) + "</ΟΓΚΟΣ_ΑΠΟΚΟΜΙΔΗΣ>\n";
                dataLine += "<ΒΑΡΟΣ_ΑΠΟΚΟΜΙΔΗΣ>" + String.valueOf(pickUp.getSumWeight()) + "</ΒΑΡΟΣ_ΑΠΟΚΟΜΙΔΗΣ>\n";
                dataLine += "<ΟΧΗΜΑ>\n";
                    dataLine += "<ΟΦΕΛΙΜΟ_ΦΟΡΤΙΟ>" + String.valueOf(pickUp.getTransportVehicle().getWeight()) + "</ΟΦΕΛΙΜΟ_ΦΟΡΤΙΟ>\n";
                    dataLine += "<ΟΦΕΛΙΜΟ_ΟΓΚΟΣ>" + String.valueOf(pickUp.getTransportVehicle().getVolume()) +"</ΟΦΕΛΙΜΟ_ΟΓΚΟΣ>\n";
                    dataLine += "<ΟΓΚΟΣ_ΑΠΟΚΟΜΙΔΗΣ>" + String.valueOf(pickUp.getSumVolume()) + "</ΟΓΚΟΣ_ΑΠΟΚΟΜΙΔΗΣ>\n";
                    dataLine += "<ΒΑΡΟΣ_ΑΠΟΚΟΜΙΔΗΣ>" + String.valueOf(pickUp.getSumWeight()) + "</ΒΑΡΟΣ_ΑΠΟΚΟΜΙΔΗΣ>\n";
                    dataLine += "<ΣΥΣΚΕΥΕΣ>\n";
                    //σαρώνει την λίστα των αιτήσεων για να πάρει τις συσκευές 
                    for(Application application : pickUp.getApplications()){
                        dataLine += "<ΣΥΣΚΕΥΗ>\n";
                            dataLine += "<ΟΝΟΜΑ>" + application.getAppliance_1().getType() + "</ΟΝΟΜΑ>\n";
                            dataLine += "<ΒΑΡΟΣ>" + String.valueOf(application.getAppliance_1().getWeight()) + "</ΒΑΡΟΣ>\n";
                            dataLine += "<ΟΓΚΟΣ>" + String.valueOf(application.getAppliance_1().getVolume()) +"</ΟΓΚΟΣ>\n";
                        dataLine += "</ΣΥΣΚΕΥΗ>\n";
                        dataLine += "<ΣΥΣΚΕΥΗ>\n";
                            dataLine += "<ΟΝΟΜΑ>" + application.getAppliance_2().getType() + "</ΟΝΟΜΑ>\n";
                            dataLine += "<ΒΑΡΟΣ>" + String.valueOf(application.getAppliance_2().getWeight()) + "</ΒΑΡΟΣ>\n";
                            dataLine += "<ΟΓΚΟΣ>" + String.valueOf(application.getAppliance_2().getVolume()) +"</ΟΓΚΟΣ>\n";
                        dataLine += "</ΣΥΣΚΕΥΗ>\n";
                    }                        
                    dataLine += "</ΣΥΣΚΕΥΕΣ>\n";
                dataLine += "</ΟΧΗΜΑ>\n";
            dataLine += "</ΑΠΟΚΟΜΙΔΗ>\n";
        }
        

        try {
            //Δημιουργείται το αρχείο outputDisposal.xml
            //όπου τα δεδομένα της dataline μεταφέρονται στο outputDisposal.xml
            FileWriter file = new FileWriter("outputDisposal.xml", false); // η File είναι μεταβλητή τύπου FileWriter
            file.write(dataLine);
            file.flush();
            file.close();
            result = true;
        } catch (IOException ex) {
            Logger.getLogger(ReportDisposal.class.getName()).log(Level.SEVERE, null, ex);
        }            
        return result;
    }
}
