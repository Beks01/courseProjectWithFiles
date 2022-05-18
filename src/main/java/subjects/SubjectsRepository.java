package subjects;

import java.util.List;

public interface SubjectsRepository {

    void save(Subjects subjects);

    List<Subjects> findAll();
}
