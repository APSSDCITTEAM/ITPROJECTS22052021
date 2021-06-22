var Student = angular.module('activeStudentsReports', []);
Student.controller('ActiveStudentsController', ['$scope', '$http', function($scope, $http) {

	
	/* getting active students data */
	$http.get('/alumni/approval/getallApprovedUsers').then(function(response) {
		$scope.approveddata = response.data;
		if ($scope.approveddata.successful) {
			
			var datalength = $scope.approveddata.responseObject.length;
			if (datalength == 0) {
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else {
				document.getElementById("emptyrow").style.display = "none";
				$scope.ApprovedStudentsData = $scope.approveddata.responseObject;
				console.log($scope.ApprovedStudentsData);
			}
			
		} else {
			console.log("Client error while getting data");
		}
	});
	
	
	/* getting individual student data */
	$scope.getStudentsJobsData = function(user_id) {
		console.log(user_id);
		$http.post('/alumni/report/getStudentsJobsData', user_id).then(function(response) {
			$scope.jobdata = response.data;
			if ($scope.jobdata.successful) {
				
				var datalength = $scope.jobdata.responseObject.length;
				if (datalength == 0) {
					console.log(datalength);
					$("#activestudents").hide();
					$("#individualStudentdata").show();
					document.getElementById("emptyrow").style.display = "table-row";
					
				}
				else {
					document.getElementById("emptyrow").style.display = "none";
					$scope.StudentsJobsData = $scope.jobdata.responseObject.StudentJobData;
					console.log($scope.StudentsJobsData);
					$("#activestudents").hide();
					$("#individualStudentdata").show();
				}
				
				$http.post('/alumni/report/getStudentsInternshipsData', user_id).then(function(response) {
					$scope.internsdata = response.data;
					if ($scope.internsdata.successful) {
						
						var datalength = $scope.internsdata.responseObject.length;
						if (datalength == 0) {
							console.log(datalength);
							document.getElementById("emptyrow").style.display = "table-row";
							
						}
						else {
							document.getElementById("emptyrow").style.display = "none";
							$scope.StudentInternsData = $scope.internsdata.responseObject.StudentInternData;
							console.log($scope.StudentInternsData);
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