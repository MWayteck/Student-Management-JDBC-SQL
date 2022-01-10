package collegemanagementsystem.model;

public class FacultyModel {
    int facultyID;
    String facultyName;
    int deptID;

    public FacultyModel() {
    }

    public FacultyModel(int facultyID, String facultyName, int deptID) {
        this.facultyID = facultyID;
        this.facultyName = facultyName;
        this.deptID = deptID;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    
    public int getFacultyID() {
        return facultyID;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public int getDeptID() {
        return deptID;
    }
    
    public  String toString(){
        return "Name: "+this.facultyName+"\nDepartment: "+this.deptID;
    }
}
