var wafepaApp = angular.module('wafepaApp', ['ngRoute']);

wafepaApp.controller('ActivityController', function($scope, $http) {
	
	$scope.getActivities = function() {
		$http.get('api/activities')
				.success(function(data) {
					$scope.activities = data;
				})
				.error(function() {
					alert('Something went wrong')
				});
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
        .otherwise({
            redirectTo: '/'
        });
}]);