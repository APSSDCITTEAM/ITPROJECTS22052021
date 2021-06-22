var Employee = angular.module('approvals', []);
Employee.controller('ApprovalsController', ['$scope', '$http', function($scope, $http) {

	$http.get('/alumni/empapproval/getallApprovedUsers').then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			var datalength = $scope.data.responseObject.length;
			if (datalength == 0) {
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else {
				document.getElementById("emptyrow").style.display = "none";
				$scope.activeEmployees = $scope.data.responseObject;
				console.log($scope.activeEmployees);
			}

		} else {
			console.log("Client error while getting data");
		}
	});
}]);