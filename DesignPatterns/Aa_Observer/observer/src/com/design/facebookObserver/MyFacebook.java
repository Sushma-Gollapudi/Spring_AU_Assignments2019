package com.design.facebookObserver;

import java.util.ArrayList;

public class MyFacebook implements FacebookSubject{

	private ArrayList<Friend> friends = new ArrayList();
    private String friendName;
    String isFriend;
    
    public MyFacebook(String friendName, String isFriend) {
		super();
		this.friendName = friendName;
		this.isFriend = isFriend;
	}

	public ArrayList<Friend> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<Friend> friends) {
		this.friends = friends;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String getIsFriend() {
		return isFriend;
	}

	public void setIsFriend(String isFriend) {
		this.isFriend = isFriend;
		notifyFriend();
	}
	
	@Override
	public void notifyFriend() {
		System.out.println("Notifying :\n");
		if(isFriend.equals("true")) {
			System.out.println("Hey "+friendName+",  Welcome to my friend circle\n");
		}
		else {
			System.out.println("Hey "+friendName+", You are blocked\n");
		}
		 }
      
		 
	@Override
	public void addFriend(Friend friend) {
		friends.add(friend);
		
	}

	@Override
	public void removefriend(Friend friend) {
		friends.remove(friend);
		
	}

	



}
