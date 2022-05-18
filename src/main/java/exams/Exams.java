package exams;

import java.util.Date;

public class Exams {
    private String subject;
    private String teacher;
    private Date date;


    public Exams() {
    }

    public Exams(String subject, String teacher, Date date) {
        this.subject = subject;
        this.teacher = teacher;
        this.date = date;

    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}