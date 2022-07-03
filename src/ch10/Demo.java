package ch10;

import java.time.Duration;
import java.time.LocalDateTime;

class Demo {
    public static void main(String[] args) {
        Phone phone = new Phone(Money.wons(5), Duration.ofSeconds(10));
        phone.call(new Call(LocalDateTime.of(2022,7,1,12,10,0),
                            LocalDateTime.of(2022,7,1,12,11,0)));
        phone.call(new Call(LocalDateTime.of(2022,7,2,16,33,10),
                            LocalDateTime.of(2022,7,2,16,34,10)));
        Money fee = phone.calculateFee();
        System.out.println(fee);
    }
}
