package ch14.practice02;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DateTimeInterval {
    private LocalDateTime from;
    private LocalDateTime to;

    private DateTimeInterval(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    public static DateTimeInterval of(LocalDateTime from, LocalDateTime to){
        return new DateTimeInterval(from,to);
    }

    public static DateTimeInterval toMidnight(LocalDateTime from){
        return new DateTimeInterval(
                from,
                LocalDateTime.of(from.toLocalDate(), LocalTime.of(23,59,59,999999999))
        );
    }
    public static DateTimeInterval fromMidnight(LocalDateTime to){
        return new DateTimeInterval(
                LocalDateTime.of(to.toLocalDate(), LocalTime.of(0,0))
                ,to);
    }
    public static DateTimeInterval during(LocalDate date){
        return new DateTimeInterval(
                LocalDateTime.of(date,LocalTime.of(0,0)),
                LocalDateTime.of(date,LocalTime.of(23,59,59,999999999))
        );
    }
    public Duration duration(){
        return Duration.between(from,to);
    }
    public LocalDateTime getFrom(){
        return from;
    }
    public LocalDateTime getTo(){
        return to;
    }

    public List<DateTimeInterval> splitByDay() {
        if(days() > 0){
            return splitByDay(days());
        }
        return Arrays.asList(this);
    }

    private List<DateTimeInterval> splitByDay(long days) {
        List<DateTimeInterval> result = new ArrayList<>();
        addFirstDay(result);
        addMiddleDays(result, days);
        addLastDay(result);
        return result;
    }

    private void addLastDay(List<DateTimeInterval> result) {
        result.add(DateTimeInterval.fromMidnight(to));
    }

    private void addMiddleDays(List<DateTimeInterval> result, long days) {
        for(int loop=1 ; loop < days; loop++){
            result.add(DateTimeInterval.during(from.toLocalDate().plusDays(loop)));
        }
    }

    private void addFirstDay(List<DateTimeInterval> result) {
        result.add(DateTimeInterval.toMidnight(from));
    }

    private long days() {
        return Duration.between(
                from.toLocalDate().atStartOfDay(), to.toLocalDate().atStartOfDay())
                .toDays();
    }

}