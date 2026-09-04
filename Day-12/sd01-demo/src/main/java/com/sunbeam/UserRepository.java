package com.sunbeam;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//Replacement of the UserDao Interface
public interface UserRepository extends JpaRepository<User,Integer>{
// 1. Basic Property Queries
	User findByEmail(String email);
	List<User> findByAddr(String address);
	// findByAddr = Addr is the Java class entity Field name "private String addr"
	List<User> findByAddrContaining(String addr);

// 2. Distinct Result
	List<User> findDistinctPeopleByAddr(String addr);

// 3. Case-Insensitive Queries
	List<User> findByNameIgnoreCase(String name);

// 4. Sorting and ordering
	List<User> findByAddrOrderByNameDesc(String name);

// 5. Range Query
	List<User> findByBirthBetween(LocalDate date1 , LocalDate date2);

// 6. Limiting Results
	List<User> findTop3ByAddrContaining(String addr);

// 7. Collection Queries
	List<User> findByRoleIgnoreCase(String Role);
}
