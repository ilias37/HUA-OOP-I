package MyPlatform;

import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Enoikiasths extends Xrhsths {
    
    protected String email;

    public Enoikiasths(String fname, String lname, String ar_taut, int afm, String email) {
        super(fname, lname, ar_taut, afm);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
    
    @Override
    public String toString() {
        return super.toString() + ", Email=" + email + "}\n" ;
    }
    
    
    public static boolean isValid(String email)  //ελέγχει αν το email είναι ρεαλιστικό 
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    
    
    //καταχωρεί μία νέα κράτηση
    public static void addEnoikiasths(ArrayList<Enoikiasths> enoik, int temp_afm) {
      
        Scanner input = new Scanner(System.in);
                        
        System.out.printf("\nΠαρακαλώ δώστε το όνομα σας: ");
        String fname = input.nextLine();

        System.out.printf("\nΠαρακαλώ δώστε το επίθετό σας: ");
        String lname = input.nextLine();

        System.out.printf("\nΠαρακαλώ δώστε τον αριθμό της ταυτότητάς σας: ");
        String ar_taut = input.nextLine();

        int afm = temp_afm;
        
        System.out.printf("\nΠαρακαλώ δώστε το email σας: ");
        String email = input.nextLine();
                
        do {
            if (isValid(email)) {
                break;
            } else {
                System.out.printf("\nΠαρακαλώ ξανά δώστε το email σας: ");
                email = input.nextLine();
            }
            
        } while (!isValid(email));    
            
        Enoikiasths e1 = new Enoikiasths(fname, lname, ar_taut, afm, email);
        enoik.add(e1);

        input.close();
    }
    
    
    public static int eureshAfm(ArrayList<Enoikiasths> enoik, int temp_afm) {
        
        int flag111 = 0;
        
        for (int i = 0; i < enoik.size(); i++) {         //έλεγχος για το αν υπάρχει το ΑΦΜ μέσα στο ArrayList<Enoikiasths> enoik

            if ( enoik.get(i).getAfm() == temp_afm ) {        //σε περίπτωση που βρεθεί το ΑΦΜ

                flag111 = 1;
                break;  //για να μην γίνουν άλλες άσκοπες επαναλήψεις

            } else if ( (i + 1 == enoik.size() ) && ( enoik.get(i).getAfm() != temp_afm) ) {    //σε περίπτωση που δεν βρεθεί το ΑΦΜ

                flag111 = 0;
            }
        }
        
        return flag111;
    }
    
    
    public static void showLista(ArrayList<Katoikia> katoikia, ArrayList<Krathsh> krat, int temp_afm) {
        
        System.out.printf("\nΗ λίστα των κρατήσεών σας περιέχει: \n");
        int deikths = 0;

        for (int i = 0; i < krat.size(); i++) {  //για να εμφανίσω τη λίστα με τις κρατήσεις του ενοικιαστή

            if ( (krat.get(i).getAfm_en()) == (temp_afm) ) {

                for (int j = 0; j < katoikia.size(); j++) {  //για να πάρω το ημερήσιο κόστος αργότερα

                    if ( (krat.get(i).getId_kat()).equals( katoikia.get(j).getId_kat() ) ) {
                        deikths = j;   
                        break;
                    }
                } 

                int kost_kr = (int) ( ( DAYS.between( krat.get(i).getHm_en(), krat.get(i).getHm_lhx() ) ) * ( katoikia.get(deikths).getHmer_kostos() ) );
                System.out.printf("\n%s και το κόστος είναι %d $\n", krat.get(i).toString(), kost_kr );
            }
        }
    }
    
    
    public static void showKostos(ArrayList<Katoikia> katoikia, ArrayList<Krathsh> krat, int temp_afm) {
        
        int sun_kostos = 0;
        int deikths = 0;

        for (int i = 0; i < krat.size(); i++) {  

            if ( (krat.get(i).getAfm_en()) == (temp_afm) ) {

                for (int j = 0; j < katoikia.size(); j++) {  //για να πάρω το ημερήσιο κόστος αργότερα

                    if ( (krat.get(i).getId_kat()).equals( katoikia.get(j).getId_kat() ) ) {
                        deikths = j; 
                    }
                } 

                int kost_kr = (int) ( ( DAYS.between( krat.get(i).getHm_en(), krat.get(i).getHm_lhx() ) ) * ( katoikia.get(deikths).getHmer_kostos() ) );
                sun_kostos = sun_kostos + kost_kr;

            }
        }

        System.out.printf("\nΤο συνολικό κόστος των κρατήσεών σας είναι %d", sun_kostos);
    }
    
}