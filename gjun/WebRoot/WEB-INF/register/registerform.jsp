<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'registerform.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <s:form method="post" action="save.action">
   	<s:textfield name="form.userName" label="使用者名稱"></s:textfield>
   	<s:password name="form.password" label="密碼"></s:password>
   	<s:textfield name="form.name" label="真實姓名"></s:textfield>
   	<s:textfield name="form.email" label="EMIAL"></s:textfield>
   	<s:textfield name="form.companyName" label="公司行號"></s:textfield>
   	<s:submit value="註冊"></s:submit>
   </s:form>
   
  </body>
</html>
