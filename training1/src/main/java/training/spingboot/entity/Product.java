package training.spingboot.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int product_id;
	private String product_name;
	private long price;
	private String category;
	
//	@ManyToOne
//@JoinColumn(name = "customer_id")
//private Customer customer;

}
