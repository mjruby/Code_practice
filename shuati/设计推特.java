package leetcode;

import java.util.*;

// 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）
// 的最近十条推文。你的设计需要支持以下的几个功能：
//
//postTweet(userId, tweetId): 创建一条新的推文
//getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。
// 推文必须按照时间顺序由最近的开始排序。
//follow(followerId, followeeId): 关注一个用户
//unfollow(followerId, followeeId): 取消关注一个用户
//

// ["Twitter","postTweet","getNewsFeed","follow","getNewsFeed","unfollow","getNewsFeed"]
//[[],[1,1],[1],[2,1],[2],[2,1],[2]]

// ["Twitter","postTweet","follow","getNewsFeed"]
//[[],[1,5],[1,1],[1]]
public class 设计推特 {
    public static void main(String[] args) {
        Twitter tw = new Twitter();
        tw.postTweet(1,1);
        List<Integer> newsFeed = tw.getNewsFeed(1);
        System.out.println(newsFeed);
        tw.follow(2,1);
        List<Integer> newsFeed1 = tw.getNewsFeed(2);
        System.out.println(newsFeed1);
        tw.unfollow(2,1);
        List<Integer> newsFeed2 = tw.getNewsFeed(2);
        System.out.println(newsFeed2);

//        Twitter twitter = new Twitter();
//        twitter.postTweet(1, 5);
//        List<Integer> ls = twitter.getNewsFeed(1);
//        System.out.println(ls);
//        twitter.follow(1, 2);
//        twitter.postTweet(2, 6);
//        twitter.getNewsFeed(1);
//        List<Integer> newsFeed = twitter.getNewsFeed(1);
//        System.out.println(newsFeed);
//        twitter.unfollow(1, 2);
//        twitter.getNewsFeed(1);
//        List<Integer> news = twitter.getNewsFeed(1);
//        System.out.println(news);
    }
}


class Twitter {
    int timeStamp;

    HashMap<Integer ,User> map = new HashMap<>();
    public Twitter() {
        timeStamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if(!map.containsKey(userId)){
            User user = new User(userId);
            map.put(userId,user);
        }
        User user = map.get(userId);
        user.postTweet(tweetId,timeStamp);
        timeStamp++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> rs = new ArrayList<>();
        if(!map.containsKey(userId)) return rs;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o2.time_Stamp - o1.time_Stamp;
            }
        });
        if(map.get(userId).head!=null){  // 如果为空，不能加入
            pq.add(map.get(userId).head);
        }
        HashSet<Integer> followed = map.get(userId).followed; // 关注的所有人id
        // 把k个链表的头都放进pq
        for (Integer id : followed) {
            User new_user = map.get(id);
            if(new_user.head!=null){
                pq.add(new_user.head);
            }
        }
        while(!pq.isEmpty()){
            if(rs.size() == 10) break;
            Tweet twt = pq.poll();
            rs.add(twt.tweetId);
            if(twt.next != null){
                pq.add(twt.next);
            }
        }
        return rs;
    }

     public void follow(int followerId, int followeeId) {
         if(!map.containsKey(followerId)){
             User user = new User(followerId);
             map.put(followerId,user);
         }
         if(!map.containsKey(followeeId)){
             User user = new User(followeeId);
             map.put(followeeId,user);
         }
         map.get(followerId).follow(map.get(followeeId).userId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(map.containsKey(followerId)){
            User user = map.get(followerId);
            user.unfollow(followeeId);
        }
    }


class User{
    int userId;
    HashSet<Integer> followed;
    Tweet head;

    public User(int id){
        this.userId = id;
        followed = new HashSet<>();
        head = null;
    }

    // 关注id
    public void follow(int id){
        if(this.userId == id) return;  // 自己不能关注自己，否则会在打印动态时，把自己的动态打印两遍
        this.followed.add(id);
    }
    // 取关
    public void unfollow(int id){
        if(id != this.userId){
            this.followed.remove(id);
        }
    }
    // 发一条动态
    public void postTweet(int twtId,int time){
        Tweet newTweet = new Tweet(twtId,time);
        newTweet.next = head;
        head = newTweet;
    }
}

}

class Tweet{
    int tweetId;
    int time_Stamp;
    Tweet next;
    public Tweet(int id, int time){
        this.tweetId = id;
        this.time_Stamp = time;
        this.next = null;
    }
}