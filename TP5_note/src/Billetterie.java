public class Billetterie {
	private int nb_tickets_dispo;
	private ResponsableBilletterie responsableBilletterie;
	private final int nb_tickets_recharge = 20;

	public Billetterie(int tickets_dispo){
        this.nb_tickets_dispo=tickets_dispo;
        responsableBilletterie = new ResponsableBilletterie( this);
    }

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

	public ResponsableBilletterie getResp(){
	    return responsableBilletterie;
	}

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

	public void imprimer() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}