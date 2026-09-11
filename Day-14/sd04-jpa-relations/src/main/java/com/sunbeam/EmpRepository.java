package com.sunbeam;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpRepository extends JpaRepository<Emp, Integer> {
	@Query("SELECT new com.sunbeam.EmpDTO(e.empno, e.ename, e.mgr, d.deptno, d.dname) FROM Emp e LEFT JOIN e.dept d")
	List<EmpDTO> findAllEmps() ;

	@Query("SELECT new com.sunbeam.EmpDTO(e.empno , e.ename,e.mgr, e.dept.deptno , e.dept.dname) FROM Emp e")
	List<EmpDTO> findAllEmps2();
}
