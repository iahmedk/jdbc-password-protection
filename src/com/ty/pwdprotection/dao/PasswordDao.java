package com.ty.pwdprotection.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.pwdprotection.dto.PasswordDto;
import com.ty.pwdprotection.util.SingletonConnection;

public class PasswordDao {

	public int saveCredentials(int uid, PasswordDto pdto) {

		Connection con = SingletonConnection.getConnection();
		String sql = "Insert into password values(?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, pdto.getId());
			preparedStatement.setString(2, pdto.getKey());
			preparedStatement.setString(3, pdto.getValue());
			preparedStatement.setString(4, pdto.getType());
			preparedStatement.setString(5, pdto.getHint());
			preparedStatement.setInt(6, uid);
			return preparedStatement.executeUpdate(sql);
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

}