public class Billetterie {
	private int nb_tickets_dispo;
	private ResponsableBilletterie responsableBilletterie;

	public Billetterie(int tickets_dispo){
        this.nb_tickets_dispo=tickets_dispo;
        responsableBilletterie = new ResponsableBilletterie( this);
    }

    //Ventes des tickets à la billetterie
    //@param int nombre de tickets que le client souhaite
    //@param Client qui définit le client qui soihaite acheter des tickets
	public synchronized void vendre_tickets(int nb_tickets, Client client)  {
		while (nb_tickets > nb_tickets_dispo) {
			try {
                //On réveille tout le monde
				notifyAll();
                //On rendort le client en attendant le passage du responsable
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
        //On vend les tickets au client, après rechargement
		nb_tickets_dispo -= nb_tickets;
	}

	//@return le responsableBilletterie de la billetterie
	public ResponsableBilletterie getResp(){
	    return responsableBilletterie;
	}

	//Recharge les billets de la billetterie
	public synchronized void recharger(int recharge_tickets) {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		nb_tickets_dispo += recharge_tickets;
		imprimer();
        //Reveil les clients après rechargement des tickets
		notifyAll();
	}

	//Temps d'attente correspondant à l'impression des tickets achetés
	public void imprimer() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}