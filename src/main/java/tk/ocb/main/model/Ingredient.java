package tk.ocb.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ingredient")
public class Ingredient {
	@Id
	@GeneratedValue
	@Column(name="ingredient_id")
	private int ingredientId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="calories_pergr", nullable=false)
	private long caloriesPer100gr;
}
