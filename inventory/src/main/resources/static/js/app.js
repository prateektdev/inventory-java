var app = angular.module('app', ['ngAnimate', 'toaster', 'ngStorage', 'ngRoute', 'ngResource']);
app.config(function ($routeProvider) {
	$routeProvider.when('/', {
		templateUrl: '/views/dashboard.html',
		controller: 'usersController'
	}).when('/dashboard', {
		templateUrl: '/views/dashboard.html',
		controller: 'usersController'
	}).when('/user', {
		templateUrl: '/views/user.html',
		controller: 'usersController'
	}).when('/products', {
		templateUrl: '/views/products.html',
		controller: 'productsController'
	}).when('/add-product', {
		templateUrl: '/views/add-product.html',
		controller: 'addProductController'
	}).when('/orders', {
		templateUrl: '/views/orders.html',
		controller: 'ordersController'
	}).when('/add-order', {
		templateUrl: '/views/add-order.html',
		controller: 'addOrderController'
	}).when('/notifications', {
		templateUrl: '/views/notifications.html',
		controller: 'usersController'
	}).when('/map', {
		templateUrl: '/views/map.html',
		controller: 'usersController'
	}).when('/tables', {
		templateUrl: '/views/tables.html',
		controller: 'usersController'
	}).when('/typography', {
		templateUrl: '/views/typography.html',
		controller: 'rolesController'
	}).when('/login', {
		templateUrl: '/views/login.html',
		controller: 'rolesController'
	}).otherwise({
		redirectTo: '/'
	});
});