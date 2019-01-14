/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spl.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import spl.daoImpl.UserLoginDaoImpl;
import spl.model.UserLogin;

/**
 *
 * @author khoerulAbu
 */
public class LoginController extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        if (action.equals("logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("index.jsp");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
            String nik = request.getParameter("nik");
            String pass = request.getParameter("password");
       
            if (pass == null || pass.equals("")) {   //validasi apabila field belum diisi
                response.sendRedirect("form-kosong.jsp");
            } else {
                UserLoginDaoImpl pm = new UserLoginDaoImpl();
                List<UserLogin> dataLogins = pm.loginUser(nik, pass);
                System.out.println("Data : "+dataLogins.size());
                if (dataLogins.isEmpty()) { //validasi apabila username dan password salah
                    response.sendRedirect("gagal.jsp"); 
                } else {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("nik", dataLogins.get(0).getNik());
                    session.setAttribute("username", dataLogins.get(0).getUsername());
                    session.setAttribute("role", dataLogins.get(0).getRole());
 
                    if (dataLogins.get(0).getNik().equals(nik)) {
                        response.sendRedirect("dashboard.jsp");
                    } else {
                        response.sendRedirect("index.jsp");
                    }
                }
            }
    }
}
