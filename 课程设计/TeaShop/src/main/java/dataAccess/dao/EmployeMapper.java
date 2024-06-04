package dataAccess.dao;


import dataAccess.entity.Employe;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface EmployeMapper {


    List<Employe> findAll();

    List<Employe> queryLike(@Param("user") String user, @Param("name") String name, @Param("sex") String sex);

    Employe query(@Param("user") String user);
    void upDateEmploye(@Param("empl") Employe employe, @Param("oe_id") String olde_id);

    void updatePass(@Param("user") String user, @Param("newPassword") String newPassword);

    void delEmploye(@Param("e_id") String e_id);

    void addEmploye(@Param("empl") Employe employe);
}