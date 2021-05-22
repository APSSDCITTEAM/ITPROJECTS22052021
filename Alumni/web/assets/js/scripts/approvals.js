var Student = angular.module('approvals', []);
Student.controller('ApprovalsController', ['$scope', '$http', function($scope, $http) {

	$http.get('/alumni/approval/getallusers').then(function(response) {
		$scope.alldata = response.data;
		if($scope.alldata.successful)
		{   
			$scope.allusers = $scope.alldata.responseObject;
			console.log(":::::::::::::: all users ::::::::::::::");
			console.log($scope.allusers);
			console.log(":::::::::::::: all users ::::::::::::::");
			
			$http.get('/alumni/approval/getallVerifiedUsers').then(function(response) {
				$scope.verifieddata = response.data;
				if($scope.verifieddata.successful)
				{   
					$scope.VerifiedUsers = $scope.verifieddata.responseObject;
					console.log(":::::::::::::: verified users ::::::::::::::");
					console.log($scope.VerifiedUsers);
					console.log(":::::::::::::: verified users ::::::::::::::");
					
					$http.get('/alumni/approval/getallApprovedUsers').then(function(response) {
						$scope.approveddata = response.data;
						if($scope.approveddata.successful)
						{   
							$scope.ApprovedUsers = $scope.approveddata.responseObject;
							console.log(":::::::::::::: approved users ::::::::::::::");
							console.log($scope.ApprovedUsers);
							console.log(":::::::::::::: approved users ::::::::::::::");
							
							$http.get('/alumni/approval/getallRejectedUsers').then(function(response) {
								$scope.rejecteddata = response.data;
								if($scope.rejecteddata.successful)
								{   
									$scope.RejectedUsers = $scope.rejecteddata.responseObject;
									console.log(":::::::::::::: rejected users ::::::::::::::");
									console.log($scope.RejectedUsers);
									console.log(":::::::::::::: rejected users ::::::::::::::");
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

	
	/* Approve User */
	$scope.ApproveUser = function(ApproveUserData){
		console.log(ApproveUserData.id);    
		$http.post('/alumni/approval/ApproveUser', ApproveUserData).then(
				function(response) {
					$scope.data = response.data;  
					if ($scope.data.successful) {
						swal("User Approved Successfully");
						Alumni.showApprovalsPage();
					} else {   
						alert("Data not updated");
					}
				}, function(errResponse) {
					console.error('Error while fetching notes');
				});
	};
	
	
	/* Reject User */
	$scope.RejectUser = function(RejectUserData){
		console.log(RejectUserData.id);    
		$http.post('/alumni/approval/RejectUser', RejectUserData).then(
				function(response) {
					$scope.data = response.data;  
					if ($scope.data.successful) {
						swal("User Rejected Successfully");
						Alumni.showApprovalsPage();
					} else {   
						alert("Data not updated");
					}
				}, function(errResponse) {
					console.error('Error while fetching notes');
				});
	};
	
	
	
	
	
	
	
	
}]);