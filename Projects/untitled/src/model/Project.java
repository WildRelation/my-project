package model;

import model.matcher.ITaskMatcher;
import model.matcher.PrioMatcher;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;


public class Project implements Comparable<Project>, Serializable {
    private String title;
    private final int id;
    private final String description;
    private final LocalDate created;
    private int nextTaskId;
    private final ArrayList<Task> tasks;

    Project(String title, String description, int id){
        this.title = title;
        this.description = description;
        this.id = id;
        nextTaskId = 0;
        tasks = new ArrayList<>();
        created = LocalDate.now();
    }

    public Task addTask(String description, Prio prio){
        Task newTask = new Task(description, prio, nextTaskId);
        tasks.add(newTask);
        nextTaskId++;
        return newTask;
    }

    public ArrayList<Task> findTasks(ITaskMatcher matcher){
        ArrayList<Task> result = new ArrayList<>();

        for(Task task : tasks){
            if(matcher.match(task)){
                result.add(task);
            }
        }
        return result;
    }

    //ArrayList<Task> prioResult = findTasks(new PrioMatcher(Prio.High));

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //Måste kolla om implemetationer på interfacet
    public ProjectState getProjectState(){
        if(tasks.isEmpty()) return ProjectState.EMPTY;
        int n = 0;
        for(Task task: tasks){
            if (task.getState()==TaskState.DONE) n++;
        }
        if(n==tasks.size()) return ProjectState.COMPLETED;
        return ProjectState.ONGOING;
    }

    public int getId() {
        return id;
    }

    public LocalDate getLastUpdated(){
        //fråga anders
        for(Task task: tasks){
            task.getLastUpdate();
        }
        return created;
    }

    public Task getTaskById(int id){
        for(Task task: tasks){
            if(task.getId()==id) return task;
        }
        return null;
    }

    public int getNextTaskId() {
        return nextTaskId;
    }

    @Override

    //fråga lärare
    public int compareTo(Project project){
        return this.title.compareTo(project.title);
    }

    @Override
    public String toString() {
        return "Project{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", nextTaskId=" + nextTaskId +
                ", tasks=" + tasks +
                '}';
    }
}


