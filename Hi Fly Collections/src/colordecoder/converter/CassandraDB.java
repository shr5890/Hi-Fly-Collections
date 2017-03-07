package colordecoder.converter;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class CassandraDB {
	public static void main(String[] args) {
		Cluster cluster;
		Session session;
		// Connect to the cluster and keyspace "demo"
		cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		session = cluster.connect("demo");
		// Insert one record into the users table
		session.execute("INSERT INTO users (lastname, age, city, email, firstname) VALUES ('Jones', 35, 'Austin', 'bob@example.com', 'Bob')");
		// Use select to get the user we just entered
		ResultSet results = session.execute("SELECT * FROM users WHERE lastname='Jones'");
		for (Row row : results) {
			System.out.format("%s %d\n", row.getString("firstname"), row.getInt("age"));
		}
		// Update the same user with a new age
		session.execute("update users set age = 36 where lastname = 'Jones'");
		// Select and show the change
		results = session.execute("select * from users where lastname='Jones'");
		for (Row row : results) {
			System.out.format("%s %d\n", row.getString("firstname"), row.getInt("age"));

		}
		// Clean up the connection by closing it
		cluster.close();
	}
}
