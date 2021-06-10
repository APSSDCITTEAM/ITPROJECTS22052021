var Student = angular.module('JobAction', []);
Student.controller('JobActionController', ['$scope', '$http', function($scope, $http) {

	
	$http.post('/alumni/viewjob/getallOpenJobs').then(function(response) {
		$scope.opendata = response.data;
		if ($scope.opendata.successful) {
			$scope.allOpenJobs = $scope.opendata.responseObject;
			console.log($scope.allOpenJobs);
		}
		else {
			console.log("Client error while getting data");
		}
	});
	
	$http.post('/alumni/viewjob/getallClosedJobs').then(function(response) {
		$scope.Jobsdata = response.data;
		if ($scope.Jobsdata.successful) {
			$scope.allClosedJobs = $scope.Jobsdata.responseObject;
			console.log($scope.allClosedJobs);
		}
		else {
			console.log("Client error while getting data");
		}
	});
	
	/* update event data */
	$scope.changeJobStatus = function(JobData){
		console.log(JobData.id);   
		$http.post('/alumni/viewjob/changeJobStatus', JobData).then(
				function(response) {
					$scope.data = response.data;  
					if ($scope.data.successful) {
						swal("Job Closed Successfully");
						Alumni.showEmployeeHeader_10();					
					} else {
						alert("Data not updated");
					}
				}, function(errResponse) {
					console.error('Error while fetching notes');
				});
	};
	

}]);