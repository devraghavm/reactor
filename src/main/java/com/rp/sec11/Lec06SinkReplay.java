package com.rp.sec11;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec06SinkReplay {
    public static void main(String[] args) {
        // handle through which we would push items
        Sinks.Many<Object> sink = Sinks.many().replay().all(); // Ignore any messages generated before subscription

        // handle through which subscribers will receive items
        Flux<Object> flux = sink.asFlux();
        flux.subscribe(Util.subscriber("sam")); // sam gets all the messages

        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are you"); // These values will be buffered and supplied to the first subscriber

        flux.subscribe(Util.subscriber("mike")); // mike only gets ?
        sink.tryEmitNext("?");
        flux.subscribe(Util.subscriber("jake")); // jake doesn't get any

        sink.tryEmitNext("hey"); // all subscribers get this message
    }
}
