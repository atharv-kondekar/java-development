package com.sunbeam;

import java.util.List;

import org.hibernate.annotations.processing.Exclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="emps")
@Data
public class Emp {
	@Id
	private int empno;
	private String ename;
	private Integer mgr; // nullable field
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name="deptno") // FK column name in emps table
	private Dept dept;
	@OneToOne(mappedBy = "emp", cascade = CascadeType.ALL)
	private Address address;
	@ManyToMany(mappedBy = "empList")
	private List<Meeting> meetingList;
}
