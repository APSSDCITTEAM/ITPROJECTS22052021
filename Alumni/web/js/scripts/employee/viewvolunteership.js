var Student = angular.module('volunteership', []);
var documentsArr = [];
Student.controller('VolunteershipViewController', ['$scope', '$http', function($scope, $http) {

	
	var std_id = Alumni.getSessionValue("user_id");
	console.log(std_id);
	$http.post('/alumni/viewjob/getallvolunteerships', std_id).then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.alldata = $scope.data.responseObject;
		}
		else {
			console.log("Client error while getting data");
		}
	});

	
	
	$http.get('/alumni/viewjob/getallvolunteershipshome').then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.homedata = $scope.data.responseObject;
		}
		else {
			console.log("Client error while getting data");
		}
	});

	var std_id = Alumni.getSessionValue("user_id");
	console.log(std_id);
	$http.post('/alumni/viewjob/getmyvolunteerships', std_id).then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.myvolunteers = $scope.data.responseObject;
		}
		else {
			console.log("Client error while getting data");
		}
	});

	
	$scope.Applyvolunteer = function(Applyvolunteer) {
		console.log(Applyvolunteer);
		var std_id = Alumni.getSessionValue("user_id");
		
		var Apply = {
			std_id: std_id,
			id: Applyvolunteer
		};
		
		console.log(Apply);

		$http.post('/alumni/viewjob/Applyvolunteer', Apply).then(
			function(response) {
				$scope.data = response.data;
				
				if ($scope.data.successful) {
					alert("Volunteership already registered!!!");
					
				} else {
					swal(
							{
								title: "Done",
								text: "Volunteership Registered Successfully!",
								type: "success"
							}, function() {
								Alumni.showEmployeeAllVolunteerships();
							});
				}
				
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});
	};
	
	
	/* Get My Internships Applicants */
	$scope.VolunteerApplicants = function(id) {
		console.log(id);
		$http.post('/alumni/viewjob/VolunteershipApplicants', id).then(function(response) {
			$scope.applieddata = response.data;
			if ($scope.applieddata.successful) {
				$scope.AppliedCandidates = $scope.applieddata.responseObject.appliedVolunteer;
				console.log($scope.AppliedCandidates);
				/*$("#myVolunteershipsDiv").hide();
				$("#myVolunteershipsApplicantsDiv").show();*/
				
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};

}]);