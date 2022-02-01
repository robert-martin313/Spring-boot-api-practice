package in.adsingh.springrestapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
	//@Column(name="id")
	private Long id;
	
	//if we want to change name to full name
	//@JsonProperty("full_name")
	//@Column(name="name")//Column annotation is not necessary if column namr in database is same as name written here then you can skip this
	@NotNull(message = "Name should not be null")
	private String name;
	
	//@JsonIgnore if we want to ignore age
	//@Column(name="age")
	private Long age = 0L;
	
	//private String location;
	
	//@Column(name="email") 
	@Email(message = "Please enter valid email address")
	private String email;
	
	
	//@Column(name="department")
	@NotNull(message = "Department should not be null")
	private String department;
	
	@CreationTimestamp
	@Column(name="created_at", nullable = false, updatable = false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="update_at")
	private Date updateAt;



}
