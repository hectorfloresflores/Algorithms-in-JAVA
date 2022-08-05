package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DesignTwitter {

    class User {
        int userId;
        List<Integer> feedFromEachUser;
        List<Integer> follow;
        public User(int userId) {
            this.userId = userId;
            this.follow = new LinkedList<>();
            this.feedFromEachUser = new LinkedList<>();
        }
    }

        //Each key will have user Id and the user
        final HashMap<Integer, User> users;
        final Stack<Integer> stack;

        public DesignTwitter() {
            this.users = new HashMap<>();
            this.stack = new Stack<>();
        }

        public void postTweet(int userId, int tweetId) {
            //If user already exists just add on his feed the new tweet
            createUser(userId);
            users.get(userId).feedFromEachUser.add(tweetId);
            stack.push(tweetId);
            System.out.println("");
        }

        public List<Integer> getNewsFeed(int userId) {
            createUser(userId);
            List<Integer> myFeed = new ArrayList<>(this.users.get(userId).feedFromEachUser);
            List<Integer> followersFeed = this.users.get(userId).follow.stream().map(user ->
                    this.users.get(user).feedFromEachUser).collect(Collectors.toList()).stream().flatMap(List::stream).collect(Collectors.toList());
            //return the user queuw and convert it to list.
            List<Integer> allFeed = Stream.of(myFeed, followersFeed).flatMap(List::stream).collect(Collectors.toList());
            int max = 1;
            List<Integer> finalFeed = new LinkedList<>();
            Stack<Integer> stackCopy = new Stack<>();
            stackCopy.addAll(stack);
            while (!stackCopy.isEmpty() && max < 11) {
                Integer newestFeed = stackCopy.pop();
                if (allFeed.contains(newestFeed)) {
                    finalFeed.add(newestFeed);
                    max++;
                }
            }
            return finalFeed;
        }

        public void follow(int followerId, int followeeId) {
            createUser(followeeId);
            createUser(followerId);
            this.users.get(followerId).follow.add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            createUser(followeeId);
            createUser(followerId);
            if (this.users.get(followerId).follow.contains(followeeId)) {
                this.users.get(followerId).follow.remove(Integer.valueOf(followeeId));
            }
        }

        void createUser(int userId) {
            //If user already exists just add on his feed the new tweet
            if (!users.containsKey(userId)) {
                //Create user if does not exist yet
                users.put(userId, new User(userId));
            }
        }


    public static void main(String[] args) {
        DesignTwitter t = new DesignTwitter();
        t.postTweet(1, 5);
        System.out.println(t.getNewsFeed(1));
        t.follow(1,2);
        t.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        t.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        t.unfollow(1, 2);  // User 1 unfollows user 2.
        t.getNewsFeed(1);
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
}
