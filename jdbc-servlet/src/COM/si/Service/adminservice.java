package COM.si.Service;

import COM.si.entity.Admin;

import java.util.List;

public interface adminservice {
    public Admin login(String user,String password);
    public List<Admin> showAllAdmin();

}
