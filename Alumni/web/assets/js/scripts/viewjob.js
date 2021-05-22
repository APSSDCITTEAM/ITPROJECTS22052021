var Student = angular.module('jobview', []);
var documentsArr = [];
Student.controller('JobViewController', ['$scope', '$http', function($scope, $http) {

	var std_id = Alumni.getSessionValue("user_id");
	console.log(std_id);
	$http.post('/alumni/viewjob/getalljobs', std_id).then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.alldata = $scope.data.responseObject;
		}
		else {
			console.log("Client error while getting data");
		}
	});
	
	$http.get('/alumni/viewjob/getalljobshome').then(function(response) {
		$scope.data = response.data;
		if($scope.data.successful)
		{   
			$scope.alldata = $scope.data.responseObject;
		}
		else
		{
			console.log("Client error while getting data");  
		}
	});

}]);