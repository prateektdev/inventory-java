app.controller('usersController', function ($scope, $localStorage) {
	$scope.headingTitle = "User List";
	console.log("token : " + $localStorage.token)
});

app.controller('rolesController', function ($scope) {
	$scope.headingTitle = "Roles List";
});



app.factory('productService', function ($resource, $window, $rootScope) {
	return $resource(appConfig.baseURL + '/rest/product/:action', {}, {
		'fetch': {
			method: 'GET',
			params: {
				action: 'getall'
			},
			isArray: true,
			headers: {
				'Authorization': 'Bearer ' + $window.localStorage.getItem('token')
			}
		},
		'create': {
			method: 'POST',
			params: {
				action: 'create'
			},
			headers: {
				'Authorization': 'Bearer ' + $window.localStorage.getItem('token')
			}
		}
	});
})


app.controller('productsController', function ($scope, $localStorage, $location,
	productService, $window) {

	$scope.products = [];
	$scope.addProduct = function () {
		$location.path("/add-product");
	}

	$scope.fetchProducts = function () {
		productService.fetch({}, function (data) {
			console.log(data);
			$scope.products = data;
		})
	}
	$scope.fetchProducts();
});

app.controller('addProductController', ['$scope', '$localStorage',
	'$location', 'productService', 'toaster', '$window',
	function ($scope, $localStorage, $location, productService, toaster, $window) {
		$scope.emailAddress = "Email Address";
		$scope.product = {
			"title": "Product 1",
			"description": "This is a sample product",
			"price": 120,
			"rating": 0,
			"category": "SPORTS",
			"stockCount": 10
		}
		$scope.fileUploaded;
		$scope.saveProduct = function () {
			productService.create($scope.product, function (data) {
				console.log(data);
				if (data.success == true) {
					toaster.success({ title: "title", body: "text1" });
					toaster.pop('success', "Product created successfully", data.message);
					// $window.location.href =
					// "http://localhost:8080/index.html";
				}
			})
		}
		$scope.uploadFile = function () {
			uploadService.upload($scope.product, function (data) {
				console.log(data);
				// if (data.token != undefined) {
				// $localStorage.token = data.token;
				// $localStorage.role = data.role;
				// $window.location.href =
				// "http://localhost:8080/index.html";
				// }
			})
		}

	}]);

app.factory('orderService', function ($resource, $window, $rootScope) {
	return $resource(appConfig.baseURL + '/rest/order/:action', {}, {
		'fetch': {
			method: 'GET',
			params: {
				action: 'getall'
			},
			isArray: true,
			headers: {
				'Authorization': 'Bearer ' + $window.localStorage.getItem('token')
			}
		},
		'create': {
			method: 'POST',
			params: {
				action: 'create'
			},
			headers: {
				'Authorization': 'Bearer ' + $window.localStorage.getItem('token')
			}
		}
	});
})


app.controller('ordersController', function ($scope, $localStorage, $location,
	orderService, $window) {

	$scope.orders = [];
	$scope.addOrder = function () {
		$location.path("/add-order");
	}

	$scope.fetchProducts = function () {
		orderService.fetch({}, function (data) {
			console.log(data);
			$scope.orders = data;
		})
	}
	$scope.fetchProducts();
});

app.controller('addOrderController', ['$scope', '$localStorage',
	'$location', 'orderService', 'productService', 'toaster', '$window',
	function ($scope, $localStorage, $location, orderService, productService, toaster, $window) {
		$scope.emailAddress = "Email Address";
		$scope.order = {
			"title": "Product 1",
			"description": "This is a sample order",
			"amount": 120,
			"products": []
		}
		$scope.states = [];
		$scope.fetchProducts = function () {
			productService.fetch({}, function (data) {
				$scope.states = data;
			})
		}
		$scope.fetchProducts();

		$scope.selectedUsers = [];
		$scope.selectedIds = [];
		$scope.saveProduct = function () {
			console.log($scope.selectedIds);
			// orderService.create($scope.order, function (data) {
			// 	console.log(data);
			// 	if (data.success == true) {
			// 		toaster.success({ title: "title", body: "text1" });
			// 		toaster.pop('success', "Order created successfully", data.message);
			// 		// $window.location.href =
			// 		// "http://localhost:8080/index.html";
			// 	}
			// })
		}

	}]);

