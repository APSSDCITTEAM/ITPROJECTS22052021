var Student = angular.module('approvals', []);
Student.controller('ApprovalsController', ['$scope', '$http', function($scope, $http) {

	$http.get('/alumni/approval/getallusers').then(function(response) {
		$scope.alldata = response.data;
		if ($scope.alldata.successful) {
			var datalength = $scope.alldata.responseObject.length;
			if (datalength == 0) {
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else {
				document.getElementById("emptyrow").style.display = "none";
				$scope.allStudents = $scope.alldata.responseObject;
				console.log($scope.allStudents);
			}
		} else {
			console.log("Client error while getting data");
		}
	});
}]);