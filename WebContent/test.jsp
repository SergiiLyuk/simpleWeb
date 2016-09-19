<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>HELLO</h3>
<c:out value="${requestScope.productsList}"></c:out>
				<c:forEach items="${requestScope.productsList}" var="product">
					<div class="col-sm-4"  style="background-color:green;" id="poductNameId">
					<c:out value="${product.productName}"></c:out>
					</div>
					<div class="col-sm-4"  style="background-color:green;" id="poductPriceId">
					<c:out value="${product.productPrice}"></c:out>
					</div>
					<div class="col-sm-4"  style="background-color:green;" id="poductDescriptptionId">
					<c:out value="${product.productDescription}"></c:out>
					</div>
				</c:forEach>
</body>
</html>