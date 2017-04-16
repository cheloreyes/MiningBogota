package com.chelo.reyes.Cassandra;

import com.chelo.reyes.Model.Tweet;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;

/**
 * Created by cheloreyes on 15/04/17.
 */
public class CassandraWorker {
    private Session session;

    public CassandraWorker() {
        SetupKeySpace setup = new SetupKeySpace();
        this.session = setup.getSession();
    }

    public void addTweet(Tweet tweet){
        WorkerRun run = new WorkerRun(session, tweet);
        new Thread(run).start();
    }
}
class WorkerRun implements Runnable{
    private Session session;
    private Tweet tweet;

    public WorkerRun(Session session, Tweet tweet) {
        this.session = session;
        this.tweet = tweet;
    }

    @Override
    public void run() {
        PreparedStatement prepared = session.prepare("insert into MiningBogota.tweets (tweet_id, text, create_at, " +
                "user_id, source, favorite_count, latitude, longitude, place, retweet_count, sensitive, lang, url, " +
                "hashtags, scope) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

        BoundStatement bound = prepared.bind(Long.toString(tweet.getId()), tweet.getText(), tweet.getCreateAt(), tweet.getUserId(),
                tweet.getSource(), tweet.getFavoriteCount(), tweet.getLatitude(), tweet.getLongitude(), tweet.getPlace().getName(),
                Long.toString(tweet.getRetweetCount()), tweet.isSensitive(), tweet.getLang(), tweet.getUrl(), tweet.getHashtags(), tweet.getScope());
        session.execute(bound);
    }
}
