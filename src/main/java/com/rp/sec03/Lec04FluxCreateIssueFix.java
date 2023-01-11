package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateIssueFix {
    public static void main(String[] args) {
        // only one instance if FluxSink
        Flux.create(fluxSink -> {
                String country;
                int counter = 0;
                do {
                    country = Util.faker().country().name();
                    System.out.println("Emitting : " + country);
                    fluxSink.next(country);
                    counter++;
                } while (!country.equalsIgnoreCase("canada") && !fluxSink.isCancelled() && counter <= 10);
                fluxSink.complete();
            })
            .take(3)
            .subscribe(Util.subscriber());
    }
}
