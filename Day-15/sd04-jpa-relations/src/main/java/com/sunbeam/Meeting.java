package com.sunbeam;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="meetings")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "empList")
public class Meeting {
	@Id
	private int meetno;
	private String topic;
	private String venue;
	@ManyToMany
	@JoinTable(name="emp_meetings", // aux table for many-to-many relation
			joinColumns = @JoinColumn(name="meetno"), // FK column in aux table for current entity i.e. Meeting
			inverseJoinColumns = @JoinColumn(name="empno") // FK column in aux table for associated entity i.e. Emp
		)
	private List<Emp> empList;
}
