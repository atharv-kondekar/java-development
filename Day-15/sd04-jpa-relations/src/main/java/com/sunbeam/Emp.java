package com.sunbeam;

import java.util.Optional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "emps")
public class Emp {
	@Id
	private int empno;
	private String ename;
	private Integer mgr; // nullable Field
	//private int deptno;

	@ManyToOne
	@JoinColumn(name = "deptno")
	private Dept dept;

	@OneToOne(mappedBy = "emp", cascade = CascadeType.ALL)
	Address address;
}
