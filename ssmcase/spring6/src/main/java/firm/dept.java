package firm;

public class dept {
    private  String dname;
    public void info(){
        System.out.println("dept:"+dname);

    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
