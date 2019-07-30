package com.internousdev.movie.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	public String execute(){

		return SUCCESS;
	}
@Override
	public void setSession(Map<String,Object> session){
	this.session = session;
	}

	public Map<String, Object> getSession(){
		return this.session;
	}


}
