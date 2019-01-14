<%-- 
    Document   : form_new_user
    Created on : Dec 30, 2018, 9:43:53 PM
    Author     : khoerulAbu
--%>


<div class="panel-heading">
    <ul class="nav nav-tabs">
        <li class="active"><a href="#tab1default" data-toggle="tab">Informasi User</a></li>
    </ul>
</div>
<form class="well-lg form-horizontal">
    <fieldset>
        <div class="form-group">
            <label class="col-md-1 control-label">Nik</label>
            <div class="col-md-5 inputGroupContainer">
                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span><input id="nik"  class="form-control" required="true" value="${userLoginFromDb.nik}" type="text" readonly="true"></div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-1 control-label">Username</label>
            <div class="col-md-5 inputGroupContainer">
                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span><input id="username"  class="form-control" required="true" value="${userLoginFromDb.username}" type="text" readonly="true"></div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-1 control-label">Password</label>
            <div class="col-md-5 inputGroupContainer">
                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-eye-open"></i></span><input id="password"  class="form-control" required="true" value="${userLoginFromDb.password}" type="text" readonly="true"></div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-1 control-label">Role</label>
            <div class="col-md-5 inputGroupContainer">
                <div class="input-group">
                     <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-cog"></i></span><input id="roleView"  class="form-control" required="true" value="${userLoginFromDb.role}" type="text" readonly="true"></div>
       
                </div>
            </div>
        </div>
    </fieldset>
</form>


