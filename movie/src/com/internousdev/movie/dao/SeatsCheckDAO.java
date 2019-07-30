package com.internousdev.movie.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.movie.util.DBConnector;
public class SeatsCheckDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private List<Integer> resurvedSeatsNumber = new ArrayList<Integer>();

	/**
	 *映画館&映画&日付に紐づく予約済み座席の確認
	 * @param theater
	 * @param movie
	 * @param date
	 * @return 予約席番号 List<Integer>
	 * @throws SQLException
	 */
	public List<Integer> getResurvedSeatsCheck(String theater,String movie,String date) throws SQLException{

		String sql = "SELECT seats_number FROM reservation_status_transaction WHERE reservation_date = ? AND theater_name = ? AND movie_name = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, date);
			ps.setString(2, theater);
			ps.setString(3, movie);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				resurvedSeatsNumber.add(rs.getInt("seats_number"));
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return resurvedSeatsNumber;
	}

}
