package ch14.practice02;

import java.util.ArrayList;
import java.util.List;

class BasicRatePolicy implements RatePolicy{
    private List<FeeRule> feeRules = new ArrayList<>();

    // 다양한 요금부과조건+요금부과금액 정책이 존재할 수 있다.
    // 근데 왜 리스트로 받는거지.. 중복부과가 되는거 아닌가. ??
    public BasicRatePolicy(List<FeeRule> feeRules) {
        this.feeRules = feeRules;
    }
    //정책의 옵션이 많음.

    // Phone 은 여러개의 call 을 가지고 있다.
    // call 하나하나의 요금을 계산하여 total 부과요금을 반환한다.
    @Override
    public Money calculateFee(Phone phone) {
        return phone.getCalls()
                .stream()
                .map(this::calculate)
                .reduce(Money.ZERO, Money::plus);
    }

    private Money calculate(Call call){
        return feeRules
                .stream()
                .map(rule -> rule.calculateFee(call))
                .reduce(Money.ZERO, Money::plus);
    }
}
