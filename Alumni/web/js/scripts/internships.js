var Student = angular.module('intership', []);
var documentsArr = [];
Student.controller('InternshipViewController', ['$scope', '$http', function($scope, $http) {

	/* Get All Internships */
	$http.get('/alumni/viewjob/getallinternshipshome').then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.internhomedata = $scope.data.responseObject;
		}
		else {
			console.log("Client error while getting data");
		}
	});

}]);