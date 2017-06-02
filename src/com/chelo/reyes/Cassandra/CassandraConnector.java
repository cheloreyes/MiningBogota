package com.chelo.reyes.Cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

/**
 * Created by cheloreyes on 14/04/17.
 */
public class CassandraConnector {
    private Cluster cluster;

    private Session session;

    public void connect() {
        Cluster.Builder b = Cluster.builder().addContactPoints("192.168.0.116", "192.168.0.117", "192.168.0.118", "192.168.0.119");
        b.withPort(9042);
        cluster = b.build();
        session = cluster.connect();
    }

    public Session getSession() {
        return this.session;
    }

    public void close() {
        session.close();
        cluster.close();
    }
}
