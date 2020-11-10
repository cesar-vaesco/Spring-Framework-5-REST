package com.vaescode.users.models;

public class User {

	private String userName;
	private String nickName;
	private String password;

	public User() {
	}

	public User(String userName, String nickName, String password) {
		this.userName = userName;
		this.nickName = nickName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}