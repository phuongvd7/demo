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
@Table(name="ticket")
@Data
public class Ticket2 {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
	private String customerPhone;
	private String customerName;
	private Date createdAt;
	private Date processAt;
	
	@Column(name = "phoneNumber")
	private int phoneNumber;
	@Column(name = "customerReviews")
	private int customerReviews;
	@Column(name = "processingTime")
	private Date processingTime;
	
	@Column(name = "ticketContent")
	private String ticketContent;
	@Column(name = "status")
	private boolean status;
	@Column(name = "departmentId")
	private int departmentId;
}
	
	
	
	

