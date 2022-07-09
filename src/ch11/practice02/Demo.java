package ch11.practice02;

import java.time.Duration;

class Demo {
    public static void main(String[] args) {
        Phone phone = new Phone(new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)));
        Phone nightlyPhone = new Phone(new NightlyDiscountPolicy(Money.wons(5), Money.wons(10), Duration.ofSeconds(10)));


        Phone phoneWithTax = new Phone(
                new TaxablePolicy(0.05
                        , new RegularPolicy(Money.wons(10), Duration.ofSeconds(10))));
        Phone phoneWithDiscount = new Phone(
                new RateDiscountablePolicy(Money.wons(1000)
                , new NightlyDiscountPolicy(Money.wons(5), Money.wons(10), Duration.ofSeconds(10))));

        Phone phoneWithDiscountAndTax = new Phone(
                new TaxablePolicy(0.05
                    , new RateDiscountablePolicy(Money.wons(1000)
                        , new NightlyDiscountPolicy(Money.wons(5), Money.wons(10), Duration.ofSeconds(10))))
                );

        //자유로운 순서. 자유로운 조합.
    }
}
