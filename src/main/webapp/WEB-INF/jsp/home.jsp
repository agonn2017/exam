<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	 h3{
            height: 40px;
            width:300px;
            margin: 0 auto;
        }
    .aside{
    	border:1px solid blue;
    	width:200px;
    	height: 300px;
    	float: left;
    }
     .content{
    	border:1px solid blue;
    	margin-left:10px;
    	width:650px;
    	height: 300px;
    	float: left;
    }
    
    li{
    	list-style: none;
    }
</style>
</head>
<body>
    <h3>论文管理系统</h3>
    <span>欢迎你&nbsp;&nbsp;,${user.userName }</span>&nbsp;&nbsp;
    	<a href="${pageContext.request.contextPath }/user/logout">注销</a>
    <div>
    
	    <div class="aside">
			
			<ul>
				<li><h3>功能列表</h3></li>
				<li><a href="welcome" target="paperFrame">用户管理</a></li>
				<li><a href="getPaperByPage" target="paperFrame">论文管理</a></li>
				<li><a href="welcome" target="paperFrame">公共代码</a></li>
			</ul>
		</div>
	    <div class="content">
			<iframe name="paperFrame" width="100%" height="100%"
				src="${pageContext.request.contextPath }/paper/welcome"></iframe>
		</div>
    </div>
</body>
</html>