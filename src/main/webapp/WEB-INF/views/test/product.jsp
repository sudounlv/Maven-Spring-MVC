<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=8; IE=9" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="content-language" content="en" />
		<title>Product Test Page</title>
		<meta name="author" content="Richard Hoppes" />
		<meta name="copyright" content="Richard Hoppes" />
		<link href="/css/reset.css" rel="stylesheet" type="text/css" />
		<link href="/css/screen.css" rel="stylesheet" type="text/css" />
		<link href="/css/test.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="/js/test/product.js"></script>
	</head>
	<body>

	<!-- Header Begin -->
	<div id="header">
		<div id="header-inner">
			<h2>Product Test Panel</h2>
		</div>
	</div>
	<!-- Header End -->

	<div id="main">
		<div class="form clear">
			<div class="form-header">
				<h1>Get Product</h1>
			</div>
			<div class="form-content">
				<form id="getProductForm" action="" target="_blank">
					<fieldset>
						<dl class="form wide">
							<dt>Product ID</dt>
							<dd><input type="text" id="getProductId" /></dd>

							<dt>Request</dt>
							<dd><textarea id="getProductRequest" rows="4" class="request"></textarea></dd>

							<dt>Response</dt>
							<dd><textarea id="getProductResponse" rows="4" class="response"></textarea></dd>

							<dt>&nbsp;</dt>
							<dd><a id="getProductButton" class="button action left" href="javascript:void(0);">Submit</a></dd>
						</dl>
					</fieldset>
				</form>
			</div>
		</div>

		<br/><br/><br/>

		<div class="form clear">
			<div class="form-header">
				<h1>Get Product List</h1>
			</div>
			<div class="form-content">
				<form id="getProductListForm" action="" target="_blank">
					<fieldset>
						<dl class="form wide">
							<dt>Request</dt>
							<dd><textarea id="getProductListRequest" rows="4" class="request"></textarea></dd>

							<dt>Response</dt>
							<dd><textarea id="getProductListResponse" rows="4" class="response"></textarea></dd>

							<dt>&nbsp;</dt>
							<dd><a id="getProductListButton" class="button action left" href="javascript:void(0);">Submit</a></dd>
						</dl>
					</fieldset>
				</form>
			</div>
		</div>

		<br/><br/><br/>

		<div class="form clear">
			<div class="form-header">
				<h1>Create Product</h1>
			</div>
			<div class="form-content">
				<form id="createProductForm" action="" target="_blank">
					<fieldset>
						<dl class="form wide">
							<dt>Product Name</dt>
							<dd><input type="text" name="name" id="createProductName" /></dd>

							<dt>Request</dt>
							<dd><textarea id="createProductRequest" rows="4" class="request"></textarea></dd>

							<dt>Response</dt>
							<dd><textarea id="createProductResponse" rows="4" class="response"></textarea></dd>

							<dt>&nbsp;</dt>
							<dd><a id="createProductButton" class="button action left" href="javascript:void(0);">Submit</a></dd>
						</dl>
					</fieldset>
				</form>
			</div>
		</div>

		<br/><br/><br/>

		<div class="form clear">
			<div class="form-header">
				<h1>Delete Product</h1>
			</div>
			<div class="form-content">
				<form id="deleteProductForm" action="" target="_blank">
					<fieldset>
						<dl class="form wide">
							<dt>Product ID</dt>
							<dd><input type="text" id="deleteProductId" /></dd>

							<dt>Request</dt>
							<dd><textarea id="deleteProductRequest" rows="4" class="request"></textarea></dd>

							<dt>Response</dt>
							<dd><textarea id="deleteProductResponse" rows="4" class="response"></textarea></dd>

							<dt>&nbsp;</dt>
							<dd><a id="deleteProductButton" class="button action left" href="javascript:void(0);">Submit</a></dd>
						</dl>
					</fieldset>
				</form>
			</div>
		</div>

		<br/><br/><br/>

		<div class="form clear">
			<div class="form-header">
				<h1>Update Product</h1>
			</div>
			<div class="form-content">
				<form id="updateProductForm" action="" target="_blank">
					<fieldset>
						<dl class="form wide">
							<dt>Product ID</dt>
							<dd><input type="text" id="updateProductId" /></dd>

							<dt>Product Name</dt>
							<dd><input type="text" name="name" id="updateProductName" /></dd>

							<dt>Request</dt>
							<dd><textarea id="updateProductRequest" rows="4" class="request"></textarea></dd>

							<dt>Response</dt>
							<dd><textarea id="updateProductResponse" rows="4" class="response"></textarea></dd>

							<dt>&nbsp;</dt>
							<dd><a id="updateProductButton" class="button action left" href="javascript:void(0);">Submit</a></dd>
						</dl>
					</fieldset>
				</form>
			</div>
		</div>

		<br/><br/><br/>

	</div>

	</body>
</html>