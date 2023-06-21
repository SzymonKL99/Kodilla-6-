package com.kodilla.stream.immutable;

public final class ForumUser {
    private final String userName;
    private  final String realName;

    public ForumUser(final String userName, final String realName) {
        this.userName = userName;
        this.realName = realName;
    }
    private String getUserName() {
        return userName;
    }
    private String getRealName() {
        return realName;
    }
}
