var Employee = angular.module('approvals', []);
Employee.controller('ApprovalsController', ['$scope', '$http', function($scope, $http) {

	/*$http.get('/alumni/empapproval/getallRejectedUsers').then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			var datalength = $scope.data.responseObject.length;
			if (datalength == 0) {
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else {
				document.getElementById("emptyrow").style.display = "none";
				$scope.rejectedEmployees = $scope.data.responseObject;
				console.log($scope.rejectedEmployees);
			}

		} else {
			console.log("Client error while getting data");
		}
	});*/
	
	
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
				$scope.rejectedEmployees = $scope.unVerifieddata.responseObject;
				console.log($scope.rejectedEmployees);
			}
			
		} else {
			console.log("Client error while getting data");
		}
	});
	
	
	
}]);