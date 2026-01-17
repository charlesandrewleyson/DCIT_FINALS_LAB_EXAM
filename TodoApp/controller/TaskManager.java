package controller;


import model.Task;
import java.util.ArrayList;
import java.util.List;


public class TaskManager {
private List<Task> taskList = new ArrayList<>();


public void addTask(Task task) {
taskList.add(task);
}


public List<Task> getTasks() {
return taskList;
}


public int generateTaskId() {
return taskList.size() + 1;
}
}
