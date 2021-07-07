var Student = angular.module('jobview', []);
var documentsArr = [];
Student.controller('JobViewController', ['$scope', '$http', function($scope, $http) {

	/* Get My Jobs Only */
	var std_id = Alumni.getSessionValue("user_id");
	console.log(std_id);
	$http.post('/alumni/viewjob/getmyjobs', std_id).then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.myjobs = $scope.data.responseObject;
		}
		else {
			console.log("Client error while getting data");
		}
	});

	/* get My Job Applicatnts */
	$scope.JobApplicants = function(id) {
		console.log(id);
		$http.post('/alumni/viewjob/JobApplicants', id).then(function(response) {
			$scope.applieddata = response.data;
			if ($scope.applieddata.successful) {
				$scope.AppliedJobCandidates = $scope.applieddata.responseObject.appliedJobs;
				console.log($scope.AppliedJobCandidates);
				$("#myJobsDiv").hide();
				$("#myJobApplicantsDiv").show();
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};

}]);