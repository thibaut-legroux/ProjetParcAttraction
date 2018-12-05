/**
 * Created by 18004011 on 04/12/18.
 */
public class ResponsableBilletterie {

    private boolean occupe;
    private boolean idle = true;

    public ResponsableBilletterie(int tickets_dispo) {

    }

    public void recharger_tickets(int recharge_tickets) {
        int tickets_dispo = 20;
        tickets_dispo+=recharge_tickets;
    }
}
