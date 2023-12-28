package com.kodilla.patterns2.observer.homework;

public class Mentor implements TaskQueueObserver {
    private final String mentorName;
    private int updateCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(TaskQueueObservable observable) {
        if (observable instanceof TaskQueue taskQueue) {
            System.out.println(mentorName + ": New tasks in queue from student "
                    + taskQueue.getStudentName() + "\n"
                    + " (total: " + taskQueue.getTasks().size() + " tasks)");
            updateCount++;
        }
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getUpdateCount() {
        return updateCount;
    }

}