<%-- 
    Document   : session
    Created on : Dec 30, 2018, 2:18:30 PM
    Author     : khoerulAbu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div>
    <%
        if ((session.getAttribute("nik") == null) || (session.getAttribute("nik") == "")) {
            response.sendRedirect(application.getContextPath() + "/index.jsp");
    %>
    <%
        }
    %>
</div>
