package jmaster.io.demospringboot.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;	
	private String content;
	private String processContent;
	private String customerPhone;
	private String customerName;
	private Date createdAt;
	private Date processAt;
	private boolean status;	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
}
