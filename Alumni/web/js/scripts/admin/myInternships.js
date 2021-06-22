var Student = angular.module('intership', []);
var documentsArr = [];
Student.controller('InternshipViewController', ['$scope', '$http', function($scope, $http) {

	/* Get My Internships */
	var std_id = Alumni.getSessionValue("user_id");
	console.log(std_id);
	$http.post('/alumni/viewjob/getmyinternships', std_id).then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.myinterns = $scope.data.responseObject;
		}
		else {
			console.log("Client error while getting data");
		}
	});



}]);