package MyPlatform;

import static java.time.temporal.ChronoUnit.DAYS;
import java.util.Scanner;
import java.util.ArrayList;

public class Idiokthths extends Xrhsths {
    
    protected String odos_kat;
    protected int arithmos_kat;

    public Idiokthths(String fname, String lname, String ar_taut, int afm, String odos_kat, int arithmos_kat) {
        super(fname, lname, ar_taut, afm);
        this.odos_kat = odos_kat;
        this.arithmos_kat = arithmos_kat;
    }

    public String getOdos_kat() {
        return odos_kat;
    }

    public void setOdos_kat(String odos_kat) {
        this.odos_kat = odos_kat;
    }

    public int getArithmos_kat() {
        return arithmos_kat;
    }

    public void setArithmos_kat(int arithmos_kat) {
        this.arithmos_kat = arithmos_kat;
    }    
    
    @Override
    public int getAfm() {
        return afm;
    }
    

    @Override
    public String toString() {
        return super.toString() + ", Οδός κατοικίας=" + odos_kat + ", Αριθμός κατοικίας=" + arithmos_kat + "}\n" ; 
    }   
    
    
    //καταχωρεί ένα νέο ιδιοκτήτη 
    public static void addIdiokthths(ArrayList<Idiokthths> idiok, int temp_afm) {
      
        Scanner input = new Scanner(System.in);
                        
        System.out.printf("\nΠαρακαλώ δώστε το όνομα σας: ");
        String fname = input.nextLine();

        System.out.printf("\nΠαρακαλώ δώστε το επίθετό σας: ");
        String lname = input.nextLine();

        System.out.printf("\nΠαρακαλώ δώστε τον αριθμό της ταυτότητάς σας: ");
        String ar_taut = input.nextLine();

        int afm = temp_afm;

        System.out.printf("\nΔώστε την οδό της μόνιμης κατοικίας σας: ");
        String odos_kat = input.nextLine();

        System.out.printf("\nΔώστε τον αριθμό της μόνιμης κατοικίας σας: ");
        int arithmos_kat = input.nextInt();

        Idiokthths i1 = new Idiokthths(fname, lname, ar_taut, afm, odos_kat, arithmos_kat );
        idiok.add(i1);

        input.close();
    }
    
    
    public static int eureshAfm(ArrayList<Idiokthths> idiok, int temp_afm) {
        
        int flag111 = 0;
        
        for (int i = 0; i < idiok.size(); i++) {   //έλεγχος για το αν υπάρχει το ΑΦΜ μέσα στο ArrayList<Idiokthths> idiok

            if ( idiok.get(i).getAfm() == temp_afm ) {    //σε περίπτωση που βρεθεί το ΑΦΜ

                flag111 = 1;
                break;  //για να μην γίνουν άλλες άσκοπες επαναλήψεις

            } else if ( (i == idiok.size() ) && ( idiok.get(i).getAfm() != temp_afm) ) {    //σε περίπτωση που δεν βρεθεί το ΑΦΜ

                flag111 = 0;
            }   
        }
        
        return flag111;
    }
    
    
    public static void showKatoikies(ArrayList<Monokatoikia> mono, ArrayList<Diamerisma> diam, int temp_afm) {
        
        for (int i = 0; i < mono.size(); i++) {
                                    
            if ( mono.get(i).getAfm() == temp_afm ) {

                System.out.printf("\n%s\n", mono.get(i).toString());
            }
        }  
        
        for (int i = 0; i < diam.size(); i++) {

            if ( diam.get(i).getAfm() == temp_afm ) {

                System.out.printf("\n%s\n", diam.get(i).toString());
            }
        }
    }    
    
    
    public static void showHmeres(ArrayList<Krathsh> krat) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.printf("\nΠαρακαλώ δώστε το ID της κατοικίας όπου θέλετε να δείτε τις συνολικές ημέρες ενοικίασης: ");
        String id_kat = input.nextLine();
        int sun_hm = 0;   //συνολικές ημέρες

        for (int i = 0; i < krat.size(); i++) {

            if ( (krat.get(i).getId_kat()).equals(id_kat) ) {

                sun_hm = sun_hm + (int) DAYS.between( krat.get(i).getHm_en(), krat.get(i).getHm_lhx() );
            }
        }

        System.out.printf("\nΤο συνολικό διάστημα ενοικίασης της κατοικίας με ID = %s είναι %d μέρες", id_kat, sun_hm);

        input.close();
    }
    
}