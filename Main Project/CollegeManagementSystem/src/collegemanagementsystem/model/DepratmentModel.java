package collegemanagementsystem.model;
public class DepratmentModel {
    int did;
    String dname;

    public DepratmentModel() {
    }

    public DepratmentModel(int did, String dname) {
        this.did = did;
        this.dname = dname;
    }

    public int getDid() {
        return did;
    }

    public String getDname() {
        return dname;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
    
    public String toString(){
        return "Department: "+this.dname+"\nID: "+this.did;
    }
}
