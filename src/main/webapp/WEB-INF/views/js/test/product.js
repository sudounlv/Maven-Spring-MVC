var TestProduct = {
	init: function() {
		$('a#getProductButton').click(function() {
			TestProduct.getProduct();
		});
		$('a#getProductListButton').click(function() {
			TestProduct.getProductList();
		});
		$('a#createProductButton').click(function() {
			TestProduct.createProduct();
		});
		$('a#deleteProductButton').click(function() {
			TestProduct.deleteProduct();
		});
		$('a#updateProductButton').click(function() {
			TestProduct.updateProduct();
		});
	},
	getProduct : function() {
		var productId = $('form#getProductForm input#getProductId').val();
		if(productId) {
			var data = $('form#getProductForm').serialize();
			var url = "/product/" + productId;
			var requestElement = $('form#getProductForm textarea#getProductRequest');
			var responseElement = $('form#getProductForm textarea#getProductResponse');

			TestProduct.doAjaxCall('GET', url, data, requestElement, responseElement);
		}
	},
	getProductList : function() {
		var data = $('form#getProductListForm').serialize();
		var url = "/product/list";
		var requestElement = $('form#getProductListForm textarea#getProductListRequest');
		var responseElement = $('form#getProductListForm textarea#getProductListResponse');

		TestProduct.doAjaxCall('GET', url, data, requestElement, responseElement);
	},
	createProduct : function() {
		var name = $('form#createProductForm input#createProductName').val();
		if(name) {
			var data = $('form#createProductForm').serialize();
			var url = "/product";
			var requestElement = $('form#createProductForm textarea#createProductRequest');
			var responseElement = $('form#createProductForm textarea#createProductResponse');

			TestProduct.doAjaxCall('POST', url, data, requestElement, responseElement);
		}
	},
	updateProduct : function() {
		var name = $('form#updateProductForm input#updateProductName').val();
		var productId = $('form#updateProductForm input#updateProductId').val();
		if(name && productId) {
			var data = $('form#updateProductForm').serialize();
			var url = "/product/" + productId;
			var requestElement = $('form#updateProductForm textarea#updateProductRequest');
			var responseElement = $('form#updateProductForm textarea#updateProductResponse');

			TestProduct.doAjaxCall('PUT', url, data, requestElement, responseElement);
		}
	},
	deleteProduct : function() {
		var productId = $('form#deleteProductForm input#deleteProductId').val();
		if(productId) {
			var data = $('form#getProductForm').serialize();
			var url = "/product/" + productId;
			var requestElement = $('form#deleteProductForm textarea#deleteProductRequest');
			var responseElement = $('form#deleteProductForm textarea#deleteProductResponse');

			TestProduct.doAjaxCall('DELETE', url, data, requestElement, responseElement);
		}
	},
	doAjaxCall : function(submitMethod, submitUrl, submitData, requestElement, responseElement) {
		$.ajax({
			url: (submitMethod == "DELETE" || submitMethod == "PUT") ? submitUrl + "?" + submitData : submitUrl,
			type: submitMethod,
			data: (submitMethod == "DELETE" || submitMethod == "PUT") ? "" : submitData,
			beforeSend : function(jqXHR) {
				requestElement.val(submitUrl + "?" + submitData);
			},
			success: function(data, textStatus, jqXHR){
				responseElement.val(jqXHR.responseText);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				responseElement.val(jqXHR.responseText);
			}
		});
	}
}

$(document).ready(function() {
	TestProduct.init();
});
