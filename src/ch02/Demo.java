package ch02;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

class Demo {
    public static void main(String[] args) {
        Movie avatar = new Movie("아바타"
                , Duration.ofMinutes(120),
                new AmountDiscountPolicy(Money.wons(800),
                                new SequenceCondition(1),
                                new SequenceCondition(10),
                                new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10,0),LocalTime.of(11,59)),
                                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10,0),LocalTime.of(20,59))
                                ),
                Money.wons(10000));

        avatar.changeDiscountPolicy(
                new NoneDiscountPolicy()
        );

        Movie titanic = new Movie("타이타닉"
                , Duration.ofMinutes(180),
                new PercentDiscountPolicy(0.1,
                        new SequenceCondition(2),
                        new SequenceCondition(100),
                        new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14,0),LocalTime.of(16,59)),
                        new PeriodCondition(DayOfWeek.WEDNESDAY, LocalTime.of(10,0),LocalTime.of(13,59))
                ),
                Money.wons(12000));

        Movie starWars = new Movie("스타워즈",
                Duration.ofMinutes(130),
                new NoneDiscountPolicy(),
                Money.wons(11000));

        Movie topGun = new Movie("탑건",
                Duration.ofMinutes(105),
                new OverlappedDiscountPolicy(
                        new PercentDiscountPolicy(0.2,
                                new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14,0),LocalTime.of(16,59))),
                        new AmountDiscountPolicy(Money.wons(1000),
                                new SequenceCondition(1000))),
                Money.wons(10500));

        Money avatarFee = new Client(new Factory()).getAvatarFee();


    }
}
