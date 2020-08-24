package in.desd.day10app1listviewexa3;

public class Student {
    String Name;
    int RollNo;

    @Override
    public String toString() {
        return "Name=" + Name + "::" + " RollNo=" + RollNo ;
    }

    public Student() {
        this.Name="NULL";
        this.RollNo=0;
    }

    public Student(String Name,int RollNo){
        this.Name=Name;
        this.RollNo=RollNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public int getRollNo() {
        return RollNo;
    }

    public void setRollNo(int rollNo) {
        RollNo = rollNo;
    }
}
