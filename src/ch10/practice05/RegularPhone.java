package ch10.practice05;

import java.time.Duration;

class RegularPhone extends Phone {
    private Money amount;
    private Duration seconds;


    public RegularPhone(Money amount, Duration seconds,double taxRate) {
        super(taxRate);
        this.amount = amount;
        this.seconds = seconds;
    }


    public Money getAmount(){
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    protected Money calculateCallFee(Call call){
        return amount.times(call.getDuration().getSeconds()/seconds.getSeconds());
    }
}
