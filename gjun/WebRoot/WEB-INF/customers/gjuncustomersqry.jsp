<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'gjuncustomersqry.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		//使用jquery
		$(document).ready(
			function()
			{
				//alert('hi');
				$('#btnGo').click(
					function(e)
					{
						firstName=$('#firstName').val();
						if(firstName.length==0)
						{
							alert('查詢內容必須要輸入!!');
							e.preventDefault(); //放棄掉submit動作
						}
					}
				);
				
			}
		);
	</script>
  </head>
  
  <body>
   <s:form action="custqrybyname.action">
   	<label>First Name:</label>
   	<s:textfield name="firstName" id="firstName"/>
   	<s:submit value="查詢" id="btnGo"/>
   	<s:reset value="清除"/>
   </s:form>
  </body>
</html>
