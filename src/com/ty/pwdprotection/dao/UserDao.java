package com.ty.pwdprotection.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.pwdprotection.dto.UserDto;
import com.ty.pwdprotection.util.SingletonConnection;

public class UserDao {

	public int saveUser(int id, String userName, String userEmail, String userPassword) {

		Connection con = SingletonConnection.getConnection();
		String sql = "Insert into user values(?,?,?,?)";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, userName);
			preparedStatement.setString(3, userEmail);
			preparedStatement.setString(4, userPassword);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	public UserDto validateUser(String userEmail, String userPassword) {

		Connection con = SingletonConnection.getConnection();
		String sql = "Select * from user where email = ? and password = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, userEmail);
			preparedStatement.setString(2, userPassword);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				UserDto dto = new UserDto();
				dto.setUid(resultSet.getInt(1));
				dto.setUserName(resultSet.getString(2));
				dto.setEmail(userEmail);
				dto.setPassword(userPassword);
				return dto;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
