/**
 * 
 */
package training.io.demospringboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author ngoc-anh
 *
 */
@Entity
@Table(name = "list_product")
@Data
public class ListProduct {
	@Id
	@Column(name = "listproduct_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double price;
	private int quantity;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
}
