package com.internousdev.movie.dto;

public class TheaterInfoDTO {

	private int id;
	private String theaterName;
	private int seats;
	private int ticketPrice;
	private String region;
	private String tell;
	private String screeningMoviePattern;


	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getTheaterName(){
		return theaterName;
	}

	public void setTheaterName(String theaterName){
		this.theaterName = theaterName;
	}

	public int getSeats(){
		return seats;
	}

	public void setSeats(int seats){
		this.seats = seats;
	}

	public int getTicketPrice(){
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice){
		this.ticketPrice = ticketPrice;
	}

	public String getRegion(){
		return region;
	}

	public void setRegion(String region){
		this.region = region;
	}

	public String getTell(){
		return tell;
	}

	public void setTell(String tell){
		this.tell = tell;
	}

	public String getScreeningMoviePattern(){
		return screeningMoviePattern;
	}

	public void setScreeningMoviePattern(String screeningMoviePattern){
		this.screeningMoviePattern = screeningMoviePattern;
	}
}
