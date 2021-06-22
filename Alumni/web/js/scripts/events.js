var Student = angular.module('viewEvents', []);
var documentsArr = [];
Student.controller('EventsViewController', ['$scope', '$http', function($scope, $http) {

	$http.post('/alumni/event/getallEvents').then(function(response) {
		$scope.Eventsdata = response.data;
		if ($scope.Eventsdata.successful) {
			$scope.eventdata = $scope.Eventsdata.responseObject;
			console.log($scope.eventdata);
		}
		else {
			console.log("Client error while getting data");
		}
	});

}]);