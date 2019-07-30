package com.internousdev.movie.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.movie.dto.ResurvedDetailsDTO;
import com.internousdev.movie.util.DBConnector;
import com.internousdev.movie.util.DateUtil;
public class ReservationStatusDAO {

		private DBConnector db = new DBConnector();
		private Connection con = db.getConnection();
		private DateUtil dateUtil = new DateUtil();
		/**
		 *座席の予約情報をDBに格納
		 * @param date
		 * @param theaterName
		 * @param movieName
		 * @param seatsNumber (最大4席までの同時予約対応)
		 * @param userName
		 * @return INSERT文の更新件数 int
		 * @throws SQLException
		 */
		public int getSeatsCheck(String theaterName,String movieName,String date,String time,List<Integer> seatsNumber,String userId) throws SQLException{
			int count = 0;
			for (int seat: seatsNumber){
				String sql = "INSERT INTO reservation_status_transaction (theater_name,movie_name,reservation_date,reservation_time,seats_number,reservation_user_id,insert_date)"
						+ "VALUES(?,?,?,?,?,?,?)";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, theaterName);
					ps.setString(2, movieName);
					ps.setString(3, date);
					ps.setString(4, time);
					ps.setInt(5, seat); // DB上ではseats_numberはint型
					ps.setString(6, userId);
					ps.setString(7, dateUtil.getDate());
					count += ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return count;
		}

		/**
		 * userIdに紐づく予約履歴の確認
		 * @param userId
		 * @return 予約情報 List<ResurvedDetailsDTO>
		 * @throws SQLException
		 */
		public List<ResurvedDetailsDTO> getResurvedDetails(String userId) throws SQLException{
			List<ResurvedDetailsDTO> resurvedDetailsList = new ArrayList<ResurvedDetailsDTO>();
				String sql = "SELECT * FROM reservation_status_transaction WHERE reservation_user_id = ?";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, userId);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						ResurvedDetailsDTO dto = new ResurvedDetailsDTO();
						dto.setUserId(userId);
						dto.setDate(rs.getString("reservation_date"));
						dto.setTime(rs.getString("reservation_time"));
						dto.setMovieName(rs.getString("movie_name"));
						dto.setTheaterName(rs.getString("theater_name"));
						dto.setSeatsNumber(rs.getInt("seats_number"));
						dto.setInsertDate(rs.getDate("insert_date"));
						resurvedDetailsList.add(dto);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return resurvedDetailsList;
		}
}
