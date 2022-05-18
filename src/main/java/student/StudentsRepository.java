package student;

import java.util.List;

public interface StudentsRepository {

    void save(Students students);

    List<Students> findAll();

}
