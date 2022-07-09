package ch11;

import java.time.Duration;

class RateDiscountableRegularPhone extends RegularPhone{

    private Money discountAmount;
    public RateDiscountableRegularPhone(Money amount, Duration seconds, Money discountAmount) {
        super(amount, seconds);
        this.discountAmount = discountAmount;
    }
    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
class RateDiscountableNightlyDiscountPhone extends NightlyDiscountPhone{
    private Money discountAmount;

    public RateDiscountableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, Money discountAmount) {
        super(nightlyAmount, regularAmount, seconds);
        this.discountAmount = discountAmount;

    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}