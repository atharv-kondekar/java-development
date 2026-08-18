package com.sunbeam.practice;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {


	private JdbcTemplate jdbcTemplate;
	private UserRowMapper userRowMapper;

	public UserDaoImpl(JdbcTemplate jdbcTemplate,UserRowMapper userRowMapper) {
		this.jdbcTemplate=jdbcTemplate;
		this.userRowMapper=userRowMapper;
	}

	@Override
	public int saveRecord(User user) {
		String sql = "INSERT INTO users VALUES (default,?,?,?,?,?,?)";
		int count = jdbcTemplate.update(sql,user.getEmail(),user.getPasswd()
				,user.getAddr(),user.getBirth(),user.getRole(),user.getEmail());
		return count;
	}

	@Override
	public int updateRecord(User user) {
		String sql = "UPDATE users SET email=?,passwd=?,addr=?,birth=?,role=?,"
				+ "name=? WHERE id = ?";
		int count = jdbcTemplate.update(sql,user.getEmail(),user.getPasswd()
				,user.getAddr(),user.getBirth(),user.getRole(),user.getName(),
				user.getId());
		return count;
	}

	@Override
	public List<User> findAllUsers() {
		String sql = "SELECT * FROM users";
		List<User> userList = jdbcTemplate.query(sql,userRowMapper);
		return userList.isEmpty()?null:userList;
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM users WHERE email = ?";
		List<User> userList =  jdbcTemplate.query(sql,userRowMapper,email);
		return userList.isEmpty()?null:userList.get(0);
	}

	@Override
	public Optional<User> findById(int id) {
		String sql = "SELECT * FROM users WHERE id =?";
		List<User> userList = jdbcTemplate.query(sql,userRowMapper,id);
		return userList.isEmpty()?Optional.empty():Optional.of(userList.get(0));
	}
}
