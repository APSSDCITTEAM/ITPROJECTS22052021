var Student = angular.module('jobview', []);
var documentsArr = [];
Student.controller('JobViewController', ['$scope', '$http', function($scope, $http) {

	/* Get My Jobs Only */
	var std_id = Alumni.getSessionValue("user_id");
	console.log(std_id);
	$http.post('/alumni/viewjob/getmyjobs', std_id).then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.myjobs = $scope.data.responseObject;
		}
		else {
			console.log("Client error while getting data");
		}
	});

}]);