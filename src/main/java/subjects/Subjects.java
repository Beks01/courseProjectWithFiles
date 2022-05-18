package subjects;

public class Subjects {
    private String teacherName;
    private String subjectName;
    private int mark;

    public Subjects() {
    }

    public Subjects(String teacherName, String subjectName, int mark) {
        this.teacherName = teacherName;
        this.subjectName = subjectName;
        this.mark = mark;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "teacherName='" + teacherName + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
