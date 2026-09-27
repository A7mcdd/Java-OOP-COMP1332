package Labswork.Labwork_2_to_5;

public class Department {
    private String depName;
    private int deptNo;

    public Department(String depName, int deptNo) {
        this.depName = depName;
        this.deptNo = deptNo;
    }

    public String getDepName() { return depName; }
    public int getDeptNo() { return deptNo; }

    public void setDepName(String depName) { this.depName = depName; }
    public void setDeptNo(int deptNo) { this.deptNo = deptNo; }

    @Override
    public String toString() {
        return depName + " (Dept #" + deptNo + ")";
    }
}
