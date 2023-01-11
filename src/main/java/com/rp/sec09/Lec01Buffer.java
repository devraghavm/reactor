package com.rp.sec09;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec01Buffer {
    public static void main(String[] args) {
        eventStream()
//                .buffer(5) // It waits until batch size is met unless complete is emitted
//.buffer(Duration.ofSeconds(2))
.bufferTimeout(5, Duration.ofSeconds(2))
.subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(800))
//                   .take(3)
                   .map(i -> "event" + i);
    }
}
