package com.chelo.reyes.Mining;

import com.chelo.reyes.Cassandra.CassandraWorker;
import com.chelo.reyes.Model.Tweet;
import twitter4j.*;

/**
 * Created by cheloreyes on 5/04/17.
 */
public class StreamMining {
    private Twitter iTwitter;
    private TwitterStream iStream;
    private CassandraWorker worker;

    private StatusListener streamListener = new StatusListener() {
        @Override
        public void onStatus(Status status) {
            Tweet tweet = new Tweet(status);
            worker.addTweet(tweet);
        }

        @Override
        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

        }

        @Override
        public void onTrackLimitationNotice(int i) {

        }

        @Override
        public void onScrubGeo(long l, long l1) {

        }

        @Override
        public void onStallWarning(StallWarning stallWarning) {

        }

        @Override
        public void onException(Exception e) {

        }
    };

    public StreamMining() {
        iTwitter = AutorizaTwitter.getInstance().getTwitter();
        iStream = AutorizaTwitter.getInstance().getTwitterStream();
        this.worker = new CassandraWorker();
        configStreamReading();
    }

    private void configStreamReading(){
        FilterQuery tweetFilter = new FilterQuery();
        double[] geoPointA = new double[]{-74.209912, 4.456174};
        double[] geoPointB = new double[]{-73.992465, 4.835781};
        tweetFilter.track(new String[]{"Bogota","Bogotá", "bogota", "bogotá"});
        tweetFilter.locations(geoPointA, geoPointB);
        tweetFilter.language(new String[]{"es"});
        if(iStream!= null){
            iStream.addListener(streamListener);
            iStream.filter(tweetFilter);
        }
    }
}