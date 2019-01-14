/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import spl.daoImpl.UserLoginDaoImpl;
import spl.model.UserLogin;

/**
 *
 * @author khoerulAbu
 */
public class AddUserController extends  HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        UserLogin newUser = new UserLogin();
        newUser.setNik(request.getParameter("nik"));
        newUser.setUsername(request.getParameter("username"));
        newUser.setPassword(request.getParameter("password"));
        newUser.setRole(request.getParameter("role"));
        newUser.setStatus("Aktif");
        
        UserLoginDaoImpl userLoginDaoImpl = new UserLoginDaoImpl();
        userLoginDaoImpl.tambahUser(newUser);
        response.sendRedirect("user.listAll?page=1");
    }
    
}
