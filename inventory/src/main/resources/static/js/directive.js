app.factory('uploadService', function ($resource, $window, $rootScope) {
	return $resource(appConfig.baseURL + '/api/:action', {}, {
		'upload': {
			method: 'POST',
			params: {
				action: 'upload'
			},
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded',
				'Authorization': 'Bearer ' + $window.localStorage.getItem('token')
			},
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
app.directive('uploadDirective', function (uploadService) {
	return {
		restrict: 'A',
		scope: true,
		link: function (scope, element, attr) {

			element.bind('change', function () {
				var formData = new FormData();
				formData.append('file', element[0].files[0]);
				uploadService.upload(formData, function (response) {
					// recieve image name to use in a ng-src 
					console.log(response);
				});
			});

		}
	};
});

app.directive('multiSelectSearchBox', function () {
	return {
		restrict: 'A',
		scope: {
			myOptions: '@',
			states: "=",
			selectedItems: "=",
			label: "@",
		},
		templateUrl: '../views/multiSelectSearchBox.html',
		controller: function ($scope) {
			$scope.searchCondition = ""; 

			$scope.items = [];

			var str = $scope.myOptions.split(' ');
			var itemStr = str[0];
			var collectionName = str[2];
			console.log("states : " + $scope.selectedItems);
			$scope.$watch(collectionName, function (collection) {
				console.log(collection);
				for (var i = 0; i < collection.length; i++) {
					$scope.items.push(collection[i]);
				}
			});

			$scope.searchTerm = function (item) {
				if (item[$scope.label].toString().toLowerCase().indexOf($scope.searchCondition.toLowerCase()) > -1) {
					return true;
				} else {
					return false;
				}
			};

			$scope.toggleSelection = function (item) {
				var idx = $scope.selectedItems.indexOf(item);
				if (idx > -1) {
					//currently selected. remove from selectedItems array
					$scope.selectedItems.splice(idx, 1);
				} else {
					//new selection. add into selectedItems array
					$scope.selectedItems.push(item);
				}
				selectedItems=$scope.selectedItems;
			}
		}
	};
});
