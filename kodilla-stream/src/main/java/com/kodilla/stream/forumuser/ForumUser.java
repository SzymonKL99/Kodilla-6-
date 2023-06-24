package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int userID;
    private final String userName;
    private final char sex;
    LocalDate dateOfBirth;
    private final int numberOfPosts;

    public ForumUser(int userID, String userName, int yearOfBirth, int monthOfBirth, int dayOfBirth, char sex, int numberOfPosts) {
        this.userID = userID;
        this.userName = userName;
        this.dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        this.sex = sex;
        this.numberOfPosts = numberOfPosts;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }


    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", numberOfPosts=" + numberOfPosts +
                '}';
    }
}
