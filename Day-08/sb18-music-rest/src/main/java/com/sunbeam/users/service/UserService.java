package com.sunbeam.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sunbeam.users.dao.UserDao;
import com.sunbeam.users.domain.User;
import com.sunbeam.users.dtos.UserRequestDTO;
import com.sunbeam.users.dtos.UserResponseDTO;
import com.sunbeam.users.model.LoginCreadentials;

@Service
public class UserService {

	private UserDao userDao;

	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
/*
	public List<User> findAllUsers() {
		return userDao.findAll();
	}
*/
	public List<UserResponseDTO> findAllUsers() {
		List<User> userList = userDao.findAll();

		List<UserResponseDTO> dtoList = userList.stream()
			.map(en-> new UserResponseDTO(en.getId(),en.getName(),en.getEmail(),
					en.getAddr(),en.getBirth(),en.getRole()))
			.toList();

		return dtoList;
	}

	public User findById(int id) {
		return userDao.findUserById(id);
	}

	public User findByEmail(String email) {
		Optional<User> opUser= userDao.findByEmail(email);
		return opUser.isEmpty()?null:opUser.get();
	}

/*
	public int saveData(User user) {
		return userDao.save(user);
	}
*/
	public UserResponseDTO saveData(UserRequestDTO uRD) {
		User user = new User(uRD.getId(),uRD.getName(),uRD.getEmail(),uRD.getPassword(),uRD.getAddress(),
				uRD.getBirth(),"ROLE_CUTOMER");
		int Count = userDao.save(user);

		if(Count == 1 ) {
			return new UserResponseDTO(user.getId(),user.getName(),user.getEmail(),
					user.getAddr(),user.getBirth(),user.getRole());
		}
		return null;
	}

	public int updateUser(User user) {
		return userDao.updateById(user);
	}

	public int updateEmail (String email,int id) {
		return userDao.updateEmail(email, id);
	}

	public int deleteUserById(int id) {
		return userDao.deleteUser(id);
	}

	public User authenticate(LoginCreadentials lc) {
		Optional<User> opUser = userDao.findByEmail( lc.getEmail() );

		if(opUser.isEmpty()) {
			return null;
		}
		else {
			User user = opUser.get();

			if(user!=null && user.getPasswd().equals(lc.getPasswd())) {
				return user;
			}
			return null;
		}
	}

}
