package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskQueueTest {
    @Test
    public void testTask() {
        TaskQueue student = new TaskQueue("Adam");
        TaskQueue student2 = new TaskQueue("Aga");
        TaskQueue student3 = new TaskQueue("Milena");

        Mentor mentor = new Mentor("John");
        Mentor mentor2 = new Mentor("Ola");

        student.registerObserver(mentor2);
        student2.registerObserver(mentor2);
        student3.registerObserver(mentor);

        student.addTask("Task 1 for Adam");
        student2.addTask("Task 1 for Aga");
        student.addTask("Task 2 for Adam");
        student2.addTask("Task 2 for Aga");
        student3.addTask("Task 1 for Milena");
        student3.addTask("Task 2 for Milena");

        assertEquals(4, mentor2.getUpdateCount());
        assertEquals(2, mentor.getUpdateCount());
    }
}
