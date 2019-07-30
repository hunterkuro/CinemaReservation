package com.internousdev.movie.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.movie.dto.TheaterInfoDTO;
import com.internousdev.movie.util.DBConnector;

public class TheaterInfoDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

/*ログイン後のメインページで映画館一覧情報を取得する*/
	public List<TheaterInfoDTO> getTheaterInfo() throws SQLException{
		List<TheaterInfoDTO> theaterInfoList = new ArrayList<TheaterInfoDTO>();
		String sql = "SELECT * FROM theater_info_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				TheaterInfoDTO theaterInfoDTO = new TheaterInfoDTO();
				theaterInfoDTO.setId(rs.getInt("id"));
				theaterInfoDTO.setTheaterName(rs.getString("theater_name"));
				theaterInfoDTO.setSeats(rs.getInt("number_of_seats"));
				theaterInfoDTO.setTicketPrice(rs.getInt("ticket_price"));
				theaterInfoDTO.setRegion(rs.getString("region"));
				theaterInfoDTO.setTell(rs.getString("tell"));
				theaterInfoDTO.setScreeningMoviePattern(rs.getString("screening_movie_pattern"));
				theaterInfoList.add(theaterInfoDTO);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return theaterInfoList;
	}

/*映画館一件ずつの詳細情報を取得する*/
	public TheaterInfoDTO getTheaterDetailsInfo(String theaterName) throws SQLException{
		String sql ="SELECT * FROM theater_info_transaction WHERE theater_name = ?";
		TheaterInfoDTO theaterDetailsList = new TheaterInfoDTO();

		try{
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, theaterName);
		ResultSet rs = ps.executeQuery();

			if(rs.next()){
				theaterDetailsList.setId(rs.getInt("id"));
				theaterDetailsList.setTheaterName(rs.getString("theater_name"));
				theaterDetailsList.setSeats(rs.getInt("number_of_seats"));
				theaterDetailsList.setTicketPrice(rs.getInt("ticket_price"));
				theaterDetailsList.setTell(rs.getString("tell"));
				theaterDetailsList.setRegion(rs.getString("region"));
				theaterDetailsList.setScreeningMoviePattern(rs.getString("screening_movie_pattern"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return theaterDetailsList;
	}

/*映画の上映タイプに応じて上映している映画館の情報を取得して返す*/
	public List<TheaterInfoDTO> getScreeningMovie(String screeningMoviePattern) throws SQLException{

		List<TheaterInfoDTO> screeningTheaterList = new ArrayList<TheaterInfoDTO>();

	    String[] spritType = screeningMoviePattern.split(",", 0); // 格納した変数を,で区切って分割した上で配列に格納
	    String qestion = ""; // sql のinsert文で ?（バインド変数）を入れる記述

		for (int i = 0 ; i < spritType.length ; i++){ // 配列の長さの数だけループ
			qestion = qestion.concat("?");
			if(i!=spritType.length -1){ //ループの最後でなければカンマを結合
				qestion = qestion +",";
				}
			}

		String sql ="SELECT * FROM theater_info_transaction WHERE screening_movie_pattern IN ("+qestion+")";

		try{
		PreparedStatement ps = con.prepareStatement(sql);

		for (int i = 0 ; i < spritType.length ; i++){ // 配列の長さの数だけループ
			ps.setString(i+1, spritType[i]); // ps.setStringで ? に入れる文字列
			}

		ResultSet rs = ps.executeQuery();

			while(rs.next()){
				TheaterInfoDTO theaterDetailsList = new TheaterInfoDTO();
				theaterDetailsList.setId(rs.getInt("id"));
				theaterDetailsList.setTheaterName(rs.getString("theater_name"));
				theaterDetailsList.setSeats(rs.getInt("number_of_seats"));
				theaterDetailsList.setTicketPrice(rs.getInt("ticket_price"));
				theaterDetailsList.setTell(rs.getString("tell"));
				theaterDetailsList.setRegion(rs.getString("region"));
				theaterDetailsList.setScreeningMoviePattern(rs.getString("screening_movie_pattern"));
				screeningTheaterList.add(theaterDetailsList);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return screeningTheaterList;
	}

}
