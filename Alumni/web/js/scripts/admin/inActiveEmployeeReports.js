var Student = angular.module('inActiveJobReports', []);
Student.controller('InActiveJobController', ['$scope', '$http', function($scope, $http) {

	$http.get('/alumni/approval/getinActiveJobs').then(function(response) {
		$scope.inActivedata = response.data;
		if ($scope.inActivedata.successful) {
			
			var datalength = $scope.inActivedata.responseObject.length;
			if (datalength == 0){
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else{
				document.getElementById("emptyrow").style.display = "none";
				$scope.InActiveJobs = $scope.inActivedata.responseObject;
				console.log($scope.InActiveJobs);
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
				$scope.JobApplicants = $scope.jobdata.responseObject.JobData;
				console.log($scope.JobApplicants);
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