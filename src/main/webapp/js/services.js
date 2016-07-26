appModule.factory('customerFactory', [ '$rootScope', '$http',
		function($rootScope, $http) {
			var customerFactory = {};

			customerFactory.create = function(customer) {
				return $http({
					method : 'POST',
					url : "rest/write/customer/create",
					data : customer,
					headers : {
						'Content-Type' : 'application/json; charset=UTF-8'
					}
				});
			};

			customerFactory.update = function(customer) {
				return $http({
					method : 'POST',
					url : "rest/write/customer/update",
					data : customer,
					headers : {
						'Content-Type' : 'application/json; charset=UTF-8'
					}
				});
			};

			customerFactory.remove = function(entityIdPk) {
				return $http.get("rest/write/customer/remove/" + entityIdPk);
			};

			customerFactory.getCustomer = function() {
				return $http.get("rest/read/customer/list");
			};

			return customerFactory;
		} ]);

appModule.factory('productFactory', [ '$rootScope', '$http',
		function($rootScope, $http) {
			var productFactory = {};

			productFactory.create = function(product) {
				return $http({
					method : 'POST',
					url : "rest/write/product/create",
					data : product,
					headers : {
						'Content-Type' : 'application/json; charset=UTF-8'
					}
				});
			};

			productFactory.update = function(product) {
				return $http({
					method : 'POST',
					url : "rest/write/product/update",
					data : product,
					headers : {
						'Content-Type' : 'application/json; charset=UTF-8'
					}
				});
			};

			productFactory.remove = function(entityIdPk) {
				return $http.get("rest/read/product/remove/" + entityIdPk);
			};

			productFactory.getProduct = function() {
				return $http.get("rest/read/product/list");
			};

			return productFactory;
		} ]);

appModule.factory('orderDetailFactory', [ '$rootScope', '$http',
		function($rootScope, $http) {
			var orderDetailFactory = {};		
			

			orderDetailFactory.getProductDetail = function() {
				return $http.get("rest/read/product/list");
			};
			
			orderDetailFactory.create = function(product,productQuantity,totalPrice,customerId) {
				var formData=new FormData();
				formData.append("product",JSON.stringify(product));				
				formData.append("quantity",productQuantity);
				formData.append("totalPrice",totalPrice);
				formData.append("customerId",customerId);
				return $http.post("rest/write/order/create",formData,{
					transformRequest:angular.identity,
					headers : {
						'Content-Type' : undefined
					}
				});		
				
			
			};

			return orderDetailFactory;
			
			
		} ]);