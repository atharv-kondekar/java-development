package com.sunbeam;

import java.security.PrivateKey;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "addrs")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Address {
	@Id
	private Integer empno;
	private String tal;
	private String dist;

	@OneToOne
	// Two ways implementing @OneToOne
	//@PrimaryKeyJoinColumn  // 1. PK of address is PK of Emp
	@JoinColumn(name = "empno") //2. FK column in address table
	@MapsId
 	private Emp emp;
}
