var Student = angular.module('InternshipApprovals', []);
Student.controller('InternshipsApprovalsController', ['$scope', '$http', function($scope, $http) {

	$http.get('/alumni/approval/getallInternships').then(function(response) {
		$scope.alldata = response.data;
		if($scope.alldata.successful)
		{   
			$scope.allInternships = $scope.alldata.responseObject;
			console.log(":::::::::::::: all Jobs ::::::::::::::");
			console.log($scope.allInternships);
			console.log(":::::::::::::: all Jobs ::::::::::::::");
			
			$http.get('/alumni/approval/getSubmittedInternships').then(function(response) {
				$scope.submitteddata = response.data;
				if($scope.submitteddata.successful)
				{   
					$scope.SubmittedInternships = $scope.submitteddata.responseObject;
					console.log(":::::::::::::: Submitted Internships ::::::::::::::");
					console.log($scope.SubmittedInternships);
					console.log(":::::::::::::: Submitted Internships ::::::::::::::");
					
					$http.get('/alumni/approval/getApprovedInternships').then(function(response) {
						$scope.approveddata = response.data;
						if($scope.approveddata.successful)
						{   
							$scope.ApprovedInternships = $scope.approveddata.responseObject;
							console.log(":::::::::::::: Approved Internships ::::::::::::::");
							console.log($scope.ApprovedInternships);
							console.log(":::::::::::::: Approved Internships ::::::::::::::");
							
							$http.get('/alumni/approval/getRejectedInternships').then(function(response) {
								$scope.rejecteddata = response.data;
								if($scope.rejecteddata.successful)
								{   
									$scope.RejectedInternships = $scope.rejecteddata.responseObject;
									console.log(":::::::::::::: Rejected Internships ::::::::::::::");
									console.log($scope.RejectedInternships);
									console.log(":::::::::::::: Rejected Internships ::::::::::::::");
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
	$scope.ApproveInternships = function(ApproveInternData){
		console.log(ApproveInternData.id);    
		$http.post('/alumni/approval/ApproveInternships', ApproveInternData).then(
				function(response) {
					$scope.data = response.data;  
					if ($scope.data.successful) {
						swal("Internship Approved Successfully");
						Alumni.showInternshipsApprovalPage();
					} else {   
						alert("Data not updated");
					}
				}, function(errResponse) {
					console.error('Error while fetching notes');
				});
	};
	
	
	/* Reject Job */
	$scope.RejectInternships = function(RejectInternData){
		console.log(RejectInternData.id);    
		$http.post('/alumni/approval/RejectInternships', RejectInternData).then(
				function(response) {
					$scope.data = response.data;  
					if ($scope.data.successful) {
						swal("Internship Rejected Successfully");
						Alumni.showInternshipsApprovalPage();
					} else {   
						alert("Data not updated");
					}
				}, function(errResponse) {
					console.error('Error while fetching notes');
				});
	};
	
	

}]);