package in.adsingh.springrestapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name="tbl_employee")
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	//if we want to change name to full name
	//@JsonProperty("full_name")
	@Column(name="name")
	private String name;
	
	//@JsonIgnore if we want to ignore age
	@Column(name="age")
	private Long age;
	
	//private String location;
	
	@Column(name="email")
	private String email;
	@Column(name="department")
	private String department;



}
