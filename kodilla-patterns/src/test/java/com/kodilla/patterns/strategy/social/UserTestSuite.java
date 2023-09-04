package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {
    @Test
    void testDefaultSharingStrategies() {
        //Given
        User user1 = new Millenials("Tomasz");
        User user2 = new YGeneration("Michal");
        User user3 = new ZGeneration("Adam");

        //When
        String tomaszService = user1.sharePost();
        System.out.println("Tomasz uses this service to share posts: "+ "<" + tomaszService + ">");
        String michalService = user2.sharePost();
        System.out.println("Michal uses this service to share posts: "+ "<" + michalService + ">");
        String adamService = user3.sharePost();
        System.out.println("Adam uses this service to share posts: "+ "<" + adamService + ">");

        //Then
        assertEquals("Facebook", tomaszService);
        assertEquals("Twitter", michalService);
        assertEquals("Snapchat", adamService);

    }
    @Test
    void testIndividualSharingStrategy() {
        //Given
        User user1 = new Millenials("Tomasz");

        //When
        String tomaszService = user1.sharePost();
        System.out.println("Tomasz uses this service to share posts: "+ "<" + tomaszService + ">");
        user1.setSocialPublisher(new TwitterPublisher());
        tomaszService = user1.sharePost();
        System.out.println("Tomasz uses now new service to share posts: "+ "<" + tomaszService + ">");

        //Then
        assertEquals("Twitter", tomaszService);
    }
}
