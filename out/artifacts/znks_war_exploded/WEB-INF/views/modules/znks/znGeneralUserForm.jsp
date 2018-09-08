<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>答题者管理</title>
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
		<li><a href="${ctx}/znks/znGeneralUser/">答题者列表</a></li>
		<li class="active"><a href="${ctx}/znks/znGeneralUser/form?id=${znGeneralUser.id}">答题者<shiro:hasPermission name="znks:znGeneralUser:edit">${not empty znGeneralUser.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="znks:znGeneralUser:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="znGeneralUser" action="${ctx}/znks/znGeneralUser/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">用户ZN：</label>
			<div class="controls">
				<form:input path="zn" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用户昵称：</label>
			<div class="controls">
				<form:input path="nickName" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">密码（明文）：</label>
			<div class="controls">
				<form:input path="password" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">密码（暗文）：</label>
			<div class="controls">
				<form:input path="passwordEncrypt" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">性别：0女、1男：</label>
			<div class="controls">
				<form:input path="sex" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">年龄：</label>
			<div class="controls">
				<form:input path="age" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">头像链接：</label>
			<div class="controls">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电话号码（手机）：</label>
			<div class="controls">
				<form:input path="phoneNumber" htmlEscape="false" maxlength="15" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用户类型:0社会人、1学生、2老师、3其他：</label>
			<div class="controls">
				<form:input path="userType" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">个性签名：</label>
			<div class="controls">
				<form:input path="signature" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用户简介：</label>
			<div class="controls">
				<form:textarea path="userDescribe" htmlEscape="false" rows="4" maxlength="1000" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">年级（K1-K12）：</label>
			<div class="controls">
				<form:input path="grade" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用户所属单位：</label>
			<div class="controls">
				<form:input path="company" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">省份：</label>
			<div class="controls">
				<form:input path="province" htmlEscape="false" maxlength="10" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">城市：</label>
			<div class="controls">
				<form:input path="city" htmlEscape="false" maxlength="10" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">东经：</label>
			<div class="controls">
				<form:input path="longitude" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">北纬：</label>
			<div class="controls">
				<form:input path="latitude" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">结算账户号：</label>
			<div class="controls">
				<form:input path="accountNo" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">账户类型:0银行卡、1支付宝、2微信：</label>
			<div class="controls">
				<form:input path="accountType" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">附加信息：</label>
			<div class="controls">
				<form:input path="additional" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">排位:8宇宙最强、7战圣、6战神、5英雄、4带头大哥、3二当家、2三弟、1小弟、0无名氏：</label>
			<div class="controls">
				<form:input path="rankings" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用户来源:0随机注册、1推荐、2机构导入、3其他：</label>
			<div class="controls">
				<form:input path="source" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用户状态:0无效、1有效、2审查中：</label>
			<div class="controls">
				<form:input path="status" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">登录状态:0未登录、1已登录：</label>
			<div class="controls">
				<form:input path="onOffLine" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">创建时间：</label>
			<div class="controls">
				<input name="created" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${znGeneralUser.created}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">更新时间：</label>
			<div class="controls">
				<input name="modified" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${znGeneralUser.modified}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
			<shiro:hasPermission name="znks:znGeneralUser:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>