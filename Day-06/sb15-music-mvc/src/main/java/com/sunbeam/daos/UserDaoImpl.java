package com.sunbeam.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.domain.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;
	private UserRowMapper userRowMapper;

	public UserDaoImpl(JdbcTemplate jdbcTemplate,UserRowMapper userRowMapper) {
		this.jdbcTemplate = jdbcTemplate;
		this.userRowMapper=userRowMapper;
	}

	public int save(User user) {
		String sql = "INSERT INTO users VALUES(default,?,?,?,?,?,?)";
		int count = jdbcTemplate.update(sql,user.getName(),user.getEmail(),user.getPasswd(),user.getAddr(),
				user.getBirth(),user.getRole());
		return count;
	}

	public int update(User user) {
		String sql = "UPDATE users SET name=?,email=?,passwd=?,addr=?,birth=?,role=? "
				+ "WHERE id = ?";
		int count = jdbcTemplate.update(sql,user.getName(),user.getEmail(),user.getPasswd()
				,user.getAddr(),user.getBirth(),user.getRole(),user.getId());
		return count;
	}

	public int deleteById(int id) {
		String sql = "DELETE FROM users WHERE id=?";
		int count = jdbcTemplate.update(sql,id);
		return count;
	}

	public List<User> findAll(){
		String sql ="SELECT * FROM users";
		List<User> userList = jdbcTemplate.query(sql, userRowMapper);
		return userList.isEmpty()?null:userList;
	}

	public User findByEmail(String email){
		String sql = "SELECT * FROM users WHERE email=?";
		List<User> userList = jdbcTemplate.query(sql,userRowMapper,email);
		return userList.isEmpty()?null:userList.get(0);
	}

	public Optional<User> findById(int id) {
		String sql = "SELECT * FROM users WHERE id =?";
		List<User> user = jdbcTemplate.query(sql,userRowMapper,id);
		return user.isEmpty()?Optional.empty():Optional.of(user.get(0));
	}
}
