import static java.lang.Thread.sleep;

public class Navette extends Thread{
    private int nb_places;
    private int nb_places_dispo;
    private Attraction attraction;

    public Navette(Attraction A, int nb_places){
        this.setDaemon(true);
        this.attraction = A;
        this.nb_places=nb_places;
        nb_places_dispo = nb_places;
    }

    public int getNb_places_dispo() {
        return nb_places_dispo;
    }

    public void voyage(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void client_monte() {
        nb_places_dispo--;
    }

    public void init_place() {
        nb_places_dispo = nb_places;
    }

    public void run() {
        while(true) {
            attraction.aQuai(this);
            voyage();
            attraction.client_descend(this);
        }
    }
}