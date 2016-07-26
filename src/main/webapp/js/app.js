

var appModule=angular.module("customerApp",['ngRoute','smart-table']);

appModule.config(function($routeProvider) {
	$routeProvider

	.when('/customer', {
		templateUrl : 'customerDetail.html',
		controller : 'customerController'
	})
	
	.when('/admin', {
		templateUrl : 'admin.html',	
	})
	
	.when('/product', {
		templateUrl : 'productDetail.html',	
		controller : 'productController'
	})
	
	.when('/order', {
		templateUrl : 'orderDetail.html',	
		controller : 'orderDetailController'
	})

	// if not find anything, redirect to guest
	.otherwise({
		redirectTo : '/admin'
	})

});

