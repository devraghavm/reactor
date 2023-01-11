package com.rp.sec05;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec04HotPublishAutoConnect {
    public static void main(String[] args) {
        // share = publish().refCount(1)
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                                       .delayElements(Duration.ofSeconds(1))
                                       .publish()
                                       .autoConnect(0);

        Util.sleepSeconds(3);

        movieStream.subscribe(Util.subscriber("raghav"));

        Util.sleepSeconds(10);

        System.out.println("Vikram is about to join");

        movieStream.subscribe(Util.subscriber("vikram"));

        Util.sleepSeconds(60);
    }

    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming req");
        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7",
                "Scene 8",
                "Scene 9"
        );
    }
}
