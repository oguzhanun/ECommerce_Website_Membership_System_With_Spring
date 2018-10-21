<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
 
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Şifre Değiştirme</title>
	<style type="text/css">
		.error{
			color:red;
		}
	</style>
</head>
<body>
<br><br>
	<div>
			<div class="error"><c:if test="${uyumsuz}"> ESKİ ŞİFRENİZ DOĞRULANAMADI...</c:if></div>
			
			<div class="error"><c:if test="${sifreKontrolDurumu}"> GİRDİĞİNİZ ŞİFRELER UYUMSUZ...</c:if></div>
			<br><br>
			
			<form action="${pageContext.request.contextPath}/sifreDegisikliginiIsle" method="get">

				<input type="hidden" name="user" value="<security:authentication property='principal.username'/>"/>
				
				<input type="text" name="eskiSifre"/>
				<br><br>
				<input type="text" name="yeniSifre"/>
				<br><br>
				<input type="text" name="sifreKontrol"/>
				<br><br>
				<input type="submit" value="Degistir"/>
			</form>
	</div>

</body>
</html>