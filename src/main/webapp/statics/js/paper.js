$(document).ready(function() {
	$(".trHead").css("background", "#79CDCD");
	$("tr:odd").css("background", "#FFE4E1");
	$("tr:even:not(.trHead)").css("background", "#C1FFC1");
})
//分页
function changePage(pageNo) {
	$("#pageNo").val(pageNo);
	$("form").submit();
}
//删除
function deletepaper(paperId){
	if(confirm("确定要删除吗")){
		$.ajax({
			url:"delete",
			data:{"id":paperId},   //参数
			type:"post",
			async:false,
			dataType:"text",
			success:function(result){
				if(result=="true"){
					$("#tr"+paperId).remove();
					alert("删除成功!");
				}
				else{
					alert("删除失败");
				}
			}
		})
	}
}
