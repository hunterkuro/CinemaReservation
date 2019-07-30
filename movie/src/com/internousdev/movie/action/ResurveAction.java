package com.internousdev.movie.action;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.movie.dao.MovieInfoDAO;
import com.internousdev.movie.dao.TheaterInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ResurveAction extends ActionSupport implements SessionAware{
	private String theaterName;
	private String movieName;
	private Date date;
	private String seatsNumber;

	public Map<String,Object> session;

	private MovieInfoDAO movieInfoDAO= new MovieInfoDAO();
	private TheaterInfoDAO theaterInfoDAO= new TheaterInfoDAO();

	public String execute() throws SQLException{
		String result = SUCCESS;

	//このアクションにはTeaterかMovieのどちらかのDetailsActionしか経由していない。確認画面で使用する（選択されている映画館情報or映画情報）の補完
			//theaterNameがparamで送られていない場合、MovieDatailsActionで取得するmovie_details_listを補完
			if(theaterName == null) {
				session.put("movieDetailsList", movieInfoDAO.getMovieDetailsInfo(movieName));
				session.put("selectedMovieName", movieName);
				}
			//movieNameがparamで送られていない場合、TheaterDatailsActionで取得するtheater_details_listを補完
			if(movieName == null) {
				session.put("theaterDetailsList",theaterInfoDAO.getTheaterDetailsInfo(theaterName));
				session.put("selectedTheaterName", theaterName);
			}
		return result;
	}

	public String getTheaterName(){
		return theaterName;
	}

	public void setTheaterName(String theaterName){
		this.theaterName = theaterName;
	}

	public String getMovieName(){
		return movieName;
	}

	public void setMovieName(String movieName){
		this.movieName = movieName;
	}

	public Date getDate(){
		return date;
	}

	public void setDate(Date date){
		this.date = date;
	}

	public String getSeatsNumber(){
		return seatsNumber;
	}

	public void setSeatsNumber(String seatsNumber){
		this.seatsNumber = seatsNumber;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public Map<String,Object> getSession(){
		return this.session;
	}
}
