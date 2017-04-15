package com.chelo.reyes.Mining;

import com.chelo.reyes.Utilities;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by cheloreyes on 4/04/17.
 */
public class AutorizaTwitter {

    private static String CONSUMER_KEY = "consumerKey";
    private static String CONSUMER_SECRET = "ConsumerSecret";
    private static String ACCESS_TOKEN = "AccessToken";
    private static String ACCESS_SECRET = "AccessSecret";
    private static String PROPERTIES = "config.properties";

    private static AutorizaTwitter instance = null;

    public static AutorizaTwitter getInstance() {
        if (instance == null) {
            instance = new AutorizaTwitter();
        }
        return instance;
    }

    private Twitter twitter;
    private TwitterStream twitterStream;

    protected AutorizaTwitter() {
        autorizeAccess();
    }

    public void autorizeAccess() {
        /*
        InputStream input = this.getClass().getClassLoader().getResourceAsStream(PROPERTIES);
        Properties prop = new Properties();
        prop.load(input);
        input.close();
        */
        Properties prop = Utilities.getProperties(this.getClass());
        if(prop != null){
            ConfigurationBuilder builder = new ConfigurationBuilder();
            builder.setDebugEnabled(true);
            builder.setOAuthConsumerKey(prop.getProperty(CONSUMER_KEY));
            builder.setOAuthConsumerSecret(prop.getProperty(CONSUMER_SECRET));
            builder.setOAuthAccessToken(prop.getProperty(ACCESS_TOKEN));
            builder.setOAuthAccessTokenSecret(prop.getProperty(ACCESS_SECRET));
            Configuration configuration = builder.build();
            TwitterFactory tf = new TwitterFactory(configuration);
            twitter = tf.getInstance();
            twitterStream = new TwitterStreamFactory(configuration).getInstance();
        }
    }

    public Twitter getTwitter() {
        return twitter;
    }

    public TwitterStream getTwitterStream() {
        return twitterStream;
    }
}
