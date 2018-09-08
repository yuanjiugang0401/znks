<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>问题信息管理</title>
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
		<li class="active"><a href="${ctx}/znks/znQuestions/">问题信息列表</a></li>
		<shiro:hasPermission name="znks:znQuestions:edit"><li><a href="${ctx}/znks/znQuestions/form">问题信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="znQuestions" action="${ctx}/znks/znQuestions/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>问题描述：</label><form:input path="questionDescribe" htmlEscape="false" maxlength="50" class="input-medium"/></li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>所属年级</th>
				<th>所属科目</th>
				<th>题型</th>
				<th>问题描述</th>
				<th>标准答案</th>
				<th>难度系数</th>
				<th>问题价值</th>
				<th>修改时间</th>
				<th>备注</th>
				<shiro:hasPermission name="znks:znQuestions:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="znQuestions">
			<tr>
				<td>${znQuestions.grade}</td>
				<td><c:if test="${znQuestions.subjectId==0}">数学</c:if>
					<c:if test="${znQuestions.subjectId==1}">语文</c:if>
					<c:if test="${znQuestions.subjectId==2}">外语</c:if>
				</td>
				<td>${znQuestions.questionType}</td>
				<td>${znQuestions.questionDescribe}</td>
				<td>${znQuestions.standardAnswer}</td>
				<td>${znQuestions.difficultyLevel}</td>
				<td>${znQuestions.questionValue}</td>
				<td><a href="${ctx}/znks/znQuestions/form?id=${znQuestions.id}">
					<fmt:formatDate value="${znQuestions.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${znQuestions.remarks}
				</td>
				<shiro:hasPermission name="znks:znQuestions:edit"><td>
    				<a href="${ctx}/znks/znQuestions/form?id=${znQuestions.id}">修改</a>
					<a href="${ctx}/znks/znQuestions/delete?id=${znQuestions.id}" onclick="return confirmx('确认要删除该问题信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>