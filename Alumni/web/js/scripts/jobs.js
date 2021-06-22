var Student = angular.module('jobview', []);
var documentsArr = [];
Student.controller('JobViewController', ['$scope', '$http', function($scope, $http) {

	/* Get All Jobs */
	$http.get('/alumni/viewjob/getalljobshome').then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.jobsdata = $scope.data.responseObject;
			console.log($scope.jobsdata);
		}
		else {
			console.log("Client error while getting data");
		}
	});

}]);