package ch01;

class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;


    public Bag(Long amount){
        this(null, amount);
    }

    public Bag(Invitation invitation,Long amount) {
        this.amount = amount;
        this.invitation = invitation;
    }

    private boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public Long hold(Ticket ticket){
        if(hasInvitation()){
            setTicket(ticket);
            return 0L;
        }else{
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }
}
