<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> view</h2>


<div>
	<p>
		<input type = 'text' id='reText' value='테스트 댓글'>
	</p>
	<p>
		<input type = 'text' id='replyer' value='replyer001'>
	</p>
	<p>
		<button id='saveBtn'>Save</button>
		
	</p>
</div>

<button id='delBtn'>DELETE BUTTON</button>
<button id='modBtn'>Update</button>

<script
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>
  
  
<script>
$(document).ready(function() {
	
	
	$("#modBtn").click(function(e){
		
		$.ajax({
			type:'post',
			url:'/replies/321/21',
			headers:{"Content-Type":"application/json", "X-HTTP-Method-Override": "PUT" },
			success:function(msg){		
				console.log(msg);
			}
		
	})
		
		
	}) //end ajax
	}); //end modBtn
	
	$("#delBtn").click(function(e){
		
		$.ajax({
			type:'delete',
			url:'/replies/321/21',
			success:function(msg){		
				console.log(msg);
			}
		});
		
	}) //end delBTn
	
	
	$("#saveBtn").click(function(e){
	
		var obj = {reText : $("#reText").val(),
				  replyer:$("#replyer").val()};
	
		
		$.ajax({
			type:'post',
			url:'/replies/321',
			headers:{"Content-Type":"application/json"},  //제일중요, json이라고 명시해야함.
			data: JSON.stringify(obj),
			success:function(result){
				console.log(result);
				console.log(result.reText);
			}
			
		}) //end ajax
		
		}) //end saveBtn

	


	



</script>	

</body>
</html>