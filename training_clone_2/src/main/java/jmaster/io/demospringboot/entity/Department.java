package jmaster.io.demospringboot.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "department")
@Data
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "{ValidationMessages.properties}")
	@Size(max=3, message  = "fail")
	private String name;
	private Date createdAt;
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY) // eager lay ca bang, con lazy chi lay cot ra thoi
	private List<Ticket> tickets;
}
