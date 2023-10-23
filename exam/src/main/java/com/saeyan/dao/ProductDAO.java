package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.ProductVO;

import util.DBManager;
public class ProductDAO {
	private ProductDAO() {
	}
	private static ProductDAO inst = new ProductDAO();
	
	public static ProductDAO Inst() {
		return inst;
	}
	public List<ProductVO> selectAllProducts() {
		String sql = "SELECT * FROM PRODUCT"
				+ " ORDER BY CODE DESC";
		List<ProductVO> list = new ArrayList<ProductVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setCode(rs.getInt("CODE"));
				pvo.setName(rs.getString("NAME"));
				pvo.setPrice(rs.getInt("PRICE"));
				pvo.setImgUrl(rs.getString("IMGURL"));
				pvo.setDes(rs.getString("DES"));
				list.add(pvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	public void insertProduct(ProductVO pvo) {
		String sql = "INSERT INTO PRODUCT VALUES("
				+ "NULL, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pvo.getName());
			pstmt.setInt(2, pvo.getPrice());
			pstmt.setString(3, pvo.getImgUrl());
			pstmt.setString(4, pvo.getDes());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public ProductVO selectProductByCode(String code) {
		String sql = "SELECT * FROM PRODUCT"
				+ "    WHERE CODE = ?";
		ProductVO pvo = null;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					pvo = new ProductVO();
					pvo.setCode(rs.getInt("CODE"));
					pvo.setName(rs.getString("NAME"));
					pvo.setPrice(rs.getInt("PRICE"));
					pvo.setImgUrl(rs.getString("IMGURL"));
					pvo.setDes(rs.getString("DES"));
				} 
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}catch (Exception e) {
				e.printStackTrace();
		}
		return pvo;
	}
	public void updateProduct(ProductVO pvo) {
		String sql = "UPDATE PRODUCT"
				+ "      SET NAME = ?, PRICE = ?, IMGURL = ?, DES = ?"
				+ "    WHERE CODE = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pvo.getName());
			pstmt.setInt(2, pvo.getPrice());
			pstmt.setString(3, pvo.getImgUrl());
			pstmt.setString(4, pvo.getDes());
			pstmt.setInt(5, pvo.getCode());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public void deleteProduct(String code) {
		String sql = "DELETE FROM PRODUCT"
				+ "	   WHERE CODE = ?";
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
