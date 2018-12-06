import java.util.HashSet;
import java.util.Set;

public class Attraction {

    private Set<Navette> navettes;
    private final int duree_arret = 5;
    private final int duree_attraction = 5;
    private final int max_places = 10;
    private int idAttraction;

    public Attraction(int idAttraction){
        this.idAttraction = idAttraction;
        this.navettes = new HashSet<Navette>();
    }
    
    //Pas compris le if
    public void addNavette(Navette navette){
        if(navette.nb_places == max_places){
            this.navettes.add(navette);
        }
    }
    
    //Peut être avec faire_attraction ?
    public void charger_navette(int nb_clients){

    }
    
    public void faire_attraction() {
        while (true) {
            //A faire
        }
    }
}
