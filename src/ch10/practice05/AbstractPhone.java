package ch10.practice05;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractPhone {
    private List<Call> calls = new ArrayList<>();

    public void call(Call call){
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;
        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }
        return result;
    }
    abstract protected Money calculateCallFee(Call call);
}
