import static java.lang.Thread.sleep;

/**
 * Created by 18004011 on 04/12/18.
 */
public class Navette {

    protected int nb_places;
    protected int nb_places_dispo;
    private boolean en_cours;

    public Navette(int nb_places){
        this.nb_places=nb_places;

    }

    public void stationner() throws InterruptedException {
        sleep(3000);
        en_cours= true;
        this.voyage();
    }

    public void voyage() throws InterruptedException {
        sleep(3000);
        en_cours = false;
        this.stationner();
    }

}
