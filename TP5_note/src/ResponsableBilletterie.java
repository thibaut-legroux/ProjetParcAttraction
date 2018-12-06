public class ResponsableBilletterie extends Thread {

    private Billeterie b;
    private final int ticketsRech = 20;

    public ResponsableBilletterie(Billeterie b) {
        this.b = b;
    }
    
    public void run() {
        //Boucle infinie
        while(true) {
            try {
                b.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            b.recharger(ticketsRech);
        }
    }

   /** public void recharger_tickets(int recharge_tickets) {
        int tickets_dispo = 20;
        tickets_dispo+=recharge_tickets;
    }
    */
}
