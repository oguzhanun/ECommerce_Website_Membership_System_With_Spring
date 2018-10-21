<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Ödeme Sayfası</title>

</head>
<body>
	<!-- 
	<form action="${pageContext.request.contextPath}/iyzipay/odemeSayfasi" method="post">
		<input type="hidden" type="number" name="price" value="1000"/>
		<input type="number" name="paidPrice" value="1000"/>
		<input type="hidden" name="currency" value="TRY"/>
		<input type="number" name="installment" value="1"/>
		
		<input type="hidden" name="callbackUrl" value="http://localhost:9090/al_solucan_gubresi/iyzipay/odemeDonusu"/>
		
		Kart Numarası : <input type="text" name="cardNumber" />
		Son Kullanım Tarihi : <input type="text" name="expireYear" />
		Son Kullanım Ayı : <input type="text" name="expireMonth"/>
		CVC : <input type="text" name="cvc"/>
		Kart Sahibi : <input type="text" name="cardHolderName"/>
		
		<input type="hidden" name="id(Buyer)" value="1"/>
		<input type="hidden" name="name(Buyer)" value="İLK ADAM"/>
		<input type="hidden" name="surname(Buyer)" value="SOYAD"/>
		<input type="hidden" name="identityNumber(Buyer)" value="40234978782"/>
		<input type="hidden" name="city(Buyer)" value="SAMSUN"/>
		<input type="hidden" name="country(Buyer)" value="TÜRKİYE"/>
		<input type="hidden" name="email(Buyer)" value="oguzhanun@hotmail.com"/>
		<input type="hidden" name="gsmNumber(Buyer)" value="1000"/>
		<input type="hidden" name="ip(Buyer)" value="127.0.1.0.1"/>
		<input type="hidden" name="registrationAddress(Buyer)" value="bla bla"/>
		<input type="hidden" name="contactName(BillingAddress)" value="seher ün"/>
		<input type="hidden" name="city(BillingAddress)" value="samsun"/>
		<input type="hidden" name="country(BillingAddress)" value="türkiye"/>
		<input type="hidden" name="address(BillingAddress)" value="bla bla"/>
		<input type="hidden" name="contactName(ShippingAddress)" value="seher ün"/>
		<input type="hidden" name="city(ShippingAddress)" value="samsun"/>
		<input type="hidden" name="country(ShippingAddress)" value="türkiye"/>
		<input type="hidden" name="address(ShippingAddress)" value="bla bla"/>
		<input type="hidden" name="id(BasketItems)" value="01"/>
		<input type="hidden" name="itemType(BasketItems)" value="PHYSICAL"/>
		<input type="hidden" name="name(BasketItems)" value="sepetteki ürün adı"/>
		<input type="hidden" name="category1(BasketItems)" value="ürün kategorisi"/>
		<input type="hidden" name="price(BasketItems)" value="1000"/>
			
		<input type="submit" value="Ödeme Yap"/>
	</form>
	 -->
	 
	<form method="post" action="https://secure.payu.com.tr/order/lu.php">
	    <input name="MERCHANT" value="PAYUDEMO" type="hidden">
	    <input name="ORDER_REF" value="112457" type="hidden">
	    <input name="ORDER_DATE" value="2018-09-22 14:55:35" type="hidden">
	    <input name="ORDER_PNAME[]" value="MacBook Air 13 inch" type="hidden">
	    <input name="ORDER_PNAME[]" value="iPhone 4S" type="hidden">
	    <input name="ORDER_PCODE[]" value="MBA13" type="hidden">
	    <input name="ORDER_PCODE[]" value="IP4S" type="hidden">
	    <input name="ORDER_PINFO[]" value="Extended Warranty - 5 Years" type="hidden">
	    <input name="ORDER_PINFO[]" value="" type="hidden">
	    <input name="ORDER_PRICE[]" value="2000" type="hidden">
	    <input name="ORDER_PRICE[]" value="500.50" type="hidden">
	    <input name="ORDER_PRICE_TYPE[]" value="GROSS" type="hidden">
	    <input name="ORDER_PRICE_TYPE[]" value="NET" type="hidden">
	    <input name="ORDER_QTY[]" value="1" type="hidden">
	    <input name="ORDER_QTY[]" value="2" type="hidden">
	    <input name="ORDER_VAT[]" value="24" type="hidden">
	    <input name="ORDER_VAT[]" value="24" type="hidden">
	    <input name="ORDER_SHIPPING" value="50" type="hidden">
	    <input name="PRICES_CURRENCY" value="EUR" type="hidden">
	    <input name="DISCOUNT" value="10" type="hidden">
	    <input name="DESTINATION_CITY" value="București" type="hidden">
	    <input name="DESTINATION_STATE" value="București" type="hidden">
	    <input name="DESTINATION_COUNTRY" value="RO" type="hidden">
	    <input name="PAY_METHOD" value="CCVISAMC" type="hidden">
	    <input name="TESTORDER" value="TRUE" type="hidden">
	    <input name="LANGUAGE" value="EN" type="hidden">
	    <input name="BILL_FNAME" value="John" type="hidden">
	    <input name="BILL_LNAME" value="Doe" type="hidden">
	    <input name="BILL_EMAIL" value="john.doe@example.com" type="hidden">
	    <input name="BILL_PHONE" value="+40771000001" type="hidden">
	    <input name="BILL_COUNTRYCODE" value="RO" type="hidden">
	    <input name="BILL_ADDRESS" value="17 Sample Street" type="hidden">
	    <input name="BILL_ZIPCODE" value="987654" type="hidden">
	    <!-- AIRLINE_INFO parameter usage sample (optional) -->
	    <input name="AIRLINE_INFO[PASSENGER_NAME]" value="John Doe" type="hidden">
	    <input name="AIRLINE_INFO[TICKET_NUMBER]" value="1497434371.1006" type="hidden">
	    <!-- Information about first transit of flight -->
	    <input name="AIRLINE_INFO[FLIGHT_SEGMENTS][0][DEPARTURE_DATE]" value="2017-06-14" type="hidden">
	    <input name="AIRLINE_INFO[FLIGHT_SEGMENTS][0][DEPARTURE_AIRPORT]" value="ABC" type="hidden">
	    <input name="AIRLINE_INFO[FLIGHT_SEGMENTS][0][DESTINATION_AIRPORT]" value="CBA" type="hidden">
	    <!-- Information about second transit of flight -->
	    <input name="AIRLINE_INFO[FLIGHT_SEGMENTS][1][DEPARTURE_DATE]" value="2017-06-20" type="hidden">
	    <input name="AIRLINE_INFO[FLIGHT_SEGMENTS][1][DEPARTURE_AIRPORT]" value="CBA" type="hidden">
	    <input name="AIRLINE_INFO[FLIGHT_SEGMENTS][1][DESTINATION_AIRPORT]" value="XYZ" type="hidden">
	    <input name="ORDER_HASH" value="efb6260ea1764d2ccb555bb048cd441c" type="hidden">
	    <input name="submit" value="Send!" type="submit">
	</form>

</body>
</html>