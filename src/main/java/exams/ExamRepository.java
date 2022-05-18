package exams;

import student.Students;

import java.util.List;

public interface ExamRepository {
    void save(Exams exams);

    List<Exams> findAll();
}
