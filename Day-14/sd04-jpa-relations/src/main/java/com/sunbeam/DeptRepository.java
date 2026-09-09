package com.sunbeam;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import com.sunbeam.Emp;


public interface DeptRepository extends JpaRepository<Dept, Integer> {
	// Solution 4 : For lazy-loading
	@Query("SELECT d FROM Dept d JOIN FETCH d.empList")
	List<Dept> findAllEmps();

	//Solution 5 : For lazy-loading
	@EntityGraph(attributePaths = "empList")
	List<Dept> findAll();

	// Solution 4 & 5 -> Both Solves the Lazy Loading problem
				//    -> Also Solves N+1 Problem
}
