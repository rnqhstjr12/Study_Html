package com.saeyan.javabeans;

public class MemberBeanTQ {
	private String name;
	private String userid;
	public MemberBeanTQ() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberBeanTQ(String name, String userid) {
		super();
		this.name = name;
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "MemberBeanTQ [name=" + name + ", userid=" + userid + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
}
