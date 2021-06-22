var Student = angular.module('InternshipApprovals', []);
Student.controller('InternshipsApprovalsController', ['$scope', '$http', function($scope, $http) {

	$http.get('/alumni/approval/getRejectedInternships').then(function(response) {
		$scope.rejecteddata = response.data;
		if ($scope.rejecteddata.successful) {
			$scope.RejectedInternships = $scope.rejecteddata.responseObject;
			console.log(":::::::::::::: Rejected Internships ::::::::::::::");
			console.log($scope.RejectedInternships);
			console.log(":::::::::::::: Rejected Internships ::::::::::::::");
		}
		else {
			console.log("Client error while getting data");
		}
	});



}]);