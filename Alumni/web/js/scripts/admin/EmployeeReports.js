var Student = angular.module('EmployeeReports', []);
var documentsArr = [];
Student.controller('EmployeeReportsController', ['$scope', '$http', function($scope, $http) {

	/* getting total employees count */
	$http.get('/alumni/report/getMembersCount').then(function(response) {
		$scope.Eventdata = response.data;
			if ($scope.Eventdata.successful) {    
				Alumni.setSessionValue("b1", $scope.Eventdata.responseObject.members_count);
				$scope.EData = {object:$scope.Eventdata.responseObject};
				console.log("............... conunt of Events ................");
				console.log($scope.EData);
			}
		else      
		{
			console.log("Client error while getting data");  
		}  
	});
	
	/* getting total Approved employees count */
	$http.get('/alumni/report/getApprovedEmployeesCount').then(function(response) {
		$scope.Approvedempdata = response.data;
			if ($scope.Approvedempdata.successful) {    
				Alumni.setSessionValue("b2", $scope.Approvedempdata.responseObject.approved_employee_count);
				$scope.ApprovedEmpData = {object:$scope.Approvedempdata.responseObject};
				console.log("............... conunt of Approved Employees ................");
				console.log($scope.ApprovedEmpData);
			}
		else      
		{
			console.log("Client error while getting data");  
		}  
	});

	/* getting total rejected employees count */   
	$http.get('/alumni/report/getRejectedEmployeesCount').then(function(response) {
		$scope.Rejectedempdata = response.data;
			if ($scope.Rejectedempdata.successful) {    
				Alumni.setSessionValue("b3", $scope.Rejectedempdata.responseObject.rejected_employee_count);
				$scope.RejectedEmpData = {object:$scope.Rejectedempdata.responseObject};
				console.log($scope.RejectedEmpData);
			}
		else      
		{
			console.log("Client error while getting data");  
		}  
	});
	
	/* getting total verified employees count */
	$http.get('/alumni/report/getVerifiedEmployeesCount').then(function(response) {
		$scope.Verifiedempdata = response.data;
			if ($scope.Verifiedempdata.successful) {    
				Alumni.setSessionValue("b4", $scope.Verifiedempdata.responseObject.verified_employee_count);
				$scope.VerifiedEmpData = {object:$scope.Verifiedempdata.responseObject};
				console.log($scope.VerifiedEmpData);
			}
		else      
		{
			console.log("Client error while getting data");  
		}  
	});
	
	/* getting total non-verified employees count */
	$http.get('/alumni/report/getnonVerifiedEmployeesCount').then(function(response) {
		$scope.NonVerifiedempdata = response.data;
			if ($scope.NonVerifiedempdata.successful) {    
				Alumni.setSessionValue("b5", $scope.NonVerifiedempdata.responseObject.nonverified_employee_count);
				$scope.NonVerifiedEmpData = {object:$scope.NonVerifiedempdata.responseObject};
				console.log($scope.NonVerifiedEmpData);
			}
		else      
		{   
			console.log("Client error while getting data");  
		}  
	});
	

/* get all count*/

	var ctx = document.getElementById("myChart3").getContext('2d');
	a1 = Alumni.getSessionValue("b1");
	a2 = Alumni.getSessionValue("b2");
	a3 = Alumni.getSessionValue("b3");
	a4 = Alumni.getSessionValue("b4");
	a5 = Alumni.getSessionValue("b5");
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


/* getting Approved Employees Data */
	$scope.getApprovedEmpData = function(status) {
		console.log(status);
		$http.post('/alumni/report/getApprovedEmpData', status).then(function(response) {
			$scope.approveddata = response.data;
			if ($scope.approveddata.successful) {
				$scope.ApprovedEmployeesData = $scope.approveddata.responseObject.approvedEmpData;
				console.log($scope.ApprovedEmployeesData);
				$("#mainpage").hide();
				$("#ApprovedEmpJobs").hide();
				$("#employeeapplied").hide();
				$("#EmpDatadiv").hide();
				$("#approveEmpDatadiv").show();
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};

	/* getting rejected employees */
	$scope.getRejectedEmpData = function(status) {
		console.log(status);
		$http.post('/alumni/report/getRejectedEmpData', status).then(function(response) {
			$scope.rejecteddata = response.data;
			if ($scope.rejecteddata.successful) {
				$scope.StudentsData = $scope.rejecteddata.responseObject.RejectedEmpData;
				console.log($scope.StudentsData);
				$("#mainpage").hide();
				$("#ApprovedEmpJobs").hide();
				$("#employeeapplied").hide();
				$("#approveEmpDatadiv").hide();
				$("#EmpDatadiv").show();
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};
	
	/* getting verified employees */
	$scope.getVerifiedEmpData = function(status) {
		console.log(status);
		$http.post('/alumni/report/getVerifiedEmpData', status).then(function(response) {
			$scope.Verifieddata = response.data;
			if ($scope.Verifieddata.successful) {
				$scope.StudentsData = $scope.Verifieddata.responseObject.VerifiedEmpData;
				console.log($scope.StudentsData);
				$("#mainpage").hide();
				$("#ApprovedEmpJobs").hide();
				$("#employeeapplied").hide();
				$("#approveEmpDatadiv").hide();
				$("#EmpDatadiv").show();
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};
	
	/* getting not verified employee */
	$scope.getnotVerifiedEmpData = function(status) {
		console.log(status);
		$http.post('/alumni/report/getnotVerifiedEmpData', status).then(function(response) {
			$scope.notVerifiedddata = response.data;
			if ($scope.notVerifiedddata.successful) {
				$scope.StudentsData = $scope.notVerifiedddata.responseObject.notverifiedEmpData;
				console.log($scope.StudentsData);
				$("#mainpage").hide();
				$("#ApprovedEmpJobs").hide();
				$("#employeeapplied").hide();
				$("#approveEmpDatadiv").hide();
				$("#EmpDatadiv").show();
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};
	
	/* getting Employees jobs and interns Data */
	/*$scope.getEmployeeJobsData = function(user_id) {
		console.log(user_id);
		$http.post('/alumni/report/getEmployeeJobsData', user_id).then(function(response) {
			$scope.jobdata = response.data;
			if ($scope.jobdata.successful) {
				$scope.EmployeeJobsData = $scope.jobdata.responseObject.EmployeeJobData;
				console.log($scope.EmployeeJobsData);
				$("#mainpage").hide();
				$("#approveEmpDatadiv").hide();
				$("#employeeapplied").hide();
				$("#EmpDatadiv").hide();
				$("#ApprovedEmpJobs").show();
				
				$http.post('/alumni/report/getEmployeeInternshipsData', user_id).then(function(response) {
					$scope.internsdata = response.data;
					if ($scope.internsdata.successful) {
						$scope.EmployeeInternsData = $scope.internsdata.responseObject.EmployeeInternData;
						console.log($scope.EmployeeInternsData);
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
	
	/* getting employee details */
	/*$scope.getEmployeeDetails = function(user_id){
		console.log(user_id);
		$http.post('/alumni/report/getEmployeeDetails', user_id).then(
		function(response) {
			$scope.popData = response.data;
			if ($scope.popData.successful) {
				$scope.empDetails={object:$scope.popData.responseObject};
				console.log($scope.empDetails);
			} else {
				alert("Error while getting data");
			}
		}, function(errResponse) {
			console.error('Error while fetching notes');
		});
	};*/
	
	
	/* get employee applied jobs and internships */
	/*$scope.getEmployeeappliedJobs = function(user_id) {
		console.log(user_id);
		$http.post('/alumni/report/getEmployeeappliedJobs', user_id).then(function(response) {
			$scope.jobapplied = response.data;
			if ($scope.jobapplied.successful) {
				$scope.EmployeeappliedJobs = $scope.jobapplied.responseObject.EmployeeJobsApplied;
				console.log($scope.EmployeeappliedJobs);
				$("#mainpage").hide();
				$("#approveEmpDatadiv").hide();
				$("#ApprovedEmpJobs").hide();
				$("#EmpDatadiv").hide();
				$("#employeeapplied").show();
				
				$http.post('/alumni/report/getEmployeeappliedInternships', user_id).then(function(response) {
					$scope.internsapplied = response.data;
					if ($scope.internsapplied.successful) {
						$scope.EmployeeappliedInterns = $scope.internsapplied.responseObject.EmployeeInternApplied;
						console.log($scope.EmployeeappliedInterns);
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