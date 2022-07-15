package ch14;

import java.time.DayOfWeek;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

class DayOfWeekDiscountRule {
    private List<DayOfWeek> dayOfWeeks = new ArrayList<>();
    private Duration duration = Duration.ZERO;
    private Money amount = Money.ZERO;

    public DayOfWeekDiscountRule(List<DayOfWeek> dayOfWeeks, Duration duration, Money amount) {
        this.dayOfWeeks = dayOfWeeks;
        this.duration = duration;
        this.amount = amount;
    }
    public Money calculate(DateTimeInterval interval){
        if(dayOfWeeks.contains(interval.getFrom().getDayOfWeek())){//해당요일의 설정(단위타임 duration ) 으로 나누어 가격을 구한다.
            return amount.times(interval.duration().getSeconds()/duration.getSeconds());
        }
        return Money.ZERO;
    }
}
