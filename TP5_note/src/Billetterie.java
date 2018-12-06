public class Billetterie {

	private int nb_tickets_dispo;
	private ResponsableBilletterie responsableBilletterie;
	private final int nb_tickets_recharge = 20;
    //private boolean occupe = false;

	public Billetterie(int tickets_dispo){
        this.nb_tickets_dispo=tickets_dispo;
        responsableBilletterie = new ResponsableBilletterie(this);
    }

	public void vendre_tickets(int nb_tickets, Client client) throws InterruptedException {
		while (nb_tickets > nb_tickets_dispo) {
			try {
                //On réveille tout le monde
				notifyAll();
                //On rendort le client en attendant le passage du responsable
				client.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
        //On vend les tickets au client, après rechargement
		nb_tickets_dispo -= nb_tickets;

/**     if(occupe){
            occupe = true;
            //Boolean toujours à false... Rentre pas dans la boucle
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
*/
	}

	public void recharger(int recharge_tickets) {
		b.wait();
		nb_tickets_dispo += recharge_tickets;
		imprimer();
        //Reveil les clients après rechargement des tickets
		notifyAll();
        // responsableBilletterie.recharger_tickets(recharge_tickets);
		// ResponsableBilletterie responsableBilletterie = new
		// ResponsableBilletterie(5);
	}

	public void imprimer() {
        //Temps d'attente d'impression des tickets
	}
}
