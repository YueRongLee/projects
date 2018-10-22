<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
    <fieldset>
    	<legend>登入作業</legend>
    	<form method="post" action="uservalid.action">
    		<label>使用者名稱</label>
    		<input type="text" name="username"/>
    		<br/>
    		<label>使用者密碼</label>
    		<input type="password" name="password"/>
    		<input type="submit" value="登入"/>
    	</form>
    </fieldset>
  </body>
</html>
