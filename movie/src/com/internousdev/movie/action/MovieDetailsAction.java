package com.internousdev.movie.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.movie.dao.MovieInfoDAO;
import com.internousdev.movie.dao.TheaterInfoDAO;
import com.internousdev.movie.dto.MovieInfoDTO;
import com.opensymphony.xwork2.ActionSupport;
public class MovieDetailsAction extends ActionSupport implements SessionAware {
//【 選択された映画の詳細ページに移行するAction 】
	public Map<String,Object> session;

	private String movieName;
	private MovieInfoDAO movieInfoDAO= new MovieInfoDAO();
	private TheaterInfoDAO theaterInfoDAO= new TheaterInfoDAO();

	public String execute() throws SQLException{
//選択された映画の名前を引数に必要情報をDBから持ってきてsessionに格納
		session.put("movieDetailsList", movieInfoDAO.getMovieDetailsInfo(movieName));
		session.put("screeningTheater", theaterInfoDAO.getScreeningMovie(((MovieInfoDTO) session.get("movieDetailsList")).getScreeningTheaterPattern()));
//選択した映画名はsessionに格納しておく
		session.put("selectedMovieName", movieName);

		return SUCCESS;
	}

	public String getMovieName(){
		return movieName;
	}

	public void setMovieName(String movieName){
		this.movieName = movieName;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public Map<String,Object> getSession(){
		return this.session;
	}

}
