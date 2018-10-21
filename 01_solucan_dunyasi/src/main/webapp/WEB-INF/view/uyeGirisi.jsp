<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

*******************GİRDİK ARTIK......................


	<form:form action="logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>
	
	<br><br>
	
	
	<div>
		<form onsubmit="return confirm('Uyeliğiniz silinecek. Emin misiniz?');" 
			action="${pageContext.request.contextPath}/uyelikSil" method="GET" >
			<input type="hidden" name="user" value='<security:authentication property="principal.username"/>'/> 
			<input type="submit" value="Üyelikten Çık"/>
		</form>
	</div>
	
	<br>
	<br>
	
	<div>
		<a href="${pageContext.request.contextPath}/sifreDegistir">şifre değiştirmek için tıklayınız...</a>
	</div>
	
	
	
	
	<script>
		function uyelikSil() {
    		
			if(confirm("Üyeliğiniz silinmesini istediğinizden emin misiniz?")){
				
			}
						
		}
	</script>
</body>
</html>