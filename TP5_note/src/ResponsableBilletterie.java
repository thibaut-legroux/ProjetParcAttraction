public class ResponsableBilletterie extends Thread {
    private Billetterie b;
    private final int ticketsRech = 20;

    public ResponsableBilletterie(Billetterie b) {
        this.setDaemon(true);
        this.b = b;
    }
    
    public void run() {
        //Boucle infinie
        while (true) {
            b.recharger(ticketsRech);
        }
    }
}