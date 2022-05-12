package training.io.demospringboot.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "customer")
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	private String customer_name;
	private String address;
	private int sdt;
	
//	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY) // eager lay ca bang, con lazy chi lay cot ra thoi
//	private List<Product> products;
}

	

