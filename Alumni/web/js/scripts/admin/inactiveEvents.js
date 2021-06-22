var Student = angular.module('EventAction', []);
Student.controller('EventActionController', ['$scope', '$http', function($scope, $http) {

	$http.post('/alumni/event/getallClosedEvents').then(function(response) {
		$scope.Eventsdata = response.data;
		if ($scope.Eventsdata.successful) {
			
			var datalength = $scope.Eventsdata.responseObject.length;
			if (datalength == 0) {
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else {
				document.getElementById("emptyrow").style.display = "none";
				$scope.allClosedEvents = $scope.Eventsdata.responseObject;
				console.log($scope.allClosedEvents);
			}
			
		}
		else {
			console.log("Client error while getting data");
		}
	});

	
}]);