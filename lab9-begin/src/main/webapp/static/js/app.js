var wafepaApp = angular.module('wafepaApp', ['ngRoute']);

wafepaApp.controller('ActivityController', function($scope, $http, $location, $routeParams) {
	
	$scope.page = 0;
	
	$scope.getActivities = function() {
		var request_params = {};
		if ($scope.search) {
			request_params['name'] = $scope.search;
		}
		
		request_params['page'] = $scope.page;
		
		$http.get('api/activities', { params : request_params })
				.success(function(data, status, headers) {
					$scope.activities = data;
					$scope.totalPages = headers('total-pages');
					$scope.successMessage = 'Everything OK';
				})
				.error(function() {
					$scope.errorMessage = 'Oops, something went wrong.';
				});
	};
	
	$scope.deleteActivity = function(id, index) {
		$http.delete('api/activities/' + id)
				.success(function() {
					$scope.activities.splice(index, 1);
				})
				.error(function() {
					
				});
	};
	
	$scope.initActivity = function() {
		$scope.activity = {};
		
		if ($routeParams && $routeParams.id) {
			$http.get('api/activities/' + $routeParams.id)
					.success(function(data) {
						$scope.activity = data;
					})
					.error(function() {
						
					});
		}
	};
	
	$scope.saveActivity = function() {
		if ($scope.activity.id) {
			$http.put('api/activities/' + $scope.activity.id, $scope.activity)
					.success(function() {
						$location.path('/activities');
					})
					.error(function() {
						
					});
		} else {
			$http.post('api/activities', $scope.activity)
					.success(function() {
						$location.path('/activities');
					})
					.error(function() {
						
					});
		}
	};
	
	$scope.changePage = function(page) {
		$scope.page = page;
		$scope.getActivities();
	};
});

wafepaApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : 'static/html/home.html'
        })
        .when('/activities', {
            templateUrl : 'static/html/activities.html',
            controller : 'ActivityController'
        })
        .when('/activities/add', {
            templateUrl : 'static/html/addEditActivity.html',
            controller : 'ActivityController'
        })
        .when('/activities/edit/:id', {
            templateUrl : 'static/html/addEditActivity.html',
            controller : 'ActivityController'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);