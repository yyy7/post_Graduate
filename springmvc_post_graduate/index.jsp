<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
  </head>
  
  <body>
   
  </body>
</html>
<script type="text/javascript">
$(function(){
   $.ajax({
          type:"post",
          url:"user.do",
          data:{},
          dataType:"json",
          async:false,
          success:function(data){
            alert(data.result);               
          },
          error:function(msg,textStatus, errorThrown){
             alert("获取服务器资源失败!"+msg.responseText);
          }
         });

});


</script>


