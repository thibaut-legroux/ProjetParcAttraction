
public class Client extends Thread {

    private int nb_client;
    private Billetterie b;
    private Attraction a1;
    private Attraction a2;
    
    public Client(int nbClient, Billetterie b, Attraction a1, Attraction a2){
        this.nb_client = nbClient;
        this.b = b;
        this.a1=a1;
        this.a2=a2;
    }

    /** Même fonction que vendre_tickets dans Billetterie
    public void acheter_Ticket(int nb_billet) throws InterruptedException {
        billetterie.vendre_tickets(nb_billet, this);
    }
    */
    
    public void aller_attraction(){
        //Temps d'aller à l'attraction
    }
       
    public void run() {
        b.vendre_tickets(6, this);
        aller_attraction();
        a1.faire_attraction();
        aller_attraction();
        a2.faire_attraction();
    }
}
