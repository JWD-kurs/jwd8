var wafepaApp = angular.module('wafepaApp.controllers', []);

wafepaApp.controller('ActivityController', function($scope, 
		$location, $routeParams, activityRestService) {
	
	$scope.page = 0;
	
	$scope.getActivities = function() {
		var request_params = {};
		if ($scope.search) {
			request_params['name'] = $scope.search;
		}
		
		request_params['page'] = $scope.page;
		
		activityRestService.getActivities(request_params)
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
		activityRestService.deleteActivity(id)
				.success(function() {
					$scope.activities.splice(index, 1);
				})
				.error(function() {
					
				});
	};
	
	$scope.initActivity = function() {
		$scope.activity = {};
		
		if ($routeParams && $routeParams.id) {
			activityRestService.getActivity($routeParams.id)
					.success(function(data) {
						$scope.activity = data;
					})
					.error(function() {
						
					});
		}
	};
	
	$scope.saveActivity = function() {
		activityRestService.saveActivity($scope.activity)
				.success(function() {
					$location.path('/activities');
				})
				.error(function() {
					
				});
	};
	
	$scope.changePage = function(page) {
		$scope.page = page;
		$scope.getActivities();
	};
});

wafepaApp.controller('LogController', function($scope, $http, $location) {
	
	$scope.getLogs = function() {
		$http.get('api/logs')
				.success(function(data) {
					$scope.logs = data;
					$scope.successMessage = 'Everything OK';
				})
				.error(function() {
					$scope.errorMessage = 'Oops, something went wrong.';
				});
	};
	
	$scope.initLog = function() {
		$scope.log = {};
		
		$http.get('api/activities')
				.success(function(data) {
					$scope.activities = data;
				})
				.error(function() {
					
				});
	};
	
	$scope.saveLog = function() {
		$http.post('api/logs', $scope.log)
				.success(function() {
					$location.path('/logs');
				})
				.error(function() {
					
				});
	};
});