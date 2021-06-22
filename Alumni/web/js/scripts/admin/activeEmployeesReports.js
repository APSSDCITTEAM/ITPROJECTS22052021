var Student = angular.module('activeEmployeesReports', []);
Student.controller('ActiveEmployeesController', ['$scope', '$http', function($scope, $http) {

	
	/* getting active students data */
	$http.get('/alumni/empapproval/getallApprovedUsers').then(function(response) {
		$scope.activeData = response.data;
		if ($scope.activeData.successful) {
			
			var datalength = $scope.activeData.responseObject.length;
			if (datalength == 0) {
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else {
				document.getElementById("emptyrow").style.display = "none";
				$scope.ApprovedEmployeesData = $scope.activeData.responseObject;
				console.log($scope.ApprovedEmployeesData);
			}
			
			
		} else {  
			console.log("Client error while getting data");
		}
	});
	
	/* individual Employee data */
	$scope.getEmployeeJobsData = function(user_id) {
		console.log(user_id);
		$http.post('/alumni/report/getEmployeeJobsData', user_id).then(function(response) {
			$scope.jobdata = response.data;
			if ($scope.jobdata.successful) {
				
				var datalength = $scope.jobdata.responseObject.length;
				if (datalength == 0) {
					console.log(datalength);
					document.getElementById("emptyrow").style.display = "table-row";
					$("#activestudents").hide();
					$("#individualEmployeedata").show();
					$("#appliedJobsInterns").hide();
				}
				else {
					document.getElementById("emptyrow").style.display = "none";
					$scope.EmployeeJobsData = $scope.jobdata.responseObject.EmployeeJobData;
					console.log($scope.EmployeeJobsData);
					$("#activestudents").hide();
					$("#individualEmployeedata").show();
					$("#appliedJobsInterns").hide();
				}
				
				$http.post('/alumni/report/getEmployeeInternshipsData', user_id).then(function(response) {
					$scope.internsdata = response.data;
					if ($scope.internsdata.successful) {
						
						var datalength = $scope.internsdata.responseObject.length;
						if (datalength == 0) {
							console.log(datalength);
							document.getElementById("emptyrow").style.display = "table-row";
						}
						else {
							document.getElementById("emptyrow").style.display = "none";
							$scope.EmployeeInternsData = $scope.internsdata.responseObject.EmployeeInternData;
							console.log($scope.EmployeeInternsData);
						}
						
					}
					else {
						console.log("Client error while getting data");
					}
				});
				
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};
	
	/* getting employee details*/
	$scope.getEmployeeDetails = function(user_id){
		console.log(user_id);
		$http.post('/alumni/report/getEmployeeDetails', user_id).then(
		function(response) {
			$scope.popData = response.data;
			if ($scope.popData.successful) {
				$scope.empDetails={object:$scope.popData.responseObject};
				console.log(";;;;;;;;;;;;;;;;;;;;;;");
				console.log($scope.empDetails);
			} else {
				alert("Error while getting data");
			}
		}, function(errResponse) {
			console.error('Error while fetching notes');
		});
	};
	
	
	/* get employee applied jobs and internships */
	$scope.getEmployeeappliedJobs = function(user_id) {
		console.log(user_id);
		$http.post('/alumni/report/getEmployeeappliedJobs', user_id).then(function(response) {
			$scope.jobapplied = response.data;
			if ($scope.jobapplied.successful) {
				
				var datalength = $scope.jobapplied.responseObject.length;
				if (datalength == 0) {
					console.log(datalength);
					document.getElementById("emptyrow").style.display = "table-row";
					$("#activestudents").hide();
					$("#individualEmployeedata").hide();
					$("#appliedJobsInterns").show();
				}
				else {
					document.getElementById("emptyrow").style.display = "none";
					$scope.EmployeeappliedJobs = $scope.jobapplied.responseObject.EmployeeJobsApplied;
					console.log($scope.EmployeeappliedJobs);
					$("#activestudents").hide();
					$("#individualEmployeedata").hide();
					$("#appliedJobsInterns").show();
				}
				
				
				
				$http.post('/alumni/report/getEmployeeappliedInternships', user_id).then(function(response) {
					$scope.internsapplied = response.data;
					if ($scope.internsapplied.successful) {
						
						var datalength = $scope.internsapplied.responseObject.length;
						if (datalength == 0) {
							console.log(datalength);
							document.getElementById("emptyrow").style.display = "table-row";
						}
						else {
							document.getElementById("emptyrow").style.display = "none";
							$scope.EmployeeappliedInterns = $scope.internsapplied.responseObject.EmployeeInternApplied;
							console.log($scope.EmployeeappliedInterns);
						}
						
					}
					else {
						console.log("Client error while getting data");
					}
				});
				
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};
	
	
	
	
	
}]);