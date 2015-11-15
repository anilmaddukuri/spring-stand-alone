package com.anil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("PersonDAO")
public class PersonDAO {

	//One way to autowire bean by ID
	@Autowired @Qualifier("dataSourcePool")
	private DataSource dataSource;
	
	Logger logger = LoggerFactory.getLogger(PersonDAO.class);
	
	public Person getPersonById(int id) {
		Person toReturn = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM PERSON WHERE id = ?");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				toReturn = new Person();
				toReturn.setAge(rs.getString("age"));
				toReturn.setEmai(rs.getString("emai"));
				toReturn.setName(rs.getString("name"));
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			logger.error(e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					logger.error("Exception while closing the connection " + e.getMessage());
				}
			}
		}
		return toReturn;
	}
}
