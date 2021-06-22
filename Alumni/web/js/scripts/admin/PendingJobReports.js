var Student = angular.module('PendingJobsReports', []);
Student.controller('ActiveEmployeesController', ['$scope', '$http', function($scope, $http) {

	$http.get('/alumni/approval/getSubmittedJobs').then(function(response) {
		$scope.submitteddata = response.data;
		if ($scope.submitteddata.successful) {
			
			var datalength = $scope.submitteddata.responseObject.length;
			if (datalength == 0){
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else{
				document.getElementById("emptyrow").style.display = "none";
				$scope.PendingJobs = $scope.submitteddata.responseObject;
				console.log($scope.PendingJobs);
			}
			
		}
		else {
			console.log("Client error while getting data");
		}
	});

}]);