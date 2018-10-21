<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!doctype html>

<html>

<head>
	<title>Anasayfa</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>

<body>
	<h2>Kırmızı Kaliforniya Solucanı</h2>
	<hr>
	

	<a href="${pageContext.request.contextPath}/uyeGirisi">Uye Girişi</a>
	<br><br>
	<a href="${pageContext.request.contextPath}/uyeOlustur">Uye Ol</a>

	<!-- Add a reference to Leaders Page -->
	<security:authorize access="hasRole('MANAGER')">
		<p><a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a> (Only for managing peeps)</p>
	</security:authorize>
	
	<!-- Add a reference to Systems Page -->
	<security:authorize access="hasRole('ADMIN') or hasRole('MANAGER')">
		<p><a href="${pageContext.request.contextPath}/systems">Systems Meeting</a> (Only for admin peeps)</p>
	</security:authorize>
	
	<br><br><br>
	
	<security:authorize access="hasRole('USER')">
		<form:form action="logout" method="POST">
			<input type="submit" value="Logout"/>
		</form:form>
	</security:authorize>
	
	<br><br>
	
	<p><a href="${pageContext.request.contextPath}/iyzipay/odemeSayfasi">Ödeme Sayfası</a></p>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>

</html>