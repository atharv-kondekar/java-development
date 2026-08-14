package com.sunbeam;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;
	private UserRowMapper userRowMapper;
//	@Autowired : No need to write the Autowired
	UserDaoImpl(JdbcTemplate jdbcTemplate,UserRowMapper userRowMapper){
		this.jdbcTemplate=jdbcTemplate;
		this.userRowMapper=userRowMapper;
	}

	@Transactional
	public int save(User user) {
		String sql = "INSERT INTO users VALUES(default,?,?,?,?,?,?)";
		int count = jdbcTemplate.update(sql,user.getEmail(),user.getPasswd(),
				user.getAddr(),user.getBirth(),user.getRole(),user.getName() );

		return count;
	}

	@Transactional
	public int update(User user) {
		String sql = "UPDATE users SET email=?,passwd=?,addr=?,birth=?,role=?,name=? "
				+ "WHERE id = ? ";
		int count = jdbcTemplate.update(sql,user.getEmail(),user.getPasswd(),
				user.getAddr(),user.getBirth(),user.getRole(),user.getName(),
				user.getId());

		return count;
	}

	@Transactional
	public int deleteById(int userId) {
		String sql = "DELETE FROM users WHERE id = ?";
		int count = jdbcTemplate.update(sql,userId);
		return count;
	}

	@Transactional
	public List<User> findAll(){
		String sql = "SELECT * FROM users";
		List<User> userList
		   = jdbcTemplate.query(sql,userRowMapper);
		return userList;
	}

	@Transactional
	public User findByEmail(String email){
		String sql = "SELECT * FROM users WHERE email = ?";
		List<User> userList = jdbcTemplate.query(sql,userRowMapper,email);
		return userList.isEmpty()?null:userList.get(0);
	}

	@Transactional
	public Optional<User> findById(int id){
		String sql = "SELECT * FROM users WHERE id = ? ";
		List<User> listUser = jdbcTemplate.query(sql, userRowMapper,id);
		return listUser.isEmpty()?
		Optional.empty():Optional.of(listUser.get(0));
	}
}
