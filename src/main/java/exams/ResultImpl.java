package exams;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResultImpl {
    private final String fileName;

    public ResultImpl(String fileName) {
        this.fileName = fileName;
    }


    public void save(Results results) {
        try (Writer writer = new FileWriter
                (fileName, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(results.getSubject() + "|" + results.getTeacher() + "|" + results.getDate() + "|" + results.getMark());
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }


    public List<Results> findAll() {
        List<Results> results = new ArrayList<>();
        // Объявили переменные для доступа
        try (Reader reader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                Object[] parts = line.split("\\|");
                line = bufferedReader.readLine();
                String subject = (String) parts[0];
                String teacher = (String) parts[1];
                Date date = (Date) parts[2];
                String stuName = (String) parts[3];
                Integer mark = (Integer) parts[4];
                Results results1 = new Results(subject, teacher, date, stuName, mark);
                results.add(results1);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return results;
    }
}

