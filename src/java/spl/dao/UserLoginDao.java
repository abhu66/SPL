/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spl.dao;


import java.sql.ResultSet;
import java.util.List;
import spl.model.UserLogin;

/**
 *
 * @author khoerulAbu
 */
public interface UserLoginDao {
    public List<UserLogin> listUserLogin(int offset,int noOfRecords, String params);
    public List<UserLogin> loginUser(String nik, String password);
    public void tambahUser(UserLogin userLogin);
    public UserLogin findByNik(String nik);
    public void updateUser(UserLogin userLogin);
    public ResultSet listUserForReport(String param);
    public List<UserLogin> listDataSearch(int offset,int noOfRecords, String nik);
    
}
