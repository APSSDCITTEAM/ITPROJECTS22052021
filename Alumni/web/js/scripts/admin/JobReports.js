var Student = angular.module('JobReports', []);
var documentsArr = [];
Student.controller('JobReportsController', ['$scope', '$http', function($scope, $http) {

	/* getting total employees count */
	$http.get('/alumni/report/getJobCount').then(function(response) {
		$scope.Eventdata = response.data;
			if ($scope.Eventdata.successful) {    
				$scope.Data = {object:$scope.Eventdata.responseObject};
				console.log("............... conunt of Jobs ................");
				console.log($scope.Data);
				
				$http.get('/alumni/report/getApprovedJobCount').then(function(response) {
					$scope.Approvedjobdata = response.data;
						if ($scope.Approvedjobdata.successful) {    
							$scope.ApprovedJobsData = {object:$scope.Approvedjobdata.responseObject};
							console.log("............... conunt of Approved Employees ................");
							console.log($scope.ApprovedJobsData);
							
							$http.get('/alumni/report/getRejectedJobsCount').then(function(response) {
								$scope.Rejectedjobdata = response.data;
									if ($scope.Rejectedjobdata.successful) {    
										$scope.RejectedJobData = {object:$scope.Rejectedjobdata.responseObject};
										console.log($scope.RejectedJobData);
										
										$http.get('/alumni/report/getClosedJobCount').then(function(response) {
											$scope.Verifiedjobdata = response.data;
												if ($scope.Verifiedjobdata.successful) {    
													$scope.ClosedJobData = {object:$scope.Verifiedjobdata.responseObject};
													console.log($scope.ClosedJobData);
													
													$http.get('/alumni/report/getPendingJobCount').then(function(response) {
														$scope.pendingjobdata = response.data;
															if ($scope.pendingjobdata.successful) {    
																$scope.PendingJobData = {object:$scope.pendingjobdata.responseObject};
																console.log($scope.PendingJobData);
															}
														else      
														{
															console.log("Client error while getting data");  
														}  
													});
													
												}
											else      
											{
												console.log("Client error while getting data");  
											}  
										});
										
									}
								else      
								{
									console.log("Client error while getting data");  
								}  
							});
							
						}
					else      
					{
						console.log("Client error while getting data");  
					}  
				});
				
			}
		else      
		{
			console.log("Client error while getting data");  
		}  
	});
	
	
	/* getting Approved Employees Data */
	$scope.getApprovedJobData = function(id) {
		console.log(id);
		$http.post('/alumni/report/getJobsData', id).then(function(response) {
			$scope.approveddata = response.data;
			if ($scope.approveddata.successful) {
				$scope.ApprovedJobData = $scope.approveddata.responseObject.approvedEmpData;
				console.log($scope.ApprovedJobData);
				$("#mainpage").hide();
				$("#ApprovedJobs").hide();
				
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};
	
	
	
	
}]);