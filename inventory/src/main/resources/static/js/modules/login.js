angular.module('login', ['ngAnimate', 'toaster', 'ngStorage', 'ngRoute', 'ngResource']).factory('userService',
	function ($resource, $rootScope) {
		return $resource(appConfig.baseURL + '/user/:action/:unitId', {}, {
			'register': {
				method: 'GET',
				params: {
					action: 'register'
				},
				isArray: true
			},
			'login': {
				method: 'POST',
				params: {
					action: 'login'
				}
			}
		});
	}).controller(
		'loginController',
		['$scope', '$localStorage', '$location', 'userService', 'toaster', '$window',
			function ($scope, $localStorage, $location, userService, toaster, $window) {
				$scope.emailAddress = "Email Address";
				$scope.userInfo = {
					username: "admin@admin.com",
					password: "admin"
				}
				$scope.doLogin = function () {
					userService.login($scope.userInfo, function (data) {
						console.log(data);
						if (data.token != undefined) {
							$window.localStorage.setItem('token', data.token);
							$window.localStorage.setItem('role', data.role);
							toaster.pop('success', "Login successfully", "");
							$localStorage.role = data.role;
							setTimeout(() => {
								$window.location.href = "http://localhost:8080/index.html";
							}, 1000);
						}
					})
				}

			}]);