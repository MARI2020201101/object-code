package ch14.practice02;

class FeeRule { //조건 + 요금(원) 이 합쳐져서 하나의 정책이 된다.
    private FeeCondition feeCondition; //요금 조건 (프로세스 변하는 부분)
    private FeePerDuration feePerDuration;  //요금 계산 (프로세스 변하지 않는 부분)

    public FeeRule(FeeCondition feeCondition, FeePerDuration feePerDuration) {
        this.feeCondition = feeCondition;
        this.feePerDuration = feePerDuration;
    }

    //한번의 전화통화 요금을 계산한다.
    public Money calculateFee(Call call){
        return feeCondition.findTimeIntervals(call)
                .stream()
                .map(each -> feePerDuration.calculate(each))
                .reduce(Money.ZERO, Money::plus);
    }
}
