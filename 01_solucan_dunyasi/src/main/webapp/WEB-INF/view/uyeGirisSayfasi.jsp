<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<%@ page isELIgnored="false" %>

<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Giriş Sayfasına Hoşgeldiniz...</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

	<div>
		
		<div id="loginbox" style="margin-top: 50px;" class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
			
			<div class="panel panel-info">

				<div class="panel-heading">
					<div class="panel-title">Uye Girişi</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<!-- Login Form -->
					<form action="authenticateTheUser" method="POST" class="form-horizontal">

					    <!-- Place for messages: error, alert etc ... -->
					    <div class="form-group">
					        <div class="col-xs-15">
					            <div>
										
								<!-- Check for login error -->
	
								<c:if test="${param.error != null}">

									<div class="alert alert-danger col-xs-offset-1 col-xs-10">
										Geçersiz kullanıcı adı veya şifre.
									</div>
								
								</c:if>
														
										
								<c:if test="${param.logout != null}">		            
									<div class="alert alert-success col-xs-offset-1 col-xs-10">
										Başarılı bir şekilde çıkış yaptınız.
									</div>
								</c:if>

					            </div>
					        </div>
					    </div>

						<!-- User name -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							
							<input type="text" name="username" placeholder="kullanıcı adı" class="form-control">
						</div>

						<!-- Password -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							
							<input type="password" name="password" placeholder="parola" class="form-control" >
						</div>

						<!-- Login/Submit Button -->
						<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-success">Giriş</button>
							</div>
							<div class="col-sm-6 controls">
								<a type="button" class="btn btn-warning" href="anasayfa">Anasayfa</a>
							</div>
						</div>
						
						<!-- Adding Token Manually -->
						
						<!-- EL default olarak bende kapalı olduğundan aşağıdaki kod çalışmıyormuş ve bu yüzden spring yukarıdaki 
						normal forma "request method post is not supported" hatasını verdiriyormuş. Şimdi ancak anladım bunu. Yalnız
						o zaman benim EL'im neden default olarak kapalı da dışardan gelen dosyaların default olarak açık... -->
					 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
 						
 						
					</form>

				</div>

			</div>

		</div>

	</div>

</body>
</html>