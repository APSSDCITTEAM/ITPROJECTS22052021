var Student = angular.module('EventAction', []);
Student.controller('EventActionController', ['$scope', '$http', function($scope, $http) {

	
	$http.post('/alumni/event/getallOpenEvents').then(function(response) {
		$scope.opendata = response.data;
		if ($scope.opendata.successful) {
			
			var datalength = $scope.opendata.responseObject.length;
			if (datalength == 0) {
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else {
				document.getElementById("emptyrow").style.display = "none";
				$scope.allOpenEvents = $scope.opendata.responseObject;
				console.log($scope.allOpenEvents);
			}
			
		}
		else {
			console.log("Client error while getting data");
		}
	});
	
}]);