package ch01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TicketOffice {
    private List<Ticket> tickets = new ArrayList<>();
    private Long amount;

    public TicketOffice(Long amount, Ticket ...tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    private Ticket getTicket(){
        return this.tickets.remove(0);
    }
    private void plusAmount(Long amount) {
        this.amount += amount;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void sellTicketTo(Audience audience){
        Long amount = audience.buy(getTicket());
        plusAmount(amount);
    }
}
