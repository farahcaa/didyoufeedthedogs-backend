package com.dyftd.didyoufeedthedogs;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class TimerService {

    private static final Duration TIMER_DURATION = Duration.ofHours(12);
    private Instant startTime;

    public TimerService() {
        this.startTime = Instant.now();
    }

    public long getSecondsRemaining() {
        Instant now = Instant.now();
        Duration elapsed = Duration.between(startTime, now);
        Duration remaining = TIMER_DURATION.minus(elapsed);

        return Math.max(remaining.getSeconds(), 0);
    }

    public void resetTimer() {
        this.startTime = Instant.now();
    }
}
