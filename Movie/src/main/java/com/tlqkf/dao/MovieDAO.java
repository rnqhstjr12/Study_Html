package com.tlqkf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tlqkf.dto.MovieVO;

import util.DBManager;

public class MovieDAO {
	private MovieDAO() {
	}
	private static MovieDAO inst = new MovieDAO();
	
	public static MovieDAO Inst() {
		return inst;
	}
	public List<MovieVO> selectAllMovies() {
		String sql = "SELECT * FROM MOVIE"
				+ " ORDER BY CODE DESC";
		List<MovieVO> list = new ArrayList<MovieVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MovieVO mvo = new MovieVO();
				mvo.setCode(rs.getInt("CODE"));
				mvo.setTitle(rs.getString("TITLE"));
				mvo.setPrice(rs.getInt("PRICE"));
				mvo.setDirector(rs.getString("DIRECTOR"));
				mvo.setActor(rs.getString("ACTOR"));
				mvo.setPoster(rs.getString("POSTER"));
				mvo.setSynopsis(rs.getString("SYNOPSIS"));
				list.add(mvo);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	public void insertMovie(MovieVO mvo) {
		String sql = "INSERT INTO MOVIE VALUES("
				+ " NULL, ?, ? ,? ,? ,?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mvo.getTitle());
			pstmt.setInt(2, mvo.getPrice());
			pstmt.setString(3, mvo.getDirector());
			pstmt.setString(4, mvo.getActor());
			pstmt.setString(5, mvo.getPoster());
			pstmt.setString(6, mvo.getSynopsis());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public MovieVO selectMovieByCode(String code) {
		String sql = "SELECT * FROM MOVIE"
				+ "    WHERE CODE = ?";
		MovieVO mvo = null;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn =DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					mvo = new MovieVO();
					mvo.setCode(rs.getInt("CODE"));
					mvo.setTitle(rs.getString("TITLE"));
					mvo.setPrice(rs.getInt("PRICE"));
					mvo.setDirector(rs.getString("DIRECTOR"));
					mvo.setActor(rs.getString("ACTOR"));
					mvo.setPoster(rs.getString("POSTER"));
					mvo.setSynopsis(rs.getString("SYNOPSIS"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mvo;
	}
	public void updateMovie(MovieVO mvo) {
		String sql = "UPDATE MOVIE"
				+ "      SET TITLE = ?, PRICE = ?, DIRECTOR = ?, ACTOR = ?, POSTER = ?, SYNOPSIS = ?"
				+ "    WHERE CODE = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mvo.getTitle());
			pstmt.setInt(2, mvo.getPrice());
			pstmt.setString(3, mvo.getDirector());
			pstmt.setString(4, mvo.getActor());
			pstmt.setString(5, mvo.getSynopsis());
			pstmt.setString(6, mvo.getPoster());
			pstmt.setInt(7, mvo.getCode());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public void deleteMovie(String code) {
		String sql = "DELETE FROM MOVIE"
				+ "    WHERE CODE = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
