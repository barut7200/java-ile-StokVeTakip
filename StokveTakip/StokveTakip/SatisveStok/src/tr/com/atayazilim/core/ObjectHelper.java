package tr.com.atayazilim.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import tr.com.atayazilim.interfaces.coreInterfaces;

public class ObjectHelper extends CoreFields implements tr.com.atayazilim.interfaces.coreInterfaces {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Connection getConnection() {
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(getUrl(),getUsername(),getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}

}
