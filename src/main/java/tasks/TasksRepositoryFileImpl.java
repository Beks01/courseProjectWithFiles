package tasks;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TasksRepositoryFileImpl implements TasksRepository {

    private final String fileName;

    public TasksRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public void save(Tasks tasks) {
        try (Writer writer = new FileWriter
                (fileName, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(tasks.getSubject() + "|" + tasks.getTask() + "|" + tasks.getSince() + "|" + tasks.getDeadline());
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Tasks> findAll() {
        List<Tasks> tasks = new ArrayList<>();
        //Объявили переменные для доступа
        try (Reader reader = new FileReader(fileName); BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] parts = line.split("\\|");
                line = bufferedReader.readLine();
                String subject = parts[0];
                String task = parts[1];
                LocalDate since = LocalDate.parse(parts[2]);
                Date deadline = new Date(parts[3]);
                Tasks tasks1 = new Tasks(subject, task, since, deadline);
                tasks.add(tasks1);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        return tasks;
    }
}
