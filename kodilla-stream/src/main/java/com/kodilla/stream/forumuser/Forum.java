package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public  final class Forum {
    private final List<ForumUser> listOfUsers = new ArrayList<>();

    public Forum() {
        listOfUsers.add(new ForumUser(1223, "Agata", 1999, 1, 23, 'F', 33));
        listOfUsers.add(new ForumUser(1241, "John", 1989, 10, 26, 'M', 12));
        listOfUsers.add(new ForumUser(2123, "Arthur", 2001, 2, 12, 'M', 37));
        listOfUsers.add(new ForumUser(3321, "Ola", 2004, 2, 12, 'F', 0));
        listOfUsers.add(new ForumUser(4221, "Samanta", 2010, 5, 19, 'F', 14));
        listOfUsers.add(new ForumUser(3311, "Katarzyna", 1993, 12, 12, 'F', 124));

    }
    public List<ForumUser> getUserList() {
        return new ArrayList<>(listOfUsers);
    }
}



