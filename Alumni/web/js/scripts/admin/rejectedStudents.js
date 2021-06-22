var Student = angular.module('approvals', []);
Student.controller('ApprovalsController', ['$scope', '$http', function($scope, $http) {

	$http.get('/alumni/approval/getallRejectedUsers').then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			var datalength = $scope.data.responseObject.length;
			if (datalength == 0) {
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else {
				document.getElementById("emptyrow").style.display = "none";
				$scope.rejectedStudents = $scope.data.responseObject;
				console.log($scope.rejectedStudents);
			}
		} else {
			console.log("Client error while getting data");
		}
	});
}]);