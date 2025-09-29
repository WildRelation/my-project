package model;

import model.matcher.ITaskMatcher;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;


public class Project implements Comparable<Project>, Serializable {
    private String title;
    private final int id;
    private String description;
    private final LocalDate created;
    private int nextTaskId = 0;
    private ArrayList<Task> tasks;
    //private Random rand = new Random();

    public Project(String title, String description, int id){
        this.title = title;
        this.description = description;
        this.id = id;
        tasks = new ArrayList<>();
        created = LocalDate.now();
    }

    public Task addTask(String description, Prio prio){
        //int id = rand.nextInt(999)+100;
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
        return created;
    }

    public Task getTaskById(int id){
        Task mytask = new Task("jio", Prio.High, 83);
        return mytask;
    }

    public int getNextTaskId() {
        return nextTaskId;
    }

    @Override
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


