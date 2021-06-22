var Student = angular.module('rejectedJobReports', []);
Student.controller('RejectedJobsController', ['$scope', '$http', function($scope, $http) {

	$http.get('/alumni/approval/getRejectedJobs').then(function(response) {
		$scope.rejecteddata = response.data;
		if ($scope.rejecteddata.successful) {
			
			var datalength = $scope.rejecteddata.responseObject.length;
			if (datalength == 0){
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else{
				document.getElementById("emptyrow").style.display = "none";
				$scope.RejectedJobs = $scope.rejecteddata.responseObject;
				console.log($scope.RejectedJobs);
			}
			
		}
		else {
			console.log("Client error while getting data");
		}
	});

}]);