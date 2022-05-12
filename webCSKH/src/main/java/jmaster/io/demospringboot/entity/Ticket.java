package jmaster.io.demospringboot.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="ticket")
@Data
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
	private String customerPhone;
	private String customerName;
	private String content;
	private String processContent;
	private Date createdAt;
	private Date processAt;
	private boolean status;
	
	
	@ManyToOne  // nhieu ticket 1 department // onetoone tuong duong manyto one
	@JoinColumn(name = "department_id") // chi ra ten cot duoc join / department_id la khoa phu
	private Department department1;
	


}
	

	
	

