var Student = angular.module('unVerifiedEmployeeReports', []);
Student.controller('notVerifiedEmployeeController', ['$scope', '$http', function($scope, $http) {

	
	$http.get('/alumni/empapproval/getallunverifiedUsers').then(function(response) {
		$scope.unVerifieddata = response.data;
		if ($scope.unVerifieddata.successful) {
			
			var datalength = $scope.unVerifieddata.responseObject.length;
			if (datalength == 0) {
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else {
				document.getElementById("emptyrow").style.display = "none";
				$scope.StudentsData = $scope.unVerifieddata.responseObject;
				console.log($scope.StudentsData);
			}
			
		} else {
			console.log("Client error while getting data");
		}
	});
	
	  
	
}]);