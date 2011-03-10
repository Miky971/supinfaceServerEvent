package controllers;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import play.mvc.Controller;
import models.User;

public class Auth extends Controller{
	
	private static ConcurrentHashMap userLogMap;
	
	public static void login(String login, String password)
	{
		String msg="bad login/password";
		User user=User.connect(login, password);
		if(user!=null){
			//add user to logMap
		//	LoggedUSer aLoggedUSer =this.new LoggedUSer();
		//userLogMap.put(user.idBooster, aLoggedUSer.CreatUserToken());
		renderJSON(user);
		}
		else{renderJSON(msg);}
		
//		if(user!=null)
//		{
//			msg=user.toString();
//		}
//		return msg;		
	}
	
	private class LoggedUSer
	{		
		User user;
		Date date;
	
		public LoggedUSer()
		{
			this.date= new Date();
		}
		
		//Create Token()	
		public String CreatUserToken() 
		{
			String token= UUID.randomUUID().toString();			
			return token;
		}		
		
	}
	
}
