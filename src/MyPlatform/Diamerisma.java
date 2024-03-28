package MyPlatform;

import java.util.ArrayList;
import java.util.Scanner;

public class Diamerisma extends Katoikia {
        
    protected int orofos;
    protected boolean balcony;
    protected boolean asanser;
   
    //constructor της υποκλάσης Diamerisma
    public Diamerisma(String dhmos, String odos, int arithmos, int afm, int pl_at, int pl_upn, boolean internet, boolean tv, boolean kouzina, boolean parking, String thea, int apost_metro, int hmer_kostos, float ep_an, String id_kat, int orofos, boolean balcony, boolean asanser) {
        super(dhmos, odos, arithmos, afm, pl_at, pl_upn, internet, tv, kouzina, parking, thea, apost_metro, hmer_kostos, ep_an, id_kat);
        this.orofos = orofos;
        this.balcony = balcony;
        this.asanser = asanser;
    }
    
    public int getOrofos() {
        return orofos;
    }

    public void setOrofos(int orofos) {
        this.orofos = orofos;
    }
    
    public boolean getBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public boolean getAsanser() {
        return asanser;
    }

    public void setAsanser(boolean asanser) {
        this.asanser = asanser;
    }

    
    @Override
    public String toString() {
        return super.toString() + ", Όροφος=" + orofos + ", Μπαλκόνι=" + balcony + ", Ασανσέρ=" + asanser + "}\n" ;
    }
    
    
    //καταχωρεί ένα διαμέρισμα
    public static void addDiamerisma(ArrayList<Diamerisma> diam, ArrayList<Idiokthths> idiok, ArrayList<Katoikia> katoikia, int temp_afm, int index) {
        
        Scanner input = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
                
        System.out.printf("Δώστε τον δήμο της κατοικίας: ");
        String dhmos = input.nextLine();

        System.out.printf("\nΔώστε την οδό της κατοικίας: ");
        String odos = input.nextLine();

        System.out.printf("\nΔώστε τον αριθμό της κατοικίας: ");
        int arithmos = input.nextInt();

        int afm = temp_afm;

        System.out.printf("\nΔώστε το πλήθος ατόμων που μπορεί να φιλοξενήσει η κατοικία: ");
        int pl_at = input.nextInt();

        System.out.printf("\nΔώστε το πλήθος υπνοδωματίων της κατοικίας: ");
        int pl_upn = input.nextInt();

        System.out.printf("\nΗ κατοικία διαθέτει ίντερνετ?(true / false) ");
        boolean internet = input.nextBoolean();

        System.out.printf("\nΗ κατοικία διαέτει τηλεόραση?(true / false) ");
        boolean tv = input.nextBoolean();

        System.out.printf("\nΗ κατοικία διαθέτει κουζίνα?(true / false) ");
        boolean kouzina = input.nextBoolean();

        System.out.printf("\nΗ κατοικία διαθέτει πάρκινγκ?(true / false) ");
        boolean parking = input.nextBoolean();

        System.out.printf("\nΗ κατοικία διαθέτει θέα?(Δρόμος, Βουνό, Θάλασσα): ");
        String thea = in.nextLine(); 

        System.out.printf("\nΣε πόσα μέτρα βρίσκεται το κοντινότερο μετρό? ");
        int apost_metro = input.nextInt();

        System.out.printf("\nΤο ημερήσιο κόστος ενοικίασης είναι: ");
        int hmer_kostos = input.nextInt();

        float ep_an = pl_at / pl_upn; 

        String id_kat = dhmos.substring(0, 2)+"-"+(int)Math.floor(Math.random()*(10000)+0000);

        System.out.printf("\nΟ όροφος στον οποίο βρίσκεται το διαμέρισμα είναι: ");
        int orofos = input.nextInt();

        System.out.printf("\nΤο διαμέρισμα διαθέτει μπαλκόνι?(true / false): ");
        boolean balcony = input.nextBoolean();

        System.out.printf("\nΤο οίκημα διαθέτει ασανσέρ?(true / false) ");
        boolean asanser = input.nextBoolean();

        //δημιουργία του αντικειμένου και πέρασμα στην ArrayList diam
        Diamerisma d1 = new Diamerisma(dhmos, odos, arithmos, afm, pl_at, pl_upn, internet, tv, kouzina, parking, thea, apost_metro, hmer_kostos, ep_an, id_kat, orofos, balcony, asanser);
        diam.add(d1);
        
        Katoikia k1 = new Katoikia(dhmos, odos, arithmos, afm, pl_at, pl_upn, internet, tv, kouzina, parking, thea, apost_metro, hmer_kostos, ep_an, id_kat) ;
        katoikia.add(k1);

        System.out.printf("\n\nΤο οίκημα που καταχωρήθηκε έχει κωδικό %s, το ΑΦΜ του ιδιοκτήτη είναι %d και ανήκει στον/ην %s %s", id_kat, afm, idiok.get(index).getFname(), idiok.get(index).getLname());

        input.close();
        in.close();
    } 
    
}