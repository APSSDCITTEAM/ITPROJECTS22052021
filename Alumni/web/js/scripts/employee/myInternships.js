var Student = angular.module('intership', []);
var documentsArr = [];
Student.controller('InternshipViewController', ['$scope', '$http', function($scope, $http) {

	/* Get My Internships */
	var std_id = Alumni.getSessionValue("user_id");
	console.log(std_id);
	$http.post('/alumni/viewjob/getmyinternships', std_id).then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.myinterns = $scope.data.responseObject;
		}
		else {
			console.log("Client error while getting data");
		}
	});

	/* Get My Internships Applicants */
	$scope.InternApplicants = function(id) {
		console.log(id);
		$http.post('/alumni/viewjob/InternshipApplicants', id).then(function(response) {
			$scope.applieddata = response.data;
			if ($scope.applieddata.successful) {
				$scope.AppliedCandidates = $scope.applieddata.responseObject.appliedInterns;
				console.log($scope.AppliedCandidates);
				$("#myInternshipsDiv").hide();
				$("#myInternshipsApplicantsDiv").show();
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};




}]);