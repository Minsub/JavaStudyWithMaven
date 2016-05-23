package com.minsub.dp.builder;

public class Main {

	public static void main(String[] args) {
		
		// basic way
		User user1 = new User();
		user1.setName("Tom");
		user1.setAge(28);
		user1.setAddress("Auckland, New Zealand");
		user1.setDesc("Handsome guy");
		
		// using builder
		User user2 = new User.UserBuilder("Smith", 32)
						.address("New York, USA")
						.desc("Rich")
						.build();
	}

}
