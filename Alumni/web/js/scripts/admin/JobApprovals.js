var Student = angular.module('JobApprovals', []);
Student.controller('JobApprovalsController', ['$scope', '$http', function($scope, $http) {

			$http.get('/alumni/approval/getSubmittedJobs').then(function(response) {
				$scope.submitteddata = response.data;
				if($scope.submitteddata.successful)
				{   
					
					var datalength = $scope.submitteddata.responseObject.length;
					if (datalength == 0) {
						console.log(datalength);
						document.getElementById("emptyrow").style.display = "table-row";
					}
					else {
						document.getElementById("emptyrow").style.display = "none";
						$scope.SubmittedJobs = $scope.submitteddata.responseObject;
						console.log($scope.SubmittedJobs);
					}
					
				}    
				else
				{
					console.log("Client error while getting data");  
				}
			});
			
			
	
	/* Approve Job */
	$scope.ApproveJob = function(ApproveJobData){
		console.log(ApproveJobData.id);    
		$http.post('/alumni/approval/ApproveJob', ApproveJobData.id).then(
				function(response) {
					$scope.data = response.data;  
					if ($scope.data.successful) {
						/*swal("Job Approved Successfully");*/
						
						swal(
								{
									title: "Done",
									text: "Job Approved Successfully!",
									type: "success"
								}, function() {
									Alumni.showAdminJobApprovals();
								});
						
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
		$http.post('/alumni/approval/RejectJob', RejectJobData.id).then(
				function(response) {
					$scope.data = response.data;  
					if ($scope.data.successful) {
						swal("Job Rejected Successfully");
						Alumni.showAdminJobApprovals();
					} else {   
						alert("Data not updated");
					}
				}, function(errResponse) {
					console.error('Error while fetching notes');
				});
	};
	
	

}]);