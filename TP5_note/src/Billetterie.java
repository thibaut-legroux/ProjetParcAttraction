/**
 * Created by 18004011 on 04/12/18.
 */
public class Billetterie {

    private int nb_tickets_dispo;
    private int nb_tickets_recharge;
    private boolean occupe=false;

    public Billetterie(int tickets_dispo){
        this.nb_tickets_dispo=tickets_dispo;
        this.nb_tickets_recharge=20;
    }

    public void vendre_tickets(int nb_tickets, Client client) throws InterruptedException {

        if(occupe){
            occupe = true;
            if(nb_tickets_dispo<nb_tickets){
                client.wait();
                recharger(nb_tickets_recharge, client);
            }else{
                nb_tickets_dispo -= nb_tickets;
            }
            occupe = false;
        }else{
            vendre_tickets(nb_tickets, client);
        }
    }

    public void recharger(int recharge_tickets, Client client){
        ResponsableBilletterie responsableBilletterie = new ResponsableBilletterie(5);
        responsableBilletterie.recharger_tickets(recharge_tickets);
        client.notify();
    }

}
