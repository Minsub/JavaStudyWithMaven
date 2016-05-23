package com.minsub.dp.builder;

public class User {
	private String name;	//required
	private int age;		//required
	private String address;	//optional
	private String desc;	//optional
	
	public User() {}
	
	private User(UserBuilder builder) {
		this.name = builder.name;
		this.age = builder.age;
		this.address = builder.address;
		this.desc = builder.desc;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	/**
	 * Builder class for User Class
	 * @author minsub ji
	 *
	 */
	public static class UserBuilder {
		private String name;
		private int age;
		private String address;
		private String desc;
		
		public UserBuilder(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}
		
		public UserBuilder desc(String desc) {
			this.desc = desc;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
	}
	
}
