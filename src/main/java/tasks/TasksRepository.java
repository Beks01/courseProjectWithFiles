package tasks;

import java.util.List;

public interface TasksRepository {
    void save(Tasks tasks);

    List<Tasks> findAll();
}
