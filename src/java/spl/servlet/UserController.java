/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spl.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperRunManager;
import spl.daoImpl.UserLoginDaoImpl;
import spl.model.UserLogin;

/**
 *
 * @author khoerulAbu
 */
public class UserController extends HttpServlet {

    public UserController() {
        super();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 5;
        String proses = "";
        String action = "";

        UserLoginDaoImpl userLoginDaoImpl = new UserLoginDaoImpl();

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        if (request.getParameter("proses") != null) {
            proses = request.getParameter("proses");
        }
        action = request.getParameter("action");

        //listAllUser(request,response,userLoginDaoImpl,page,recordsPerPage,request.getParameter("q"));
        if (proses != null) {
            switch (proses) {
                case "input-user":
                    response.sendRedirect("form_new_user.jsp");
                    break;
                case "edit-user":

                    String paramNik = request.getParameter("nik");
                    UserLogin userLoginFromDb = userLoginDaoImpl.findByNik(paramNik);
                    request.setAttribute("userLoginFromDb", userLoginFromDb);
                    RequestDispatcher userLoginEdit = request.getRequestDispatcher("form_edit_user.jsp");
                    userLoginEdit.forward(request, response);
                    break;

                case "view-user":
                    String paramNikView = request.getParameter("nik");
                    userLoginFromDb = userLoginDaoImpl.findByNik(paramNikView);
                    request.setAttribute("userLoginFromDb", userLoginFromDb);
                    RequestDispatcher uerLoginView = request.getRequestDispatcher("form_view_user.jsp");
                    uerLoginView.forward(request, response);
                    break;

                case "list-all-user":
                    listAllUser(request, response, userLoginDaoImpl, page, recordsPerPage, null, "user_page.jsp");
                    break;

                case "report-user-login":
                    listAllUser(request, response, userLoginDaoImpl, page, recordsPerPage, null, "report_userlogin_page.jsp");
                    break;
                case "cetak-data-user":
                    System.out.println("Tester U");
                    response.setContentType("application/pdf");
                    ServletOutputStream servletOutputStream = response.getOutputStream();
                    InputStream reportStream = getServletConfig().getServletContext().getResourceAsStream("/report/ReportUserLogin.jasper");
                    //InputStream reportStream = getServletConfig().getServletContext().getResourceAsStream(application.getRealPath("/report/reportdokter.jasper"));          

                    ResultSet rs = userLoginDaoImpl.listUserForReport(request.getParameter("qReport"));
                    JRResultSetDataSource dataSource = new JRResultSetDataSource(rs); //resultSet);
                     {
                        try {
                            JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, new HashMap(), dataSource);
                        } catch (JRException ex) {
                            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    servletOutputStream.flush();
                    servletOutputStream.close();
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserLoginDaoImpl userLoginDaoImpl = new UserLoginDaoImpl();
        String data = request.getParameter("data");
        String proses = request.getParameter("proses");

        int page = 1;
        int recordsPerPage = 5;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        if (proses.equals("list-all-user")) {
            listAllUser(request, response, userLoginDaoImpl, page, recordsPerPage, request.getParameter("q"), "user_page.jsp");
        } else if (proses.equals("report-user-login")) {
            listAllUser(request, response, userLoginDaoImpl, page, recordsPerPage, request.getParameter("qReport"), "report_userlogin_page.jsp");
        }

        if (data != null) {
            if (data.equals("user")) {
                UserLogin user;
                switch (proses) {
                    case "input-user":

                        user = new UserLogin();
                        user.setNik(request.getParameter("nikNew"));
                        user.setUsername(request.getParameter("usernameNew"));
                        user.setPassword(request.getParameter("passwordNew"));
                        user.setRole(request.getParameter("roleNew"));
                        user.setStatus("Aktif");
                        userLoginDaoImpl.tambahUser(user);

                        listAllUser(request, response, userLoginDaoImpl, page, recordsPerPage, request.getParameter("q"), "user_page.jsp");
                        break;
                    case "update-user":

                        user = new UserLogin();
                        user.setNik(request.getParameter("nikEdit"));
                        user.setUsername(request.getParameter("usernameEdit"));
                        user.setPassword(request.getParameter("passwordEdit"));
                        user.setRole(request.getParameter("roleEdit"));
                        user.setStatus("Aktif");
                        userLoginDaoImpl.updateUser(user);
                        response.sendRedirect("UserController?proses=list-all-user&page=1");
                        //listAllUser(request,response,userLoginDaoImpl,page,recordsPerPage,request.getParameter("q"));
                        break;

                    case "search-user":
                        listAllUser(request, response, userLoginDaoImpl, page, recordsPerPage, request.getParameter("qReport"), "report_userlogin_page.jsp");
                        break;
                    case "cetak-data-user":

                        break;
                    default:
                        break;

                }
            }
        }
    }

    public void listAllUser(HttpServletRequest request, HttpServletResponse response,
            UserLoginDaoImpl userLoginDaoImpl, int page, int recordsPerPage, String query, String pageName) {
        try {
            List<UserLogin> list = new ArrayList<>();
            list.clear();
            //getting parameter from search field..
            //query = request.getParameter("q");
            
            String params = request.getQueryString();
            System.out.println("Params : "+params);
            if(params.equals("data=user&proses=search-user")){
                 list = userLoginDaoImpl.listUserLogin((page - 1) * recordsPerPage, recordsPerPage, query);
            }
            else {
                 list = userLoginDaoImpl.listUserLogin((page - 1) * recordsPerPage, recordsPerPage, query);
            }
           
            int noOfRecords = userLoginDaoImpl.getNoOfRecords();
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

            request.setAttribute("employeeList", list);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
            if(query == null){
                 request.setAttribute("qReport", "");
            }
            else {
                 request.setAttribute("qReport", query);
            }
           
            RequestDispatcher view = request.getRequestDispatcher(pageName);
            view.forward(request, response);
        } catch (ServletException | IOException | NullPointerException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
