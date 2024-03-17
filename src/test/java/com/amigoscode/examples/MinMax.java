package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class MinMax {

    @Test
    public void min() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);

        Integer min1 = numbers.stream().min(Integer::compareTo).get(); // method 1

        Integer min2 = numbers.stream().min(Comparator.naturalOrder()).get(); // method 2

        Integer max1 = numbers.stream().max(Integer::compareTo).get(); // method 1

        Integer max2 = numbers.stream().max(Comparator.naturalOrder()).get(); // method 2

        System.out.printf("Min1: %s     Min2: %s\nMax1: %s   Max2: %s", min1,min2,max1,max2);
    }

    @Test
    public void max() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);
    }
}
