package com.internousdev.movie.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.movie.dao.LoginDAO;
import com.internousdev.movie.dao.MovieInfoDAO;
import com.internousdev.movie.dao.TheaterInfoDAO;
import com.internousdev.movie.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String password;
	private String errMessage="";
	public Map<String,Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private TheaterInfoDAO theaterInfoDAO= new TheaterInfoDAO();
	private MovieInfoDAO movieInfoDAO= new MovieInfoDAO();
	public String execute() throws SQLException{
		String result = ERROR;
//ユーザー入力のID.PASSをDAOに送る
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, password);

//戻り値DTO型に入っているloginFlgはLoginDAOで認証成功していたらtrueになっている
		session.put("loginUser", loginDTO);
		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){ // login認証成功している場合
			result = SUCCESS;
			session.put("loginUserId", loginDTO.getLoginId());
			session.put("theaterInfoList", theaterInfoDAO.getTheaterInfo());
			session.put("movieInfoList", movieInfoDAO.getMovieInfo());
		}else {
			session.put("errMessage","ログインID もしくは パスワードが誤っています");
		}
		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public Map<String,Object> getSession(){
		return this.session;
	}
}