package com.estsoft.db;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQLProjectDBConnection implements DBConnection {

	@Override
	public Connection getConnection() throws SQLException {
		// project에 맞는 DB구현하고 이 Connection만 사용하면 된다.
		
		return null;
	}

}
