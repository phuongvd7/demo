package jmaster.io.demospringboot.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	// can tao them danh sach ticket kem theo
	@OneToMany(mappedBy = "department1", fetch = FetchType.LAZY) // lazy la khi nao dung den thi moi select, con khong thi thoi eager tu dong lay het
	//map voi thang department1 ben ticket,  fetch chi select may thuoc tinh ben department, khong select ben kia nua
	private List<Ticket> tickets;
	
}

