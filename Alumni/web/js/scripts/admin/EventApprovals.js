var Student = angular.module('EventApprovals', []);
Student.controller('EventsApprovalsController', ['$scope', '$http', function($scope, $http) {

	$http.get('/alumni/event/getSubmittedevents').then(function(response) {
		$scope.submitteddata = response.data;
		if ($scope.submitteddata.successful) {
			
			var datalength = $scope.submitteddata.responseObject.length;
			if (datalength == 0) {
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else {
				document.getElementById("emptyrow").style.display = "none";
				$scope.SubmittedEvents = $scope.submitteddata.responseObject;
				console.log($scope.SubmittedEvents);
			}
			
		}
		else {
			console.log("Client error while getting data");
		}
	});

	/* Approve Job */
	$scope.ApproveEvent = function(ApproveData) {
		console.log(ApproveData.id);
		$http.post('/alumni/event/ApproveEvent', ApproveData.id).then(
			function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {
					/*swal("Internship Approved Successfully");*/
					
					swal(
							{
								title: "Done",
								text: "Event Approved Successfully!",
								type: "success"
							}, function() {
								Alumni.showAdminEventsApprovals();
							});
					
				} else {
					swal("Data not updated");
				}
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});
	};


	/* Reject Job */
	$scope.RejectEvent = function(RejectData) {
		console.log(RejectData.id);
		$http.post('/alumni/event/RejectEvent', RejectData.id).then(
			function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {
					swal(
						{
							title: "Done",
							text: "Event Rejected Successfully!",
							type: "success"
						}, function() {
							Alumni.showAdminEventsApprovals();
						});
				} else {
					swal("Data not updated");
				}
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});
	};

}]);