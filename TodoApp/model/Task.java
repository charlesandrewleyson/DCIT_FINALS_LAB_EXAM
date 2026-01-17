package model;


public class Task extends AbstractTask {


public enum Status {
NOT_STARTED, ONGOING, DONE
}


private Status status;


public Task() {
this.status = Status.NOT_STARTED;
}


public Task(int id, String name, String description, Status status) {
super(id, name, description);
this.status = status;
}


@Override
public String getStatus() {
return status.name();
}


@Override
public void setStatus(String status) {
this.status = Status.valueOf(status);
}


public Status getStatusEnum() {
return status;
}


public void setStatusEnum(Status status) {
this.status = status;
}
}