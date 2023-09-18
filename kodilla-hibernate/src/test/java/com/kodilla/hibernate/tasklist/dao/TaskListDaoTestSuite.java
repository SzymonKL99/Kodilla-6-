package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    @Test
    void testFindByListName() {
        //Given
        TaskList taskList1 = new TaskList("ToDo", "Tasks to do");
        TaskList taskList2 = new TaskList("InProgress", "Tasks in progress");
        TaskList taskList3 = new TaskList("Done", "Completed tasks");

        taskListDao.save(taskList1);
        taskListDao.save(taskList2);
        taskListDao.save(taskList3);

        //When
        List<TaskList> foundLists = taskListDao.findByListName("ToDo");

        // Then
        assertEquals(1, foundLists.size());

        // CleanUp
        int id = foundLists.get(0).getId();
        taskListDao.deleteById(id);
    }
}
