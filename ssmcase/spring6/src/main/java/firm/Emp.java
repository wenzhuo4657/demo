package firm;

public class Emp {
    private  dept dept;
    private  String EName;
    private  String age;

    public String getEName() {
        return EName;
    }

    public void setEName(String EName) {
        this.EName = EName;
    }

    public  void work(){
        System.out.println(EName+"工作："+age);
        dept.info();
    }

    public firm.dept getDept() {
        return dept;
    }

    public void setDept(firm.dept dept) {
        this.dept = dept;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
