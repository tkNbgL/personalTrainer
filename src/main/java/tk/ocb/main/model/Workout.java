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

import tk.ocb.main.modelEnums.Difficulty;
import tk.ocb.main.modelEnums.Duration;
import tk.ocb.main.modelEnums.Intensity;

@Entity
@Table(name="workout")
public class Workout {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="workout_id")
	private int id;
	
	@Column(name="work_out_name", nullable=false, length=100)
	private String workOutName;
	
	@Column(name="duration", nullable=true)
	private Duration duration;
	
	@Column(name="difficulty", nullable=true)
	private Difficulty difficulty;
	
	@Column(name="intensity", nullable=true)
	private Intensity intensity;
		
	@ManyToMany
	@JoinTable(
		name="wokout_exercise",
		joinColumns = @JoinColumn(name = "workout_id", nullable=true),
		inverseJoinColumns = @JoinColumn(name = "exercise_id", nullable=true))
	private List<Exercise> exercises;
	
	@ManyToMany(mappedBy = "workouts")
	private List<UserInformation> userInformation;

	
	
	public Workout() {	}

	public Workout(int id, String workOutName, Duration duration, Difficulty difficulty, Intensity intensity,
			List<Exercise> exercises, List<UserInformation> userInformation) {
		super();
		this.id = id;
		this.workOutName = workOutName;
		this.duration = duration;
		this.difficulty = difficulty;
		this.intensity = intensity;
		this.exercises = exercises;
		this.userInformation = userInformation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWorkOutName() {
		return workOutName;
	}

	public void setWorkOutName(String workOutName) {
		this.workOutName = workOutName;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public Intensity getIntensity() {
		return intensity;
	}

	public void setIntensity(Intensity intensity) {
		this.intensity = intensity;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

	public List<UserInformation> getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(List<UserInformation> userInformation) {
		this.userInformation = userInformation;
	}	
	
	
	
}
