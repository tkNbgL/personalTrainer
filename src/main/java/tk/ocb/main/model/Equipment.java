package tk.ocb.main.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="equipment")
public class Equipment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="equipment_id")
	private int id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private int weight;
	
	@ManyToMany(mappedBy = "equipments")
	private List<Exercise> exercises;
	
	public Equipment() { }

	public Equipment(int id, String name, int weight, List<Exercise> exercises) {
		super();
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.exercises = exercises;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
	
	
}
