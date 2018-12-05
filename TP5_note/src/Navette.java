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

/**
public class Quai {

    private boolean monter=false;
    private int nb_client;
    private Navette navette;

    public Quai(Navette navette, int nb_client){
        this.navette = navette;
        this.nb_client = nb_client;
    }

    public Boolean monter_navette() throws InterruptedException {
        if(monter){
            //wait.client
        }else{
            navette.stationner();
            monter=true;
            nb_client-=navette.nb_places;
            //ou
            while(nb_client>0 && (navette.nb_places_dispo>0)){
                nb_client--;
                navette.nb_places_dispo--;
                navette.voyage();
            }


            //client qui partent du quai car navette présente
            //attention le nombre de client sur le quai doit être >=0
        }
        return monter;
    }

    public void descendre_navette() throws InterruptedException {
        if(navette.nb_places_dispo == navette.nb_places){

        }
    }


}
*/
