package ch14;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

class TimeOfDayDiscountPolicy extends BasicRatePolicy{
    private List<LocalTime> starts = new ArrayList<>(); //시작시간
    private List<LocalTime> ends = new ArrayList<>(); //종료시간
    private List<Duration> durations = new ArrayList<>(); //단위시간
    private List<Money> amounts = new ArrayList<>(); //부과금액

    @Override
    protected Money calculateCallFee(Call call) {
        Money result = Money.ZERO;
        for(DateTimeInterval interval : call.splitByDay()){
            for(int loop=0 ; loop< starts.size() ; loop++){
                result.plus(amounts.get(loop).times
                        (Duration.between
                                (from(interval, starts.get(loop)), to(interval, ends.get(loop)))
                                .getSeconds() / durations.get(loop).getSeconds()
                ));
            }
        }
        return null;
    }

    private LocalTime to(DateTimeInterval interval, LocalTime to) {
        return interval.getTo().toLocalTime().isAfter(to) ?
                to :
                interval.getTo().toLocalTime();
    }

    private LocalTime from(DateTimeInterval interval, LocalTime from) {
        return interval.getFrom().toLocalTime().isBefore(from) ?
                from :
                interval.getFrom().toLocalTime();
    }
}
