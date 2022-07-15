package ch14.practice02;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

class TimeOfDayFeeCondition implements FeeCondition{
    private LocalTime from;
    private LocalTime to;

    public TimeOfDayFeeCondition(LocalTime from, LocalTime to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return call
                .getInterval()
                .splitByDay() // 하루 단위로 쪼개고
                .stream()
                .filter(each -> from(each).isBefore(to(each)))  //내 시간대에 속하는 부분만 걸러내어서
                .map(each -> DateTimeInterval.of(
                        LocalDateTime.of(each.getFrom().toLocalDate(), from(each)),
                        LocalDateTime.of(each.getTo().toLocalDate(), to(each))
                )).collect(Collectors.toList());
    }

    private LocalTime from(DateTimeInterval interval){
        return interval.getFrom().toLocalTime().isBefore(from) ?
                from : interval.getFrom().toLocalTime();
    }
    private LocalTime to(DateTimeInterval interval){
        return interval.getTo().toLocalTime().isAfter(to) ?
        to: interval.getTo().toLocalTime();
    }
}
