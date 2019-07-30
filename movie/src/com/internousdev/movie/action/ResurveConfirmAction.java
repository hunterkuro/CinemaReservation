package com.internousdev.movie.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ResurveConfirmAction extends ActionSupport implements SessionAware{
	private String seatNumber0;
	private String seatNumber1;
	private String seatNumber2;
	private String seatNumber3;
	public Map<String,Object> session;
	private String date;

	public String execute() {
		List<Integer> seatNumber = new ArrayList<>();
		// 選択された座席が未選択でなければ、席番号をListに格納
		if(!(seatNumber0).equals("")) {
			seatNumber.add(Integer.parseInt(seatNumber0));
		}
		if(!(seatNumber1).equals("")) {
			seatNumber.add(Integer.parseInt(seatNumber1));
		}
		if(!(seatNumber2).equals("")) {
			seatNumber.add(Integer.parseInt(seatNumber2));
		}
		if(!(seatNumber3).equals("")) {
			seatNumber.add(Integer.parseInt(seatNumber3));
		}

		//for(int i=0;i<=3;i++) {
		//	if(!("seatNumber"+i).equals("")) {
		//		seatNumber.add(("seatNumber"+i));
		//	}

		// 予約された座席をsessionで保持
		session.put("resurvedSeatNumber", seatNumber);

		return SUCCESS;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public String getSeatNumber0() {
		return seatNumber0;
	}

	public void setSeatNumber0(String seatNumber0) {
		this.seatNumber0 = seatNumber0;
	}

	public String getSeatNumber1() {
		return seatNumber1;
	}

	public void setSeatNumber1(String seatNumber1) {
		this.seatNumber1 = seatNumber1;
	}

	public String getSeatNumber2() {
		return seatNumber2;
	}

	public void setSeatNumber2(String seatNumber2) {
		this.seatNumber2 = seatNumber2;
	}

	public String getSeatNumber3() {
		return seatNumber3;
	}

	public void setSeatNumber3(String seatNumber3) {
		this.seatNumber3 = seatNumber3;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public Map<String,Object> getSession(){
		return this.session;
	}
}
