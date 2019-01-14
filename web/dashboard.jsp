

 <%@include file="header.jsp" %>
 <%@include file="sidebar.jsp"%>
 <%@include file="session.jsp"%>
 
<div class="col-md-10 content">
    <div class="panel panel-default">
        <div class="panel-heading">Sistem Pengajuan Lembur</div>
        <div class="panel-body">
            <h4>Welcome <%=session.getAttribute("username")%></h4>
            <div class="panel-body"><img src="image/placeholder_150x150.png" alt="" class="img-responsive" /></div>
            <div class="panel-body">
                <table class="table table-striped">
                    <tr>
                        <td>Nik</td>
                        <td>:</td>
                        <td><%=session.getAttribute("nik")%></td>
                    </tr>
                     <tr>
                        <td>Nama</td>
                        <td>:</td>
                        <td><%=session.getAttribute("username")%></td>
                    </tr>
                     <tr>
                        <td>Role</td>
                        <td>:</td>
                        <td><%=session.getAttribute("role")%></td>
                    </tr>
                </table>
            </div>
            <div class="panel-body">
            Merupakan sebuah sistem aplikasi yang berguna untuk pengajuan lembur karyawan,
            dan dapat memudahkan pengguna dalam melakukan pengajuan lembur apabila diharuskan lembur 
            karena banyaknya pekerjaan atau pekerjaan yang harus deselesaikan pada waktu itu juga.
            </div>
            
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
