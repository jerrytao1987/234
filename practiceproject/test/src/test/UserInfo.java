package test;

public class UserInfo {
	private long userId;
	private String username;
	private int age;
	private String emailAddress;
	public long getUserId() {
		return userId;
	}
	public UserInfo() {
		super();
	}
	public UserInfo(long userId, String username) {
		this.userId = userId;
		this.username = username;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", username=" + username + ", age=" + age + ", emailAddress="
				+ emailAddress + "]";
	}
}
