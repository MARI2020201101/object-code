package ch11;

import java.time.Duration;

class TaxableRegularPhone extends RegularPhone{
    //optional하게 적용될 수 있어야 한다. 상속을 이용할 경우 조합 폭발 문제가 발생한다.
    private double taxRate;
    public TaxableRegularPhone(Money amount, Duration seconds, double taxRate) {
        super(amount, seconds);
        this.taxRate = taxRate;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.times(taxRate));
    }
}

class TaxableNightlyDiscountPhone extends NightlyDiscountPhone{

    private double taxRate;
    public TaxableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
        super(nightlyAmount, regularAmount, seconds);
        this.taxRate = taxRate;
    }
    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.times(taxRate));
    }
}