package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                System.out.println("emitting");
                String country = Util.faker().country().name();
                synchronousSink.next(country); // 1
//                synchronousSink.complete();
//                synchronousSink.error(new RuntimeException("oops"));
            })
//            .take(2)
            .subscribe(Util.subscriber());
    }
}
