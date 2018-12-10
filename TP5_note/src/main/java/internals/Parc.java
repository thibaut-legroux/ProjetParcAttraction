package internals;

public class Parc {
	private final int minClient = 10;
	private final int maxAttraction = 10;
	private int nbClients = 20;
	private int idClient = 0;
	private int idAttraction = 0;
	private Attraction[] attractions = new Attraction[maxAttraction];
	private Client[] clients;
	Billetterie billeterie;

	public Parc() {
	    if(nbClients < minClient) {
            nbClients = minClient;
        }
        clients = new Client[nbClients];
		while (nouvelleAttraction()) {}
		billeterie = new Billetterie(20);
		while (nouveauClient()) {}
		// Crée le responsable et l'endort avant que les clients prennent des tickets
		billeterie.getResp().start();
		
		for(Client cl : clients) {
			cl.start();
		}
	}

	//Crée une nouvelle attraction si possible lorsque les précédents sont pleines
	private boolean nouvelleAttraction() {       
		if (maxAttraction == idAttraction) {
			System.out.println("Le nombre maximal d'attractions est atteint.");
			return false;
		}
		attractions[idAttraction] = new Attraction(idAttraction);
		idAttraction++;
		return true;
	}

    //Crée un nouveau client si possible lorsque les précédents sont sortis
    //@return false si le nombre maximum de client est atteint, true sinon
	private boolean nouveauClient() {
        //On définit les attractions qu'un client va faire aléatoirement
		int attraction1 = (int) (Math.random() * ((getMaxAttraction() - 1) + 1));
		int attraction2 = (int) (Math.random() * ((getMaxAttraction() - 1) + 1));
		if (nbClients == idClient) {
			System.out.println("Le nombre maximal de clients est atteint.");
			return false;
		}
		clients[idClient] = new Client(idClient, billeterie, attractions[attraction1], attractions[attraction2]);
		idClient++;
		return true;
	}

    //@return le nombre de clients
	public int getNbClient() {
		return nbClients;
	}

    //@return le nombre de d'attractions
	public int getMaxAttraction() {
		return maxAttraction;
	}

	//Création du parc d'attraction
	public static void main(String[] args) {
    	Parc parc = new Parc();
	}
}