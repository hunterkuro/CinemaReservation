package com.internousdev.movie.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.movie.dao.MovieInfoDAO;
import com.internousdev.movie.dao.TheaterInfoDAO;
import com.internousdev.movie.dto.TheaterInfoDTO;
import com.opensymphony.xwork2.ActionSupport;
public class TheaterDetailsAction extends ActionSupport implements SessionAware {
//【 選択された映画館の詳細ページに移行するAction 】
	public Map<String,Object> session;

	private String theaterName;
	private TheaterInfoDAO theaterInfoDAO= new TheaterInfoDAO();
	private MovieInfoDAO movieInfoDAO= new MovieInfoDAO();

	public String execute() throws SQLException{

		session.put("theaterDetailsList",theaterInfoDAO.getTheaterDetailsInfo(theaterName));
		session.put("screeningMovie", movieInfoDAO.getScreeningTheater(((TheaterInfoDTO) session.get("theaterDetailsList")).getScreeningMoviePattern()));

//選択した映画名はsessionに格納しておく
		session.put("selectedTheaterName", theaterName);
		return SUCCESS;
	}

	public String getTheaterName(){
		return theaterName;
	}

	public void setTheaterName(String theaterName){
		this.theaterName = theaterName;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public Map<String,Object> getSession(){
		return this.session;
	}

}
