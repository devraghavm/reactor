package com.rp.sec08;

import com.rp.courseutil.Util;
import com.rp.sec08.helper.American;
import com.rp.sec08.helper.Emirates;
import com.rp.sec08.helper.Qatar;
import reactor.core.publisher.Flux;

public class Lec03Merge {
    public static void main(String[] args) {
        Flux<String> merge = Flux.merge(
                Qatar.getFlights(),
                Emirates.getFlights(),
                American.getFlights()
        );

        merge.subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }
}
