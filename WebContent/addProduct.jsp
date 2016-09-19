<%@page import="com.journaldev.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product list</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="BOOTSTRAP/progect.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap-theme.min.css">
<script src="http://code.jquery.com/jquery.min.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="row ">
			<div class="row-border" style="padding: 10px; margin: 0px;">
				<form action="LoginServlet" id="loginFormId">
					<div div class="row">
						<div class="col-sm-1" style="backgraound-color: yellow;">
							<label>Логін</label>
						</div>
						<div class="col-sm-3" style="backgraound-color: yellow;">
							<input name="login" type="text" id="loginId" />
						</div>
					</div>
					<div div class="row">
						<div class="col-sm-1" style="backgraound-color: yellow;">
							<label>Пароль</label>
						</div>
						<div class="col-sm-3" style="backgraound-color: yellow;">
							<input name="password" type="password" id="passwordId" />
						</div>
					</div>
					<div div class="row">
						<div class="col-sm-1" style="backgraound-color: yellow;"></div>
						<div class="col-sm-2" style="backgraound-color: yellow;">
							<button type="submit" id="loginButton" class="btn btn-primary ">Увійти</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="row" style="padding-bottom:10px;">
			<div class="col-sm-12 row-border">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Категорії товарів <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<c:forEach items="${applicationScope.menuProductsMapCtx}" var="menuList">
								<li><a href="${menuList.memuRequestTo}?${menuList.menuRequestParamName}=${menuList.menuRequestParam}"><c:out value="${menuList.menuDescription}"></c:out></a></li>
							</c:forEach> 
						</ul></li>
				</ul>
			</div>
		</div>
		

		<div class="row">
			<div class="col-sm-4" style="backgraound-color: yellow;">
			<c:choose>
				<c:when test="${not empty sessionScope.SelectedFilters}">
				Вибрані фільтри:</br>
					<c:forEach items="${sessionScope.SelectedFilters}" var="selectedFilters">
						<li><a href="${selectedFilters.actionTo}?selecteMenu=${sessionScope.selecteMenu}&${selectedFilters.actionParamName}=${selectedFilters.actionParamValue}&cheked=${selectedFilters.fiterIsChecked}">
						<span class="glyphicon glyphicon-plus">&nbsp;<c:out value="${selectedFilters.filterNameDescription}"></c:out></span></a></li>
					</c:forEach>
					</br> 
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${not empty sessionScope.ProducerFilterList}">
				Колонка пошукового фільтру</br>
					<c:forEach items="${sessionScope.ProducerFilterList}" var="producerFilter">
						<li><a href="${producerFilter.actionTo}?selecteMenu=${sessionScope.selecteMenu}&${producerFilter.actionParamName}=${producerFilter.actionParamValue}">
						<span class="glyphicon glyphicon-plus">&nbsp;<c:out value="${producerFilter.filterNameDescription}"></c:out></span></a></li>
					</c:forEach> 
				</c:when>
			</c:choose>
			</div>
			<div class="col-sm-8" style="background-color: green;">

				<div class="col-sm-4" style="background-color: green;"
					id="poductNameId">Назва продукту</div>
				<div class="col-sm-4" style="background-color: green;"
					id="poductPriceId">Ціна продукту</div>
				<div class="col-sm-4" style="background-color: green;"
					id="poductDescriptptionId">Характеристики</div>
				<div class="col-sm-4" style="background-color: green;"
					id="poductNameId"></div>
				<div class="col-sm-4" style="background-color: green;"
					id="poductPriceId"></div>
				<div class="col-sm-4" style="background-color: green;"
					id="poductDescriptptionId"></div>
				<div id="prList">
				
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
				<h3>!!!!!!</h3>
				
				<c:forEach items="${applicationScope.productsListCtx}" var="productCtx">
					<div class="col-sm-4"  style="background-color:green;" id="poductNameId">
					<c:out value="${productCtx.productName}"></c:out>
					</div>
					<div class="col-sm-4"  style="background-color:green;" id="poductPriceId">
					<c:out value="${productCtx.productPrice}"></c:out>
					</div>
					<div class="col-sm-4"  style="background-color:green;" id="poductDescriptptionId">
					<c:out value="${productCtx.productDescription}"></c:out>
					</div>
				</c:forEach> 
			</div>
			</div>
		</div>
	</div>
</body>
</html>