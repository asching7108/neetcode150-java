class Twitter {

    private static int timeStamp=0;

    private Map<Integer, User> userMap;

    // Tweet class that connects to the next tweet
    private class Tweet {
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
            this.next = null;
        }
    }

    private class User {
        public int id;
        public Set<Integer> followed;
        public Tweet tweetHead;

        public User(int id) {
            this.id = id;
            this.followed = new HashSet<>();
            // First follow itself
            follow(id);
            tweetHead = null;
        }

        public void follow(int userId) {
            followed.add(userId);
        }

        public void unfollow(int userId) {
            followed.remove(userId);
        }

        public void post(int id) {
            Tweet t = new Tweet(id);
            t.next = tweetHead;
            tweetHead = t;
        }
    }

    public Twitter() {
        userMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        userMap.computeIfAbsent(userId, id -> new User(id)).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        if (!userMap.containsKey(userId)) return res;

        Set<Integer> users = userMap.get(userId).followed;
        Queue<Tweet> maxHeap = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));

        for (int user : users) {
            Tweet t = userMap.get(user).tweetHead;
            if (t != null) {
                maxHeap.add(t);
            }
        }

        int n = 0;
        while (!maxHeap.isEmpty() && n < 10) {
            Tweet t = maxHeap.poll();
            res.add(t.id);
            n++;
            if (t.next != null) {
                maxHeap.add(t.next);
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        userMap.computeIfAbsent(followerId, id -> new User(id)).follow(followeeId);
        userMap.putIfAbsent(followeeId, new User(followeeId));
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            userMap.computeIfAbsent(followerId, id -> new User(id)).unfollow(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */