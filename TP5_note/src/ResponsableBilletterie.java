public class ResponsableBilletterie extends Thread {

    private Billetterie b;
    private final int ticketsRech = 20;

    public ResponsableBilletterie(Billetterie b) {
        this.b = b;
    }
    
    public void run() {
        //Boucle infinie
        while(true) {
            b.recharger(ticketsRech);
        }
    }

   /** public void recharger_tickets(int recharge_tickets) {
        int tickets_dispo = 20;
        tickets_dispo+=recharge_tickets;
    }
    */
}