var Student = angular.module('volunteership', []);
var documentsArr = [];
Student.controller('VolunteershipViewController', ['$scope', '$http', function($scope, $http) {

	
	var std_id = Alumni.getSessionValue("user_id");
	console.log(std_id);
	$http.post('/alumni/viewjob/getallvolunteerships', std_id).then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.alldata = $scope.data.responseObject;
			console.log($scope.alldata);
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
					Alumni.showStudentAllVolunteerships();
					
				} else {
					swal(
							{
								title: "Done",
								text: "Volunteership Registered Successfully!",
								type: "success"
							}, function() {
								Alumni.showStudentAllVolunteerships();
							});
				}
				
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});
	};
	
}]);