package com.sunbeam;

import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
	private JdbcTemplate jdbcTemplate;

	public UserDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int addRecord(User user) {
		String sql = "INSERT INTO users VALUES(default,?,?,?,?,?,?)";
		int count = jdbcTemplate.update(sql,user.getEmail(),user.getPasswd(),user.getAddr()
				,user.getBirth(),user.getRole(),user.getName());
		return count;
	}

	public int updateRecord(User user) {
		String sql = "UPDATE users SET passwd = ? , addr = ? WHERE id = ?";
		int count = jdbcTemplate.update(sql,user.getPasswd(),user.getAddr(),user.getId());
		return count;
	}

	public int deleteUser(int id) {
		String sql = "DELETE FROM users WHERE id = ?";
		int count = jdbcTemplate.update(sql,id);
		return count;
	}
}
