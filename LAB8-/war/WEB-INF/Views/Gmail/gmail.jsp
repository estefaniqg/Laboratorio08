<%@ page import="java.util.List"%>
<%@ page import="model.entity.Usuario"%>
<%@ page import="com.google.appengine.api.users.User"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>

<%@ page import="model.entity.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  
 
	 UserService us = UserServiceFactory.getUserService();
	 Usuario user = us.getCurrentUser();
	 %>
		 <h1>Información de la Cuenta Google</h1>
		 <br><a href='../'>Regresar...</a>"
		 <br/><b>User :</b>"
		 
		<label><%=user.getName()%></label>
		
		 
		 <a href='"+ us.createLogoutURL(req.getRequestURI())+"'> Cerrar sesión </a>"
		 

</body>
</html>