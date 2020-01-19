package tk.ocb.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fruit")
public class Fruit {
	@Id
	@GeneratedValue
	@Column(name="fruit_id")
	private int fruitId;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="calories_pergr", nullable=false)
	private long caloriesPer100gr;
}
