package ch14.practice02;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class DurationFeeCondition implements FeeCondition{
    private Duration from;
    private Duration to;

    public DurationFeeCondition(Duration from, Duration to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        if(call.getInterval().duration().compareTo(from) < 0){
            //요금단위구간보다 통화시간이 짧음.
            return Collections.emptyList();
        }
        // 단위구간별로 쪼개어 LocalDateTime 리스트로 반환한다.
        return Arrays.asList(
                DateTimeInterval.of(
                        call.getInterval().getFrom().plus(from),
                        call.getInterval().duration().compareTo(to) > 0 ?
                                call.getInterval().getFrom().plus(to) :
                                call.getInterval().getTo()));
    }
}
