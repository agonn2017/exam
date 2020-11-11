<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<strong>您现在所在的位置是:</strong>论文管理页面
	
	<form action="getPaperByPage" method="post">
		论文主题:<input type="text" name="title" value="${title }"/>
		论文类型:<select name="typeCode">
			<option value="-1">不限</option>
			<c:forEach items="${typeList }" var="type">
				<option value="${type.typeCode }" <c:if test="${typeCode==type.typeCode }"> selected="selected"</c:if>>${type.typeName }</option>
			</c:forEach>
			
		</select>
		<input type="submit" value="查询"/>
		<!--隐藏域用于分页  -->
		<input type="hidden" id="pageNo" name="curPageNo"/>
		<a href="toAdd">增加论文</a>
	</form>
	
	<table border="1">
		<tr>
			<td>论文主题</td>
			<td>作者</td>
			<td>论文类型</td>
			<td>发表时间</td>
			<td>修改时间</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.pageList }" var="paper">
			<tr id="tr${paper.id}">
				<td>${paper.title }</td>
				<td>${paper.createdBy }</td>
				<td>${paper.typeName }</td>
				<td><fmt:formatDate value="${paper.creationDate }" pattern="yyyy-MM-dd"/>
				</td>
				<td><fmt:formatDate value="${paper.modifyDate }" pattern="yyyy-MM-dd"/></td>
				<td>
					<a href="getById?id=${paper.id }">修改</a>&nbsp;&nbsp;
					<a href="javascript:" onclick="deletepaper(${paper.id})">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div id="page">
		<a href="javascript:void(0)"
			onclick="changePage(1)">首页</a>&nbsp;&nbsp;
		<a href="javascript:void(0)" onclick="changePage(${page.curPageNo-1})"
			>上一页</a>&nbsp;&nbsp;
		<a href="javascript:void(0)"
				onclick="changePage(${page.curPageNo+1})">下一页</a>&nbsp;&nbsp;
		<a href="javascript:void(0)" onclick="changePage(${page.totalPage})">尾页</a>
		第${page.curPageNo }页/共${page.totalPage }页
		(${page.totalCount }条)
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/paper.js"></script>
	
</body>
</html>