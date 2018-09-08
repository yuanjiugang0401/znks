<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>问题信息管理</title>
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
		<li><a href="${ctx}/znks/znQuestions/">问题信息列表</a></li>
		<li class="active"><a href="${ctx}/znks/znQuestions/form?id=${znQuestions.id}">问题信息<shiro:hasPermission name="znks:znQuestions:edit">${not empty znQuestions.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="znks:znQuestions:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="znQuestions" action="${ctx}/znks/znQuestions/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">所属年级（K1-K12）：</label>
			<div class="controls">
				<form:select path="grade">
					<form:options items="${fns:getDictList('znks_grade')}" maxlength="200" class="input-xxlarge " itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">所属科目:0数、1语、2外：</label>
			<div class="controls">
				<form:input path="subjectId" htmlEscape="false" maxlength="200" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">题型:1单选、2多选、3判断、4填空、5计算、6问答、7解答、8论述、9完形填空、10证明、11阅读理解、12作文、13智力题、自定义：</label>
			<div class="controls">
				<form:input path="questionType" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">题目描述：</label>
			<div class="controls">
				<form:textarea path="questionDescribe" htmlEscape="false" rows="4" maxlength="2000" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">选项描述1：</label>
			<div class="controls">
				<form:input path="option1" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">选项描述2：</label>
			<div class="controls">
				<form:input path="option2" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">选项描述3：</label>
			<div class="controls">
				<form:input path="option3" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">选项描述4：</label>
			<div class="controls">
				<form:input path="option4" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">选项描述5：</label>
			<div class="controls">
				<form:input path="option5" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">选项描述6：</label>
			<div class="controls">
				<form:input path="option6" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">选项描述7：</label>
			<div class="controls">
				<form:input path="option7" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">选项描述8：</label>
			<div class="controls">
				<form:input path="option8" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">选项描述9：</label>
			<div class="controls">
				<form:input path="option9" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">选项描述10：</label>
			<div class="controls">
				<form:input path="option10" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">提示内容：</label>
			<div class="controls">
				<form:input path="tips" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">标准答案：</label>
			<div class="controls">
				<form:textarea path="standardAnswer" htmlEscape="false" rows="4" maxlength="1000" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">难度系数（1-5颗星）：</label>
			<div class="controls">
				<form:input path="difficultyLevel" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">问题价值（0-5滴血）：</label>
			<div class="controls">
				<form:input path="questionValue" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">出题者id/专家id：</label>
			<div class="controls">
				<form:input path="expertId" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">专家ZN：</label>
			<div class="controls">
				<form:input path="expertZn" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">题目状态:0未通过、1通过、2审核中：</label>
			<div class="controls">
				<form:input path="status" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">创建时间：</label>
			<div class="controls">
				<input name="created" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${znQuestions.created}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">更新时间：</label>
			<div class="controls">
				<input name="modified" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${znQuestions.modified}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
			<shiro:hasPermission name="znks:znQuestions:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>