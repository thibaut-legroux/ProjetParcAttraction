public class Parc {
	private final int minClient = 10;
	private final int maxAttraction = 10;
	private final int nbClients = 20;
	private int idClient = 0;
	private int idAttraction = 0;
	private Attraction[] attractions = new Attraction[maxAttraction];
	private Client[] clients = new Client[nbClients];
	Billetterie billeterie;

	public Parc() {
		while (nouvelleAttraction()) {}
		 billeterie = new Billetterie(20);
		while (nouveauClient()) {}
		// Creer le responsable et l'endormir avant que les clients prennent des tickets
		billeterie.getResp().start();
		
		for(Client cl : clients) {
			cl.start();
		}
	}

	private boolean nouvelleAttraction() {       
		if (maxAttraction == idAttraction) {
			System.out.println("Le nombre maximum de clients est atteint.");
			return false;
		}
		attractions[idAttraction] = new Attraction(idAttraction);
		idAttraction++;
		return true;
	}

	private boolean nouveauClient() {
		int attraction1 = (int) (Math.random() * ((getMaxAttraction() - 1) + 1));
		int attraction2 = (int) (Math.random() * ((getMaxAttraction() - 1) + 1));
		if (nbClients == idClient) {
			System.out.println("Le nombre maximum de clients est atteint.");
			return false;
		}
		clients[idClient] = new Client(idClient,billeterie ,attractions[attraction1], attractions[attraction2]);
		idClient++;
		return true;
	}
    
	public int getNbClient() {
		return nbClients;
	}

	public int getMaxAttraction() {
		return maxAttraction;
	}

	public static void main(String[] args) {
    	Parc parc = new Parc();
	}
}