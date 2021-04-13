package com.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@XmlRootElement
@Table(name="employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

/*
 * { "empId": 4, "empLastname": "testln", "empFirstname": "testfn", "empSal":
 * 3.5, "age": 22, "started": 111, "createdAt": "2020-04-28T14:45:15.000+00:00",
 * "updatedAt": "2021-04-28T14:45:15.000+00:00", "active": true }
 */
public class Employee {
	
	
	@Id
	@GeneratedValue
	private Integer empId;
	private String empLastname;
	private String empFirstname;
	private Double empSal;
	private Integer age;
	private Integer started;
	private Date createdAt;
	private Date updatedAt;
	private Boolean active;
	private String email;
}
