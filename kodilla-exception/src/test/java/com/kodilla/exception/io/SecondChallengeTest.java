package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SecondChallengeTest {
    private final SecondChallenge secondChallenge = new SecondChallenge();

    @Test
    void testProbablyIWillThrowException() {
        // Case: x >= 2
        Assertions.assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.0, 1.0));

        // Case: x < 1
        Assertions.assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.5, 1.0));

        // Case: y == 1.5
        Assertions.assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.0, 1.5));

        // Case: valid input
        Assertions.assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.0, 1.0));
    }
}

