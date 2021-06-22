var Student = angular.module('JobApprovals', []);
Student.controller('JobApprovalsController', ['$scope', '$http', function($scope, $http) {


	$http.get('/alumni/approval/getApprovedJobs').then(function(response) {
		$scope.approveddata = response.data;
		if ($scope.approveddata.successful) {
			$scope.ApprovedJobs = $scope.approveddata.responseObject;
			console.log(":::::::::::::: Approved Jobs ::::::::::::::");
			console.log($scope.ApprovedJobs);
			console.log(":::::::::::::: Approved Jobs ::::::::::::::");

		}
		else {
			console.log("Client error while getting data");
		}
	});

}]);