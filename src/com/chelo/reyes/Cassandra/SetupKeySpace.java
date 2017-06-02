package com.chelo.reyes.Cassandra;

import com.datastax.driver.core.KeyspaceMetadata;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.TableMetadata;

/**
 * Created by cheloreyes on 14/04/17.
 */
public class SetupKeySpace {
    private static final String TABLE_NAME = "tweets";
    private Session session;
    private boolean ready = false;

    public SetupKeySpace() {
        CassandraConnector client = new CassandraConnector();
        client.connect();
        this.session = client.getSession();

        //dropTable();
        //dropType();
        //dropKeyspace();

        this.ready = tableExist();
        //ready = false;
        if(!ready){
            createKeyspace();
            //createTypePlace();
            createTable();
        }
        //getAllTable();

    }

    public Session getSession(){
        return (ready)? this.session: null;
    }

    private void createKeyspace(){
        String query = "CREATE KEYSPACE IF NOT EXISTS MiningBogota WITH REPLICATION = { 'class' : 'NetworkTopologyStrategy', 'datacenter1' : 3};";
        session.execute(query);
    }

    private void dropKeyspace(){
        String query = "DROP KEYSPACE IF EXISTS MiningBogota;";
        session.execute(query);
    }

    private void createTable(){
        String query = "CREATE TABLE IF NOT EXISTS MiningBogota.tweets (tweet_id text, text text, create_at timestamp, user_id text, " +
                "source text, favorite_count int, latitude double, longitude double, place text, " +
                "retweet_count text, sensitive boolean, lang text, url set<text>, hashtags list<text>, " +
                "scope text, PRIMARY KEY (tweet_id, user_id));";
        session.execute(query);
    }

    private void dropTable(){
        String query = "DROP TABLE IF EXISTS MiningBogota.tweets;";
        session.execute(query);
    }

    private void getAllTable(){
        String query = "SELECT * FROM MiningBogota.tweets;";
        ResultSet rs = session.execute(query);
        rs.forEach(row -> {System.out.println(row.getString("text"));});
    }

    private void createTypePlace(){
        String query = "CREATE TYPE IF NOT EXISTS MiningBogota.place (name text, street_address text, country_code text, id text, " +
                "country text, place_type text,  url text, fullName text, latitude double, longitude double);";
        session.execute(query);
    }

    private void dropType(){
        String query = "DROP TYPE IF EXISTS MiningBogota.place;";
        session.execute(query);
    }

    private boolean tableExist(){
        boolean exist = false;
        KeyspaceMetadata ks = session.getCluster().getMetadata().getKeyspace("MiningBogota");
        if(ks != null){
            TableMetadata table = ks.getTable("tweets");
            if(table!=null) exist = true;
        }
        return exist;
    }

}
