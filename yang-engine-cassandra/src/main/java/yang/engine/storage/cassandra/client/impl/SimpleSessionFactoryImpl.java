package yang.engine.storage.cassandra.client.impl;

import com.datastax.driver.core.Session;
import yang.engine.storage.cassandra.client.SessionFactory;

public class SimpleSessionFactoryImpl implements SessionFactory {
    public Session newCassandraSession() {
        return null;
    }
}
