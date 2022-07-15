package ch14;

import java.time.Duration;

class FixedFeePolicy extends BasicRatePolicy{
    private Money amount;
    private Duration seconds;
    public FixedFeePolicy(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }
    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}

