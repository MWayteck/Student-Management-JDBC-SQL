package collegemanagementsystem.model;
public class Staff {
    int staffId;
    String staffname;
    int deptId;

    public Staff() {
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    
    public Staff(int staffId, String staffname, int deptId) {
        this.staffId = staffId;
        this.staffname = staffname;
        this.deptId = deptId;
    }

    public int getStaffId() {
        return staffId;
    }

    public String getStaffname() {
        return staffname;
    }

    public int getDeptId() {
        return deptId;
    }
    
    public String toString(){
        return "Name: "+this.staffname+"\nDepartment: "+this.deptId;
    }
}
