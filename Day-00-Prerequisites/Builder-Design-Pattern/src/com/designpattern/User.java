package com.designpattern;

public class User {
	private int userId;
	private String emailId;
	private String userName;

	public User(UserBuider userBuider) {
		this.userId = userBuider.userId;
		this.emailId = userBuider.userEmail;
		this.userName = userBuider.userName;
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public static class UserBuider{
		private String userName;
		private int userId;
		private String userEmail;

		public UserBuider() {

		}

		public UserBuider setUserName(String userName) {
			this.userName = userName;
			return this;
		}

		public UserBuider setUserId(int userId) {
			this.userId = userId;
			return this;
		}

		public UserBuider setUserEmail(String userEmail) {
			this.userEmail = userEmail;
			return this;
		}

		public User build() {
			User user = new User(this);
			return user;
		}

	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", emailId=" + emailId + ", userName=" + userName + "]";
	}


}
