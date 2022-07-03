package ch10.practice03;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

class Phone {
    private Money amount; //요금제 (10초에 5원 -> 5)
    private Duration seconds; //단위시간 (10초)
    private List<Call> calls = new ArrayList<>();


    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }



    public void call(Call call){
        calls.add(call);
    }
    public List<Call> getCalls(){
        return this.calls;
    }
    public Money getAmount(){
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }
    public Money calculateFee(){
        Money result = Money.ZERO;
        for(Call call : calls){
            result = result.plus(amount.times(call.getDuration().getSeconds()/seconds.getSeconds()));
        }
        return result;
    }
}
