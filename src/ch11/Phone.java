package ch11;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

abstract class Phone {
    private List<Call> calls = new ArrayList<>();

    public Money calculateFee(){
        Money result = Money.ZERO;
        for(Call call :  calls){
            result = result.plus(calculateCallFee(call));
        }
        return result;
    }

    protected abstract Money calculateCallFee(Call call);
    protected Money afterCalculated(Money fee){
        return fee;
    }
}

class RegularPhone extends Phone{

    private Money amount;
    private Duration seconds;

    public RegularPhone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override //통화량 만큼의 요금을 부과한다.
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }

}
class NightlyDiscountPhone extends Phone{

    private static final int LATE_NIGHT_HOUR = 22;
    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {

        if(call.getFrom().getHour() >=LATE_NIGHT_HOUR){
            return nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        }
        return regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}