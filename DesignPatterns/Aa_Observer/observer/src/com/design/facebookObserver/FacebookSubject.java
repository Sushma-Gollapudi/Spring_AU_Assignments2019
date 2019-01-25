package com.design.facebookObserver;

public interface FacebookSubject {
	public void addFriend(Friend friend);
	 public void removefriend(Friend friend);
	 public void notifyFriend();
}
