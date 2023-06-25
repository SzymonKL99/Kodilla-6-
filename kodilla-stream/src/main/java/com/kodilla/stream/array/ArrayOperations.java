package com.kodilla.stream.array;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {
     static double getAverage(int[] numbers) {
         System.out.println("Numbers: ");
         IntStream.range(0, numbers.length)
            .forEach(i -> System.out.println(numbers[i]));

         OptionalDouble average = Arrays.stream(numbers).asDoubleStream()
                 .average();

         return average.orElse(0.0);

    }
}
