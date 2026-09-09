package com.sunbeam;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "depts")
@ToString(exclude = "empList")
public class Dept {
	@Id
	private int deptno;
	private String dname;
	// Uni-Directional @OneToMany
//	@OneToMany
//	@JoinColumn(name = "deptno")
//	private List<Emp> empList;

	// Splotion 3: For Lazy-Loading Problem
	@OneToMany(mappedBy = "dept" /*, fetch = FetchType.EAGER*/ )
	private List<Emp> empList;
}
