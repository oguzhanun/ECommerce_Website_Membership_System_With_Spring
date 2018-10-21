<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">  
	<meta http-equiv="content-type" content="text/html; charset=UTF-8"> 
	<meta name="refresh" content="1" />
	<title>Uye Oluştur</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<style type="text/css">
		.errors{
			color:red;
		}
	</style>
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<h2>Üyelik Formu</h2>
	<p><i>Tabloda * ile işaretli alanları doldurmanız gerekmektedir.</i></p>
	
	<c:if test="${uyumsuz}"><p class="errors">Şifre uyumsuz...</p></c:if>
	<c:if test="${kullaniciVar}"><p class="errors">Bu kullanıcı adı zaten var...</p></c:if>
	<table>
		<form:form modelAttribute="musteri" action="uyeKayit" method="POST" autoComplete="off">
			<form:hidden path="id"/>
			<tr>
				<td>
					*İsim :
				</td>
				<td>
					<form:input  path="isim"></form:input>
					<form:errors path="isim" cssClass="errors"/>
				</td>
			</tr>
			<tr>
				<td>
					*Soyisim :
				</td>
				<td>
					<form:input  path="soyisim"></form:input>
					<form:errors path="soyisim" cssClass="errors"/>
				</td>
			</tr>
			<tr>
				<td>
					*Email(Kullanıcı Adı) :
				</td>
				<td>
					<form:input  path="email"></form:input>
					<form:errors path="email" cssClass="errors"/>
				</td>
			</tr>
			<tr>
				<td>
					*Telefon :
				</td>
				<td>
					<form:input path="telefon"/>
					<form:errors path="telefon" cssClass="errors"/>
				</td>
			</tr>
			<tr>
				<td>
					*Adres :
				</td>
				<td>
					<form:input  path="adres"></form:input>
					<form:errors path="adres" cssClass="errors"/>
				</td>
			</tr>
			<tr>
				<td>
					*Şifre :
				</td>
				<td>
					<form:password  path="sifre"></form:password>
					<form:errors path="sifre" cssClass="errors"/>
					
				</td>
			</tr>
			<tr>
				<td>
					*Şifre Kontrol :
				</td>
				<td>
					<form:password   path="sifreKontrol"></form:password >
					<form:errors path="sifreKontrol" cssClass="errors"/>
				</td>
			</tr>
			
				<td>
					<input type="submit" value="Kayıt"/>
				</td>
		</form:form>
	</table>
</body>
</html>