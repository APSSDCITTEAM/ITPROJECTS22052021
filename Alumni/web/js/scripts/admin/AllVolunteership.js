var Student = angular.module('AllVolunteership', []);
var documentsArr = [];
Student.controller('VolunteershipsViewController', ['$scope', '$http', function($scope, $http) {


	$http.get('/alumni/viewjob/getallvolunteershipshome').then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.volunteersdata = $scope.data.responseObject;
			console.log($scope.volunteersdata);
		}
		else {
			console.log("Client error while getting data");
		}   
	});


}]);