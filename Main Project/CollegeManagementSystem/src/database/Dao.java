package database;

import collegemanagementsystem.model.CourseModel;
import collegemanagementsystem.model.DepratmentModel;
import collegemanagementsystem.model.Enrollment;
import collegemanagementsystem.model.FacultyModel;
import collegemanagementsystem.model.Staff;
import collegemanagementsystem.model.StudentModel;
import java.util.List;

public interface Dao {
    public void addStaff(Staff staff);
    
    public void updateStaff(Staff staff);
    
    public void deleteStaff(int staffID);
    
    public Staff searchStaff(int searchID);
    
    public void updateStudent(StudentModel student);
    
    public Object searchStudent(String searchingTable, String searchingCriteria);
    
    public void enrollInCourse(Enrollment enrollment);
    
    public void addStudentModel(StudentModel student);
    
    public void updateStudentModel(StudentModel student);
    
    public List<StudentModel> getAllStudent();
    
    public StudentModel searchStudent(int studentId);
    
    public void deleteStudent(int studentId);
    
    public void addCourse(CourseModel course);
    
    public void updateCourse(CourseModel course);
    
    public List<CourseModel> getAllCourses();
    
    public CourseModel searchCourse(String courseId);
    
    public void deleteCourse(String courseId);
    
    public void addFaculty(FacultyModel faculty);
    
    public void updateFaculty(FacultyModel faculty);
    
    public void deleteFaculty(int facultyId);
    
    public FacultyModel searchFaculty(int facultyId);
    
    public List<FacultyModel> getAllFaculty();
    
    public void addEnrollement(Enrollment enrollment);
    
    public void updateEnrollemnet(Enrollment enrollment);
    
    public void deleteEnrollmenbt(int id);
    
    public Enrollment searchEnrollement(int id);
    
    public List<Enrollment> getAllEnrollemnets();
    
    
    public void addDepartmnet(DepratmentModel dept);
    
    public void updateDepartment(DepratmentModel dept);
    
    public void deleteDepartment(int id);
    
    public DepratmentModel searchDepartment(int id);
    
    public List<DepratmentModel> getAllDepartments();
    
   
    
    
    
   
    
}
