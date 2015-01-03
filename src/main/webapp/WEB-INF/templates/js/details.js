function comment(){
	var articleId = $("#articleId").val();
	var toUser = $("#toUser").val();
	var fromUser = $("#fromUser").val();
	var content =$("#content").val();
	var isRecomment = 0; 
	$.post("comment",{
		articleId:articleId,
		toUser:toUser,
		fromUser:fromUser,
		content:content,
		isRecomment:isRecomment
		},
		function (){
			location.href="details?articleId="+articleId;
		}
	); 
}

//回复评论
function recomment(commentId){
	var articleId = $("#articleId").val();
	var toUser = $("#commentauthor"+commentId).html();
	
	var content = $("#recommentInput"+commentId).val();
	var isRecomment = 1; 
	var recommentId = commentId;
	$.post("comment",{
		articleId:articleId,
		toUser:toUser,
		
		content:content,
		isRecomment:isRecomment,
		recommentId:recommentId
		},
		function (date){
			$.each(date,function(k,v){
				if(k == "100"){
					location.href="details?articleId="+articleId;
				}else{
					$.scojs_message(v, $.scojs_message.TYPE_ERROR);
				}
			});
			
		}
	); 
}

function star(){

	var articleId = $("#articleId").val();
	$.post("star",{
		articleId:articleId,
		},
		function (date){
			$.each(date,function(k,v){
				$("#star").html(v);
			});
		}
	); 
	$("#likebtn").addClass("active");
	$("#likebtn").attr("disabled","disabled");

}