import COM.si.Service.impl.adminserviceimpl;
import COM.si.entity.Admin;

public class Main {
    public static void main(String[] args) {
         String a="fsadf";
         String b="fasdfa";
        adminserviceimpl adminserviceimpl=new adminserviceimpl();
        Admin ab= adminserviceimpl.login(a,b);
        if (ab==null){
            System.out.println("诶呦");
        }
    }
}