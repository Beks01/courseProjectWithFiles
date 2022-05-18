package tasks;

import java.time.LocalDate;
import java.util.Date;

public class Tasks {
    private String subject;
    private String task;
    private LocalDate since;
    private Date deadline;

    public Tasks() {
    }

    public Tasks(String subject, String task, LocalDate since, Date deadline) {
        this.subject = subject;
        this.task = task;
        this.since = since;
        this.deadline = deadline;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getSince() {
        return since;
    }

    public void setSince(LocalDate since) {
        this.since = since;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "subject='" + subject + '\'' +
                ", task='" + task + '\'' +
                ", since=" + since +
                ", deadline=" + deadline +
                '}';
    }
}
