package subjects;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Показать список предметов (Показывает список предметов на котором
//учится студент)
public class SubjectsRepositoryFileImpl implements SubjectsRepository {

    private final String fileName;

    public SubjectsRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }

    //сохранить,добавить предмет
    @Override
    public void save(Subjects subjects) {
        try (Writer writer = new FileWriter
                (fileName, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(subjects.getTeacherName() + " " + subjects.getSubjectName() + " " + subjects.getMark());
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }


    // список всех предметов
    @Override
    public List<Subjects> findAll() {
        List<Subjects> subjects = new ArrayList<>();
        //Объявили переменные для доступа
        try (Reader reader = new FileReader(fileName); BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] parts = line.split("\\|");
                line = bufferedReader.readLine();
                String teacherName = parts[0];
                String subject = parts[1];
                int mark = Integer.parseInt(parts[2]);
                Subjects subjects1 = new Subjects(teacherName, subject, mark);
                subjects.add(subjects1);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        return subjects;
    }


//показывает список всех предметов на котором учится студент

    public List<String> listOfSubject(List<Subjects> subjects) {
        List<String> list = new ArrayList<>();
        for (Subjects subjects1 : subjects) {
            list.add(String.valueOf(subjects.get(1))); //
        }
        return list;
    }

    // показывает список оценок студента
    public List<String> listOfMarks(List<Subjects> subjects) {
        List<String> list = new ArrayList<>();
        for (Subjects subjects1 : subjects) {
            list.add(String.valueOf(subjects.get(1)) + " " + String.valueOf(subjects.get(2)));
        }
        return list;
    }


}
