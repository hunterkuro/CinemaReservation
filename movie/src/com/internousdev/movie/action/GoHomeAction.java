package com.internousdev.movie.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GoHomeAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;

	public String execute(){
		String result = "home";
		if(session.get("login_user_id") !="" && session.get("login_user_id") !=null){
			//test
			System.out.println(session.get("login_user_id"));
			System.out.println(session.get("theater_info_list"));
			result = SUCCESS;
		}
		return result;
	}

	public Map<String,Object> getSession(){
		return this.session;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
