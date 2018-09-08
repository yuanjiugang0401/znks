<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>试卷信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/znks/znExaminationInfo/">试卷信息列表</a></li>
		<li class="active"><a href="${ctx}/znks/znExaminationInfo/form?id=${znExaminationInfo.id}">试卷信息<shiro:hasPermission name="znks:znExaminationInfo:edit">${not empty znExaminationInfo.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="znks:znExaminationInfo:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="znExaminationInfo" action="${ctx}/znks/znExaminationInfo/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">试卷id：</label>
			<div class="controls">
				<form:input path="testId" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">总分：</label>
			<div class="controls">
				<form:input path="totalScore" htmlEscape="false" maxlength="4" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">题目数量：</label>
			<div class="controls">
				<form:input path="totalQuestions" htmlEscape="false" maxlength="4" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">考试时间（分钟）：</label>
			<div class="controls">
				<form:input path="testTime" htmlEscape="false" maxlength="4" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">题目List：</label>
			<div class="controls">
				<form:textarea path="questionList" htmlEscape="false" rows="4" maxlength="1000" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">分值List：</label>
			<div class="controls">
				<form:textarea path="scoreList" htmlEscape="false" rows="4" maxlength="1000" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">试卷状态:0未通过、1通过、2审核中：</label>
			<div class="controls">
				<form:input path="status" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">创建时间：</label>
			<div class="controls">
				<input name="created" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${znExaminationInfo.created}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">更新时间：</label>
			<div class="controls">
				<input name="modified" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${znExaminationInfo.modified}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="znks:znExaminationInfo:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>