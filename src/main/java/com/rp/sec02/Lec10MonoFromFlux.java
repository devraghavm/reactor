package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec10MonoFromFlux {
    public static void main(String[] args) {
        Flux.range(1, 10)
//            .filter(i -> i > 3)
            .next() // next() converts flux to mono
            .filter(i -> i > 3)
            .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
