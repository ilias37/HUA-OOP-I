package MyPlatform;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.Scanner;
import java.util.ArrayList;

public class MyPlatform {
    
    public static void main(String[] args) throws ParseException {
        
        Scanner input = new Scanner(System.in);
        Scanner in = new Scanner(System.in);

        /////////////////////////////////////////////ΕΚΧΩΡΗΣΗ ΔΕΔΟΜΕΝΩΝ ΓΙΑ ΤΗΝ ΟΜΑΛΗ ΛΕΙΤΟΥΡΓΙΑ ΤΟΥ ΠΡΟΓΡΑΜΜΑΤΟΣ////////////////////////////////////////////////////////////////////
         
        //δημιουργία των ArrayLists που θα χρησιμοποιηθούν κατά την εκτέλεση του προγράμματος
        ArrayList<Monokatoikia> mono = new ArrayList<>();  //λίστα με τις μονοκατοικίες
        ArrayList<Diamerisma> diam = new ArrayList<>();    //λίστα με τα διαμερίσματα
        ArrayList<Katoikia> katoikia = new ArrayList<>();  //λίστα με το σύμολο των μονοκατοικιών και των διαμερισμάτων
        ArrayList<Idiokthths> idiok = new ArrayList<>();   //λίστα με τους ιδιοκτήτες
        ArrayList<Enoikiasths> enoik = new ArrayList<>();  //λίστα με τους ενοικιαστές
        ArrayList<Krathsh> krat = new ArrayList<>();       //λίστα με τις κρατήσεις
          
        //αρχικά δεδομένα για να υλοποιηθεί η εφαρμογή
        mono.add( new Monokatoikia("Κουκάκι", "Κουντουριώτη", 90, 123456789, 4, 3, true, true, true, true, "Δρόμος", 800, 100, 1.33f, "Κο-7452", 40, 0, true) );
        mono.add( new Monokatoikia("Γλυφάδα", "Πλαταιών", 29, 234567890, 7, 4, true, true, true, true, "Θάλασσα", 1300, 300, 1.75f, "Γλ-9836", 100, 25, true) );
        mono.add( new Monokatoikia("Κηφισιά", "Αγίου Ιωάννου", 30, 345678901, 5, 3, true, true, true, true, "Βουνό", 1900, 100, 1.66f, "Κη-3864", 120, 0, true) );
                
        diam.add( new Diamerisma("Αθήνα", "Πατησίων", 67, 123456789, 5, 2, true, true, true, true, "Δρόμος", 1000, 50, 2.5f, "Αθ-1234", 2, true, true) );
        diam.add( new Diamerisma("Φάληρο", "Ανδρομάχης", 54, 234567890, 4, 2, true, true, true, false, "Θάλασσα", 500, 70, 2.0f, "Φα-2547", 5, true, true) );
        diam.add( new Diamerisma("Βύρωνας", "Βαλαωρίτου", 154, 345678901, 2, 1, true, true, true, false, "Βουνό", 2000, 40, 2.0f, "Βυ-7386", 0, false, false) );
        
        katoikia.add( new Katoikia("Κουκάκι", "Κουντουριώτη", 90, 123456789, 4, 3, true, true, true, true, "Δρόμος", 800, 100, 1.33f, "Κο-7452") );
        katoikia.add( new Katoikia("Γλυφάδα", "Πλαταιών", 29, 234567890, 7, 4, true, true, true, true, "Θάλασσα", 1300, 300, 1.75f, "Γλ-9830") );
        katoikia.add( new Katoikia("Κηφισιά", "Αγίου Ιωάννου", 30, 345678901, 5, 3, true, true, true, true, "Βουνό", 1900, 100, 1.66f, "Κη-3861") ); 
        katoikia.add( new Katoikia("Αθήνα", "Πατησίων", 67, 123456789, 5, 2, true, true, true, true, "Δρόμος", 1000, 50, 2.5f, "Αθ-1234") );
        katoikia.add( new Katoikia("Φάληρο", "Ανδρομάχης", 54, 234567890, 4, 2, true, true, true, false, "Θάλασσα", 500, 70, 2.0f, "Φα-2547") );
        katoikia.add( new Katoikia("Βύρωνας", "Βαλαωρίτου", 154, 345678901, 2, 1, true, true, true, false, "Βουνό", 2000, 40, 2.0f, "Βυ-7381") );
               
        idiok.add( new Idiokthths("Νίκος", "Βασιλόπουλος", "ΕΚ123456", 123456789, "Παπαστράτου", 8) );
        idiok.add( new Idiokthths("Χαρά", "Δεμερτζή", "ΦΙ567890", 234567890, "Αράξου", 99) );
        idiok.add( new Idiokthths("Ευάγγελος", "Καραφώτης", "ΔΤ456789", 345678901, "καλαβρύτων",  45) );
        
        enoik.add( new Enoikiasths("Ασπασία", "Δενδρινού", "ΨΟ230482", 456789012, "aspasia@gmail.com") );
        enoik.add( new Enoikiasths("Φωτεινή", "Γεωργαλή", "ΥΤ437890", 567890123, "foteinh@outlook.com") );
        enoik.add( new Enoikiasths("Δημήτρης", "Καρράς", "ΟΔ739057", 678901234, "mhtsaras@gmail.com") );
        
        krat.add( new Krathsh( (LocalDate.of(2022, 9, 12)), LocalDate.of(2022, 9, 14), "Κο-2022-35477", 456789012, "Κο-7452") );
        krat.add( new Krathsh( (LocalDate.of(2022, 7, 26)), LocalDate.of(2022, 7, 30), "Κη-2022-45748", 678901234, "Βυ-7386") );
        krat.add( new Krathsh( (LocalDate.of(2022, 7, 11)), LocalDate.of(2022, 7, 17), "Γλ-2022-78984", 567890123, "Γλ-9836") );
        krat.add( new Krathsh( (LocalDate.of(2022, 8, 01)), LocalDate.of(2022, 8, 07), "Kη-2022-23450", 456789012, "Κη-3864") );
        krat.add( new Krathsh( (LocalDate.of(2022, 9, 01)), LocalDate.of(2022, 9, 10), "Kο-2022-67349", 456789012, "Κο-7452") );

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        int epilogh;    //δείχνει την επιλογή του χρήστη
        int sunexeia;   //αν θέλει ο χρήστης να προχωρήσει σε κάποια νέα ενέργεια
        int temp_afm;
        int flag = 0;    //αν βρέθηκε το ΑΦΜ μέσα στο ArrayList
        int index = 0;   //θέση στο ΑrrayList
        int temp_kat;    //τύπος κατοικίας
        
        //είσοδος στην πλατφόρμα
        System.out.printf("Καλωσήρθατε στην πλατφόρμα JavaBnB!\n");     //μενού της πλατφόρμας
        
        do {    //με αυτο το do θα ξανά πηγαίνει το πρόγραμμα από την αρχή εάν το επιθυμεί ο χρήστης
                 
            System.out.printf("\nΠαρακαλώ δώστε τον κατάλληλο αριθμό σύμφωνα με την ενέργεια που θέλετε να πραγματοποιήσετε: 1--> Καταχώρηση ακινήτου\n"
                             +"                                                                                            2--> Δημιουργία κράτησης\n"
                             +"                                                                                            3--> Αλλαγή κράτησης\n"
                             +"                                                                                            4--> Εμφάνιση αναφορών\n"
                             +"Παρακαλώ δώστε έναν ακέραιο αριθμό: ");

            do {     //έλεγχος εγκυρότητας για την επιλογή που δίνει ο χρήστης
                                
                epilogh = input.nextInt();

                if ( ( epilogh != 1 ) && ( epilogh != 2 ) && ( epilogh != 3 ) && ( epilogh != 4 ) ) {
                    System.out.printf("Παρακαλώ η επιλογή σας πρέπει να είναι 1 ή 2 ή 3 ή 4.\n");
                    System.out.printf("Παρακαλώ ξανά επιλέξτε μία ενέργεια: ");
                }

            } while ( ( epilogh != 1 ) && ( epilogh != 2 ) && ( epilogh != 3 ) && ( epilogh != 4 ) );
            
    //////////////////////////////////////////////////**********ΥΛΟΠΟΙΗΣΗ ΚΥΡΙΩΝ ΛΕΙΤΟΥΡΓΙΩΝ**********//////////////////////////////////////////////////    
            
            switch (epilogh) {   //υλοποίηση των κύριων ζητουμένων της εκφώνησης
            
                case 1: //////////////////////////////**********ΣΕ ΠΕΡΙΠΤΩΣΗ ΠΟΥ ΕΠΙΛΕΧΘΕΙ ΚΑΤΑΧΩΡΗΣΗ ΑΚΙΝΗΤΟΥ**********/////////////////////////////
                    
                    System.out.printf("\nΕπιλέξατε να καταχωρήσετε ένα ακίνητο!\n\n");
                    
                    temp_afm = Xrhsths.elegxosAfm();  //παίρνει και ελέγχει αν το ΑΦΜ έχει 9 ψηφία
                    
                    for (int i = 0; i < idiok.size(); i++) {         //έλεγχος για το αν υπάρχει το ΑΦΜ μέσα στο ArrayList<Idiokthths> idiok

                        if ( idiok.get(i).getAfm() == temp_afm ) {    //σε περίπτωση που βρεθεί το ΑΦΜ
                            
                            System.out.printf("\nΠαρακαλώ δώστε τα ακόλουθα στοιχεία ώστε να καταχωρήσετε ένα νέο ακίνητο.\n");
                            flag = 1;   //βρέθηκε το ΑΦΜ, αλλιώς 0
                            index = i;  //σε ποιο νούμερο του ArrayList βρέθηκε το ΑΦΜ
                            break;  //για να μην γίνουν άλλες άσκοπες επαναλήψεις
                            
                        } else if ( (i + 1 == idiok.size() ) && ( idiok.get(i).getAfm() != temp_afm) ) {    //σε περίπτωση που δεν βρεθεί το ΑΦΜ
                            
                            System.out.printf("\nΠρέπει να εγγραφείτε στην πλατφόρμα προτού καταχωρήσετε ένα ακίνητο.\n");
                            flag = 0;
                            index = i + 1;  //η τελευταία θέση του ArrayList στην οποία θα μπει η καταχώρηση ιδιοκτήτη που θα ακολουθήσει 
                        }   
                    }

                    
                    if ( flag == 1 ) {  //όταν έχει βρεθεί το ΑΦΜ                    

                        temp_kat = Katoikia.tuposKatoikias();  //επιλέγει αν θέλει να εκχωρήσει μονοκατοικία ή διαμέρισμα
                        
                        if (temp_kat == 1) {  //εάν θέλει να εκχωρήσει μονοκατοικία
                            
                            Monokatoikia.addMonokatoikia(mono, idiok, katoikia, temp_afm, index);
                                
                        } else {   //εάν θέλει να εκχωρήσει διαμέρισμα
                                
                            Diamerisma.addDiamerisma(diam, idiok, katoikia, temp_afm, index);
                        }   
                        
                    } else {  //σε περίπτωση που δεν έχει βρεθεί το ΑΦΜ στα ήδη καταχωρημένα
                       
                        //ξεκινάει η εγγραφή του ιδιοκτήτη και η πρσθήκη του στο ArrayList idiok 
                        System.out.printf("\nΔεν είσαστε εγγεγραμμένος/η στην πλατφόρμα, οπότε πρέπει να δημιουργήσετε ένα λογαριασμό χρήστη πρώτα!\n");
                        
                        Idiokthths.addIdiokthths(idiok, temp_afm);
                        
                        temp_kat = Katoikia.tuposKatoikias();     //ξεκινάει η προσθήκη του ακινήτου
                        
                        if (temp_kat == 1) {   //εάν θέλει να εκχωρήσει μονοκατοικία
                                
                            Monokatoikia.addMonokatoikia(mono, idiok, katoikia, temp_afm, index);
                                
                        } else {    //εάν θέλει να εκχωρήσει διαμέρισμα
                                
                            Diamerisma.addDiamerisma(diam, idiok, katoikia, temp_afm, index);
                        }  
                    }  
                    
                    break;
                    
                case 2: //////////////////////////////**********ΣΕ ΠΕΡΙΠΤΩΣΗ ΠΟΥ ΕΠΙΛΕΧΘΕΙ ΔΗΜΙΟΥΡΓΙΑ ΚΡΑΤΗΣΗΣ**********/////////////////////////////
                    
                    System.out.printf("\nΕπιλέξατε να κάνετε μία κράτηση!\n\n");
                    
                    LocalDate hm_en, hm_lhx;
                    int flag1, flag2;
                    
                    do {
                        flag1 = 0;
                        flag2 = 0;
                        System.out.printf("\nΠαρακαλώ δώστε την ημερομηνία έναρξης της ενοικίασης (ηη/μμ/εεεε): ");
                        hm_en = Krathsh.hmeromhnia();
                        System.out.printf("\nΠαρακαλώ δώστε την ημερομηνία λήξης της ενοικίασης (ηη/μμ/εεεε): ");
                        hm_lhx = Krathsh.hmeromhnia();

                        if  ( (hm_en).isBefore(java.time.LocalDate.now() ) || (hm_lhx).isBefore(java.time.LocalDate.now() )) {
                            System.out.printf("Δεν μπορείτε να επιλέξετε ημερομηνία που έχει παρέλθει.\n");
                            flag1 = 1;
                        } 

                        if  ( DAYS.between(hm_en, hm_lhx) >= 15 ) {
                            System.out.printf("Δεν μπορείτε να ενοικιάσετε ένα οίκημα για πάνω από 15 μέρες.\n");
                            flag2 = 1;
                        } 
                        
                    } while ( (flag1 == 1) || (flag2 == 1) );
                    
                    System.out.printf("\nΠόσα άτομα θέλετε να μπορεί να φιλοξενήσει το οίκημα? ");
                    int pl_at = input.nextInt();
                    System.out.printf("\nΣε ποιο δήμο θέλετε να βρίσκεται το οίκημα? ");
                    String dhmos;
                    dhmos = in.nextLine();
                    
                    Katoikia.eureshKatoikias(katoikia, krat, dhmos, pl_at, hm_en, hm_lhx); //εμφανίζει τις διαθέσιμες κατοικίες
                    
                    flag = 0;
                    System.out.printf("\nΓια να πραγματοποιήσετε μία κράτηση δώστε το ΑΦΜ σας πρώτα!\n\n");
                    
                    temp_afm = Xrhsths.elegxosAfm();  //παίρνει και ελέγχει αν το ΑΦΜ έχει 9 ψηφία
                    
                    for (int i = 0; i < enoik.size(); i++) {         //έλεγχος για το αν υπάρχει το ΑΦΜ μέσα στο ArrayList<Enoikiasths> enoik

                        if ( enoik.get(i).getAfm() == temp_afm ) {        //σε περίπτωση που βρεθεί το ΑΦΜ
                            
                            System.out.printf("\nΠαρακαλώ δώστε τα ακόλουθα στοιχεία ώστε να κάνετε μία κράτηση.\n");
                            flag = 1;   //βρέθηκε το ΑΦΜ, αλλιώς 0
                            break;  //για να μην γίνουν άλλες άσκοπες επαναλήψεις
                            
                        } else if ( (i + 1 == enoik.size() ) && ( enoik.get(i).getAfm() != temp_afm) ) {    //σε περίπτωση που δεν βρεθεί το ΑΦΜ
                            
                            System.out.printf("\nΠρέπει να εγγραφείτε στην πλατφόρμα προτού κάνετε μία κράτηση.\n");
                            flag = 0;
                        }
                    }
                    
                    String kwd_kr = dhmos.substring(0, 2) + "-" + hm_en.getYear() + "-" +(int)Math.floor(Math.random()*(100000)+00000);
                    
                    if ( flag == 1 ) {  //όταν έχει βρεθεί το ΑΦΜ        
                        
                        Krathsh.addKrathsh(krat, katoikia, hm_en, hm_lhx, temp_afm, kwd_kr); //καταχώρηση της κράτησης
                        
                    } else {  //σε περίπτωση που δεν έχει βρεθεί το ΑΦΜ στα ήδη καταχωρημένα
                       
                        //ξεκινάει η εγγραφή του ενοικιαστή και η πρσθήκη του στο ArrayList enoik 
                        System.out.printf("\nΔεν είσαστε εγγεγραμμένος/η στην πλατφόρμα, οπότε πρέπει να δημιουργήσετε ένα λογαριασμό χρήστη πρώτα!\n");
                        
                        Enoikiasths.addEnoikiasths(enoik, temp_afm);  //καταγραφή του ενοικιαστή
                        
                        Krathsh.addKrathsh(krat, katoikia, hm_en, hm_lhx, temp_afm, kwd_kr);   //καταχώρηση της κράτησης
                    
                    }  
                    
                    break;
                      
                case 3: //////////////////////////////**********ΣΕ ΠΕΡΙΠΤΩΣΗ ΠΟΥ ΕΠΙΛΕΧΘΕΙ ΑΛΛΑΓΗ ΚΡΑΤΗΣΗΣ**********/////////////////////////////
                    
                    System.out.printf("\nΕπιλέξατε να αλλάξετε ή να ακυρώσετε μία κράτηση!\n\n");
                    
                    System.out.printf("Παρακαλώ δώστε τον κωδικό κράτησης σας: ");
                    kwd_kr = in.nextLine();
                    int energeia;
                    
                    for (int i = 0; i < krat.size(); i++) {
                        
                        if ( (krat.get(i).getKwd_kr()).equals(kwd_kr) ) {    //σε περίπτωση που βρεθεί ο κωδικός κράτησης στο ArrayLisst<Krathsh> krat
                            
                            int deikths = 0;
                            
                            for (int j = 0; j < katoikia.size(); j++) {  //για να πάρω το ημερήσιο κόστος αργότερα
                                
                                if ( (krat.get(i).getId_kat()).equals( katoikia.get(j).getId_kat() ) ) {
                                    deikths = j;   
                                }
                            }
                            
                            
                            do {   //έλεγχος εγκυρότητας για το τι θέλει να κάνει ο χρήστης
                                System.out.printf("\nΠαρακαλώ δώστε 1 για αλλαγή ημερομηνιών κράτησης ή 2 για ακύρωση κράτησης: ");
                                energeia = input.nextInt();
                                
                            } while ( (energeia !=1 ) && ( energeia != 2 ) );
                            
                            
                            if ( energeia == 1 ) {   //σε περίπτωση που ο χρήστης επιλέξει αλλαγή κράτησης
                                
                                if ( ( DAYS.between( java.time.LocalDate.now(), krat.get(i).getHm_en() ) ) >= 1 ) {   //σε περίπτωση που η έναρξη της κράτησης είναι τουλάχιστον μία ημέρα μετά την ημερομηνία του συστήματος
                                    
                                    LocalDate hm_enar, hm_lx;
                                    int flag11, flag22;

                                    do {
                                        flag11 = 0;
                                        flag22 = 0;
                                        System.out.printf("\nΠαρακαλώ δώστε την νέα ημερομηνία έναρξης της ενοικίασης (ηη/μμ/εεεε): ");
                                        hm_enar = Krathsh.hmeromhnia();
                                        System.out.printf("\nΠαρακαλώ δώστε την νέα ημερομηνία λήξης της ενοικίασης (ηη/μμ/εεεε): ");
                                        hm_lx = Krathsh.hmeromhnia();

                                        if  ( (hm_enar).isBefore(java.time.LocalDate.now() ) || (hm_lx).isBefore(java.time.LocalDate.now() )) {
                                            System.out.printf("Δεν μπορείτε να επιλέξετε ημερομηνία που έχει παρέλθει.\n");
                                            flag11 = 1;
                                        } 

                                        if  ( DAYS.between(hm_enar, hm_lx) >= 15 ) {
                                            System.out.printf("Δεν μπορείτε να ενοικιάσετε ένα οίκημα για πάνω από 15 μέρες.\n");
                                            flag22 = 1;
                                        } 

                                    } while ( (flag11 == 1) || (flag22 == 1) );
                                    
                                    krat.get(i).setHm_en(hm_enar);
                                    krat.get(i).setHm_lhx(hm_lx);
                                    
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                                    System.out.printf("Η κράτηση με κωδικό %s, θα είναι πλέον από τις %s έως τις %s και το συνολικό κόστος είναι: %d\n", kwd_kr, formatter.format(hm_enar), formatter.format(hm_lx), (DAYS.between(hm_enar, hm_lx)) * ( katoikia.get(deikths).getHmer_kostos() ) );
                                    
                                } else {   //σε περίπτωση που η έναρξη της κράτησης δεν είναι τουλάχιστον μία ημέρα μετά την ημερομηνία του συστήματος
                                    
                                    System.out.printf("\nΔυστυχώς δεν μπορείτε να αλλάξετε τις ημερομηνίες της κράτησης όταν η έναρξη της ενοικίασης απέχει λιγότερο από μία ημέρα.");
                                }
                                
                            } else {    //σε περίπτωση που ο χρήστης επιλέξει ακύρωση κράτησης
                                
                                int kost_kr = (int) ( ( DAYS.between( krat.get(i).getHm_en(), krat.get(i).getHm_lhx() ) ) * ( katoikia.get(deikths).getHmer_kostos() ) );
                                double kost_akur = ( kost_kr ) * (0.1) ;
                                int hm_prin = (int) DAYS.between( java.time.LocalDate.now(), krat.get(i).getHm_en() );
                                double xrewsh = kost_akur + ( kost_kr / hm_prin );
                                
                                krat.remove(i);
                                
                                System.out.printf("\nΗ κράτηση με κωδικό %s ακυρώθηκε και η χρέωση είναι %.2f $\n", kwd_kr, xrewsh);    
                            }
                            
                            break;     //για να μην γίνουν άλλες άσκοπες επαναλήψεις
                            
                        } else if ( (i + 1 == krat.size() ) && ( !(krat.get(i).getKwd_kr()).equals(kwd_kr) ) ) {  //σε περίπτωση που δεν βρεθεί ο κωδικός κράτησης στο ArrayLisst<Krathsh> krat
                            
                            System.out.printf("\nΔεν έχετε πραγματοποιήσει κάποια κράτηση ώστε να κάνετε κάποια αλλαγή ή κάποια ακύρωση!\n");
                        }  
                    }
                    
                    break;
                
                case 4: //////////////////////////////**********ΣΕ ΠΕΡΙΠΤΩΣΗ ΠΟΥ ΕΠΙΛΕΧΘΕΙ ΕΜΦΑΝΙΣΗ ΑΝΑΦΟΡΩΝ**********/////////////////////////////
                    
                    System.out.printf("\nEπιλέξατε να δείτε τις αναφορές σας!\n\n");
                    
                    temp_afm = Xrhsths.elegxosAfm();  //παίρνει και ελέγχει αν το ΑΦΜ έχει 9 ψηφία
                    String idiothta;
                    
                    do {   //έλεγχος εγκυρότηας για να πάρω μόνο δεκτές επιλογές
                        System.out.printf("\nΠοια είναι η ιδιότητά σας? (Ιδιοκτήτης / Ενοικιαστής ): ");
                        idiothta = in.nextLine();
                        
                        if ( (!idiothta.equals("Ιδιοκτήτης") ) && (!idiothta.equals("Ενοικιαστής") ) ) {
                                    
                            System.out.printf("\nΠαρακαλώ δώστε μία έγκυρη επιλογή...\n");
                        }
                        
                    } while ( (!idiothta.equals("Ιδιοκτήτης") ) && (!idiothta.equals("Ενοικιαστής") ) );
                    
                    int flag111;
                    
                    if ( idiothta.equals("Ιδιοκτήτης") ) {
                          
                        flag111 = Idiokthths.eureshAfm(idiok, temp_afm);
                        
                        if ( flag111 == 1 ) {
                            
                            String epil;
                            
                            do {  //έλεγχος εγκυρότηας για να πάρω μόνο δεκτές επιλογές
                                System.out.printf("Θέλετε να δείτε τα χαρακτηριστικά όλων των ακινήτων σας ή το συνολικο διάστημα ενοικίασης μίας κατοικίας? (Χαρακτηριστικά / Ημέρες) ");
                                epil = in.nextLine();

                                if ( epil.equals("Χαρακτηριστικά") ) {

                                    Idiokthths.showKatoikies(mono, diam, temp_afm);

                                } else if (epil.equals("Ημέρες") ) {

                                    Idiokthths.showHmeres(krat);
                                }
                                
                                if ( (!epil.equals("Χαρακτηριστικά") ) && (!epil.equals("Ημέρες") ) ) {
                                    
                                    System.out.printf("\nΠαρακαλώ δώστε μία έγκυρη επιλογή...\n");
                                }
                                
                            } while ( (!epil.equals("Χαρακτηριστικά") ) && (!epil.equals("Ημέρες") ) ); 
                        
                        } else if ( flag111 == 0 ) {
                            
                            System.out.printf("\nΣυγγνώμη αλλά δεν είστε εγγεγρραμμένος ως ιδιοκτήτης\n");
                        }
       
                    } else if ( idiothta.equals("Ενοικιαστής") ) {
                        
                        flag111 = Enoikiasths.eureshAfm(enoik, temp_afm);
                        
                        if ( flag111 == 1 ) {   
                            
                            String epil;

                            do {
                                System.out.printf("Θέλετε να δείτε λίστα των κρατήσεών σας ή το συνολικό τους κόστος? (Λίστα / Κόστος) ");
                                epil = in.nextLine();

                                if ( epil.equals("Λίστα") ) {

                                    Enoikiasths.showLista(katoikia, krat, temp_afm);

                                } else if (epil.equals("Κόστος") ) {

                                    Enoikiasths.showKostos(katoikia, krat, temp_afm);
                                }    
                                
                                if ( (!epil.equals("Λίστα") ) && (!epil.equals("Κόστος") ) ) {
                                    
                                    System.out.printf("\nΠαρακαλώ δώστε μία έγκυρη επιλογή...\n");
                                }
                            
                            } while( (!epil.equals("Λίστα") ) && (!epil.equals("Κόστος") ) );    
                        
                        } else if ( flag111 == 0 ) {
                            
                            System.out.printf("\nΣυγγνώμη αλλά δεν είστε εγγεγραμμένος ως ενοικιαστής\n");
                        }
                    }    
                    
                    break;
                    
                //default στη switch (epilogh) δεν υπάρχει καθώς δεν πρόκειται να βγει από τον έλεγχο εγκυρότητας που βρίσκεται στην αρχή κάποιος αριθμός εκτός του εύρους [1,4]    
            
            }  //τέλος switch (epilogh)  

            System.out.printf("\nθα θέλατε να προχωρήσετε σε νέα ενέργεια? Εάν ναι πατήστε 1, αλλιώς 0:  ");   //εάν θέλει ο χρήστης να χρησιμοποιήσει πάλι την πλατφόρμα

            do {             //εγκυρότητα για συνέχεια 1 ή 0
                sunexeia = input.nextInt();
                
                if ( ( sunexeia != 1) && ( sunexeia != 0) ) {
                    
                    System.out.printf("\nΠαρακαλώ δώστε μία έγκυρη επιλογή: ");
                }
            
            } while ( ( sunexeia != 1) && ( sunexeia != 0) );
            
        } while ( sunexeia == 1 );   
     
       System.out.printf("\nΕυχαριστούμε που χρησιμοποιήσατε την πλατφόρμα JavaBnB!\n");

       input.close();
       in.close();
     
    }   //τέλος της main
    
}    //τέλος της class