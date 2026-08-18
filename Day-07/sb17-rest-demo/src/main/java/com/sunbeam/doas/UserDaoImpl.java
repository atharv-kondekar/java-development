package com.sunbeam.doas;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;
	private UserRowMapper userRowMapper;

	public UserDaoImpl(JdbcTemplate jdbcTemplate,UserRowMapper userRowMapper) {
		this.jdbcTemplate = jdbcTemplate;
		this.userRowMapper=userRowMapper;
	}

	public List<User> findAll() {
		String sql = "SELECT * FROM users";
		List<User> userList = jdbcTemplate.query(sql, userRowMapper);
		return userList.isEmpty()?null:userList;
	}
}
