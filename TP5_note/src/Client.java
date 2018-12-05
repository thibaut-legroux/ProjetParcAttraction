/**
 * Created by 18004011 on 04/12/18.
 */
public class Client {

    private int nb_client;
    private Billetterie billetterie;

    public Client(int nb_client){
        this.nb_client = nb_client;
    }

    public void acheter_Ticket(int nb_billet) throws InterruptedException {
        billetterie.vendre_tickets(nb_billet, this);
    }

    public void aller_attraction(int nb_attraction){

    }

    public void faire_attraction(int nb_attraction){

    }
}
