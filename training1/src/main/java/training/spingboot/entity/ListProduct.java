//package training.spingboot.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import lombok.Data;
//
//@Entity
//@Table(name = "listproduct")
//@Data
//public class ListProduct {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	
//	private int id_listproduct;
//	private int quantity;
//
//	@ManyToOne()
//	@JoinColumn(name = "product_id")
//	private Product product;
//
//	@ManyToOne()
//	@JoinColumn(name = "customer_id")
//	private Customer customer;
//
//}
