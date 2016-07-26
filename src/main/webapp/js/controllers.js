appModule.controller('customerController', [ '$rootScope', '$scope', '$filter','customerFactory',
                                    		function($rootScope, $scope, $filter, customerFactory) {
                                    			$scope.customer;
                                    			$scope.customerList = [];
                                    			
                                    			getCustomer();
                                    			
                                    			function getCustomer() {
                                    				customerFactory.getCustomer().success(function(response) {
                                    					console.log("gecustomer1");
                                    					$scope.customerList = response;
                                    					console.log("controller"+JSON.stringify(response));
                                    				}).error(function(response) {
                                    					alert("Error1"+response.status);
                                    				});
                                    			};
                                    			
                                    			$scope.create=function(){
                                    				customerFactory.create($scope.customer).success(function(response){
                                    					$scope.customerList.push(response);
                                    					$scope.reset();
                                    				}).error(function(response){
                                    					alert("error in creating customer: "+response.status);	
                                    				});
                                    			};
                                    			
                                    			$scope.edit=function(customer){
                                    				$scope.customer=angular.copy(customer);
                                    			};
                                    			
                                    			$scope.update=function(){
                                    				customerFactory.update($scope.customer).success(function(response){
                                    					for(var i=0;i<$scope.customerList.length;i++){
                                    						if($scope.customerList[i].customerIdPk == $scope.customer.customerIdPk){
                                    							angular.extend($scope.customerList[i],response);
                                    							$scope.reset();
                                    							break;
                                    						}
                                    					}
                                    				});
                                    			};
                                    			
                                    			$scope.remove=function(entityIdPk){
                                    				customerFactory.remove(entityIdPk).success(function(response){
                                    					for(var i=0;i<$scope.customerList.length;i++){
                                    						if($scope.customerList[i].customerIdPk == entityIdPk){
                                    							$scope.customerList.splice(i,1);                                    							
                                    							break;
                                    						}
                                    					}
                                    				});
                                    			}; 
                                    			
                                    			$scope.reset = function() {
                        						    $scope.customer = {};
                        						}

                                    		} ]);



appModule.controller('productController', [ '$rootScope', '$scope', '$filter','productFactory',
                                     		function($rootScope, $scope, $filter, productFactory) {
                                     			$scope.product;
                                     			$scope.productList = [];
                                     			
                                     			getProduct();
                                     			
                                     			function getProduct() {
                                     				productFactory.getProduct().success(function(response) {                                     					
                                     					$scope.productList = response;
                                     					console.log("controller"+response);
                                     				}).error(function(response) {
                                     					alert("Error1"+response.status);
                                     				});
                                     			};
                                     			
                                     			$scope.create=function(){
                                     				productFactory.create($scope.product).success(function(response){
                                     					$scope.productList.push(response);
                                     					$scope.reset();
                                     				}).error(function(response){
                                     					alert("error in creating product: "+response.status);	
                                     				});
                                     			};
                                     			
                                     			$scope.edit=function(product){
                                     				$scope.product=angular.copy(product);
                                     			};
                                     			
                                     			$scope.update=function(){
                                     				productFactory.update($scope.product).success(function(response){
                                     					for(var i=0;i<$scope.productList.length;i++){
                                     						if($scope.productList[i].productIdPk == $scope.product.productIdPk){
                                     							angular.extend($scope.productList[i],response);
                                     							$scope.reset();
                                     							break;
                                     						}
                                     					}
                                     				});
                                     			};
                                     			
                                     			$scope.remove=function(entityIdPk){
                                     				productFactory.remove(entityIdPk).success(function(response){
                                     					for(var i=0;i<$scope.productList.length;i++){
                                     						if($scope.productList[i].productIdPk == entityIdPk){
                                     							$scope.productList.splice(i,1);                                    							
                                     							break;
                                     						}
                                     					}
                                     				});
                                     			}; 
                                     			
                                     			$scope.reset = function() {
                         						    $scope.product = {};
                         						}

                                     		} ]);

appModule.controller('orderDetailController', [ '$rootScope', '$scope', '$filter','orderDetailFactory',
                                         		function($rootScope, $scope, $filter, orderDetailFactory) {                                         			
                                         			$scope.productDetailList = [];
                                         			$scope.product={};
                                         			$scope.productQuantity=0;
                                         			$scope.customerId;
                                         			$scope.totalPrice=0.0;
                                         			getProductDetail();
                                         			
                                         			function getProductDetail() {                             				
                                         			
                                         				orderDetailFactory.getProductDetail().success(function(response) { 
                                         					$scope.productDetailList = response;  
                                         				}).error(function(response) {
                                         					alert("Error1"+response.status);
                                         				});
                                         			};
                                         			
                                         			$scope.create=function(){
                                         				
                                         				orderDetailFactory.create($scope.product,$scope.productQuantity,$scope.totalPrice,$scope.customerId).success(function(response){
                                         					//console.log("getorder1"+response);
                                         					$scope.product={};
                                         					$scope.productQuantity={};
                                         					$scope.customerId={};
                                         					$scope.totalPrice={};
                                         					
                                         				}).error(function(error){
                                         					alert("error in adding order : "+error);	
                                         				});
                                         			};
                                         			
                                         			$scope.getProductQuantity=function(){
                                         				$scope.totalPrice=$scope.productQuantity*$scope.product.price;
                                         			}
                                         			$scope.getProductQuantity();
                                         			

                                         		} ]);

