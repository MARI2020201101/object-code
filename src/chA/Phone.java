package chA;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Phone {
    private RatePolicy ratePolicy;
    private List<Call> calls = new ArrayList<>();

    public Phone(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
    }
    public List<Call> getCalls() {
        return Collections.unmodifiableList(calls);
    }
    public Money calculateFee(){
        return ratePolicy.calculateFee(this);
    }
    public void call(Call call){
        calls.add(call);
    }

    public Bill publishBill(){
        return new Bill(this, calculateFee());
    }
}
