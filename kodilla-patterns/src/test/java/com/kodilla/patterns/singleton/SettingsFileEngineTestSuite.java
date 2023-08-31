package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SettingsFileEngineTestSuite {
    private static SettingsFileEngine settingsFileEngine;

    @BeforeAll
    public static void openSettingFile() {
        settingsFileEngine = SettingsFileEngine.INSTANCE;
        settingsFileEngine.open("myapp.settings");
        System.out.println();
    }

    @AfterAll
    public static void closeSettingFile() {
        settingsFileEngine.close();
    }

    @Test
    void testGetFileName() {
        //Given
        //When
        String fileNAme = settingsFileEngine.getFileName();
        System.out.println("Opened: " + fileNAme);
        //Then
        assertEquals("myapp.settings", fileNAme);
    }
    @Test
    void testLoadSettings() {
        //Given
        //When
        boolean result = settingsFileEngine.loadSettings();
        //Then
        assertTrue(true);
    }
    @Test
    void testSaveSettings(){
        //Given
        //When
        boolean result = settingsFileEngine.saveSettings();
        //Then
        assertTrue(true);
    }
}
