package colordecoder;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CreateKeySpace {
	public static Session getSession() {
		Session cassandraSession = null;
		if (cassandraSession == null) {
			cassandraSession = createSession();
		}
		return cassandraSession;
	}
	protected static Session createSession() {
		Cluster cluster = Cluster.builder().addContactPoint("localhost:2701").build();//Error is thrown here
		return cluster.connect();
	}
	
	public static void main(String args[]){
		String query = "CREATE KEYSPACE tp WITH replication "
				+ "= {'class':'SimpleStrategy', 'replication_factor':1};";
		Session cassandraSession = getSession();
		cassandraSession.execute(query);
		cassandraSession.execute("USE tp");
		System.out.println("Keyspace created"); 
	}
}