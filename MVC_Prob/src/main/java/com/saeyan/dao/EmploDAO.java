package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.EmploVO;

import util.Util;

public class EmploDAO {
	private EmploDAO() {
	}
	private static EmploDAO inst = new EmploDAO();
	public static EmploDAO Inst() {
		return inst;
	}
	public List<EmploVO> emploAll() {
		String sql = "SELECT * FROM EMPLO "
				+ "   ORDER BY ID DESC";
		List<EmploVO> list = new ArrayList<EmploVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try { 
			conn = Util.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				EmploVO evo = new EmploVO();
				evo.setId(rs.getString("ID"));
				evo.setPw(rs.getString("PW"));
				evo.setName(rs.getString("NAME"));
				evo.setLv(rs.getString("LV"));
				evo.setEnter(rs.getDate("ENTER"));
				evo.setGender(rs.getString("GENDER"));
				evo.setPhone(rs.getString("PHONE"));
				list.add(evo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, stmt, rs);
		}
		return list;
	}
	public void insertEmplo(EmploVO evo) {
//		String sql = "INSERT INTO BOARD VALUES"
//				+ "(NULL, ?, ?, ?, ?, ?)";
		String sql = "INSERT INTO EMPLO VALUES(?, ?, ?, ?, NOW(), ?, ?)"; 
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = Util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, evo.getId());
			pstmt.setString(2, evo.getPw());
			pstmt.setString(3, evo.getName());
			pstmt.setString(4, evo.getLv());
			pstmt.setString(5, evo.getGender());
			pstmt.setString(6, evo.getPhone());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt);
		}
	}
	public EmploVO selectEmploById(String id) {
		String sql = "SELECT * FROM EMPLO"
				+ "   WHERE ID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		EmploVO evo = new EmploVO();
		ResultSet rs = null;
		try {
			conn = Util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				evo = new EmploVO();
				
				evo.setId(rs.getString("ID"));
				evo.setPw(rs.getString("PW"));
				evo.setName(rs.getString("NAME"));
				evo.setLv(rs.getString("LV"));
				evo.setGender(rs.getString("GENDER"));
				evo.setPhone(rs.getString("PHONE"));
				evo.setEnter(rs.getDate("ENTER"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		return evo;
	}
	public void updateEmplo(EmploVO evo) {
		String sql = "UPDATE EMPLO"
				+ "	  SET ID = ?, PW =?, NAME =?, LV = ?, GENDER = ?, PHONE = ?"
				+ "   WHERE ID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = Util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, evo.getId());
			pstmt.setString(2, evo.getPw());
			pstmt.setString(3, evo.getName());
			pstmt.setString(4, evo.getLv());
			pstmt.setString(5, evo.getGender());
			pstmt.setString(6, evo.getPhone());
			pstmt.setString(7, evo.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt);
		}
	}
	public void deleteEmplo(String id) {
		String sql = "DELETE FROM EMPLO"
				+ "	  WHERE ID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = Util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt);
		}
	}
}
