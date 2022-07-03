package ch02;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

class Factory {

    public Movie createAvatarMovie(){
        Movie avatar = new Movie("아바타"
                , Duration.ofMinutes(120),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10,0),LocalTime.of(11,59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10,0),LocalTime.of(20,59))
                ),
                Money.wons(10000));
        return avatar;
    }
}
