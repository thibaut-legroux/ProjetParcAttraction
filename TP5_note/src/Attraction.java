import java.util.HashSet;
import java.util.Set;

/**
 * Created by 18004011 on 04/12/18.
 */
public class Attraction {

    private Quai quai;
    private Set<Navette> navettes;
    private int duree_arret = 7;
    private int duree_attraction = 3;
    private int max_places = 10;

    public Attraction(Quai quai){
        this.quai = quai;
        this.navettes = new HashSet<Navette>();
    }

    public void addNavette(Navette navette){
        if(navette.nb_places == max_places){
            this.navettes.add(navette);
        }

    }

    public void charger_navette(int nb_clients){

    }



}
