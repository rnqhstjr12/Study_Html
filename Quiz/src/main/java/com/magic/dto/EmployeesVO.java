package com.magic.dto;

import java.sql.Date;

public class EmployeesVO {
	private String id;
	private String pw;
	private String name;
	private String lv;
	private Date enter;
	private int sex;
	private String phone;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLv() {
		return lv;
	}

	public void setLv(String lv) {
		this.lv = lv;
	}

	public Date getEnter() {
		return enter;
	}

	public void setEnter(Date enter) {
		this.enter = enter;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "EmployeesVO [id=" + id + ", pw=" + pw + ", name=" + name + ", lv=" + lv + ", enter=" + enter + ", sex="
				+ sex + ", phone=" + phone + "]";
	}
	
}
