package teacher;

public class Teachers {
    private String acType;
    private String login;
    private String password;
    private String fullName;
    private String subject;
    private Integer age;


    public Teachers() {
    }

    public Teachers(String acType, String login, String password, String fullName,String subject, Integer age) {
        this.acType = acType;
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.subject = subject;
        this.age = age;
    }

    public String getAcType() {
        return acType;
    }

    public void setAcType(String acType) {
        this.acType = acType;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teachers{" +
                "acType='" + acType + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", subject='" + subject + '\'' +
                ", age=" + age +
                '}';
    }
}
