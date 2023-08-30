package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BoardConfig {
    @Qualifier("To do list")
    @Autowired //Dlaczego nie @Autowierd Board board?
    TaskList toDoList;

    @Qualifier("In progress list")
    @Autowired
    TaskList inProgressList;

    @Qualifier("Done list")
    @Autowired
    TaskList doneList;

    @Bean
    public Board getBoard() {
        return new Board(toDoList, inProgressList, doneList); //Dlaczego nie samo board
    }

    @Bean(name = "To do list")
    public TaskList getToDoList() {
        return new TaskList();
    }

    @Bean(name = "In progress list")
    public TaskList getInProgressList() {
        return new TaskList();
    }

    @Bean(name = "Done list")
    public TaskList getDoneList() {

        return new TaskList();
    }

}
