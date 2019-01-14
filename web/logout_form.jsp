

 <%@include file="header.jsp" %>
 <%@include file="sidebar.jsp"%>
 <%@include file="session.jsp"%>
 
<div class="col-md-10 content">
    <div class="panel panel-default">
        <div class="panel-heading">Sistem Pengajuan Lembur</div>
        <div class="panel-body">
            <div class="panel-body">
                <form action="<%=request.getContextPath()%>/LogoutController" method="get">
                <h4>Keluar ?</h4>
                <input type="submit" class="btn btn-default" value="Keluar"/>
                <a href="dashboard.jsp" id="cancel" name="cancel" class="btn btn-default">Cancel</a>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
