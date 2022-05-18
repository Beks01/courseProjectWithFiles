package exams;

import student.Students;

import java.util.Date;

public class Results extends Exams{
    private String studentName;
    private int mark;

    public Results() {
    }

    public Results(String subject, String teacher, Date date, String studentName, int mark) {
        super(subject, teacher, date);
        this.studentName = studentName;
        this.mark = mark;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Results{" +
                "studentName='" + studentName + '\'' +
                ", mark=" + mark +
                '}';
    }
}
