package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class TaskQueue implements TaskQueueObservable {
    private final List<TaskQueueObserver> observers;
    private final List<String> tasks;
    private final String studentName;

    public TaskQueue(String studentName) {
        this.studentName = studentName;
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(TaskQueueObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (TaskQueueObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(TaskQueueObserver observer) {
        observers.remove(observer);
    }

    public String getStudentName() {
        return studentName;
    }

    public List<String> getTasks() {
        return tasks;
    }
}
