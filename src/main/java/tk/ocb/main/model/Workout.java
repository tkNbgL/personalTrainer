package tk.ocb.main.model;

import java.util.List;

import tk.ocb.main.modelEnums.Difficulty;
import tk.ocb.main.modelEnums.Duration;
import tk.ocb.main.modelEnums.Intensity;

public class Workout {
	private int id;
	private String workOutName;
	private Duration duration;
	private Difficulty difficulty;
	private Intensity intensity;
	private List<Equipment> equipment;
	private List<Exercise> exercises;
}
