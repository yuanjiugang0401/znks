<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>答题者管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/znks/znGeneralUser/">答题者列表</a></li>
		<shiro:hasPermission name="znks:znGeneralUser:edit"><li><a href="${ctx}/znks/znGeneralUser/form">答题者添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="znGeneralUser" action="${ctx}/znks/znGeneralUser/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>昵称</th>
				<th>性别</th>
				<th>年龄</th>
				<th>手机号</th>
				<th>年龄</th>
				<th>用户类型</th>
				<th>年级</th>
				<th>修改时间</th>
				<th>备注</th>
				<shiro:hasPermission name="znks:znGeneralUser:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="znGeneralUser">
			<tr>

				<td>${znGeneralUser.nickName}</td>
				<td>${znGeneralUser.sex}</td>
				<td>${znGeneralUser.age}</td>
				<td>${znGeneralUser.phoneNumber}</td>
				<td>${znGeneralUser.userType}</td>
				<td>${znGeneralUser.grade}</td>
				<td>${znGeneralUser.company}</td>
				<td><a href="${ctx}/znks/znGeneralUser/form?id=${znGeneralUser.id}">
					<fmt:formatDate value="${znGeneralUser.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${znGeneralUser.remarks}
				</td>
				<shiro:hasPermission name="znks:znGeneralUser:edit"><td>
    				<a href="${ctx}/znks/znGeneralUser/form?id=${znGeneralUser.id}">修改</a>
					<a href="${ctx}/znks/znGeneralUser/delete?id=${znGeneralUser.id}" onclick="return confirmx('确认要删除该答题者吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>