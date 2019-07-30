package com.internousdev.movie.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.movie.dto.MovieInfoDTO;
import com.internousdev.movie.util.DBConnector;

public class MovieInfoDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

/*ログイン後のメインページで映画館一覧情報を取得する*/
	public List<MovieInfoDTO> getMovieInfo() throws SQLException{
		List<MovieInfoDTO> movieInfoList = new ArrayList<MovieInfoDTO>();
		String sql = "SELECT * FROM movie_info_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				MovieInfoDTO movieInfoDTO = new MovieInfoDTO();
				movieInfoDTO.setId(rs.getInt("id"));
				movieInfoDTO.setMovieName(rs.getString("movie_name"));
				movieInfoDTO.setPeriod(rs.getString("period"));
				movieInfoDTO.setScreeningTheaterPattern(rs.getString("screening_theater_pattern"));
				movieInfoList.add(movieInfoDTO);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return movieInfoList;
	}

/*映画館一件ずつの詳細情報を取得する*/
	public MovieInfoDTO getMovieDetailsInfo(String movieName) throws SQLException{
		String sql ="SELECT * FROM movie_info_transaction WHERE movie_name = ?";
		MovieInfoDTO movieDetailsList = new MovieInfoDTO();

		try{
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, movieName);
		ResultSet rs = ps.executeQuery();

			if(rs.next()){
				movieDetailsList.setId(rs.getInt("id"));
				movieDetailsList.setMovieName(rs.getString("movie_name"));
				movieDetailsList.setPeriod(rs.getString("period"));
				movieDetailsList.setScreeningTheaterPattern(rs.getString("screening_theater_pattern"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return movieDetailsList;
	}

	/*映画の上映タイプに応じて上映している映画館の情報を取得して返す*/
	public List<MovieInfoDTO> getScreeningTheater(String screeningTheaterPattern) throws SQLException{

		List<MovieInfoDTO> screeningMovieList = new ArrayList<MovieInfoDTO>();

		String sql ="SELECT * FROM movie_info_transaction WHERE screening_theater_pattern LIKE ?";

		try{
		PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1,"%"+screeningTheaterPattern+"%"); // ps.setStringで ? に入れる文字列

		ResultSet rs = ps.executeQuery();

			while(rs.next()){
				MovieInfoDTO movieDetailsList = new MovieInfoDTO();
				movieDetailsList.setId(rs.getInt("id"));
				movieDetailsList.setMovieName(rs.getString("movie_name"));
				movieDetailsList.setPeriod(rs.getString("period"));
				movieDetailsList.setScreeningTheaterPattern(rs.getString("screening_theater_pattern"));
				screeningMovieList.add(movieDetailsList);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return screeningMovieList;
	}
}
