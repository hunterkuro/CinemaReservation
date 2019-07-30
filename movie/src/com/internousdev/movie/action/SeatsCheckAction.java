package com.internousdev.movie.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.movie.dao.SeatsCheckDAO;
import com.internousdev.movie.dto.TheaterInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SeatsCheckAction extends ActionSupport implements SessionAware{

	private String theater;
	private String movie;
	private String date;
	private int seats;
	private List<Integer> seatsNumber = new ArrayList<Integer>();
	private Map<String,Object> session;

	public String execute() throws SQLException{
		String result = SUCCESS;
			System.out.println("String型 = " + theater);
			System.out.println("String型 = " + movie);
            System.out.println("String型 = " + date);

            session.put("resurved_date",date);
    		//ここでDAOで満情報を取得
            SeatsCheckDAO seatsCheckDAO = new SeatsCheckDAO();
            seatsNumber = seatsCheckDAO.getResurvedSeatsCheck(theater,movie,date); //埋まり座席の番号がint型配列が戻る。

            setSeats(((TheaterInfoDTO) session.get("theaterDetailsList")).getSeats());
            System.out.println(seats);

            //予約情報を配列に記憶
            session.put("resurvedTheater", theater);
            session.put("resurvedMovie", movie);
            session.put("resurvedSeats", seats);
            session.put("resurvedDate", date);
		return result;
	}

	public String getTheater(){
		return theater;
	}

	public void setTheater(String theater){
		this.theater = theater;
	}

	public String getMovie(){
		return movie;
	}

	public void setMovie(String movie){
		this.movie = movie;
	}

	public String getDate(){
		return date;
	}

	public void setDate(String date){
		this.date = date;
	}

	public List<Integer> getSeatsNumber(){
		return seatsNumber;
	}

	public void setSeatsNumber(List<Integer> seatsNumber){
		this.seatsNumber = seatsNumber;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public Map<String,Object> getSession(){
		return this.session;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
}
