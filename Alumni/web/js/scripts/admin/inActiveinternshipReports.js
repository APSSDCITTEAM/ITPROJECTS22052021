var Student = angular.module('inActiveinternshipReports', []);
Student.controller('inActiveinternshipController', ['$scope', '$http', function($scope, $http) {

	/* Individual Job applicants */
	$scope.getJobsData = function(id) {
		console.log(id);
		$http.post('/alumni/report/getJobsData', id).then(function(response) {
			$scope.jobdata = response.data;
			if ($scope.jobdata.successful) {
				$scope.JobApplicants = $scope.jobdata.responseObject.JobData;
				console.log($scope.JobApplicants);
				$("#activestudents").hide();
				$("#individualJobdata").show();
				
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};
	
	$http.get('/alumni/approval/getinActiveInternships').then(function(response) {
		$scope.rejecteddata = response.data;
		if ($scope.rejecteddata.successful) {
			
			var datalength = $scope.rejecteddata.responseObject.length;
			if (datalength == 0){
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else{
				document.getElementById("emptyrow").style.display = "none";
				$scope.RejectedInternships = $scope.rejecteddata.responseObject;
				console.log($scope.RejectedInternships);
			}
			
		}
		else {
			console.log("Client error while getting data");
		}
	});
	

}]);