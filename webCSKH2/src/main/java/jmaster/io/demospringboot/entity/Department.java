package jmaster.io.demospringboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "department")
@Data
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // chay lan dau se tao ra cot id , khoa chinh , kieu int, va tich vao cot AI
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "startDate")
	private Date startDate;
	
}

