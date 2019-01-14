<%-- 
    Document   : form_new_user
    Created on : Dec 30, 2018, 9:43:53 PM
    Author     : khoerulAbu
--%>
    

<div class="panel-heading">
    <ul class="nav nav-tabs">
        <li class="active"><a href="#tab1default" data-toggle="tab">Edit User</a></li>
    </ul>
</div>

<form class="well form-horizontal" action="UserController?data=user&proses=update-user" method="post">
    <fieldset>
        <div class="form-group">
            <label class="col-md-1 control-label">Nik</label>
            <div class="col-md-5 inputGroupContainer">
                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span><input id="nik" name="nikEdit" placeholder="Nik" class="form-control" required="true" value="${userLoginFromDb.nik}" type="text" readonly="true"></div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-1 control-label">Username</label>
            <div class="col-md-5 inputGroupContainer">
                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span><input id="username" name="usernameEdit" placeholder="Username" class="form-control" required="true" value="${userLoginFromDb.username}" type="text"></div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-1 control-label">Password</label>
            <div class="col-md-5 inputGroupContainer">
                <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-eye-open"></i></span><input id="password" name="passwordEdit" placeholder="Password" class="form-control" required="true" value="${userLoginFromDb.password}" type="password"></div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-1 control-label">Role</label>
            <div class="col-md-5 inputGroupContainer">
                <div class="input-group">
                    <span class="input-group-addon" style="max-width: 100%;"><i class="glyphicon glyphicon-cog"></i></span>
                    <select class="selectpicker form-control" name="roleEdit">
                        <option value="Admin">Admin</option>
                        <option value="User">User</option>
                    </select>
                </div>
            </div>
        </div>
    </fieldset>
    <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-floppy-disk"></span> Simpan</button>
    <a href="" type="UserController?proses=list-all-user" class="btn btn-primary cancel"><span class="glyphicon glyphicon-floppy-remove"></span> Cancel</a>
</form>


