package student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class StudentsRepositoryFileImpl implements StudentsRepository {
    private final String fileName;

    public StudentsRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(Students students) {
        try (Writer writer = new FileWriter
                (fileName, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(students.getAcType() + "|" + students.getLogin() + "|" + students.getPassword() + "|" + students.getFullName() + "|" + students.getAge());
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Students> findAll() {
        List<Students> students = new ArrayList<>();
        //Объявили переменные для доступа
        try (Reader reader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                Object[] parts = line.split("\\|");
                line = bufferedReader.readLine();
                String acType = (String) parts[0];
                String login = (String) parts[1];
                String password = (String) parts[2];
                String fullName = (String) parts[3];
                Integer age = Integer.parseInt((String) parts[4]);
                Students students1 = new Students(acType, login, password, fullName, age);
                students.add(students1);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        return students;
    }
}

