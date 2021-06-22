var Student = angular.module('InternshipApprovals', []);
Student.controller('InternshipsApprovalsController', ['$scope', '$http', function($scope, $http) {

	$http.get('/alumni/approval/getSubmittedInternships').then(function(response) {
		$scope.submitteddata = response.data;
		if ($scope.submitteddata.successful) {
			
			var datalength = $scope.submitteddata.responseObject.length;
			if (datalength == 0) {
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else {
				document.getElementById("emptyrow").style.display = "none";
				$scope.SubmittedInternships = $scope.submitteddata.responseObject;
				console.log($scope.SubmittedInternships);
			}
			
		}
		else {
			console.log("Client error while getting data");
		}
	});

	/* Approve Job */
	$scope.ApproveInternships = function(ApproveInternData) {
		console.log(ApproveInternData.id);
		$http.post('/alumni/approval/ApproveInternships', ApproveInternData.id).then(
			function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {
					/*swal("Internship Approved Successfully");*/
					
					swal(
							{
								title: "Done",
								text: "Internship Approved Successfully!",
								type: "success"
							}, function() {
								Alumni.showAdminInternshipApprovals();
							});
					
				} else {
					swal("Data not updated");
				}
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});
	};


	/* Reject Job */
	$scope.RejectInternships = function(RejectInternData) {
		console.log(RejectInternData.id);
		$http.post('/alumni/approval/RejectInternships', RejectInternData.id).then(
			function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {
					swal("Internship Rejected Successfully");
					Alumni.showAdminInternshipApprovals();
				} else {
					swal("Data not updated");
				}
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});
	};

}]);