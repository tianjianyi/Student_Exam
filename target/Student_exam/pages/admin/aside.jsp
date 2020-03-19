<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p><security:authentication property="principal.username"></security:authentication></p>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/pages/admin/main.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>

			<li class="treeview"><a href="${pageContext.request.contextPath}/student/findAll.do"> <i class="fa fa-pie-chart"></i>
					<span>管理学生</span>
			</a></li>
			<li class="treeview"><a href="${pageContext.request.contextPath}/teacher/findAll.do"> <i class="fa fa-cube"></i>
					<span>管理教师</span>
			</a></li>
			<li class="treeview"><a href="${pageContext.request.contextPath}/course/findAll.do"> <i class="fa fa-laptop"></i>
				<span>管理课程</span>
			</a></li>


		</ul>
	</section>
	<!-- /.sidebar -->
</aside>