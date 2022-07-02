package ch01;

class Theater {
    private TickerSeller tickerSeller;

    public Theater(TickerSeller tickerSeller) {
        this.tickerSeller = tickerSeller;
    }

    public void enter(Audience audience){
        tickerSeller.sellTo(audience);
    }
}
