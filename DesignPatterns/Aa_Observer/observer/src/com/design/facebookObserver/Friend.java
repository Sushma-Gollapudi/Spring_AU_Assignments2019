package com.design.facebookObserver;

public class Friend {
	String friendName;

	public Friend(String friendName) {
		super();
		this.friendName = friendName;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	
	public void alter(String isFriend) {
			
		if(isFriend.equals("true")) {
			System.out.println("Hey "+friendName+",  Welcome to my friend circle");
		}
		else {
			System.out.println("Hey "+friendName+", You are blocked");
		}
	}
}
