package collegemanagementsystem.model;
public class Enrollment {
    
    int sid;
    String cid;
    int exam1;
    int exam2;
    int finals;

    public Enrollment() {
    }

    public Enrollment(int sid, String cid, int exam1, int exam2, int finals) {
        this.sid = sid;
        this.cid = cid;
        this.exam1 = exam1;
        this.exam2 = exam2;
        this.finals = finals;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setExam1(int exam1) {
        this.exam1 = exam1;
    }

    public void setExam2(int exam2) {
        this.exam2 = exam2;
    }

    public void setFinals(int finals) {
        this.finals = finals;
    }

    public int getSid() {
        return sid;
    }

    public String getCid() {
        return cid;
    }

    public int getExam1() {
        return exam1;
    }

    public int getExam2() {
        return exam2;
    }

    public int getFinals() {
        return finals;
    }
    
    public String toString(){
        return "Student: "+this.sid+"\nCourse: "+this.cid+"\nExam1 Marks: "+this.exam1+"\nExam2 Marks: "+this.exam2+"\nFinals: "+this.finals;
        
    }
}
