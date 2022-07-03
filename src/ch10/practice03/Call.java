package ch10.practice03;

import java.time.Duration;
import java.time.LocalDateTime;

class Call {
    private LocalDateTime from;
    private LocalDateTime to;

    public Call(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }
    public Duration getDuration(){
        return Duration.between(from,to);
    }

    public LocalDateTime getFrom() {
        return from;
    }
}