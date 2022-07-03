package ch06;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class Demo {
    public static void main(String[] args) {
        Event meeting = new Event("회의",
                LocalDateTime.of(2022, 07, 12, 10, 30, 00),
                Duration.of(90, ChronoUnit.MINUTES));

        RecurringSchedule schedule = new RecurringSchedule("회의",
                DayOfWeek.MONDAY,
                LocalTime.of(10, 30),
                Duration.of(100, ChronoUnit.MINUTES));

        System.out.println(meeting.isSatisfied(schedule));
        System.out.println(meeting.isSatisfied(schedule));
    }

}
