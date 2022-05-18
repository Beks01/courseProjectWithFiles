package tasks;

import junit.framework.TestCase;

public class TasksRepositoryFileImplTest extends TestCase {
    TasksRepositoryFileImpl tasksRepositoryFile = new TasksRepositoryFileImpl("Tasks.txt");

    public TasksRepositoryFileImpl getTasksRepositoryFile() {
        return tasksRepositoryFile;
    }

}