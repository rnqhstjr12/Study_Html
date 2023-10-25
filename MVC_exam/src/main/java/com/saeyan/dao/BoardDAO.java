package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.BoardVO;

import util.Util;
public class BoardDAO {
	private BoardDAO() {
	}
	private static BoardDAO inst = new BoardDAO();
	public static BoardDAO Inst() {
		return inst;
	}
	public List<BoardVO> boardAll() {
		String sql = "SELECT * FROM BOARD "
				+ 	 "ORDER BY NUM DESC";
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = Util.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BoardVO bvo = new BoardVO();
				bvo.setNum(rs.getInt("NUM"));
				bvo.setName(rs.getString("NAME"));
				bvo.setEmail(rs.getString("EMAIL"));
				bvo.setPw(rs.getString("PW"));
				bvo.setTitle(rs.getString("TITLE"));
				bvo.setContent(rs.getString("CONTENT"));
				bvo.setReadcnt(rs.getInt("READCNT"));
				bvo.setWritedate(rs.getDate("WRITEDATE"));
				list.add(bvo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, stmt, rs);
		}
		return list;
	}
	public void insertBoard(BoardVO bvo) {
//		String sql = "INSERT INTO BOARD VALUES"
//				+ "(NULL, ?, ?, ?, ?, ?)";
		String sql = "INSERT INTO BOARD(NUM, NAME, EMAIL, PW, TITLE, CONTENT) VALUES(NULL, ?, ?, ?, ?, ?)"; 
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = Util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bvo.getPw());
			pstmt.setString(2, bvo.getName());
			pstmt.setString(3, bvo.getEmail());
			pstmt.setString(4, bvo.getTitle());
			pstmt.setString(5, bvo.getContent());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt);
		}
	}
	public void updateReadCount(String num) {
		String sql = "UPDATE BOARD"
				+ "   SET READCNT = READCNT + 1"
				+ "   WHERE NUM = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = Util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt);
		}
	}
	public BoardVO selectBoardByNum(String num) {
		String sql = "SELECT * FROM BOARD"
				+ "   WHERE NUM = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		BoardVO bvo = new BoardVO();
		ResultSet rs = null;
		try {
			conn = Util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bvo = new BoardVO();
				
				bvo.setNum(rs.getInt("NUM"));
				bvo.setPw(rs.getString("PW"));
				bvo.setName(rs.getString("NAME"));
				bvo.setEmail(rs.getString("EMAIL"));
				bvo.setTitle(rs.getString("TITLE"));
				bvo.setContent(rs.getString("CONTENT"));
				bvo.setReadcnt(rs.getInt("READCNT"));
				bvo.setWritedate(rs.getDate("WRITEDATE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		return bvo;
	}
	public void updateBoard(BoardVO bvo) {
		String sql = "UPDATE BOARD"
				+ "	  SET NAME = ?, EMAIL =?, PW =?, TITLE = ?, CONTENT = ?"
				+ "   WHERE NUM = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = Util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bvo.getName());
			pstmt.setString(2, bvo.getEmail());
			pstmt.setString(3, bvo.getPw());
			pstmt.setString(4, bvo.getTitle());
			pstmt.setString(5, bvo.getContent());
			pstmt.setInt(6, bvo.getNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt);
		}
	}
	public BoardVO checkPW(String pw, String num) {
		String sql = "SELECT * FROM BOARD"
				+ "   WHERE PW = ? AND NUM = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO bvo = null;
		try {
			conn = Util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bvo = new BoardVO();
				bvo.setNum(rs.getInt("NUM"));
				bvo.setName(rs.getString("NAME"));
				bvo.setEmail(rs.getString("EMAIL"));
				bvo.setPw(rs.getString("PW"));
				bvo.setTitle(rs.getString("TITLE"));
				bvo.setContent(rs.getString("CONTENT"));
				bvo.setReadcnt(rs.getInt("READCNT"));
				bvo.setWritedate(rs.getDate("WRITEDATE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		return bvo;
	}
	public void deleteBoard(String num) {
		String sql = "DELETE FROM BOARD"
				+ "	  WHERE NUM = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = Util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt);
		}
	}
}
