package com.chunjae.comm;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection instance = new DBConnection();
    private DBConnection() {
    }
    public static DBConnection getInstance() {
        return instance;
    }
    public Connection getConnection() throws SQLException, NamingException {
        Context init = new InitialContext();
        DataSource ds = (DataSource) init.lookup("java:/comp/env/jdbc/chunjae");
        Connection conn = ds.getConnection();
        return conn;
    }
}
