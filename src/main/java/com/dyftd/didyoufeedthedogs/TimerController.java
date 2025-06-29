package com.dyftd.didyoufeedthedogs;

import com.dyftd.didyoufeedthedogs.TimerService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/timer")
@CrossOrigin(origins = "http://localhost:5173") // or your frontend URL
public class TimerController {

    private final TimerService timerService;

    public TimerController(TimerService timerService) {
        this.timerService = timerService;
    }

    @GetMapping
    public Map<String, Long> getTimer() {
        long secondsLeft = timerService.getSecondsRemaining();
        return Map.of("seconds", secondsLeft);
    }

    @PostMapping("/reset")
    public Map<String, String> resetTimer() {
        timerService.resetTimer();
        return Map.of("message", "Timer reset to 12 hours.");
    }
}
