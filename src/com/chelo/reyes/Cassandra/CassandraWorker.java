package com.chelo.reyes.Cassandra;

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

    public void addTweet(){
        PreparedStatement prepared = session.prepare("insert into product (sku, description) values (?, ?)");

        BoundStatement bound = prepared.bind("234827", "Mouse");
        session.execute(bound);
    }
}
