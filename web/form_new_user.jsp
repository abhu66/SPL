<%-- 
    Document   : form_new_user
    Created on : Dec 30, 2018, 9:43:53 PM
    Author     : khoerulAbu
--%>
<Script>
    //clear all field value
    $(document).ready(function(){
          $("#formNewUser").trigger('reset'); 
    });
   
</script>
<div class="panel-heading">
    <ul class="nav nav-tabs">
        <li class="active"><a href="#tab1default" data-toggle="tab">Tambah User</a></li>
    </ul>
</div>
<form id="formNewUser" class="well-lg form-horizontal" action="UserController?data=user&proses=input-user" method="post">
    <div class="form-group">
        <label class="col-md-1 control-label">Nik</label>
        <div class="col-md-5 inputGroupContainer">
            <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span><input id="nik" name="nikNew" placeholder="Nik" class="form-control" required="true" value="" type="text"></div>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-1 control-label">Username</label>
        <div class="col-md-5 inputGroupContainer">
            <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span><input id="usernameNew" name="usernameNew" placeholder="Username" class="form-control" required="true" value="" type="text"></div>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-1 control-label">Password</label>
        <div class="col-md-5 inputGroupContainer">
            <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-eye-open"></i></span><input id="passwordNew" name="passwordNew" placeholder="Password" class="form-control" required="true" value="" type="password"></div>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-1 control-label">Role</label>
        <div class="col-md-5 inputGroupContainer">
            <div class="input-group">
                <span class="input-group-addon" style="max-width: 100%;"><i class="glyphicon glyphicon-cog"></i></span>
                <select class="selectpicker form-control" name="roleNew">
                    <option>Admin</option>
                    <option>User</option>
                </select>
            </div>
        </div>
    </div>
    <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-floppy-disk"></span> Simpan</button>
    <a href ="UserController?proses=list-all-user" class="btn btn-primary cancel"><span class="glyphicon glyphicon-floppy-remove"></span> Cancel</a>
</form>