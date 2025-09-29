package model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class ProjectsManager {
    private int nextProjectId;
    private ArrayList<Project> projects;
    //private Random rand = new Random();

    public ProjectsManager(){
        projects = new ArrayList<>();
        nextProjectId = 0;
    }
    public void setProjects(ArrayList<Project> incomingProjects) {
        projects.clear();
        projects.addAll(incomingProjects);
        nextProjectId = projects.getLast().getId()+1;//CHECKA ESTO xd
    }

    public Project addProject(String title, String description)throws TitleNotUniqueException{

        if(!isTitleUnique(description)) throw new TitleNotUniqueException("Not unique title") ;
        //int id = rand.nextInt(999)+100;
        projects.add(new Project(title, description, nextProjectId));
        nextProjectId++;
        return projects.getLast();
    }

    public boolean isTitleUnique(String title){
        for (Project project : projects) {
            if (Objects.equals(project.getTitle(), title)) return false;
        }
        return true;
    }

    public void removeProject(Project project){
        projects.remove(project);
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }


    public Project getProjectById(int id){
        for (int i = 0; i < projects.size(); i++) {
            if(projects.get(i).getId()==id) return projects.get(i);
        }
        return null;
    }
    public ArrayList<Project> findProjects(String titleStr){
        for(Project project:projects){
            project.equals(project);
        }
        return projects;
    }


    private int getHighestId(){
        return nextProjectId-1;
    }

    @Override
    public String toString() {
        return "projects = " + projects;
    }
}
