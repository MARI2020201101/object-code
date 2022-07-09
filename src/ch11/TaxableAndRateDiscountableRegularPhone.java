package ch11;

import java.time.Duration;

class TaxableAndRateDiscountableRegularPhone extends TaxableRegularPhone{
    private Money discountAmount;

    public TaxableAndRateDiscountableRegularPhone(Money amount, Duration seconds, double taxRate, Money discountAmount) {
        super(amount, seconds, taxRate);
        this.discountAmount = discountAmount;
    }
    @Override
    protected Money afterCalculated(Money fee) {
        return super.afterCalculated(fee).minus(discountAmount);
    }
}
class RateDiscountableAndTaxableRegularPhone extends RateDiscountableRegularPhone{
    private double taxRate;

    public RateDiscountableAndTaxableRegularPhone(Money amount, Duration seconds, Money discountAmount, double taxRate) {
        super(amount, seconds, discountAmount);
        this.taxRate =taxRate;
    }
    @Override
    protected Money afterCalculated(Money fee) {
        return super.afterCalculated(fee).plus(fee.times(taxRate));
    }
}
