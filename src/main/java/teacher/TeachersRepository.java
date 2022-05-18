package teacher;

import student.Students;

import java.util.List;

public interface TeachersRepository {
    void save(Teachers teachers);
    List<Teachers> findAll();

}
