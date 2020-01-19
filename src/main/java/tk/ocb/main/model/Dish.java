package tk.ocb.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dish")
public class Dish {
	@Id
	@GeneratedValue
	@Column(name="dish_id")
	private int dishId;
	
	@Column(name="name")
	private String name;
}
