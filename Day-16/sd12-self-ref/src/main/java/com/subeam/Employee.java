package com.subeam;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// ----------- Example of the SLEF-JOIN -------------------
//employees table -> empno, ename, deptno, mgr
//						5	Sarang	  40	NULL
//						4	Nitin	  40	5
//						3	Nilesh	  20	4
//						2	Rahul	  10	3
//						1	Amit	  10	4

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude =  {"manager","employees"})
public class Employee {
	@Id
	private int empno;
	private String ename;
	private int deptno;

	@ManyToOne // Many Employees can Report to the Same Manager
	@JoinColumn(name = "mgr")
	private Employee manager;

	@OneToMany(mappedBy = "manager")
	private List<Employee> employees;
}
