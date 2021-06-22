var Student = angular.module('activeJobReports', []);
Student.controller('ActiveJobController', ['$scope', '$http', function($scope, $http) {


	$http.get('/alumni/approval/getApprovedJobs').then(function(response) {
		$scope.approveddata = response.data;
		if ($scope.approveddata.successful) {
			
			var datalength = $scope.approveddata.responseObject.length;
			if (datalength == 0) {
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else {
				document.getElementById("emptyrow").style.display = "none";
				$scope.ApprovedJobs = $scope.approveddata.responseObject;
				console.log($scope.ApprovedJobs);
			}
			
		}
		else {
			console.log("Client error while getting data");
		}
	});
	
	
	/* Individual Job applicants */
	$scope.getJobsData = function(id) {
		console.log(id);
		$http.post('/alumni/report/getJobsData', id).then(function(response) {
			$scope.jobdata = response.data;
			if ($scope.jobdata.successful) {

				var datalength = $scope.jobdata.responseObject.length;
				if (datalength == 0) {
					console.log(datalength);
					document.getElementById("emptyrow").style.display = "table-row";
					
				}
				else {
					document.getElementById("emptyrow").style.display = "none";
					$scope.JobApplicants = $scope.jobdata.responseObject.JobData;
					console.log($scope.JobApplicants);
				}
				$("#activestudents").hide();
				$("#individualjobdata").show();
				$("#appliedJobsInterns").hide(); 
				  
				
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};
	
	

}]);