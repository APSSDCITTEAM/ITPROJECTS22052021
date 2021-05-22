var Student = angular.module('JobApprovals', []);
Student.controller('JobApprovalsController', ['$scope', '$http', function($scope, $http) {

	$http.get('/alumni/approval/getallJobs').then(function(response) {
		$scope.alldata = response.data;
		if($scope.alldata.successful)
		{   
			$scope.allJobs = $scope.alldata.responseObject;
			console.log(":::::::::::::: all Jobs ::::::::::::::");
			console.log($scope.allJobs);
			console.log(":::::::::::::: all Jobs ::::::::::::::");
			
			$http.get('/alumni/approval/getSubmittedJobs').then(function(response) {
				$scope.submitteddata = response.data;
				if($scope.submitteddata.successful)
				{   
					$scope.SubmittedJobs = $scope.submitteddata.responseObject;
					console.log(":::::::::::::: Submitted Jobs ::::::::::::::");
					console.log($scope.SubmittedJobs);
					console.log(":::::::::::::: Submitted Jobs ::::::::::::::");
					
					$http.get('/alumni/approval/getApprovedJobs').then(function(response) {
						$scope.approveddata = response.data;
						if($scope.approveddata.successful)
						{   
							$scope.ApprovedJobs = $scope.approveddata.responseObject;
							console.log(":::::::::::::: Approved Jobs ::::::::::::::");
							console.log($scope.ApprovedJobs);
							console.log(":::::::::::::: Approved Jobs ::::::::::::::");
							
							$http.get('/alumni/approval/getRejectedJobs').then(function(response) {
								$scope.rejecteddata = response.data;
								if($scope.rejecteddata.successful)
								{   
									$scope.RejectedJobs = $scope.rejecteddata.responseObject;
									console.log(":::::::::::::: Rejected Jobs ::::::::::::::");
									console.log($scope.RejectedJobs);
									console.log(":::::::::::::: Rejected Jobs ::::::::::::::");
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
	
	
	/* Approve Job */
	$scope.ApproveJob = function(ApproveJobData){
		console.log(ApproveJobData.id);    
		$http.post('/alumni/approval/ApproveJob', ApproveJobData).then(
				function(response) {
					$scope.data = response.data;  
					if ($scope.data.successful) {
						swal("Job Approved Successfully");
						Alumni.showJobApprovalsPage();
					} else {   
						alert("Data not updated");
					}
				}, function(errResponse) {
					console.error('Error while fetching notes');
				});
	};
	
	
	/* Reject Job */
	$scope.RejectJob = function(RejectJobData){
		console.log(RejectJobData.id);    
		$http.post('/alumni/approval/RejectJob', RejectJobData).then(
				function(response) {
					$scope.data = response.data;  
					if ($scope.data.successful) {
						swal("Job Rejected Successfully");
						Alumni.showJobApprovalsPage();
					} else {   
						alert("Data not updated");
					}
				}, function(errResponse) {
					console.error('Error while fetching notes');
				});
	};
	
	

}]);