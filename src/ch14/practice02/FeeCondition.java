package ch14.practice02;

import java.util.List;

//변하는 부분 : FeeCondition 클래스구현체만 이해하면 요금제 정책들을 파악할 수 있게 된다.
interface FeeCondition {
    //요금제 조건. 시간/요일/구간별로 call 을 쪼개어 리스트로 반환한다.
    List<DateTimeInterval> findTimeIntervals(Call call);
}
