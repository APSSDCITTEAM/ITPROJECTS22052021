var Student = angular.module('volunteership', []);
var documentsArr = [];
Student.controller('VolunteershipViewController', ['$scope', '$http', function($scope, $http) {


	$http.get('/alumni/viewjob/getallvolunteershipshome').then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.volunteersdata = $scope.data.responseObject;
		}
		else {
			console.log("Client error while getting data");
		}
	});


}]);