package tk.ocb.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dish_ingredient")
public class DishIngredient {
	@Id
	@GeneratedValue
	@Column(name="dish_ingredient_id")
	private int DishIngredientId;
}
