package com.chelo.reyes;

import twitter4j.*;

/**
 * Created by cheloreyes on 5/04/17.
 */
public class StreamMining {
    private Twitter iTwitter;
    private TwitterStream iStream;

    private StatusListener streamListener = new StatusListener() {
        @Override
        public void onStatus(Status status) {
            System.out.println(status.getText());
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
        iTwitter = AutorizaSingleton.getInstance().getTwitter();
        iStream = AutorizaSingleton.getInstance().getTwitterStream();
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
