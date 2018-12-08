import static java.lang.Thread.sleep;

public class Navette extends Thread{
    private int nb_places;
    private int nb_places_dispo;
    private Attraction attraction;

    public Navette(Attraction A, int nb_places){
        //Permet d'arrêter la boucle infinie lorsqu'il n'y a plus de client
        this.setDaemon(true);
        this.attraction = A;
        this.nb_places=nb_places;
        nb_places_dispo = nb_places;
    }

    //@return le nombre de places disponibles
    public int getNb_places_dispo() {
        return nb_places_dispo;
    }

    //Simulation du temps où la navette est en train de faire l'attraction
    public void voyage(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Lorsqu'un client monte dans une navette, il y a une place en moins dans cette même navette
    public void client_monte() {
        nb_places_dispo--;
    }

    //Réinitialisation des places de la navette lorsque les clients descendent
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