package COM.si.Service.impl;
import COM.si.Service.adminservice;
import COM.si.dao.impl.AdminDaoImpl;
import COM.si.entity.Admin;
import COM.si.utils.Dbutils;

import java.util.List;

public class adminserviceimpl implements adminservice {
    AdminDaoImpl adminDao=new AdminDaoImpl();

    @Override
    public Admin login(String user, String password) {
        Admin resule=null;

        try {
            Dbutils.begin();
            Admin admin= adminDao.select(user);
            if (admin!=null){
                if (admin.getPassword().equals(password)){
                    resule=admin;

                }
            }

            Dbutils.commit();
        } catch (Exception e) {
            Dbutils.rollback();
            throw new RuntimeException(e);
        }

        return  resule;
    }

    @Override
    public List<Admin> showAllAdmin() {
        return null;
    }
}
