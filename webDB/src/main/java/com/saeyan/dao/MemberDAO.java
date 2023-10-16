package com.saeyan.dao;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private MemberDAO() {
		
	}
	
	private static MemberDAO inst = new MemberDAO();
	
	public static MemberDAO getInst() {
		return inst;
	}
	
	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
		conn = ds.getConnection();
		return conn;
	}
}
