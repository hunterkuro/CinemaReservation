package com.internousdev.movie.dto;

public class MovieInfoDTO {

	private int id;
	private String movieName;
	private String period;
	private String screeningTheaterPattern;


	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getMovieName(){
		return movieName;
	}

	public void setMovieName(String movieName){
		this.movieName = movieName;
	}

	public String getPeriod(){
		return period;
	}

	public void setPeriod(String period){
		this.period = period;
	}

	public String getScreeningTheaterPattern(){
		return screeningTheaterPattern;
	}

	public void setScreeningTheaterPattern(String screeningTheaterPattern){
		this.screeningTheaterPattern = screeningTheaterPattern;
	}
}
