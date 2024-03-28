package MyPlatform;

import java.util.Scanner;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;


public class Krathsh {
    
    LocalDate hm_en, hm_lhx;
    String kwd_kr;
    int afm_en;
    String id_kat;


    public Krathsh(LocalDate hm_en, LocalDate hm_lhx, String kwd_kr, int afm_en, String id_kat) {
        this.hm_en = hm_en;
        this.hm_lhx = hm_lhx;
        this.kwd_kr = kwd_kr;
        this.afm_en = afm_en;
        this.id_kat = id_kat;

    }
   
    public LocalDate getHm_en() {
        return hm_en;
    }

    public void setHm_en(LocalDate hm_en) {
        this.hm_en = hm_en;
    }

    public LocalDate getHm_lhx() {
        return hm_lhx;
    }

    public void setHm_lhx(LocalDate hm_lhx) {
        this.hm_lhx = hm_lhx;
    }

    public String getKwd_kr() {
        return kwd_kr;
    }

    public void setKwd_kr(String kwd_kr) {
        this.kwd_kr = hm_en.getYear() +"-"+(int)Math.floor(Math.random()*(100000)+00000);
    }

    public int getAfm_en() {
        return afm_en;
    }

    public void setAfm_en(int afm_en) {
        this.afm_en = afm_en;
    }

    public String getId_kat() {
        return id_kat;
    }

    public void setId_kat(String id_kat) {
        this.id_kat = id_kat;
    }

    
    @Override
    public String toString() {
        return "Κράτηση {" + "Ημερομηνία έναρξης =" + hm_en + ", Ημερομηνία λήξης =" + hm_lhx + ", Κωδικός κράτησης =" + kwd_kr + ", ΑΦΜ Ενοικιαστή =" + afm_en + '}';
    } 
        
    
    public static LocalDate hmeromhnia() throws ParseException { //παίρνει την ημερομηνία και την μετατρέπει στο format που θέλω
        
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String hmer = input.nextLine();
        
        LocalDate d1 = LocalDate.parse(hmer, formatter);
        input.close();
        return d1;
    }
    
    
    //κάνει μία κράτηση
    public static void addKrathsh(ArrayList<Krathsh> krat, ArrayList<Katoikia> katoikia, LocalDate hm_en, LocalDate hm_lhx, int temp_afm, String kwd_kr) {
        
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        
        //ξεκινάει η κράτηση
        System.out.printf("Δώστε το ID της κατοικίας από τις διαθέσιμες που σας προτάθηκαν: ");
        String id_kat = input.nextLine();

        krat.add( new Krathsh( hm_en, hm_lhx, kwd_kr, temp_afm, id_kat) );
        int hmer_kostos = 50;

        for (int k = 0; k < katoikia.size(); k++ ) {  //για να βρω το ημερήσιο κόστος του οικήματος

            if ( (katoikia.get(k).getId_kat()).equals(id_kat) ) {

                hmer_kostos = katoikia.get(k).getHmer_kostos();
            }
        }
        
        System.out.printf("\nΠραγματοποιήσατε μία κράτηση με κωδικό %s, από τις %s έως τις %s και το συνολικό κόστος είναι: %d$\n", kwd_kr, formatter.format(hm_en), formatter.format(hm_lhx), (DAYS.between(hm_en, hm_lhx)) * hmer_kostos);

        input.close();
    
    }
    
}
