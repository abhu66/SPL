<%-- 
    Document   : list_all_user
    Created on : Dec 29, 2018, 7:51:42 PM
    Author     : khoerulAbu
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="spl.model.UserLogin"%>
<%@page import="spl.daoImpl.UserLoginDaoImpl"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="sidebar.jsp"%>
<%@include file="session.jsp"%>
<div class="col-md-10 content">
    <div class="panel panel-default">
        <div class="panel-heading"><h4>List User</h4> </div>
            <div class="panel-body">
                <form action="" method="post">
                    <table>
                        <tr>
                            <td><input type="text" class="form-control" name="q" placeholder="cari data"/></td>
                            <td>&nbsp;</td>
                            <td><input type="submit" class="btn btn-default" value="Cari"/></td>
                        </tr>
                    </table>
                </form>
                </br>
                <table class="table table-bordered">
                    <tr>
                        <th  scope="col">Nik</th>
                        <th scope="col">Username</th>
                        <th scope="col">Password</th>
                        <th scope="col" style="text-align: center;">Role</th>
                        <th scope="col" style="text-align: center;">Status</th>
                        <th scope="col" style="text-align: center;">Action</th>
                    </tr>
                    
                    <c:set var="nomor" value="0"/>
                    <c:forEach var="userLogin" items="${employeeList}">
                    <c:set var="nomor" value="${nomor + 1}" scope="page"/>
                    <tr>
                    <td>${userLogin.nik}</td>
                    <td>${userLogin.username}</td>
                    <td>${userLogin.password}</td>
                    <td style="text-align: center;">${userLogin.role}</td>
                    <td style="text-align: center;">${userLogin.status}</td>
                    <td style="text-align: center;">
                        <a class="editLink" href="UserController?proses=edit-user&nik=${userLogin.nik}"><span class="glyphicon glyphicon-edit"></span> Edit</a>
                        <a class="viewLink" href="UserController?proses=view-user&nik=${userLogin.nik}"><span class="glyphicon glyphicon-eye-open"></span> Lihat | 
                        <a href="#"><span class="glyphicon glyphicon-trash"></span> Hapus</td>
                    </tr>
                    </c:forEach>
                </table>
                <div class="btn-toolbar" role="toolbar" style="margin: 0;">
                    <a id="btnTambahUser" href="UserController?proses=input-user" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span>Tambah</a>
                    <div class="btn-group pull-right">
                        <ul class="pagination"  style="margin: 0;">
                            <%--For displaying Previous link except for the 1st page --%>
                            <c:if test="${currentPage != 1}">
                                <li class="page-item"><a class="page-link" href="UserController?proses=list-all-user&page=${currentPage - 1}">Previous</a></li>
                                </c:if>
                                <c:forEach begin="1" end="${noOfPages}" var="i">
                                    <c:choose>
                                        <c:when test="${currentPage eq i}">
                                        <li class="page-item active"><a class="page-link" href="#" >${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="UserController?proses=list-all-user&page=${i}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                                <%--For displaying Next link --%>
                                <c:if test="${currentPage lt noOfPages}">
                                <li class="page-item"><a  class="page-link" href="UserController?proses=list-all-user&page=${currentPage + 1}">Next</a></li>
                                </c:if>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>                               
    </div>
<div class="panel with-nav-tabs panel-default" id="FormUser" style="display: none;">
    <%@include file="/form_new_user.jsp" %>
</div>
<div class="panel with-nav-tabs panel-default" id="FormEditUser" style="display: none;">
    <%@include file="/form_edit_user.jsp" %>
</div>
<div class="panel with-nav-tabs panel-default" id="FormViewUser" style="display: none;">
    <%@include file="/form_view_user.jsp" %>
</div>
</div>
<%@include file="/footer.jsp" %>

