var Student = angular.module('StudentReports', []);
var documentsArr = [];
Student.controller('StudentReportsController', ['$scope', '$http', function($scope, $http) {

	/* getting total employees count */
	$http.get('/alumni/report/getStudentMembersCount').then(function(response) {
		$scope.stddata = response.data;
		if ($scope.stddata.successful) {
			console.log($scope.stddata.responseObject);
			Alumni.setSessionValue("a1", $scope.stddata.responseObject.members_count);
			$scope.studentData = { object: $scope.stddata.responseObject };
			
			$http.get('/alumni/report/getApprovedStudentsCount').then(function(response) {
				$scope.Approvedstddata = response.data;
				if ($scope.Approvedstddata.successful) {
					Alumni.setSessionValue("a2", $scope.Approvedstddata.responseObject.approved_student_count);
					$scope.ApprovedStdData = { object: $scope.Approvedstddata.responseObject };
					console.log($scope.ApprovedStdData);
					
					$http.get('/alumni/report/getRejectedStudentsCount').then(function(response) {
						$scope.Rejectedstddata = response.data;
						if ($scope.Rejectedstddata.successful) {
							Alumni.setSessionValue("a3", $scope.Rejectedstddata.responseObject.rejected_students_count);
							$scope.RejectedStdData = { object: $scope.Rejectedstddata.responseObject };
							console.log($scope.RejectedStdData);
							
							$http.get('/alumni/report/getVerifiedStudentsCount').then(function(response) {
								$scope.Verifiedstddata = response.data;
								if ($scope.Verifiedstddata.successful) {
									Alumni.setSessionValue("a4", $scope.Verifiedstddata.responseObject.verified_student_count,0);
									$scope.VerifiedStdData = { object: $scope.Verifiedstddata.responseObject };
									console.log($scope.VerifiedStdData);   
									
									$http.get('/alumni/report/getnonVerifiedStudentsCount').then(function(response) {
										$scope.NonVerifiedstddata = response.data;
										if ($scope.NonVerifiedstddata.successful) {
											Alumni.setSessionValue("a5", $scope.NonVerifiedstddata.responseObject.nonverified_student_count);
											$scope.NonVerifiedStdData = { object: $scope.NonVerifiedstddata.responseObject };
											console.log($scope.NonVerifiedStdData);
											
											var ctx = document.getElementById("myChart3").getContext('2d');
											a1 = Alumni.getSessionValue("a1");
											a2 = Alumni.getSessionValue("a2");
											a3 = Alumni.getSessionValue("a3");
											a4 = Alumni.getSessionValue("a4");
											a5 = Alumni.getSessionValue("a5");
											var chartdata = [a1,a2,a3,a4,a5];
											console.log(a1);
											console.log(a2);
											console.log(a3);
											console.log(a4);
											console.log(a5);
											var myChart = new Chart(ctx, {  
											    type: 'doughnut',
											    data: {
											        datasets: [{
											            data: chartdata,
											            backgroundColor: [
											                '#247CE9',
											                '#63ed7a',
											                '#fc544b',
											                '#C2335E',
											                '#FA7428',
											            ],
											            label: 'Dataset 1'
											        }],
											        labels: [
											            'Total Count',
											            'Active Count',
											            'Rejected Count',
											            'Verified Count',
											            'Un Verified Count'
											        ],
											    },
											    options: {
											        responsive: true,
											        legend: {
											            position: 'bottom',
											        },
											    }
											});
											
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
					
		}
		else {
			console.log("Client error while getting data");
		}
	});

	/* getting total Approved employees count */
	/*$http.get('/alumni/report/getApprovedStudentsCount').then(function(response) {
		$scope.Approvedstddata = response.data;
		if ($scope.Approvedstddata.successful) {
			Alumni.setSessionValue("a2", 1);
			$scope.ApprovedStdData = { object: $scope.Approvedstddata.responseObject };
			console.log($scope.ApprovedStdData);
		}
		else {
			console.log("Client error while getting data");
		}
	});*/

	/* getting total rejected employees count */
	/*$http.get('/alumni/report/getRejectedStudentsCount').then(function(response) {
		$scope.Rejectedstddata = response.data;
		if ($scope.Rejectedstddata.successful) {
			Alumni.setSessionValue("a3", 1);
			$scope.RejectedStdData = { object: $scope.Rejectedstddata.responseObject };
			console.log($scope.RejectedStdData);
		}
		else {
			console.log("Client error while getting data");
		}
	});*/

	/* getting total verified employees count */
	/*$http.get('/alumni/report/getVerifiedStudentsCount').then(function(response) {
		$scope.Verifiedstddata = response.data;
		if ($scope.Verifiedstddata.successful) {
			Alumni.setSessionValue("a4", 1);
			$scope.VerifiedStdData = { object: $scope.Verifiedstddata.responseObject };
			console.log($scope.VerifiedStdData);
		}
		else {
			console.log("Client error while getting data");
		}
	});*/

	/* getting total non-verified student count */
	/*$http.get('/alumni/report/getnonVerifiedStudentsCount').then(function(response) {
		$scope.NonVerifiedstddata = response.data;
		if ($scope.NonVerifiedstddata.successful) {
			Alumni.setSessionValue("a5", 1);
			$scope.NonVerifiedStdData = { object: $scope.NonVerifiedstddata.responseObject };
			console.log($scope.NonVerifiedStdData);
		}
		else {
			console.log("Client error while getting data");
		}
	});*/

/* get all count*/

	/*var ctx = document.getElementById("myChart3").getContext('2d');
	a1 = Alumni.getSessionValue("a1");
	a2 = Alumni.getSessionValue("a2");
	a3 = Alumni.getSessionValue("a3");
	a4 = Alumni.getSessionValue("a4");
	a5 = Alumni.getSessionValue("a5");
	var chartdata = [a1,a2,a3,a4,a5];
	console.log(a1);
	console.log(a2);
	console.log(a3);
	console.log(a4);
	console.log(a5);
	var myChart = new Chart(ctx, {
	    type: 'doughnut',
	    data: {
	        datasets: [{
	            data: chartdata,
	            backgroundColor: [
	                '#247CE9',
	                '#63ed7a',
	                '#fc544b',
	                '#C2335E',
	                '#FA7428',
	            ],
	            label: 'Dataset 1'
	        }],
	        labels: [
	            'Total Count',
	            'Active Count',
	            'Rejected Count',
	            'Verified Count',
	            'Un Verified Count'
	        ],
	    },
	    options: {
	        responsive: true,
	        legend: {
	            position: 'bottom',
	        },
	    }
	});*/



	/* getting Approved students Data */
	$scope.getApprovedStdData = function(status) {
		console.log(status);
		$http.post('/alumni/report/getApprovedStdData', status).then(function(response) {
			$scope.approveddata = response.data;
			if ($scope.approveddata.successful) {
				$scope.ApprovedStudentsData = $scope.approveddata.responseObject.approvedStdData;
				console.log($scope.ApprovedStudentsData);
				$("#mainpage").hide();
				$("#ApprovedEmpJobs").hide();
				$("#EmpDatadiv").hide();
				$("#approveEmpDatadiv").show();
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};

	/* getting rejected students Data */
	$scope.getRejectedStdData = function(status) {
		console.log(status);
		$http.post('/alumni/report/getRejectedStdData', status).then(function(response) {
			$scope.Rejecteddata = response.data;
			if ($scope.Rejecteddata.successful) {
				$scope.StudentsData = $scope.Rejecteddata.responseObject.rejectedStdData;
				console.log($scope.StudentsData);
				$("#mainpage").hide();
				$("#ApprovedEmpJobs").hide();
				$("#approveEmpDatadiv").hide();
				$("#EmpDatadiv").show();
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};

	/* getting verified students Data */
	$scope.getVerifiedStdData = function(status) {
		console.log(status);
		$http.post('/alumni/report/getVerifiedStdData', status).then(function(response) {
			$scope.Verifieddata = response.data;
			if ($scope.Verifieddata.successful) {
				$scope.StudentsData = $scope.Verifieddata.responseObject.verifiedStdData;
				console.log($scope.StudentsData);
				$("#mainpage").hide();
				$("#ApprovedEmpJobs").hide();
				$("#approveEmpDatadiv").hide();
				$("#EmpDatadiv").show();
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};

	/* getting not verified students Data */
	$scope.getnotVerifiedStdData = function(status) {
		console.log(status);
		$http.post('/alumni/report/getnotVerifiedStdData', status).then(function(response) {
			$scope.Notverifieddata = response.data;
			if ($scope.Notverifieddata.successful) {
				$scope.StudentsData = $scope.Notverifieddata.responseObject.notVerifiedStdData;
				console.log($scope.StudentsData);
				$("#mainpage").hide();
				$("#ApprovedEmpJobs").hide();
				$("#approveEmpDatadiv").hide();
				$("#EmpDatadiv").show();
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};

	/* getting Employees jobs and interns Data */
	/*$scope.getStudentsJobsData = function(user_id) {
		console.log(user_id);
		$http.post('/alumni/report/getStudentsJobsData', user_id).then(function(response) {
			$scope.jobdata = response.data;
			if ($scope.jobdata.successful) {
				$scope.StudentsJobsData = $scope.jobdata.responseObject.StudentJobData;
				console.log($scope.StudentsJobsData);
				$("#mainpage").hide();
				$("#approveEmpDatadiv").hide();
				$("#EmpDatadiv").hide();
				$("#ApprovedEmpJobs").show();

				$http.post('/alumni/report/getStudentsInternshipsData', user_id).then(function(response) {
					$scope.internsdata = response.data;
					if ($scope.internsdata.successful) {
						$scope.StudentInternsData = $scope.internsdata.responseObject.StudentInternData;
						console.log($scope.StudentInternsData);
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
	};*/

}]);