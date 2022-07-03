package ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface DiscountPolicy{
    Money calculateDiscountAmount(Screening screening);
}

abstract class DefaultDiscountPolicy implements DiscountPolicy{
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(DiscountCondition ...conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening){
        for(DiscountCondition each : conditions){
            if(each.isSatisfiedBy(screening)){
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    public abstract Money getDiscountAmount(Screening screening);
}

class AmountDiscountPolicy extends DefaultDiscountPolicy {
    private Money discountAmount;
    public AmountDiscountPolicy(Money discountAmount, DiscountCondition ...conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }
    @Override
    public Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}

class PercentDiscountPolicy extends DefaultDiscountPolicy {
    private double percent;
    public PercentDiscountPolicy(double percent, DiscountCondition ...conditions) {
        super(conditions);
        this.percent = percent;
    }
    @Override
    public Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}

class NoneDiscountPolicy implements DiscountPolicy{
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}

class OverlappedDiscountPolicy extends DefaultDiscountPolicy{
    private List<DiscountPolicy> discountPolicies = new ArrayList<>();
    public OverlappedDiscountPolicy(DiscountPolicy ...discountPolicies) {
        this.discountPolicies.addAll(Arrays.asList(discountPolicies));
    }
    @Override
    public Money getDiscountAmount(Screening screening) {
        Money result = Money.ZERO;
        for(DiscountPolicy each : discountPolicies){
            result = result.plus(each.calculateDiscountAmount(screening));
        }
        return result;
    }
}