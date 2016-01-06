var wafepaApp = angular.module('wafepaApp.services', []);

wafepaApp.service('activityRestService', function($http) {
	
	this.getActivity = function(id) {
		return $http.get('api/activities/' + id);
	};
	
	this.getActivities = function(request_params) {
		return $http.get('api/activities', { params : request_params });
	};
	
	this.deleteActivity = function(id) {
		return $http.delete('api/activities/' + id);
	};
	
	this.saveActivity = function(activity) {
		if (activity.id) {
			return $http.put('api/activities/' + activity.id, activity);
		} else {
			return $http.post('api/activities', activity);
		}
	};
});