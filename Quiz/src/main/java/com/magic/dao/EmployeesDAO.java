package com.magic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.magic.dto.EmployeesVO;

public class EmployeesDAO {
	private EmployeesDAO() {
		
	}
	
	private static EmployeesDAO inst = new EmployeesDAO();
	
	public static EmployeesDAO getInst() {
		return inst;
	}
	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
		conn = ds.getConnection(); //JAVA와 DB를 연결해주는메서드 
		return conn;
	}
	public int userCheck(String id, String pw, String lv) {
		int result = -1; // default값 -1
		String sql = "SELECT * FROM employees"
				   + " WHERE ID = ?";
		Connection conn = null; //DB와의 연결 객체
		PreparedStatement pstmt = null; //SQL구문을 실행 -> 전달하는 역활(구문을 이해하진 못함)
		ResultSet rs = null; // SELECT문의 결과를 저장하는 객체
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); //SELECT구문의 객체 값
			if(rs.next()){
				if(pw.equals(rs.getString("PW"))){
					if(lv.equals(rs.getString("LV"))){
						result = 2; // 관리자
						if(lv.equals("B")){
							result=3; // 일반회원
						}
					} else{
						result =1; // 등급이 다름
					}
				} else{
					result = 0; // 비밀번호 불일치
				}
			} else{
				result = -1; // 아이디 존재하지 않음
			}
		} catch(Exception e) {
			e.printStackTrace(); // 예외발생시 정보와 예외 결과를 화면에 출력
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result; // 반환값
	}
	public EmployeesVO getEmployees(String id) {
		EmployeesVO evo = null;
		String sql = "SELECT * FROM employees"
				   + " WHERE ID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				evo = new EmployeesVO();
				evo.setId(rs.getString("ID"));
				evo.setPw(rs.getString("PW"));
				evo.setName(rs.getString("NAME"));
				evo.setLv(rs.getString("LV"));
				evo.setEnter(rs.getDate("ENTER"));
				evo.setSex(Integer.parseInt(rs.getString("SEX")));
				evo.setPhone(rs.getString("PHONE"));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return evo;
	}
	public boolean editEmployees(EmployeesVO evo) {
		boolean result = false;
		String sql = "UPDATE employees"
				   + "   SET id = ?, pw = ?, name = ?, lv = ?, sex = ?, enter = ?, phone = ?"
				   + " WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			if (idCheck(evo.getId())) {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, evo.getId());
				pstmt.setString(2, evo.getPw());
				pstmt.setString(3, evo.getName());
				pstmt.setString(4, evo.getLv());
				pstmt.setInt(5, evo.getSex());
				pstmt.setDate(6, evo.getEnter());
				pstmt.setString(7, evo.getPhone());
				pstmt.setString(8, new EmployeesVO().getId());
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public boolean idCheck(String id) {
		boolean result = false;
		String sql = "SELECT id"
				+ "     FROM employees"
				+ "	   WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = false;
			} else {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int insertMember(EmployeesVO evo) {
		int result = 1;
		String sql = "INSERT INTO employees"
				+ "	  VALUES(?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, evo.getId());
			pstmt.setString(2, evo.getPw());
			pstmt.setString(3, evo.getName());
			pstmt.setString(4, evo.getLv());
			pstmt.setDate(5, evo.getEnter());
			pstmt.setInt(6, evo.getSex());
			pstmt.setString(7, evo.getPhone());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
