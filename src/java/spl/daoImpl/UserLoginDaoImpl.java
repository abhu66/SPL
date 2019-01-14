/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spl.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import spl.dao.UserLoginDao;
import spl.koneksi.Koneksi;
import spl.model.UserLogin;

/**
 *
 * @author khoerulAbu
 */
public class UserLoginDaoImpl implements UserLoginDao {

    private ResultSet rs;
    private Statement st;
    private final Koneksi kon = Koneksi.getInstance();
    private Connection con;
    private int noOfRecords;

    @Override
    public List<UserLogin> listUserLogin(int offset, int noOfRecords, String params) {
        List<UserLogin> data = new ArrayList<>();
        try {
            String sql = "";
            if (params == null) {
                sql = " select  SQL_CALC_FOUND_ROWS * FROM  user_login  limit " + offset + "," + noOfRecords + " ";
            } else {
                sql = " select  SQL_CALC_FOUND_ROWS * FROM  user_login where "
                        + " nik like '%" + params + "%'"
                        + " or username like '%" + params + "%' limit " + offset + "," + noOfRecords + " ";
            }

            con = kon.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            UserLogin userLogin = null;
            while (rs.next()) {
                userLogin = new UserLogin();
                userLogin.setNik(rs.getString("nik"));
                userLogin.setUsername(rs.getString("username"));
                userLogin.setPassword(rs.getString("password"));
                userLogin.setRole(rs.getString("role"));
                userLogin.setStatus(rs.getString("status"));
                data.add(userLogin);
            }
            rs.close();
            rs = st.executeQuery("SELECT FOUND_ROWS()");
            if (rs.next()) {
                this.noOfRecords = rs.getInt(1);
            }
            System.out.println("Rfci :" + this.noOfRecords);
            rs.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Terjadi Kesalahan Saat menampilkan data User" + ex);
        }
        return data;
    }

    public int getNoOfRecords() {
        return noOfRecords;
    }

    @Override
    public List<UserLogin> loginUser(String nik, String password) {
        List<UserLogin> data = new ArrayList<>();
        try {
            String sql = "select * FROM  user_login where nik = " + nik + " and password = " + password + " ";
            con = kon.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                UserLogin userLogin = new UserLogin();
                userLogin.setNik(rs.getString("nik"));
                userLogin.setUsername(rs.getString("username"));
                userLogin.setPassword(rs.getString("password"));
                userLogin.setRole(rs.getString("role"));
                userLogin.setStatus(rs.getString("status"));
                data.add(userLogin);
            }
            rs.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Terjadi Kesalahan Saat menampilkan data User" + ex);
        }
        return data;
    }

    @Override
    public void tambahUser(UserLogin userLogin) {
        try {
            String sql = "INSERT INTO User_login values (?,?,?,?,?)";
            PreparedStatement ps;
            con = kon.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userLogin.getNik());
            ps.setString(2, userLogin.getUsername());
            ps.setString(3, userLogin.getPassword());
            ps.setString(4, userLogin.getRole());
            ps.setString(5, userLogin.getStatus());
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserLoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public UserLogin findByNik(String nik) {
        UserLogin userLogin = null;
        try {
            String sql = "SELECT * FROM User_login WHERE nik = "+nik+" ";
            con = kon.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
                userLogin = new UserLogin();
                userLogin.setNik(rs.getString("nik"));
                userLogin.setUsername(rs.getString("username"));
                userLogin.setPassword(rs.getString("password"));
                userLogin.setRole(rs.getString("role"));
                userLogin.setStatus(rs.getString("status"));
            }
            rs.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Terjadi Kesalahan Saat menampilkan data User" + ex);
        }
        return userLogin;
    }

    @Override
    public void updateUser(UserLogin userLogin) {
        try {
            String sql = "UPDATE User_login set username= ?, password = ?, role = ? where nik = ?";
            PreparedStatement ps;
            con = kon.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(4, userLogin.getNik());
            ps.setString(1, userLogin.getUsername());
            ps.setString(2, userLogin.getPassword());
            ps.setString(3, userLogin.getRole());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserLoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ResultSet listUserForReport(String param) {
      UserLogin userLogin = null;
        try {
            String sql = "";
            if(param == null || param.isEmpty()){
                sql = "SELECT * FROM User_login";
            }
            else {
                sql = "SELECT * FROM  User_login where nik = "+param+" ";
            }
          
            con = kon.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Terjadi Kesalahan Saat menampilkan data User" + ex);
        }
        return rs;
    }

    @Override
    public List<UserLogin> listDataSearch(int offset, int noOfRecords, String params) {
       List<UserLogin> data = new ArrayList<>();
        try {
           String sql = "";
            if (params == null) {
                sql = " select  SQL_CALC_FOUND_ROWS * FROM  user_login  limit " + offset + "," + noOfRecords + " ";
            } else {
                sql = " select  SQL_CALC_FOUND_ROWS * FROM  user_login where "
                        + " nik like '%" + params + "%'"
                        + " or username like '%" + params + "%' limit " + offset + "," + noOfRecords + " ";
            }
            
            con = kon.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                UserLogin userLogin = new UserLogin();
                userLogin.setNik(rs.getString("nik"));
                userLogin.setUsername(rs.getString("username"));
                userLogin.setPassword(rs.getString("password"));
                userLogin.setRole(rs.getString("role"));
                userLogin.setStatus(rs.getString("status"));
                data.add(userLogin);
            }
            rs.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Terjadi Kesalahan Saat menampilkan data User" + ex);
        }
        return data;
    }
}
