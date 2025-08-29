import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Todo {
    private final String title;
    private String description;
    private boolean done;
    private LocalDateTime time = LocalDateTime.now();
    private final DateTimeFormatter timeFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT);
    private final String myTime = time.format(timeFormat)+"\n";

    private void updateTime(){
        time = LocalDateTime.now();
    }

    public Todo(String tittle, String description){
        time = LocalDateTime.now();
        this.title = tittle;
        this.description = myTime + description;
        done = false;
    }

    public void updateDescription(String description){
        updateTime();
        this.description += myTime + description;
    }

    public String getDescription(){
        return description;
    }

    public boolean taskDone(){
        done = true;
        return done;
    }

    @Override
    public String toString(){
        return String.format("Tittle: %s\nTask created: %sDescription: %s\nDone? %s", title, myTime, description, taskDone());
    }
}
