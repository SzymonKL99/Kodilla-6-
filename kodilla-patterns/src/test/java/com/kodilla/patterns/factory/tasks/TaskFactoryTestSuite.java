package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {
    @Test
    void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.taskCreate(TaskFactory.SHOPPINGTASK);
        //Then
        assertNotNull(shoppingTask);
        assertEquals("Buy phones and smartwatches", shoppingTask.getTaskName());
        assertFalse(shoppingTask.isTaskExecute());

        shoppingTask.executeTask();
        assertTrue(shoppingTask.isTaskExecute());
    }
    @Test
    void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task paintingTask =factory.taskCreate(TaskFactory.PAINTINGTASK);
        //Then
        assertNotNull(paintingTask);
        assertEquals("Paint the room", paintingTask.getTaskName());
        assertFalse(paintingTask.isTaskExecute());

        paintingTask.executeTask();
        assertTrue(paintingTask.isTaskExecute());
    }
    @Test
    void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task drivingTask = factory.taskCreate(TaskFactory.DRIVINGTASK);
        //Then
        assertNotNull(drivingTask);
        assertEquals("Deliver the food", drivingTask.getTaskName());
        assertFalse(drivingTask.isTaskExecute());

        drivingTask.executeTask();
        assertTrue(drivingTask.isTaskExecute());
    }
}
