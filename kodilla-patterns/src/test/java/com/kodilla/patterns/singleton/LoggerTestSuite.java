package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {
    private static Logger logger;

    @BeforeAll
    public static void log() {
        logger = Logger.INSTANCE;
        logger.log("Operation1");
        logger.log("Operation2");
        logger.log("Operation3");
        logger.log("Operation4");
        System.out.println();
    }
    @Test
    void testGetLastLog() {
        //Given
        //When
        String lastLog = logger.getLastLog();
        System.out.println("Last log: " + lastLog);

        //Then
        assertEquals("Operation4", lastLog);

    }
}
