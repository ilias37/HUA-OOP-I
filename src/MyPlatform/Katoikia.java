package MyPlatform;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Katoikia {  //είναι abstract class δεν θα καλεστεί πουθενά, αποτελεί έναν πολύ "γενικό" τύπο
    
    protected String dhmos;
    protected String odos;
    protected int arithmos;
    protected int afm;
    protected int pl_at;    //πλήθος ατόμων
    protected int pl_upn;   //πλήθος υπνοδωματίων
    protected boolean internet;
    protected boolean tv;
    protected boolean kouzina;
    protected boolean parking;
    protected String thea;  //θέα
    protected int apost_metro;   //απόσταση από μετρό
    protected int hmer_kostos;
    protected float ep_an;     //επίπεδο άνεσης
    protected String id_kat;    //κωδικός ταυτοποιήσης ακινήτου

    //constructor της κλάσης Katoikia
    public Katoikia(String dhmos, String odos, int arithmos, int afm, int pl_at, int pl_upn, boolean internet, boolean tv, boolean kouzina, boolean parking, String thea, int apost_metro, int hmer_kostos, float ep_an, String id_kat) {
        this.dhmos = dhmos;
        this.odos = odos;
        this.arithmos = arithmos;
        this.afm = afm;
        this.pl_at = pl_at;
        this.pl_upn = pl_upn;
        this.internet = internet;
        this.tv = tv;
        this.kouzina = kouzina;
        this.parking = parking;
        this.thea = thea;
        this.apost_metro = apost_metro;
        this.hmer_kostos = hmer_kostos;
        this.ep_an = ep_an;
        this.id_kat = id_kat;
    }
    
    public String getDhmos() {
        return dhmos;
    }

    public void setDhmos(String dhmos) {
       this.dhmos = dhmos;
    }

    public String getOdos() {
        return odos;
    }

    public void setOdos(String odos) {
        this.odos = odos;
    }

    public int getArithmos() {
        return arithmos;
    }

    public void setArithmos(int arithmos) {
        this.arithmos = arithmos;
    }

    public int getAfm() {
        return afm;
    }

    public void setAfm(int afm) {
        this.afm = afm;
    }

    public int getPl_at() {
        return pl_at;
    }

    public void setPl_at(int pl_at) {
        this.pl_at = pl_at;
    }

    public int getPl_upn() {
        return pl_upn;
    }

    public void setPl_upn(int pl_upn) {
        this.pl_upn = pl_upn;
    }

    public boolean getInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public boolean getTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean getKouzina() {
        return kouzina;
    }

    public void setKouzina(boolean kouzina) {
        this.kouzina = kouzina;
    }

    public boolean getParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public String getThea() {
        return thea;
    }

    public void setThea(String thea) {
        this.thea = thea;
    }

    public int getApost_metro() {
        return apost_metro;
    }

    public void setApost_metro(int apost_metro) {
        this.apost_metro = apost_metro;
    }

    public int getHmer_kostos() {
        return hmer_kostos;
    }

    public void setHmer_kostos(int hmer_kostos) {
        this.hmer_kostos = hmer_kostos;
    }

    public float getEp_an() {
        return ep_an;
    }

    public void setEp_an(int pl_at, int pl_upn) {
        this.ep_an = pl_at / pl_upn;
    }

    public String getId_kat() {
        return id_kat;
    }

    public void setId_kat(String dhmos) {
        this.id_kat = dhmos.substring(0, 2)+"-"+(int)Math.floor(Math.random()*(10000)+0000);
    }

 
    @Override
    public String toString() {
        return "Κατοικία {" + "Δήμος=" + dhmos + ", Οδός=" + odos + ", Αριθμός=" + arithmos + ", ΑΦΜ=" + afm + ", Πλήθος ατόμων=" + pl_at + ", Πλήθος υπνοδωματίων=" + pl_upn + ", Ίντερνετ=" + internet + ", Τηλεόραση=" + tv + ", Κουζίνα=" + kouzina + ", Πάρκινγκ=" + parking + ", Θέα=" + thea + ", Απόσταση από μετρό=" + apost_metro + " μέτρα, Ημερήσιο κόστος=" + hmer_kostos + " $, Επίπεδο άνεσης=" + ep_an + ", ID κατοικίας=" + id_kat ;
    }
    
    
    public static int tuposKatoikias() {  //παίρνει τον τύπο κατοικίας που θέλει να εκχωρήσει ο ιδιοκτήτης
        
        int temp_kat;
        
        Scanner input = new Scanner(System.in);
        
        System.out.printf("\nΠρόκειται να καταχωρήσετε μονοκατοικία ή διαμέρισμα? Παρακαλώ δώστε 1 για μονοκατοικία ή 2 για διαμέρισμα: ");

        do {    //έλεγχος για το τι τύπο κατοικίας θέλει να καταχωρήσει ο χρήστης

            temp_kat = input.nextInt();

            if ( (temp_kat != 1) && (temp_kat != 2) ) {

                System.out.printf("\nΠαρακαλώ δώστε μία αποδεκτή επιλογή: ");
            }

        } while ( (temp_kat != 1) && (temp_kat != 2) );
        
        input.close();
        return temp_kat;
    }
    
    
    //εμφανίζει τις διαθέσιμες κατοικίες
    public static  void eureshKatoikias(ArrayList<Katoikia> katoikia, ArrayList<Krathsh> krat, String dhmos, int pl_at, LocalDate hm_en, LocalDate hm_lhx) {
     
        for (int i = 0; i < katoikia.size(); i++) {   //πρώτα ψάχνω τις κατοικίες και αν υπάρχουν διαθέσιμες στον δήμο με τα άτομα που θέλω τότε θα ψάξω τις κρατήσεις αν είναι διαθέσιμο το σπίτι

            if ( ( katoikia.get(i).getDhmos().equals(dhmos) ) && (katoikia.get(i).getPl_at() >= pl_at) ) {
                   
                for (int j = 0; j < krat.size(); j++) {
                    
                    if ( (((hm_en).isBefore(krat.get(j).getHm_en())) && ((hm_lhx).isBefore(krat.get(j).getHm_en()))) || ((hm_en).isAfter(krat.get(j).getHm_lhx())) ) {
                       
                        System.out.printf("\nID κατοικίας: %s, Ημερήσιο κόστος: %d $", katoikia.get(i).getId_kat(), katoikia.get(i).getHmer_kostos());
                        break;

                    }
                }
            }

        }
    }

}