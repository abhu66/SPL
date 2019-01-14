/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spl.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
public class UserDataEditController  extends HttpServlet{
    public UserDataEditController() {
            super();
    }
 
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             
         UserLoginDaoImpl dao = new UserLoginDaoImpl();
         UserLogin userLogin = null;
         
         //getting parameter from search field..
         String query = request.getParameter("nik");
         userLogin = dao.findByNik(query);
      
         request.setAttribute("userlogin", userLogin);
      
    }
}
