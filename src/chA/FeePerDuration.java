package chA;

import java.time.Duration;

class FeePerDuration { //단위시간당 요금부과정책
    //요금을 계산하는 책임을 맡는다.
    private Money fee; //ex) 10초당 19원.
    private Duration duration;

    public FeePerDuration(Money fee, Duration duration) {
        this.fee = fee;
        this.duration = duration;
    }
    public Money calculate(DateTimeInterval interval){
        //단위시간으로 나눈 뒤 단위요금을 곱한다. = 부과금액
        return fee.times(Math.ceil((double) interval.duration().toNanos() / duration.toNanos()));
    }
}
