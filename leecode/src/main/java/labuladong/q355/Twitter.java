package labuladong.q355;

import java.util.*;

public class Twitter {

    // 账户ID和账户详情
    private Map<Integer, User> userMap = new HashMap<>();
    private static int timestamp = 0;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        User curUser = userMap.get(userId);
        curUser.postTweet(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return res;
        }

        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a, b) -> b.time - a.time);

        for (int followeeId : users) {
            Tweet tweet = userMap.get(followeeId).head;
            if (tweet == null) {
                continue;
            }
            pq.add(tweet);
        }

        while (!pq.isEmpty()) {
            if (res.size() >= 10) {
                break;
            }

            Tweet tweet = pq.poll();
            res.add(tweet.id);
            if (tweet.next != null) {
                pq.add(tweet.next);
            }
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }

        userMap.get(followerId).follow(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            User followerUser = userMap.get(followerId);
            followerUser.unfollow(followeeId);
        }
    }

    class Tweet {
        private int id;
        private int time;
        private Tweet next;

        // 需要传入推文内容（id）和发文时间
        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }


    class User {
        int userId;
        Set<Integer> followed;
        Tweet head;

        public User(int userId) {
            this.userId = userId;
            followed = new HashSet<>();
            this.head = null;
            // 关注自己
            follow(userId);
        }

        public void follow(int userId) {
            followed.add(userId);
        }

        public void unfollow(int userId) {
            if (userId != this.userId) {
                followed.remove(userId);
            }
        }

        public void postTweet(int tweetId) {
            Tweet tweet = new Tweet(tweetId, timestamp);
            timestamp++;
            tweet.next = head;
            head = tweet;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        for (int i = 0; i < 10; i++) {
            System.out.println(System.currentTimeMillis());
        }
    }

}
