package database;

import collegemanagementsystem.model.CourseModel;
import collegemanagementsystem.model.DepratmentModel;
import collegemanagementsystem.model.Enrollment;
import collegemanagementsystem.model.FacultyModel;
import collegemanagementsystem.model.Staff;
import collegemanagementsystem.model.StudentModel;
import collegemanagementsystem.student.StudentEnrollment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseHandler implements Dao {

    Connection dbConnection = DatabaseInstance.getConnection();

    @Override
    public void addStaff(Staff staff) {
        try {
            int sID = staff.getStaffId();
            String sname = staff.getStaffname();
            int deptID = staff.getDeptId();

            String sql = "INSERT INTO staff VALUES('" + sID + "', '" + sname + "', '" + deptID + "')";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Staff Added Record");
            } else {
                System.out.println("Error in inserting Staff record");
            }
        } catch (SQLException ex) {
            System.out.println("Exception in Inserting Staff");
        }
    }

    @Override
    public void updateStaff(Staff staff) {
        try {

            int sID = staff.getStaffId();
            String sname = staff.getStaffname();
            int deptID = staff.getDeptId();

            String sql = "UPDATE staff set sname  = ?, depid = ? WHERE sid = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            preparedStatement.setInt(3, sID);
            preparedStatement.setString(1, sname);
            preparedStatement.setInt(2, deptID);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Staff Update Record");
            } else {
                System.out.println("Error in updating Staff record");
            }
        } catch (SQLException ex) {
            System.out.println("Exception in Updating Staff");
        }
    }

    @Override
    public Staff searchStaff(int searchID) {
        Staff staff = new Staff();
        try {
            String sql = "SELECT * FROM staff";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (rs.getInt("sid") == searchID) {
                    int sid = rs.getInt("sid");
                    String sname = rs.getString("sname");
                    int depid = rs.getInt("depid");

                    staff.setStaffId(sid);
                    staff.setStaffname(sname);
                    staff.setDeptId(depid);
                }
            }

        } catch (SQLException ex) {
            System.out.println("Exception in Searching staff");
        }

        return staff;
    }

    @Override
    public void deleteStaff(int staffID) {
        try {
            String sql = "DELETE FROM staff WHERE sid = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);

            preparedStatement.setInt(1, staffID);

            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Staff Deleted Record");
            } else {
                System.out.println("Error in Deleting Staff record");
            }
        } catch (SQLException ex) {
            System.out.println("Exception in Deleting Staff record: " + ex.getMessage());
        }
    }

    @Override
    public void enrollInCourse(Enrollment enrollment) {
        try {
            String sql = "INSERT INTO enrollment VALUES('" + enrollment.getSid() + "', '" + enrollment.getCid() + "', '" + enrollment.getExam1() + "', "
                    + "'" + enrollment.getExam2() + "', '" + enrollment.getFinals() + "')";

            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Studen is enrolled In Course");
            } else {
                System.out.println("Error in enrollment");
            }
        } catch (SQLException ex) {
            System.out.println("Exception occured in Enrollment: " + ex.getMessage());
        }
    }

    @Override
    public Object searchStudent(String searchingTable, String searchCriteria) {
        CourseModel course = new CourseModel();
        Enrollment enrollment = new Enrollment();
        FacultyModel faculty = new FacultyModel();
        DepratmentModel department = new DepratmentModel();
        try {
            String sql = "SELECT * FROM " + searchingTable;
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            if (searchingTable.equals("courses")) {
                while (rs.next()) {
                    if (rs.getString("cid").equals(searchCriteria)) {
                        String cid = rs.getString("cid");
                        String cname = rs.getString("cname");
                        String meetsAt = rs.getString("meets_at");
                        String room = rs.getString("room");
                        int limit = rs.getInt("limits");
                        int facultyID = rs.getInt("fid");

                        course.setCourseID(cid);
                        course.setCourseName(cname);
                        course.setMeets_at(meetsAt);
                        course.setRoom(room);
                        course.setLimit(limit);
                        course.setFacultyID(facultyID);
                        return course;
                    }

                }
            } else if (searchingTable.equals("enrollement")) {
                while (rs.next()) {
                    if (rs.getInt("exam1") == Integer.parseInt(searchCriteria)) {
                        int sid = rs.getInt("sid");
                        String cid = rs.getString("cid");
                        int exam1 = rs.getInt("exam1");
                        int exam2 = rs.getInt("exam2");
                        int finals = rs.getInt("final");

                        enrollment.setCid(cid);
                        enrollment.setSid(sid);
                        enrollment.setExam1(exam1);
                        enrollment.setExam2(exam2);
                        enrollment.setFinals(finals);

                        return enrollment;
                    }

                }

            } else if (searchingTable.equals("faculty")) {
                while (rs.next()) {
                    if (rs.getString("fname").equals(searchCriteria)) {
                        int fid = rs.getInt("fid");
                        String fname = rs.getString("fname");
                        int depid = rs.getInt("depid");

                        faculty.setFacultyID(fid);
                        faculty.setFacultyName(fname);
                        faculty.setDeptID(depid);

                        return faculty;
                    }

                }

            } else if (searchingTable.equals("department")) {
                while (rs.next()) {
                    System.out.println(rs.getString("dname"));
                    if (rs.getString("dname").equals(searchCriteria)) {
                        int depid = rs.getInt("did");
                        String dname = rs.getString("dname");

                        department.setDid(depid);
                        department.setDname(dname);

                        return department;
                    }

                }
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
    @Override
    public void updateStudent(StudentModel student) {
        try {
            int sid = student.getStudentID();
            String sql = "UPDATE student set sname  = ?, major = ?, s_level = ?, age = ? WHERE sid = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            preparedStatement.setInt(5, sid);
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setString(3, student.getsLevel());
            preparedStatement.setString(2, student.getMajor());
            preparedStatement.setInt(4, student.getAge());

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Staff Update Record");
            } else {
                System.out.println("Error in updating Staff record");
            }
        } catch (SQLException ex) {
            System.out.println("Exception in Updating Staff");
        }
    }

    public List<StudentModel> getAllStudents() {
        List<StudentModel> students = new ArrayList<>();
        try {
            String sql = "SELECT * FROM student";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int sid = rs.getInt("sid");
                String sname = rs.getString("sname");
                String major = rs.getString("major");
                String sLevel = rs.getString("s_level");
                int age = rs.getInt("age");

                StudentModel student = new StudentModel(sid, sname, major, sLevel, age);
                students.add(student);

            }

        } catch (SQLException ex) {
            System.out.println("Exception in getting Students");
        }

        return students;
    }

    public List<DepratmentModel> getAllDepartment() {
        List<DepratmentModel> departments = new ArrayList<>();
        try {
            String sql = "SELECT * FROM department";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int did = rs.getInt("did");
                String dname = rs.getString("dname");

                DepratmentModel department = new DepratmentModel(did, dname);
                departments.add(department);

            }

        } catch (SQLException ex) {
            System.out.println("Exception in getting Departments");
        }

        return departments;
    }

    public List<FacultyModel> getAllFacultyModel() {
        List<FacultyModel> facultyMembers = new ArrayList<>();
        try {

            String sql = "SELECT * FROM faculty";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int fid = rs.getInt("fid");
                String fname = rs.getString("fname");
                int depid = rs.getInt("depid");

                FacultyModel faculty = new FacultyModel(fid, fname, depid);
                facultyMembers.add(faculty);

            }

        } catch (SQLException ex) {
            System.out.println("Exception in getting Faculty");
        }

        return facultyMembers;
    }

    public List<CourseModel> getAllCourses() {
        List<CourseModel> courses = new ArrayList<>();
        try {

            String sql = "SELECT * FROM courses";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("cid");
                String cname = rs.getString("cname");
                String meets_at = rs.getString("meets_at");
                String room = rs.getString("room");
                int limit = rs.getInt("limits");
                int fid = rs.getInt("fid");

                CourseModel course = new CourseModel(id, cname, meets_at, room, limit, fid);
                courses.add(course);

            }

        } catch (SQLException ex) {
            System.out.println("Exception in getting courses");
        }

        return courses;
    }

    public List<Staff> getAllStaff() {
        List<Staff> staffList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM staff";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int sid = rs.getInt("sid");
                String sname = rs.getString("sname");
                int depid = rs.getInt("depid");

                Staff staff = new Staff(sid, sname, depid);
                staffList.add(staff);

            }

        } catch (SQLException ex) {
            System.out.println("Exception in getting Staff");
        }

        return staffList;
    }

    public List<Enrollment> getAllEnrolledStudents() {
        List<Enrollment> enrrolledStudents = new ArrayList<>();
        try {
            String sql = "SELECT * FROM enrollement";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int sid = rs.getInt("sid");
                String cid = rs.getString("cid");
                int exam1 = rs.getInt("exam1");
                int exam2 = rs.getInt("exam2");
                int finals = rs.getInt("final");

                Enrollment enrolledStudent = new Enrollment(sid, cid, exam1, exam2, finals);
                enrrolledStudents.add(enrolledStudent);
            }

        } catch (SQLException ex) {
            System.out.println("Exception in getting Enrolled Students");
        }

        return enrrolledStudents;
    }

    @Override
    public void addStudentModel(StudentModel student) {
        try {
            int sid = student.getStudentID();
            String sname = student.getStudentName();
            String major = student.getMajor();
            String s_level = student.getsLevel();
            int age = student.getAge();

            String sql = "INSERT INTO student VALUES('" + sid + "', '" + sname + "', '" + major + "', '" + s_level + "', '" + age + "')";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Student inserted successfully");
            } else {
                System.out.println("Student could not be stored !");
            }
        } catch (SQLException ex) {
            System.out.println("Exception in inserting Student: " + ex.getMessage());
        }
    }

    @Override
    public void updateStudentModel(StudentModel student) {
        try {

            int sID = student.getStudentID();
            String sname = student.getStudentName();
            String major = student.getMajor();
            String sLevel = student.getsLevel();
            int age = student.getAge();

            String sql = "UPDATE student set sname  = ?, major = ?, s_level = ?, age = ? WHERE sid = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            preparedStatement.setInt(5, sID);
            preparedStatement.setString(1, sname);
            preparedStatement.setString(2, major);
            preparedStatement.setString(3, sLevel);
            preparedStatement.setInt(4, age);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Student Update Record");
            } else {
                System.out.println("Error in updating Student record");
            }
        } catch (SQLException ex) {
            System.out.println("Exception in Updating Student");
        }
    }

    @Override
    public List<StudentModel> getAllStudent() {
        List<StudentModel> students = new ArrayList<>();
        try {
            String sql = "SELECT * FROM student";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int sid = rs.getInt("sid");
                String sname = rs.getString("sname");
                String major = rs.getString("major");
                String s_level = rs.getString("s_level");
                int age = rs.getInt("age");

                StudentModel student = new StudentModel(sid, sname, major, s_level, age);
                students.add(student);
            }
        } catch (SQLException ex) {
            System.out.println("Exception in getting all students");
        }
        return students;
    }

    @Override
    public StudentModel searchStudent(int studentId) {
        StudentModel student = new StudentModel();
        try {
            String sql = "SELECT * FROM student";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (rs.getInt("sid") == studentId) {
                    int sID = rs.getInt("sid");
                    String sname = rs.getString("sname");
                    String major = rs.getString("major");
                    String sLevel = rs.getString("s_level");
                    int age = rs.getInt("age");

                    student.setStudentID(studentId);
                    student.setStudentName(sname);
                    student.setMajor(major);
                    student.setsLevel(sLevel);
                    student.setAge(age);
                }
            }

        } catch (SQLException ex) {
            System.out.println("Exception in Searching staff");
        }

        return student;
    }

    @Override
    public void deleteStudent(int studentId) {
        try {
            String sql = "DELETE FROM student WHERE sid = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);

            preparedStatement.setInt(1, studentId);

            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Student Deleted Record");
            } else {
                System.out.println("Error in Deleting Student record");
            }
        } catch (SQLException ex) {
            System.out.println("Exception in Deleting Student record: " + ex.getMessage());
        }
    }

    @Override
    public void addCourse(CourseModel course) {
        try {
            String cid = course.getCourseID();
            String cname = course.getCourseName();
            String meets_at = course.getMeets_at();
            String room = course.getRoom();
            int limit = course.getLimit();
            int faculty = course.getFacultyID();

            String sql = "INSERT INTO courses VALUES('" + cid + "', '" + cname + "', '" + meets_at + "', '" + room + "', '" + limit + "', '" + faculty + "')";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Course inserted successfully");
            } else {
                System.out.println("Course could not be stored !");
            }
        } catch (SQLException ex) {
            System.out.println("Exception in inserting Course: " + ex.getMessage());
        }
    }

    @Override
    public void updateCourse(CourseModel course) {
        try {

            String cid = course.getCourseID();
            String cname = course.getCourseName();
            String meets_at = course.getMeets_at();
            String room = course.getRoom();
            int limit = course.getLimit();
            int faculty = course.getFacultyID();

            String sql = "UPDATE courses set cname  = ?, meets_at = ?, room = ?, limit = ?, fid = ? WHERE cid = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            preparedStatement.setString(6, cid);
            preparedStatement.setString(1, cname);
            preparedStatement.setString(2, meets_at);
            preparedStatement.setString(3, room);
            preparedStatement.setInt(4, limit);
            preparedStatement.setInt(5, faculty);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Course Update Record");
            } else {
                System.out.println("Error in updating Course record");
            }
        } catch (SQLException ex) {
            System.out.println("Exception in Updating Course");
        }
    }

    @Override
    public CourseModel searchCourse(String courseId) {
        CourseModel course = new CourseModel();
        try {
            String sql = "SELECT * FROM courses";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equals(courseId)) {
                    String sID = rs.getString("cid");
                    String cname = rs.getString("cname");
                    String meets_at = rs.getString("meets_at");
                    String room = rs.getString("room");
                    int limit = rs.getInt("limit");
                    int fid = rs.getInt("fid");

                    course.setCourseID(courseId);
                    course.setCourseName(cname);
                    course.setMeets_at(meets_at);
                    course.setRoom(room);
                    course.setLimit(limit);
                    course.setFacultyID(fid);
                }
            }

        } catch (SQLException ex) {
            System.out.println("Exception in Searching Student record: " + ex.getMessage());
        }
        return course;
    }

    @Override
    public void deleteCourse(String courseId) {
        try {
            String sql = "DELETE FROM courses WHERE cid = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);

            preparedStatement.setString(1, courseId);

            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Course Deleted Record");
            } else {
                System.out.println("Error in Deleting Course record");
            }
        } catch (SQLException ex) {
            System.out.println("Exception in Deleting Course record: " + ex.getMessage());
        }
    }

    @Override
    public void addFaculty(FacultyModel faculty) {
        try {
            int fid = faculty.getFacultyID();
            String fname = faculty.getFacultyName();
            int deptID = faculty.getDeptID();

            String sql = "INSERT INTO faculty VALUES('" + fid + "', '" + fname + "', '" + deptID + "')";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Faculty inserted successfully");
            } else {
                System.out.println("Faculty could not be stored !");
            }
        } catch (SQLException ex) {
            System.out.println("Exception in inserting Faculty: " + ex.getMessage());
        }
    }

    @Override
    public void updateFaculty(FacultyModel faculty) {
        try {
            int fid = faculty.getFacultyID();
            String fname = faculty.getFacultyName();
            int deptID = faculty.getDeptID();

            String sql = "UPDATE faculty set fname  = ?, depid = ? were fid=?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            preparedStatement.setInt(3, fid);
            preparedStatement.setString(1, fname);
            preparedStatement.setInt(2, deptID);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Faculty Update Record");
            } else {
                System.out.println("Error in updating Faculty record");
            }
        } catch (SQLException ex) {
            System.out.println("Exception in updating Faculty");
        }

    }

    @Override
    public void deleteFaculty(int facultyId) {
        try {
            String sql = "DELETE FROM faculty WHERE fid = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);

            preparedStatement.setInt(1, facultyId);

            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Faculty Deleted Record");
            } else {
                System.out.println("Error in Deleting Faculty record");
            }
        } catch (SQLException ex) {
            System.out.println("Exception in Deleting Faculty record: " + ex.getMessage());
        }
    }

    @Override
    public FacultyModel searchFaculty(int facultyId) {
        FacultyModel faculty = new FacultyModel();
        try {
            String sql = "SELECT * FROM faculty";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (rs.getInt("fid")==facultyId) {
                    int fid = rs.getInt("fid");
                    String fname = rs.getString("fname");
                    int depid = rs.getInt("depid");

                    faculty.setFacultyID(facultyId);
                    faculty.setFacultyName(fname);
                    faculty.setDeptID(depid);
                }
            }

        } catch (SQLException ex) {
            System.out.println("Exception in Deleting staff");
        }

        return faculty;
    }

    @Override
    public List<FacultyModel> getAllFaculty() {
        List<FacultyModel> facultyMembers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM faculty";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int fid = rs.getInt("fid");
                String fname = rs.getString("fname");
                int depid = rs.getInt("depid");

                FacultyModel faculty = new FacultyModel(fid, fname, depid);
                facultyMembers.add(faculty);
            }
        } catch (SQLException ex) {
            System.out.println("Exception in getting all faculty members !");
        }
        return facultyMembers;
    }

    @Override
    public void addEnrollement(Enrollment enrollment) {
        try {
            int sid = enrollment.getSid();
            String cid = enrollment.getCid();
            int exam1 = enrollment.getExam1();
            int exam2 = enrollment.getExam2();
            int finals = enrollment.getFinals();

            String sql = "INSERT INTO enrollement VALUES('" + sid + "', '" + cid + "', '" + exam1 + "', '" + exam2 + "', '" + finals + "')";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Student enrolled successfully");
            } else {
                System.out.println("Student could not be enrolled !");
            }
        } catch (SQLException ex) {
            System.out.println("Exception in Enrolling Student: " + ex.getMessage());
        }
    }

    @Override
    public void updateEnrollemnet(Enrollment enrollment) {
        try {

            int sid = enrollment.getSid();
            String cid = enrollment.getCid();
            int exam1 = enrollment.getExam1();
            int exam2 = enrollment.getExam2();
            int finals = enrollment.getFinals();

            String sql = "UPDATE enrollement set exam1  = ?, exam2 = ?, finals = ? WHERE sid = '" + sid + "' AND cid = '" + cid + "'";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            preparedStatement.setInt(1, exam1);
            preparedStatement.setInt(2, exam1);
            preparedStatement.setInt(4, finals);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Student Enrollment Updated");
            } else {
                System.out.println("Error in updating Student Enrollment");
            }
        } catch (SQLException ex) {
            System.out.println("Exception in Updating Student Enrollment");
        }
    }

    @Override
    public void deleteEnrollmenbt(int id) {
        try {
            String sql = "DELETE FROM enrollement WHERE sid = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Student Deleted From Course");
            } else {
                System.out.println("Error in Deleting Student From Course");
            }
        } catch (SQLException ex) {
            System.out.println("Exception in Deleting Student From Course: " + ex.getMessage());
        }
    }

    @Override
    public Enrollment searchEnrollement(int id) {
        Enrollment enrollment = new Enrollment();
        try {
            String sql = "SELECT * FROM enrollement";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equals(id)) {
                    int sID = rs.getInt("sid");
                    String cid = rs.getString("cid");
                    int exam1 = rs.getInt("exam1");
                    int exam2 = rs.getInt("exam2");
                    int finals = rs.getInt("finals");

                    enrollment.setSid(sID);
                    enrollment.setCid(cid);
                    enrollment.setExam1(exam1);
                    enrollment.setExam2(exam2);
                    enrollment.setFinals(finals);
                }
            }

        } catch (SQLException ex) {
            System.out.println("Exception in Searching staff");
        }

        return enrollment;
    }

    @Override
    public List<Enrollment> getAllEnrollemnets() {
        List<Enrollment> enrollments = new ArrayList<>();
        try {
            String sql = "SELECT * FROM enrollement";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int sID = rs.getInt("sid");
                String cid = rs.getString("cid");
                int exam1 = rs.getInt("exam1");
                int exam2 = rs.getInt("exam2");
                int finals = rs.getInt("finals");

                Enrollment enrollment = new Enrollment();
                enrollment.setSid(sID);
                enrollment.setCid(cid);
                enrollment.setExam1(exam1);
                enrollment.setExam2(exam2);
                enrollment.setFinals(finals);

                enrollments.add(enrollment);
            }
        } catch (SQLException ex) {
            System.out.println("Exception in getting all Enrolled Students");
        }
        return enrollments;
    }

    @Override
    public void addDepartmnet(DepratmentModel dept) {
        try {
            int depid = dept.getDid();
            String dname = dept.getDname();

            String sql = "INSERT INTO department VALUES('" + depid + "', '" + dname + "')";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Student inserted Department");
            } else {
                System.out.println("Department could not be stored !");
            }
        } catch (SQLException ex) {
            System.out.println("Exception in inserting Department: " + ex.getMessage());
        }
    }

    @Override
    public void updateDepartment(DepratmentModel dept) {
        try {

            int did = dept.getDid();
            String dname = dept.getDname();

            String sql = "UPDATE department set dname  = ? WHERE did = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            preparedStatement.setInt(2, did);
            preparedStatement.setString(1, dname);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Department Update Record");
            } else {
                System.out.println("Error in updating Department record");
            }
        } catch (SQLException ex) {
            System.out.println("Exception in Updating Department");
        }
    }

    @Override
    public void deleteDepartment(int id) {
        try {
            String sql = "DELETE FROM department WHERE did = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Department Deleted Record");
            } else {
                System.out.println("Error in Deleting Department record");
            }
        } catch (SQLException ex) {
            System.out.println("Exception in Deleting Department record: " + ex.getMessage());
        }
    }

    @Override
    public DepratmentModel searchDepartment(int id) {
        DepratmentModel department = new DepratmentModel();
        try {
            String sql = "SELECT * FROM department";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equals(id)) {
                    int did = rs.getInt("sid");
                    String dname = rs.getString("dname");

                    department.setDid(did);
                    department.setDname(dname);
                }
            }

        } catch (SQLException ex) {
            System.out.println("Exception in Searching staff");
        }

        return department;
    }

    @Override
    public List<DepratmentModel> getAllDepartments() {
        List<DepratmentModel> departments = new ArrayList<>();
        try {
            String sql = "SELECT * FROM department";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int did = rs.getInt("did");
                String dname = rs.getString("dname");
                DepratmentModel department = new DepratmentModel(did, dname);
                departments.add(department);

            }

        } catch (SQLException ex) {
            System.out.println("Exception in getting Staff");
        }

        return departments;
    }

}
