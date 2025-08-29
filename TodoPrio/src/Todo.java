import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.FormatStyle.SHORT;

public class Todo {
    //instance fields
    private final String title;
    private String description;
    private boolean status;
    private LocalDateTime time;
    private final Priority priority;

    public Todo(String title, String description, Priority priority){
        this.title = title;
        this.description = description;
        this.priority = priority;
        time = LocalDateTime.now();
        status = false;
    }
    public Todo(String title, String description){
        this.title = title;
        this.description = description;
        priority = Priority.MEDIUM;
        time = LocalDateTime.now();
        status = false;
    }

    public String getPriority(){
        return String.format(""+ priority);
    }

    private void updateTime(){
        time = LocalDateTime.now();
    }
    public void doneTask(){
        status = true;
    }

    public void updateDescription(String description){
        this.description += "\n" + description;
        updateTime();
    }

    public String getDescription(){
        return description;
    }

    public String getTitle(){
        return title;
    }

    public String getDate(){
        DateTimeFormatter myFormat = DateTimeFormatter.ofLocalizedDateTime(SHORT, SHORT);
        return time.format(myFormat);
    }

    public boolean getStatus(){
        return status;
    }

    @Override

    public String toString(){
        return String.format("Tittle: %s \nDescription:\n%s\nLast time updated: %s\nPriority: %s\nDone: %s",
                getTitle(), getDescription(), getDate(), getPriority(), getStatus());
    }

}
