package ch14.practice02;

import java.util.Arrays;
import java.util.List;

class FixedFeeCondition implements FeeCondition{
    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return Arrays.asList(call.getInterval());
    }
}
