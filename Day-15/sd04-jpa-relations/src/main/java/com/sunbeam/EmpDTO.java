package com.sunbeam;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmpDTO {
	private Integer empno;
	private String ename;
	private Integer mgr;
	private Integer deptno;
	private String dname;
}
