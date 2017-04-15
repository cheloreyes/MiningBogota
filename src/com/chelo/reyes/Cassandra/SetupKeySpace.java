package com.chelo.reyes.Cassandra;

import com.datastax.driver.core.KeyspaceMetadata;
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
        this.ready = tableExist();
        if(!ready){
            createKeyspace();
            createTypeGeo();
            createTypePlace();
            createTable();
        }
    }

    public Session getSession(){
        return (ready)? this.session: null;
    }

    private void createKeyspace(){
        String query = "CREATE KEYSPACE IF NOT EXISTS MiningBogota WITH REPLICATION = { 'class' : 'NetworkTopologyStrategy', dc1 : 3};";
        session.execute(query);
    }

    private void createTable(){
        String query = "CREATE TABLE IF NOT EXISTS tweets (tweet_id text, text text, create_at timestamp, user_id text, " +
                "source text, favorite_count text, latitude double, longitude double, place Place, " +
                "retweet_count decimal, sensitive boolean, lang text, url set<text>, hastags list<text>, " +
                "scope text, PRIMARY KEY (tweet_id, insertion_time));";
        session.execute(query);
    }

    private void createTypePlace(){
        String query = "CREATE TYPE place (name text, street_address text, country_code text, id text, " +
                "country text, place_type text,  url text, fullName text, boundingBoxType text, " +
                "bounding_box_coordinates geo, geometryType text, geometry_coordinates geo, " +
                "contained_with_in list<place>);";
        session.execute(query);
    }
    private void createTypeGeo(){
        String query = "CREATE TYPE geo (latitude double, longitude double);";
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
