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
        Cluster.Builder b = Cluster.builder().addContactPoints("192.168.0.3", "192.168.0.4", "192.168.0.2");
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
