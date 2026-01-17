package model;


public class TimedTask extends Task {
private int estimatedMinutes;


public TimedTask(int id, String name, String description, Status status, int minutes) {
super(id, name, description, status);
this.estimatedMinutes = minutes;
}


public int getEstimatedMinutes() {
return estimatedMinutes;
}


public void setEstimatedMinutes(int estimatedMinutes) {
this.estimatedMinutes = estimatedMinutes;
}
}