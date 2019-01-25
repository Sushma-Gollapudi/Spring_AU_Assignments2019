package com.design.facebookObserver;


public class FacebookNotifyPatternMain {
	
	public static void main(String[] args) {
		Friend TomFriend=new Friend("Tom");
		Friend JoyFriend=new Friend("Joy");
	    
		MyFacebook friend1=new MyFacebook("Tom","true");
		MyFacebook friend2=new MyFacebook("Joy","false");
	    
  
		friend1.addFriend(TomFriend);
		friend2.removefriend(JoyFriend);
	    
	    //Now joy is added as a friend
		friend2.setIsFriend("true");
		
		//Notifying Tom that he is blocked
		friend1.setIsFriend("flase");
}
}
