$(document).ready(function(){
	//表单提交验证
	$("form").submit(function(){
		 //提交按钮时验证重名
        var flag = checkTitle();
        if(flag){
        	return false;
        }
		//非空验证
		$("#titleSpan").text("");
		$("#summarySpan").text("");
		$("#contentSpan").text("");
		var title = $("#title").val();
		var summary=$("#summary").val();
		if(title=='' || title==null){
			$("#titleSpan").text("标题不能为空");
			return false;
		}
		else if(summary=='' || summary==null){
			$("#summarySpan").text("摘要不能为空");
			return false;
		}
		
		//验证文件类型
		var filepath = $("input[type='file']").val();
        var extStart = filepath.lastIndexOf(".");
        var ext = filepath.substring(extStart, filepath.length);
        if (ext != ".doc" && ext != ".docx") {
        	$("#contentSpan").text("文件格式不正确");
        	return false;
        }
        return true;
	});
	
	//标题控件失去焦点事件验证重名
	$("#title").blur(checkTitle);
	
})

//标题占用,返回true
function checkTitle(){
	$("#titleSpan").text("");
	var title = $("#title").val();
	var flag=false;
	$.ajax({
		url:"checkTitleExist",
		data:{"title":title},   //参数
		type:"post",
		async:false,
		dataType:"text",
		success:function(result){
			if(result=="true"){
				$("#titleSpan").text("此论文题目已经存在,请重新输入");
				flag= true;
			}
		}
	})
	return flag;
}

