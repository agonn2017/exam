<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<strong>您现在所在的位置是:</strong>论文管理页面>>发表论文页面
	<form action="add" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>论文题目:</td>
				<td><input type="text" name="title" id="title"/><span id="titleSpan" style="color: red"> </span></td>
			</tr>
			<tr>
				<td>类型:</td>
				<td><select name="typeCode">
						<c:forEach items="${typeList }" var="type">
							<option value="${type.typeCode }" >${type.typeName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>论文摘要:</td>
				<td><textarea rows="5" cols="20" id="summary" name="paperSummary"></textarea><span id="summarySpan" style="color: red"> </span></td>
			</tr>
			<tr>
				<td>论文内容:</td>
				<td><input type="file" name="content" id="file"/>
					<span id="contentSpan" style="color: red"> </span>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="保存"/>
					<input type="button" value="返回"/>
				</td>
			</tr>
		</table>
	</form>
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/add.js"></script>
</body>
</html>