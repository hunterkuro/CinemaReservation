package com.internousdev.movie.dto;

import java.util.Date;

public class ResurvedDetailsDTO {

	private String userId;
	private String date;
	private String time;
	private String movieName;
	private String theaterName;
	private int seatsNumber;
	private Date insertDate;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	public int getSeatsNumber() {
		return seatsNumber;
	}
	public void setSeatsNumber(int seatsNumber) {
		this.seatsNumber = seatsNumber;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
}
