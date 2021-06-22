var Student = angular.module('InternshipApprovals', []);
Student.controller('InternshipsApprovalsController', ['$scope', '$http', function($scope, $http) {

	$http.get('/alumni/approval/getApprovedInternships').then(function(response) {
		$scope.approveddata = response.data;
		if ($scope.approveddata.successful) {
			$scope.ApprovedInternships = $scope.approveddata.responseObject;
			console.log(":::::::::::::: Approved Internships ::::::::::::::");
			console.log($scope.ApprovedInternships);
			console.log(":::::::::::::: Approved Internships ::::::::::::::");
		}
		else {
			console.log("Client error while getting data");
		}
	});



}]);