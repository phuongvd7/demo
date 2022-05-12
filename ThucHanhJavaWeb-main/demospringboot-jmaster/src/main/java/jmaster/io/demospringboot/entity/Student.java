package jmaster.io.demospringboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//ORM: object relational mapping
@Entity
@Table(name = "sinhvien") // table trong sql
public class Student {

	@Id
	private int id;

	@Column(name = "name")
	private String name;

	@Column(unique = true)
	private String username;

	public Student() {
	}

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
