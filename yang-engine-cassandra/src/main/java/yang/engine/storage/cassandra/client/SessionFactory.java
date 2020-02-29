package yang.engine.storage.cassandra.client;

import com.datastax.driver.core.Session;

public interface SessionFactory {

    Session newCassandraSession();
}
