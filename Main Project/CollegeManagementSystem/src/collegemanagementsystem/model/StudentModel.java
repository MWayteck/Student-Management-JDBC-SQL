package collegemanagementsystem.model;

public class StudentModel {

    int studentID;
    String studentName;
    String major;
    String sLevel;
    int age;

    public StudentModel() {
    }

    public StudentModel(int studentID, String studentName, String major, String sLevel, int age) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.major = major;
        this.sLevel = sLevel;
        this.age = age;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setsLevel(String sLevel) {
        this.sLevel = sLevel;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getMajor() {
        return major;
    }

    public String getsLevel() {
        return sLevel;
    }

    public int getAge() {
        return age;
    }

    public String toString(){
        return "Name: "+this.studentName+"\nMajor: "+this.major+"\nStudent level: "+this.sLevel+"\nAge: "+this.age;
    }
}
