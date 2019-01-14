<div class="container-fluid main-container">
    <div class="col-md-2 sidebar">
        <div class="row">
            <!-- uncomment code for absolute positioning tweek see top comment in css -->
            <div class="absolute-wrapper"> </div>
            <!-- Menu -->
            <div class="side-menu">
                <nav class="navbar navbar-default" role="navigation">
                    <!-- Main Menu -->
                    <div class="side-menu-container">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="dashboard.jsp"><span class="glyphicon glyphicon-dashboard"></span> Dashboard</a></li>
                             <!-- Dropdown-->
                            <li class="panel panel-default" id="dropdown">
                                <a data-toggle="collapse" href="#dropdown-lvl1">
                                    <span class="glyphicon glyphicon-user"></span> Karyawan <span class="caret"></span>
                                </a>
                                 <!-- Dropdown level 1 -->
                                <div id="dropdown-lvl1" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="#">Pengajuan Lembur</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            
                            <li class="panel panel-default" id="dropdown">
                                <a data-toggle="collapse" href="#dropdown-lv21">
                                    <span class="glyphicon glyphicon-file"></span> Manager <span class="caret"></span>
                                </a>
                                 <!-- Dropdown level 2 -->
                                <div id="dropdown-lv21" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="#">Pengajuan Lembur</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li class="panel panel-default" id="dropdown">
                                <a data-toggle="collapse" href="#dropdown-lv31">
                                    <span class="glyphicon glyphicon-briefcase"></span> Administrator <span class="caret"></span>
                                </a>
                                 <!-- Dropdown level 2 -->
                                <div id="dropdown-lv31" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="UserController?proses=list-all-user">User</a></li>
                                            <li><a href="UserController?proses=report-user-login">Laporan</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </nav>
            </div>
        </div> 
    </div>
