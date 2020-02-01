package tk.ocb.main.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import tk.ocb.main.modelEnums.TargetBody;

@Entity
@Table(name="exercise")
public class Exercise {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="exercise_id")
	private int id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private TargetBody target;
	
	@ManyToMany(mappedBy = "exercises")
	private List<Workout> workouts;
	
	@ManyToMany
	@JoinTable(
		name="exercise_equipment",
		joinColumns = @JoinColumn(name = "exercise_id", nullable=true),
		inverseJoinColumns = @JoinColumn(name = "equip_id", nullable=true))
	private List<Equipment> equipments;

	public Exercise() {	}

	public Exercise(int id, String name, TargetBody target, List<Workout> workouts, List<Equipment> equipments) {
		super();
		this.id = id;
		this.name = name;
		this.target = target;
		this.workouts = workouts;
		this.equipments = equipments;
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

	public TargetBody getTarget() {
		return target;
	}

	public void setTarget(TargetBody target) {
		this.target = target;
	}

	public List<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	
	
}
