package teacher;

import student.Students;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TeachersRepositoryFileImpl implements TeachersRepository {


    private final String fileName;


    public TeachersRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public void save(Teachers teachers) {
        try (Writer writer = new FileWriter(fileName, true); BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(teachers.getAcType() + "|" + teachers.getLogin() + "|" + teachers.getPassword()+"|"+teachers.getFullName()+"|"+teachers.getAge());
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Teachers> findAll() {
        List<Teachers> teachers = new ArrayList<>();
        //Объявили переменные для доступа
        try (Reader reader = new FileReader(fileName); BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] parts = line.split("\\|");
                line = bufferedReader.readLine();
                String acType = parts[0];
                String login = parts[1];
                String password = parts[2];
                String fullName = parts[3];
                String sub = parts[4];
                Integer age = Integer.parseInt(parts[5]);
                Teachers teachers1 = new Teachers(acType,login,password,fullName,sub,age);
                teachers.add(teachers1);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        return teachers;
    }
}
