package ch11.practice02;

import java.time.Duration;

abstract class AdditionalRatePolicy implements RatePolicy{
    private RatePolicy next;

    public AdditionalRatePolicy(RatePolicy next) {
        this.next = next;
    }

    @Override
    public Money calculateFee(Phone phone) {
        Money fee = next.calculateFee(phone);
        return afterCalculated(fee);
    }

    protected abstract Money afterCalculated(Money fee);
}
class TaxablePolicy extends AdditionalRatePolicy{
    private double taxRatio;
    public TaxablePolicy(double taxRatio, RatePolicy next) {
        super(next);
        this.taxRatio =taxRatio;
    }
    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.times(taxRatio));
    }
}

class RateDiscountablePolicy extends AdditionalRatePolicy{
    private Money discountAmount;
    public RateDiscountablePolicy(Money discountAmount, RatePolicy next) {
        super(next);
        this.discountAmount = discountAmount;
    }
    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}