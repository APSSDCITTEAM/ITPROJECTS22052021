var Student = angular.module('verifiedEmployeeReports', []);
Student.controller('VerifiedEmployeeController', ['$scope', '$http', function($scope, $http) {

	
	$http.get('/alumni/empapproval/getallVerifiedUsers').then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			
			var datalength = $scope.data.responseObject.length;
			if (datalength == 0) {
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else {
				document.getElementById("emptyrow").style.display = "none";
				$scope.StudentsData = $scope.data.responseObject;
				console.log($scope.StudentsData);
			}
			
		} else {
			console.log("Client error while getting data");
		}
	});
	
	
	
}]);