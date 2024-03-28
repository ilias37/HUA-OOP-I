package MyPlatform;

import java.util.Scanner;

public class Xrhsths {  //είναι abstract class δεν θα καλεστεί πουθενά, αποτελεί έναν πολύ "γενικό" τύπο
    
    protected String fname;
    protected String lname;
    protected String ar_taut;
    protected int afm;
    
    //constructor της κλάσης Xrhsths
    public Xrhsths(String fname, String lname, String ar_taut, int afm) {
        this.fname = fname;
        this.lname = lname;
        this.ar_taut = ar_taut;
        this.afm = afm;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAr_taut() {
        return ar_taut;
    }

    public void setAr_taut(String ar_taut) {
        this.ar_taut = ar_taut;
    }

    public int getAfm() {
        return afm;
    }

    public void setAfm(int afm) {
        this.afm = afm;
    }
    
    
    @Override
    public String toString() {
        return "Χρήστης {" + "Όνομα=" + fname + ", Επίθετο=" + lname + ", Αριθμός ταυτότητας=" + ar_taut + ", ΑΦΜ=" + afm ;
    }

    
    public static int elegxosAfm() {  //ελέγχει τα ψηφία του ΑΦΜ αν είναι 9 
        
        int temp_afm1, temp_afm2, count;
        Scanner input = new Scanner(System.in);
       
        do {  //μέτρηση των ψηφίων του ΑΦΜ
            count = 0;
            System.out.printf("Δώστε το 9-ψήφιο ΑΦΜ σας παρακαλώ: ");
            temp_afm1 = input.nextInt();
            temp_afm2 = temp_afm1;
            
            while ( temp_afm1 != 0 ) {
                
                temp_afm1 /= 10;
                ++count;
            }
             
            if ( count != 9 ) {
                
                System.out.printf("Δυστυχώς δεν δώσατε 9 ψηφία. Παρακαλώ ξανά προσπαθήστε.\n");
            }
            
        } while (count != 9);

        input.close();
        
        return temp_afm2;
        
    }
    
}