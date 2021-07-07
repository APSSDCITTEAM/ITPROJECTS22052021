var Student = angular.module('PendingInternReports', []);
Student.controller('pendingInternshipsController', ['$scope', '$http', function($scope, $http) {

	$http.get('/alumni/approval/getSubmittedInternships').then(function(response) {
		$scope.submitteddata = response.data;
		if ($scope.submitteddata.successful) {
			
			var datalength = $scope.submitteddata.responseObject.length;
			if (datalength == 0) {
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else {
				document.getElementById("emptyrow").style.display = "none";
				$scope.PendingInternships = $scope.submitteddata.responseObject;
				console.log($scope.PendingInternships);
			}
			
		}
		else {
			console.log("Client error while getting data");
		}
	});

}]);