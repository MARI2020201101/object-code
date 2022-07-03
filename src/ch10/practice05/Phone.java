package ch10.practice05;

import java.time.Duration;

class Phone extends AbstractPhone{
    private Money amount;
    private Duration seconds;


    public Phone(Money amount, Duration seconds) {
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
