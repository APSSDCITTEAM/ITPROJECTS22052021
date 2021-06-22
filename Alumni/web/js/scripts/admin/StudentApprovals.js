var Student = angular.module('approvals', []);
Student.controller('ApprovalsController', ['$scope', '$http', function($scope, $http) {

	$http.get('/alumni/approval/getallVerifiedUsers').then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			var datalength = $scope.data.responseObject.length;
			if (datalength == 0) {
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else {
				document.getElementById("emptyrow").style.display = "none";
				$scope.VerifiedStudents = $scope.data.responseObject;
				console.log($scope.VerifiedStudents);
			}
		} else {
			console.log("Client error while getting data");
		}
	});

	/* Approve User */
	$scope.ApproveUser = function(id) {
		$.blockUI({
			message: '<img src="/alumni/assets/images/block_loader.gif" /><br><h6>Just a Moment....</h6>',
			css: {
				backgroundColor: 'transparent',
				color: '#fff',
				border: 'none'
			}
		});
		console.log(id);
		$http.post('/alumni/approval/ApproveUser', id).then(
			function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {
					setTimeout(function() {
						$.unblockUI();
						swal(
							{
								title: "Done!",
								text: "User Approved Successfully!",
								type: "success"
							}, function() {
								Alumni.showStudentApprovals();
							});

					}, 3000);
				} else {
					setTimeout(function() {
						$.unblockUI();
						swal(
							{
								title: "Oops!",
								text: "Failed to Approve User!",
								type: "error"
							}, function() {
								Alumni.showStudentApprovals();
							});
					}, 3000);
				}
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});
	};


	/* Reject User */
	$scope.RejectUser = function(id) {
		$.blockUI({
			message: '<img src="/alumni/assets/images/block_loader.gif" /><br><h6>Just a Moment....</h6>',
			css: {
				backgroundColor: 'transparent',
				color: '#fff',
				border: 'none'
			}
		});
		console.log(id);
		$http.post('/alumni/approval/RejectUser', id).then(
			function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {
					setTimeout(function() {
						$.unblockUI();
						swal(
							{
								title: "Done!",
								text: "User Rejected Successfully!",
								type: "success"
							}, function() {
								Alumni.showStudentApprovals();
							});

					}, 3000);
				} else {
					setTimeout(function() {
						$.unblockUI();
						swal(
							{
								title: "Oops!",
								text: "Failed to Reject User!",
								type: "error"
							}, function() {
								Alumni.showStudentApprovals();
							});
					}, 3000);
				}
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});
	};
}]);