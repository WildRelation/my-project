package model.matcher;

import model.Task;
import model.TaskState;

public class NotDoneMatcher implements ITaskMatcher{
    TaskState state;
    public NotDoneMatcher(){
        this.state = TaskState.IN_PROGRESS;
    }

    @Override
    public boolean match(Task task) {
        return task.getState()==state;
    }
}
