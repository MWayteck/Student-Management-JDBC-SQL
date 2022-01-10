package collegemanagementsystem.model;
public class CourseModel {
    String courseID;
    String courseName;
    String meets_at;
    String room;
    int limit;
    int facultyID;

    public CourseModel() {
    }

    public CourseModel(String courseID, String courseName, String meets_at, String room, int limit, int facultyID) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.meets_at = meets_at;
        this.room = room;
        this.limit = limit;
        this.facultyID = facultyID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setMeets_at(String meets_at) {
        this.meets_at = meets_at;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }

    
    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getMeets_at() {
        return meets_at;
    }

    public String getRoom() {
        return room;
    }

    public int getLimit() {
        return limit;
    }

    public int getFacultyID() {
        return facultyID;
    }
    public String toString(){
        return "Course Name: "+this.courseName+"\nMeets At: "+this.meets_at+"\nRoom: "+this.room+"\nLimit: "+this.limit;    }    
}
