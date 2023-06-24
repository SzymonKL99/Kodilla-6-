package com.kodilla.stream;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.forumuser.Forum;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        Forum theForum = new Forum();
        Map<Integer, ForumUser> theResultMapOfUsers = theForum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> forumUser.getDateOfBirth().isAfter(LocalDate.now().minusYears(20L)) || forumUser.getDateOfBirth().isEqual(LocalDate.now().minusYears(20L)))
                .filter(forumUser -> forumUser.getNumberOfPosts() > 1)
                .collect(Collectors.toMap(ForumUser::getUserID, forumUser -> forumUser));

        System.out.println("# elements: " + theResultMapOfUsers.size());
        theResultMapOfUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

    }
}