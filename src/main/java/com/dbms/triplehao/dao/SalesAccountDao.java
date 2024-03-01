package com.dbms.triplehao.dao;

import com.dbms.triplehao.entity.SalesAccount;

import java.util.List;


public interface SalesAccountDao {

    //login
    List<SalesAccount> searchSalesAccount(String username);

    //register
    int insertSalesAccount(SalesAccount salesAccount);

    int deleteSalesAccountByUsername(String username);

    List<SalesAccount> querySalesAccountByUsername(String username);

//    int updatedSalesAccount(SalesAccount salesAccount);
//
//    int deleteSalesAccount(int empId);

}
