package com.internousdev.movie.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.movie.dao.ReservationStatusDAO;
import com.internousdev.movie.dto.ResurvedDetailsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ResurveDetailsAction extends ActionSupport implements SessionAware{
	private String movieName;
	private String theaterName;
	private List<Integer> seatsNumber;
	private List<ResurvedDetailsDTO> resurvedDetailsList;
	private String date;
	private Map<String,Object> session;
	private String time;

	@SuppressWarnings("unchecked") // sessionの中のList<String>をキャストするため
	public String execute(){
		String result = ERROR;
		ReservationStatusDAO reservationStatusDAO = new ReservationStatusDAO();
		seatsNumber = (List<Integer>)session.get("resurvedSeatNumber");

		/*選択された座席の予約完了処理*/
		try {
			int count=0;
			time="12時"; // システム仕様で予約時間は12時固定。
			count = reservationStatusDAO.getSeatsCheck(theaterName,movieName,date,time,seatsNumber,session.get("loginUserId").toString());
			if(count==seatsNumber.size()){
				result = "checked";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/*マイページの履歴内容表示*/
		try {
			resurvedDetailsList = reservationStatusDAO.getResurvedDetails(session.get("loginUserId").toString());
			if(result.equals("checked")) {
				result = SUCCESS;
			}else {
				result = ERROR;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return result;
	}

	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public List<Integer> getSeatsNumber() {
		return seatsNumber;
	}
	public void setSeatsNumber(List<Integer> seatsNumber) {
		this.seatsNumber = seatsNumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	public List<ResurvedDetailsDTO> getResurvedDetailsList() {
		return resurvedDetailsList;
	}

	public void setResurvedDetailsList(List<ResurvedDetailsDTO> resurvedDetailsList) {
		this.resurvedDetailsList = resurvedDetailsList;
	}
}
