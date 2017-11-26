package Logic;

public class Achievement {
	private String name;
	private String description;
	//progress is a double that can be used when a user has completed only part of an achievement
	private double progress;
	public Achievement(String name, String description){
		this.name = name;
		this.description = description;
		progress = 0;
	}
	public String getName(){
		return name;
	}
	public String getDescription(){
		return description;
	}
	//if progress is over one it means that the user has gotten the achievement
	public boolean isAchieved(){
		return (progress >= 1.0);
	}
	public void addToProgress(double num){
		progress += num;
	}
	public double getProgress(){
		return progress;
	}
}
