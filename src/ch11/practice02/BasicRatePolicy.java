package ch11.practice02;

import java.time.Duration;

abstract class BasicRatePolicy implements RatePolicy{
    @Override
    public Money calculateFee(Phone phone) {
        Money result = Money.ZERO;
        for(Call call :  phone.getCalls()){
            result = result.plus(calculateCallFee(call));
        }
        return result;
    }

    protected abstract Money calculateCallFee(Call call);
}

class RegularPolicy extends BasicRatePolicy{
    private Money amount;
    private Duration seconds;
    public RegularPolicy(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override //통화량 만큼의 요금을 부과한다.
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
class NightlyDiscountPolicy extends BasicRatePolicy{

    private static final int LATE_NIGHT_HOUR = 22;
    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;

    public NightlyDiscountPolicy(Money nightlyAmount, Money regularAmount, Duration seconds) {
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