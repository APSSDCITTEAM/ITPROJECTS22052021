var Student = angular.module('JobApprovals', []);
Student.controller('JobApprovalsController', ['$scope', '$http', function($scope, $http) {

	$http.get('/alumni/approval/getRejectedJobs').then(function(response) {
		$scope.rejecteddata = response.data;
		if ($scope.rejecteddata.successful) {
			$scope.RejectedJobs = $scope.rejecteddata.responseObject;
			console.log(":::::::::::::: Rejected Jobs ::::::::::::::");
			console.log($scope.RejectedJobs);
			console.log(":::::::::::::: Rejected Jobs ::::::::::::::");
		}
		else {
			console.log("Client error while getting data");
		}
	});


}]);