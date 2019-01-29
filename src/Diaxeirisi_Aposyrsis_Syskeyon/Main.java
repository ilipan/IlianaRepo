package Diaxeirisi_Aposyrsis_Syskeyon;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ParseException {
        
        //Δημιουργία λίστας με αιτήσεις
        ArrayList<Application> applications = new ArrayList<>();
        
        //Γέμισμα λίστας με αιτήσεις (πίνακας 1)
        applications.add(
                new Application(1, "ΧΑΛΑΝΔΡΙ", false, 
                new Appliance("ΚΟΥΖΙΝΑ", 1.0, 90.0), 
                new Appliance("ΨΥΓΕΙΟ", 2.0, 60.0)));
        applications.add(
                new Application(2, "ΜΑΡΟΥΣΙ", false, 
                new Appliance("ΚΑΤΑΨΗΚΤΗΣ", 1.5, 70.0), 
                new Appliance("ΠΛΥΝΤΗΡΙΟ", 1.0, 110.0)));
        applications.add(
                new Application(3, "ΦΙΛΟΘΕΗ", false, 
                new Appliance("ΚΟΥΖΙΝΑ", 0.9, 120.0), 
                new Appliance("ΨΥΓΕΙΟ", 1.8, 90.0)));
        applications.add(
                new Application(4, "ΓΑΛΑΤΣΙ", false, 
                new Appliance("ΚΑΤΑΨΗΚΤΗΣ", 1.7, 90.0), 
                new Appliance("ΠΛΥΝΤΗΡΙΟ", 1.2, 130.0)));
        applications.add(
                new Application(5, "ΝΕΑ ΧΑΛΚΗΔΟΝΑ", false, 
                new Appliance("ΚΟΥΖΙΝΑ", 1.1, 80.0), 
                new Appliance("ΨΥΓΕΙΟ", 2.1, 50.0)));
        applications.add(
                new Application(6, "ΜΕΤΑΜΟΡΦΩΣΗ", false, 
                new Appliance("ΚΑΤΑΨΗΚΤΗΣ", 1.7, 60.0), 
                new Appliance("ΠΛΥΝΤΗΡΙΟ", 1.2, 100.0)));
        
        //Δημιουργία λίστας με υπαλλήλους
        ArrayList<Employee> employees = new ArrayList<>();
        
        //Γέμισμα λίστας υπαλλήλων με δεδομένα (πίνακας 2)
        employees.add(new Officer(1, "Γραφείο 1", "Υπάλληλος Γραφείου") {});
        employees.add(new Driver(2, "Οδηγός 1", "Οδηγός") {});
        employees.add(new Driver(3, "Οδηγός 2", "Οδηγός") {});
        employees.add(new Transporter(4, "Μεταφορέας 11", "Μεταφορέας") {});
        employees.add(new Transporter(5, "Μεταφορέας 12", "Μεταφορέας") {});
        employees.add(new Transporter(6, "Μεταφορέας 21", "Μεταφορέας") {});
        employees.add(new Transporter(7, "Μεταφορέας 22", "Μεταφορέας") {});
        
        // Δημιουργία Δήμου Αθήνας με τα δεδομένα του πίνακα 2
        Municipality municipality = new Municipality("ΑΘΗΝΑΣ", employees);
        
        // Δημιουργία λίστας φορτηγών
        ArrayList<TransportVehicle> transportVehicles = new ArrayList<>();
        
        
        //Γέμισμα λίστας φορτηγών με δεδομένα (πίνακας 3)
        transportVehicles.add(new TransportVehicle(1, 5, 500, 
                (Driver)employees.stream().filter(e -> e.getName().equals("Οδηγός 1")).findFirst().get(), 
                (Transporter)employees.stream().filter(e -> e.getName().equals("Μεταφορέας 12")).findFirst().get(), 
                (Transporter)employees.stream().filter(e -> e.getName().equals("Μεταφορέας 22")).findFirst().get()));
        transportVehicles.add(new TransportVehicle(2, 7, 600, 
                (Driver)employees.stream().filter(e -> e.getName().equals("Οδηγός 1")).findFirst().get(), 
                (Transporter)employees.stream().filter(e -> e.getName().equals("Μεταφορέας 12")).findFirst().get(), 
                (Transporter)employees.stream().filter(e -> e.getName().equals("Μεταφορέας 22")).findFirst().get()));
        
        //εκτύπωση πινάκων
        System.out.println("------ΑΙΤΗΣΕΙΣ------");
        for (Application App:applications){
            System.out.println(App.toString()+"\n");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("------ΥΠΑΛΛΗΛΟΙ ΔΗΜΟΥ ΑΘΗΝΑΣ------");
        for (Employee Emp:employees){
            System.out.println(Emp.toString()+"\n");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("------OXHMATA------");
        for (TransportVehicle TV:transportVehicles){
            System.out.println(TV.toString()+"\n");
        }
        System.out.println("");
        System.out.println("");
        
        
        //Δημιουργία αποκομιδών
        String dateStr = "20/01/2019";
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date disposalDate = (Date)formatter.parse(dateStr);
        PickUp pickUp;
        ArrayList<PickUp> pickUps = new ArrayList<>();
        ArrayList<Application> appsToBeServed = new ArrayList<>();
        //ορίζω μεταβλητές για το συνολικό όγκο και βάρος αντίστοιχα των 2 συσκευών κάθε αίτησης
        double totalVolume = 0.0;
        double totalWeight = 0.0;
        int disposalNumber = 0;
        
        //Έλεγχος σε όλες τις μη εξυπηρετημένες αιτήσεις
        for(Application notServedApp : applications.stream().filter(a -> !a.isServed()).collect(Collectors.toList())){
            totalVolume = notServedApp.getAppliance_1().getVolume() + notServedApp.getAppliance_2().getVolume();
            totalWeight = notServedApp.getAppliance_1().getWeight() + notServedApp.getAppliance_2().getWeight();
            appsToBeServed.clear();
            //εάν ο ο ωφέλιμος ογκος και το ωφέλιμο βάρος μεγαλύτερα του όγκου και βάρους των 2 συσκευών
            if( transportVehicles.get(0).getVolume() >= totalVolume && transportVehicles.get(0).getWeight() >= totalWeight){
                // τότε (εφόσον χωρούν σε ένα όχημα) δημιουργείται μία αποκομιδή
                // Αρχικά βρίσκω την διαφορά του όγκου των 2 συσκευών απ'τον ωφάλιμο όγκο
                transportVehicles.get(0).setVolume(transportVehicles.get(0).getVolume() - totalVolume);
                //και την διαφορά απο το βάρων των 2 συσκευών απο το ωφέλιμο βάρος
                transportVehicles.get(0).setWeight(transportVehicles.get(0).getWeight() - totalWeight);
                appsToBeServed.add(notServedApp);
                //δημιουργείται η αποκομιδή
                pickUp = municipality.createPickUp(
                    (Officer)employees.stream().filter(e -> e.getName().equals("Γραφείο 1")).findFirst().get(), 
                    disposalDate, ++disposalNumber,
                    new DisposalPoint("ΣΗΜΕΙΟ ΔΙΑΚΟΜΙΔΗΣ", "2ος Όροφος", ""), 
                    appsToBeServed,
                    transportVehicles.get(0));
                pickUps.add(pickUp);
            }
            //αλλιώς εάν συνολικο βάρος μεγαλύτερο του ωφέλιμου, ή συνολικός ογκος μεγαλύτερος του ωφελιμου
            else {
                //βρίσκω την διαφορά αναμεσα τους 
                totalVolume -= transportVehicles.get(0).getVolume();
                totalWeight -= transportVehicles.get(0).getWeight();
                //το πρώτο φορτηγό παιρνει τόσο όγκο και τόσο βάρος όσο ειναι το ωφέλιμο
                transportVehicles.get(0).setVolume(0);
                transportVehicles.get(0).setWeight(0);
                //το δεύτερο φορτηγό παίρνει τόσο όγκο όση η διαφορά των όγκων από τον ωφέλιμο
                transportVehicles.get(1).setVolume(transportVehicles.get(1).getVolume() - totalVolume);
                //και τόσο βάρος όσο η διαφορά από το ωφέλιμο βάρος
                transportVehicles.get(1).setWeight(transportVehicles.get(1).getWeight() - totalWeight);
                appsToBeServed.add(notServedApp);
                
                //δημιουργούνται οι 2 αποκομιδές
                pickUp = municipality.createPickUp(
                    (Officer)employees.stream().filter(e -> e.getName().equals("Γραφείο 1")).findFirst().get(), 
                    disposalDate, ++disposalNumber,
                    new DisposalPoint("ΣΗΜΕΙΟ ΔΙΑΚΟΜΙΔΗΣ", "2ος Όροφος", ""), 
                    appsToBeServed,
                    transportVehicles.get(0));
                pickUps.add(pickUp);
                
                pickUp = municipality.createPickUp(
                    (Officer)employees.stream().filter(e -> e.getName().equals("Γραφείο 1")).findFirst().get(), 
                    disposalDate, ++disposalNumber,
                    new DisposalPoint("ΣΗΜΕΙΟ ΔΙΑΚΟΜΙΔΗΣ", "2ος Όροφος", ""), 
                    appsToBeServed,
                    transportVehicles.get(1));
                pickUps.add(pickUp);
            }
            
            // Η αίτηση εξυπηρετήθηκε
            notServedApp.setServed(true);
            
            // Κάνε τα οχήματα πάλι διαθέσιμα
            transportVehicles.get(0).setVolume(5.0);
            transportVehicles.get(0).setWeight(500.0);
            transportVehicles.get(1).setVolume(7.0);
            transportVehicles.get(1).setWeight(600.0);
        }
        
        ReportDisposal reportDisposal = new ReportDisposal(pickUps);
        
        if(!reportDisposal.createDisposalXML())
            System.out.print("Output file fail to be created.");
        else
            System.out.print("Output file created.");
    }   
}
