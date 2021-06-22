var Student = angular.module('jobview', []);
var documentsArr = [];
Student.controller('JobViewController', ['$scope', '$http', function($scope, $http) {

	/* Get All Jobs Expect Mine */
	var std_id = Alumni.getSessionValue("user_id");
	console.log(std_id);
	$http.post('/alumni/viewjob/getalljobs', std_id).then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.alljobs = $scope.data.responseObject;
			console.log($scope.alldata);
		}
		else {
			console.log("Client error while getting data");
		}
	});

}]);