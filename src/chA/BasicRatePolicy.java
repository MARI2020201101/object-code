package chA;


import java.util.ArrayList;
import java.util.List;

class BasicRatePolicy implements RatePolicy {
    private List<FeeRule> feeRules = new ArrayList<>();
    public BasicRatePolicy(List<FeeRule> feeRules) {
        this.feeRules = feeRules;
    }
    @Override
    public Money calculateFee(Phone phone) {
        assert phone != null;

        Money result = Money.ZERO;

        result.plus(phone.getCalls()
                .stream()
                .map(this::calculate)
                .reduce(Money.ZERO, Money::plus));

        assert result.isGreaterThanOrEqual(Money.ZERO);
        return result;
    }

    private Money calculate(Call call){
        return feeRules
                .stream()
                .map(rule -> rule.calculateFee(call))
                .reduce(Money.ZERO, Money::plus);
    }
}
