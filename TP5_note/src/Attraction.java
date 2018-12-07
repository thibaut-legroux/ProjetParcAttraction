import java.util.HashSet;
import java.util.Set;

public class Attraction {
    private Set<Navette> navettes;
    private final int duree_arret = 5;
    private final int nbNavette = 4;
    private int idAttraction;
    private Navette Na;

    public Attraction(int idAttract){
        this.idAttraction = idAttract;
        this.navettes = new HashSet<Navette>();
        int place = 1 + (int) (Math.random() * ((20 - 1) + 1));
        for(int i=0; i<nbNavette; i++) {
            Navette Nav = new Navette(this, place);
            navettes.add(Nav);
        }

        for(Navette Na : navettes) {
            Na.start();
        }
    }

    public synchronized void aQuai(Navette N){
        while(Na != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.Na = N;
        try {
            Thread.sleep(100);
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void charger_client() {
        while (Na == null || Na.getNb_places_dispo() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Na.client_monte();
        notifyAll();
    }

    public void faire_attraction() {
        charger_client();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void client_descend(Navette N) {
        while(Na != N) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Na.init_place();
        Na = null;
        notifyAll();
    }
}