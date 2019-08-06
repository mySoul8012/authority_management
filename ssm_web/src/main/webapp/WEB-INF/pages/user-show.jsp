<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ming
  Date: 19-7-3
  Time: 上午5:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 3 | Invoice</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/css/adminlte.min.css">
    <link href="/css/tree.css" rel="stylesheet" type="text/css">
<!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">


    <link rel="stylesheet" href="https://static.runoob.com/assets/js/jquery-treeview/jquery.treeview.css" />
    <link rel="stylesheet" href="https://static.runoob.com/assets/js/jquery-treeview/screen.css" />

    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="https://static.runoob.com/assets/js/jquery-treeview/jquery.cookie.js"></script>
    <script src="https://static.runoob.com/assets/js/jquery-treeview/jquery.treeview.js" type="text/javascript"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $("#browser").treeview({
                toggle: function() {
                    console.log("%s was toggled.", $(this).find(">span").text());
                }
            });

            $("#add").click(function() {
                var branches = $("<li><span class='folder'>New Sublist</span><ul>" +
                    "<li><span class='file'>Item1</span></li>" +
                    "<li><span class='file'>Item2</span></li></ul></li>").appendTo("#browser");
                $("#browser").treeview({
                    add: branches
                });
            });
        });
    </script>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light border-bottom">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#"><i class="fas fa-bars"></i></a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="../../index3.html" class="nav-link">Home</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">Contact</a>
            </li>
        </ul>

        <!-- SEARCH FORM -->
        <form class="form-inline ml-3">
            <div class="input-group input-group-sm">
                <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
                <div class="input-group-append">
                    <button class="btn btn-navbar" type="submit">
                        <i class="fas fa-search"></i>
                    </button>
                </div>
            </div>
        </form>

        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
            <!-- Messages Dropdown Menu -->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-comments"></i>
                    <span class="badge badge-danger navbar-badge">3</span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">
                            <img src="../../dist/img/user1-128x128.jpg" alt="User Avatar" class="img-size-50 mr-3 img-circle">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Brad Diesel
                                    <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">Call me whenever you can...</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">
                            <img src="/img/user8-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    John Pierce
                                    <span class="float-right text-sm text-muted"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">I got your message bro</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">
                            <img src="/img/user3-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Nora Silvester
                                    <span class="float-right text-sm text-warning"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">The subject goes here</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item dropdown-footer">See All Messages</a>
                </div>
            </li>
            <!-- Notifications Dropdown Menu -->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-bell"></i>
                    <span class="badge badge-warning navbar-badge">15</span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <span class="dropdown-item dropdown-header">15 Notifications</span>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-envelope mr-2"></i> 4 new messages
                        <span class="float-right text-muted text-sm">3 mins</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-users mr-2"></i> 8 friend requests
                        <span class="float-right text-muted text-sm">12 hours</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-file mr-2"></i> 3 new reports
                        <span class="float-right text-muted text-sm">2 days</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item dropdown-footer">See All Notifications</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#">
                    <i class="fas fa-th-large"></i>
                </a>
            </li>
        </ul>
    </nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar user (optional) -->
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="image">
                    <img src="/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
                </div>
                <div class="info">
                    <a href="#" class="d-block">Alexander Pierce</a>
                </div>
            </div>

            <!-- Sidebar Menu -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                    <!-- Add icons to the links using the .nav-icon class
                         with font-awesome or any other icon font library -->
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>
                                Dashboard
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="../../index.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Dashboard v1</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../../index2.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Dashboard v2</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../../index3.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Dashboard v3</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a href="../widgets.html" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Widgets
                                <span class="right badge badge-danger">New</span>
                            </p>
                        </a>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-copy"></i>
                            <p>
                                Layout Options
                                <i class="fas fa-angle-left right"></i>
                                <span class="badge badge-info right">6</span>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="../layout/top-nav.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Top Navigation</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../layout/boxed.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Boxed</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../layout/fixed.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Fixed</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../layout/fixed-topnav.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Fixed Navbar</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../layout/fixed-footer.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Fixed Footer</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../layout/collapsed-sidebar.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Collapsed Sidebar</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-chart-pie"></i>
                            <p>
                                Charts
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="../charts/chartjs.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>ChartJS</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../charts/flot.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Flot</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../charts/inline.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Inline</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-tree"></i>
                            <p>
                                UI Elements
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="../UI/general.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>General</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../UI/icons.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Icons</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../UI/buttons.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Buttons</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../UI/sliders.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Sliders</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../UI/modals.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Modals & Alerts</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-edit"></i>
                            <p>
                                Forms
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="../forms/general.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>General Elements</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../forms/advanced.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Advanced Elements</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../forms/editors.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Editors</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-table"></i>
                            <p>
                                Tables
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="../tables/simple.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Simple Tables</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../tables/data.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Data Tables</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-header">EXAMPLES</li>
                    <li class="nav-item">
                        <a href="../calendar.html" class="nav-link">
                            <i class="nav-icon far fa-calendar-alt"></i>
                            <p>
                                Calendar
                                <span class="badge badge-info right">2</span>
                            </p>
                        </a>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon far fa-envelope"></i>
                            <p>
                                Mailbox
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="../mailbox/mailbox.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Inbox</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../mailbox/compose.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Compose</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../mailbox/read-mail.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Read</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview menu-open">
                        <a href="/user/findAll.do" class="nav-link active">
                            <i class="nav-icon fas fa-book"></i>
                            <p>
                                用户列表
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="../examples/invoice.html" class="nav-link active">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Invoice</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../examples/profile.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Profile</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../examples/login.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Login</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../examples/register.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Register</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../examples/lockscreen.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Lockscreen</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon far fa-plus-square"></i>
                            <p>
                                Extras
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="../examples/404.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Error 404</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../examples/500.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Error 500</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../examples/blank.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Blank Page</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../../starter.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Starter Page</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="../examples/legacy-user-menu.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Legacy User Menu</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-header">MISCELLANEOUS</li>
                    <li class="nav-item">
                        <a href="https://adminlte.io/docs" class="nav-link">
                            <i class="nav-icon fas fa-file"></i>
                            <p>Documentation</p>
                        </a>
                    </li>
                    <li class="nav-header">LABELS</li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <i class="nav-icon far fa-circle text-danger"></i>
                            <p class="text">Important</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <i class="nav-icon far fa-circle text-warning"></i>
                            <p>Warning</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <i class="nav-icon far fa-circle text-info"></i>
                            <p>Informational</p>
                        </a>
                    </li>
                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>Invoice</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Invoice</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <!-- Main content -->
                        <div class="invoice p-3 mb-3">
                            <!-- /.row -->

                            <!-- Table row -->
                            <div class="row">
                                <div class="col-12 table-responsive">
                                    <table class="table table-striped">
                                        <thead>
                                        <tr>
                                            <th>用户id</th>
                                            <th>用户状态</th>
                                            <th>用户名称</th>
                                            <th>用户电话</th>
                                            <th>用户邮箱</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>${userInfo.id}</td>
                                                <td>${userInfo.statusStr}</td>
                                                <td>${userInfo.username}</td>
                                                <td>${userInfo.phone_num}</td>
                                                <td>${userInfo.email}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.col -->
                            </div>
                        </div>
                        <!-- /.invoice -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </section>



        <ul id="browser" class="filetree treeview-famfamfam">
            <c:forEach items="${userInfo.roles}" var="role">
                <li><span class="folder">权限信息</span>
                    <ul>
                        <li><span class="folder">${role.role_name}</span>
                            <ul>
                                <li><span class="folder">权限的资源信息</span>
                                    <ul id="folder21">
                                        <c:forEach items="${role.permissions}" var="permissions">
                                            <ul>
                                                <li><span>${permissions.perssion_name}</span>
                                                    <ul>
                                                        <li>权限url： ${permissions.url}</li>
                                                        <li>权限名称： ${permissions.perssion_name}</li>
                                                        <li>权限id： ${permissions.id}</li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </c:forEach>
                                    </ul>
                                </li>
                                <li><span class="folder">权限对应的用户</span>
                                    <ul>
                                        <c:forEach items="${role.users}" var="users">
                                            <ul>
                                                <li><span>${users.username}</span>
                                                    <ul>
                                                        <li>用户名称: ${users.username}</li>
                                                        <li>用户id: ${users.id}</li>
                                                        <li>用户状态: ${users.statusStr}</li>
                                                        <li>用户名称: ${users.phone_num}</li>
                                                        <li>用户邮箱: ${users.email}</li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </c:forEach>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </c:forEach>
        </ul>


        <!-- /.content-wrapper -->
        <footer class="main-footer no-print">
            <div class="float-right d-none d-sm-block">
                <b>Version</b> 3.0.0-beta.1
            </div>
            <strong>Copyright &copy; 2014-2018 <a href="http://adminlte.io">AdminLTE.io</a>.</strong> All rights
            reserved.
        </footer>

        <!-- Control Sidebar -->
        <aside class="control-sidebar control-sidebar-dark">
            <!-- Control sidebar content goes here -->
        </aside>
        <!-- /.control-sidebar -->
    </div>
    <!-- ./wrapper -->

    <!-- jQuery -->
    <script src="/plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap 4 -->
    <script src="/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- FastClick -->
    <script src="/plugins/fastclick/fastclick.js"></script>
    <!-- AdminLTE App -->
    <script src="/js/adminlte.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="/js/demo.js"></script>

    <script type="text/javascript">
        $(function(){
            $('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title', 'Collapse this branch'); //给ul添加parent_li后再在span标签加上 title属性
            $('.tree li.parent_li > span').on('click', function (e) {	//循环遍历span标签并监听点击事件,如果显示（visible）,让它在隐藏的同时改变title和图像
                var children = $(this).parent('li.parent_li').find(' > ul > li');
                if (children.is(":visible")) {
                    children.hide('fast');
                    $(this).attr('title', 'Expand this branch').find(' > i').addClass('icon-plus-sign').removeClass('icon-minus-sign');
                } else {
                    children.show('fast');//Expand this branch
                    $(this).attr('title', 'Collapse this branch').find(' > i').addClass('icon-minus-sign').removeClass('icon-plus-sign');
                }

                e.stopPropagation();
            });
        });
        new verTree({
            items:"#tree_list",
            type: "form",/*list:表格展示 data:一般展示 form：表单展示*/
            data:[{"id":16,"pid":0,"name":"系统管理","jingle":"system","href":"javascript:;","level":1,"sort":2,"icon":"icon-cog","status":1,"create_time":1531020243,"update_time":1531020299,"children":[{"id":25,"pid":16,"name":"管理员","jingle":"admin","href":"\/administrators\/index.html","level":2,"sort":1,"icon":"","status":1,"create_time":1531021892,"update_time":1531021892,"children":[{"id":28,"pid":25,"name":"新增","jingle":"add admin","href":"\/administrators\/add.html","level":3,"sort":1,"icon":"","status":1,"create_time":1538020839,"update_time":1538020839,"children":[]},{"id":29,"pid":25,"name":"编辑","jingle":"edit admin","href":"\/administrators\/edit.html","level":3,"sort":1,"icon":"","status":1,"create_time":1538020871,"update_time":1538020871,"children":[]},{"id":30,"pid":25,"name":"删除","jingle":"delete admin","href":"\/administrators\/delete.html","level":3,"sort":1,"icon":"","status":1,"create_time":1538023903,"update_time":1538023903,"children":[]}]},{"id":27,"pid":16,"name":"网站设置","jingle":"web site","href":"\/web_site_setting\/index.html","level":2,"sort":1,"icon":"","status":1,"create_time":1536912438,"update_time":1536912438,"children":[{"id":31,"pid":27,"name":"编辑","jingle":"edit site","href":"\/web_site_setting\/edit.html","level":3,"sort":1,"icon":"","status":1,"create_time":1538097015,"update_time":1538097015,"children":[]}]},{"id":32,"pid":16,"name":"友情链接","jingle":"friend link","href":"\/friend_link\/index.html","level":2,"sort":1,"icon":"","status":1,"create_time":1538278095,"update_time":1538278095,"children":[{"id":33,"pid":32,"name":"新增","jingle":"add link","href":"\/friend_link\/add.html","level":3,"sort":1,"icon":"","status":1,"create_time":1538279661,"update_time":1538279661,"children":[]}]}]},{"id":6,"pid":0,"name":"权限中心","jingle":"power","href":"javascript:;","level":1,"sort":3,"icon":"icon-lock","status":1,"create_time":1530934634,"update_time":1531020289,"children":[{"id":7,"pid":6,"name":"菜单管理","jingle":"menu","href":"\/menu\/index.html","level":2,"sort":1,"icon":"","status":1,"create_time":1530934662,"update_time":1531020115,"children":[{"id":8,"pid":7,"name":"新增菜单","jingle":"menu add","href":"\/menu\/add.html","level":3,"sort":1,"icon":"","status":1,"create_time":1530934854,"update_time":1530934854,"children":[]},{"id":9,"pid":7,"name":"编辑菜单","jingle":"menu edit","href":"\/menu\/edit.html","level":3,"sort":1,"icon":"","status":1,"create_time":1530934943,"update_time":1530934943,"children":[]},{"id":10,"pid":7,"name":"删除菜单","jingle":"menu delete","href":"\/menu\/delete.html","level":3,"sort":1,"icon":"","status":1,"create_time":1530934977,"update_time":1530934977,"children":[]}]},{"id":11,"pid":6,"name":"白名单管理","jingle":"write","href":"\/open_write\/index.html","level":2,"sort":1,"icon":"","status":1,"create_time":1530956796,"update_time":1530956796,"children":[{"id":12,"pid":11,"name":"新增名单","jingle":"write add","href":"\/open_write\/add.html","level":3,"sort":1,"icon":"","status":1,"create_time":1530963832,"update_time":1530963832,"children":[]},{"id":13,"pid":11,"name":"编辑","jingle":"write edit","href":"\/open_write\/edit.html","level":3,"sort":1,"icon":"","status":1,"create_time":1530963880,"update_time":1538018448,"children":[]},{"id":14,"pid":11,"name":"删除","jingle":"write delete","href":"\/open_write\/delete.html","level":3,"sort":1,"icon":"","status":1,"create_time":1530970686,"update_time":1538018463,"children":[]}]},{"id":15,"pid":6,"name":"角色管理","jingle":"role","href":"\/role\/index.html","level":2,"sort":1,"icon":"","status":1,"create_time":1530971574,"update_time":1530971574,"children":[{"id":22,"pid":15,"name":"查看","jingle":"role details","href":"\/role\/details.html","level":3,"sort":0,"icon":"","status":1,"create_time":1531021332,"update_time":1538018546,"children":[]},{"id":20,"pid":15,"name":"新增角色","jingle":"role add","href":"\/role\/add.html","level":3,"sort":1,"icon":"","status":1,"create_time":1531021094,"update_time":1531021094,"children":[]},{"id":21,"pid":15,"name":"编辑","jingle":"role edit","href":"\/role\/edit.html","level":3,"sort":1,"icon":"","status":1,"create_time":1531021136,"update_time":1538018922,"children":[]},{"id":23,"pid":15,"name":"删除","jingle":"role delete","href":"\/role\/delete.html","level":3,"sort":1,"icon":"","status":1,"create_time":1531021373,"update_time":1538018518,"children":[]},{"id":24,"pid":15,"name":"角色授权","jingle":"applies","href":"\/role\/apply.html","level":3,"sort":1,"icon":"","status":1,"create_time":1531021416,"update_time":1531021416,"children":[]}]}]},{"id":19,"pid":0,"name":"用户中心","jingle":"user center","href":"javascript:;","level":1,"sort":3,"icon":"icon-user","status":1,"create_time":1531020536,"update_time":1536912065,"children":[{"id":34,"pid":19,"name":"用户管理","jingle":"user","href":"\/user\/index.html","level":2,"sort":1,"icon":"","status":1,"create_time":1539824935,"update_time":1539824935,"children":[{"id":38,"pid":34,"name":"邮件推送","jingle":"email push","href":"\/user\/email_push.html","level":3,"sort":1,"icon":"","status":1,"create_time":1539828381,"update_time":1539828381,"children":[]},{"id":35,"pid":34,"name":"禁用","jingle":"disable user","href":"\/user\/disable_user.html","level":3,"sort":2,"icon":"","status":1,"create_time":1539827762,"update_time":1539828430,"children":[]},{"id":37,"pid":34,"name":"注销","jingle":"cancellation","href":"\/user\/cancellation.html","level":3,"sort":2,"icon":"","status":1,"create_time":1539827851,"update_time":1539828444,"children":[]}]}]},{"id":17,"pid":0,"name":"博客中心","jingle":"blog","href":"javascript:;","level":1,"sort":4,"icon":"icon-hot","status":1,"create_time":1531020432,"update_time":1538018320,"children":[{"id":45,"pid":17,"name":"文章管理","jingle":"blog","href":"\/blog\/index.html","level":2,"sort":1,"icon":"","status":1,"create_time":1548208237,"update_time":1548208237,"children":[{"id":46,"pid":45,"name":"文章审核","jingle":"examine","href":"\/blog\/examine.html","level":3,"sort":1,"icon":"","status":1,"create_time":1548208407,"update_time":1548208407,"children":[]}]},{"id":47,"pid":17,"name":"公告管理","jingle":"notice","href":"\/notice\/index.html","level":2,"sort":1,"icon":"","status":1,"create_time":1551319464,"update_time":1551319464,"children":[{"id":48,"pid":47,"name":"新增公告","jingle":"add notice","href":"\/notice\/add.html","level":3,"sort":1,"icon":"","status":1,"create_time":1551319880,"update_time":1551319880,"children":[]}]}]},{"id":39,"pid":0,"name":"邮件管理","jingle":"email","href":"javascript:;","level":1,"sort":4,"icon":"icon-email","status":1,"create_time":1539843564,"update_time":1539843772,"children":[{"id":40,"pid":39,"name":"模板管理","jingle":"template","href":"\/email_tpl\/index.html","level":2,"sort":1,"icon":"","status":1,"create_time":1539843814,"update_time":1539843814,"children":[{"id":41,"pid":40,"name":"新增","jingle":"add tpl","href":"\/email_tpl\/add.html","level":3,"sort":1,"icon":"","status":1,"create_time":1539844655,"update_time":1539844655,"children":[]},{"id":42,"pid":40,"name":"详情","jingle":"details","href":"\/email_tpl\/details.html","level":3,"sort":1,"icon":"","status":1,"create_time":1539912236,"update_time":1539912236,"children":[]},{"id":43,"pid":40,"name":"编辑","jingle":"edit email","href":"\/email_tpl\/edit.html","level":3,"sort":1,"icon":"","status":1,"create_time":1539912274,"update_time":1539912274,"children":[]}]}]},{"id":18,"pid":0,"name":"下载中心","jingle":"download","href":"javascript:;","level":1,"sort":5,"icon":"icon-download","status":1,"create_time":1531020491,"update_time":1531020491,"children":[]}],
            parent:"pid",
            params:"id",
            value:"name"
        });

        $("#browser").treeview({
            toggle: function() {
                console.log("%s was toggled.", $(this).find(">span").text());
            }
        });


    </script>
    <script src="/js/tree.js"></script>
</body>
</html>

