var Student = angular.module('InternshipApplicant', []);
Student.controller('InternshipApplicantController', ['$scope', '$http', function($scope, $http) {

	
	var std_id = Alumni.getSessionValue("user_id");
	console.log(std_id);
	$http.post('/alumni/viewjob/getallmyinternships', std_id).then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.alldata = $scope.data.responseObject;
		}
		else {
			console.log("Client error while getting data");
		}
	});  

}]);
