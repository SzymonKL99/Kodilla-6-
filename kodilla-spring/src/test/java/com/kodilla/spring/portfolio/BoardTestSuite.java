package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {
    @Autowired
    private Board board;

    @Test
    void testAddTask() {
        // Given
        String taskToDo = "Task to do";
        String taskInProgress = "Task in progress";
        String taskDone = "Task done";

        // When
        board.getToDoList().addTask(taskToDo);
        board.getInProgressList().addTask(taskInProgress);
        board.getDoneList().addTask(taskDone);

        // Then
        assertEquals(taskToDo, board.getToDoList().getTasks().get(0));
        assertEquals(taskInProgress, board.getInProgressList().getTasks().get(0));
        assertEquals(taskDone, board.getDoneList().getTasks().get(0));

    }
}
