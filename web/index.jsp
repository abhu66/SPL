<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <link href="css/login.css" rel="stylesheet"/> 
        <!------ Include the above in your HEAD tag ---------->
    </head>
    <body id="LoginForm">
        <div class="container">
            <div class="login-form">
                <div class="main-div">
                    <div class="panel">
                        <h2>Form Login</h2>
                        <p>Login dengan Nik dan Password</p>
                    </div>
                    <form id="Login" method="post" action="LoginController">
                        <div class="form-group">
                            <input type="text" class="form-control" name="nik" placeholder="Nik" required="true">
                        </div>

                        <div class="form-group">
                            <input type="password" class="form-control" name="password" placeholder="Password" required="true">
                        </div>
                        <div class="forgot">
                            <a href="reset.html">Lupa Password?</a>
                        </div>
                        <input type="submit" class="btn btn-primary" value="Login">

                    </form>
                </div>
                <p class="botto-text">Sistem Pengajuan Lembur | KCP Mandiri Depok</p>
            </div></div></div>
</body>
</html>