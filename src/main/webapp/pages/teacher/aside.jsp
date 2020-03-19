<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
				<p>${username}</p>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/pages/teacher/main.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>

			<li class="treeview"><a href="${pageContext.request.contextPath}/teacher/findSelectStudent.do"> <i class="fa fa-pie-chart"></i>
					<span>选课学生</span>
			</a></li>
			<li class="treeview"><a href="${pageContext.request.contextPath}/teacher/findGrade.do"> <i class="fa fa-cube"></i>
					<span>录入成绩</span>
			</a></li>
			<%--<li class="treeview"><a href="${pageContext.request.contextPath}/student/alreadySelect.do"> <i class="fa fa-laptop"></i>--%>
				<%--<span>已选课程</span>--%>
			<%--</a></li>--%>


		</ul>
	</section>
	<!-- /.sidebar -->
</aside>