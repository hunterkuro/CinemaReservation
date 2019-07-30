package com.internousdev.movie.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.movie.dto.LoginDTO;
import com.internousdev.movie.util.DBConnector;

public class LoginDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private LoginDTO loginDTO = new LoginDTO();

	public LoginDTO getLoginUserInfo(String loginUserId,String password){
		String sql = "SELECT * FROM login_user_transaction WHERE login_id= ? AND login_pass = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, loginUserId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				loginDTO.setLoginId(rs.getString("login_id"));
				loginDTO.setPassword(rs.getString("login_pass"));
				loginDTO.setUserName(rs.getString("user_name"));
				if(rs.getString("login_id")!=null){
					loginDTO.setLoginFlg(true);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return loginDTO;
	}
}
