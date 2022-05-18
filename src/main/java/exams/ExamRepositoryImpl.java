package exams;

import student.Students;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamRepositoryImpl implements ExamRepository{
    private final String fileName;

    public ExamRepositoryImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(Exams exams) {
        try (Writer writer = new FileWriter
                (fileName, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(exams.getSubject()+"|"+exams.getTeacher()+"|"+exams.getDate());
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Exams> findAll() {
        List<Exams> exams = new ArrayList<>();
        //Объявили переменные для доступа
        try (Reader reader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                Object[] parts = line.split("\\|");
                line = bufferedReader.readLine();
                String subject = (String) parts[0];
                String teacher = (String) parts[1];
                Date date = (Date) parts[2];
                Exams exams1 = new Exams(subject,teacher,date);
                exams.add(exams1);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return exams;
    }
}
