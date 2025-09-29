package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Comparable<Task>, Serializable{
    private final String description;
    private final int id;
    private String takenBy;
    private TaskState state;
    private LocalDate lastUpdate;
    private Prio prio;

    public Task(String description, Prio prio, int id){
        this.description = description;
        this.prio = prio;
        this.id = id;
        this.takenBy = null;
        lastUpdate = LocalDate.now();
    }

    public void setTakenBy(String takenBy) {
        if(this.takenBy!=null) throw new IllegalStateException("Task taken already by another person");
        this.takenBy = takenBy;
    }

    public void setLastUpdate(int hr){
        this.lastUpdate = LocalDate.now();
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public void setPrio(Prio prio) {
        this.prio = prio;
    }

    public String getTakenBy() {
        return takenBy;
    }

    public Prio getPrio() {
        return prio;
    }

    @Override
    public int compareTo(Task task){
        //First key, prio
        int result = this.prio.compareTo(task.prio);
        if (result==0){
            System.out.println("same prio");
            // second key, description
            result = this.description.compareTo(task.description);
        }
        return result;
    }

    public TaskState getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", takenBy='" + takenBy + '\'' +
                ", state=" + state +
                ", lastUpdate=" + lastUpdate +
                ", prio=" + prio +
                '}';
    }
}
