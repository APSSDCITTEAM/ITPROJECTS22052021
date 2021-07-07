var Student = angular.module('intership', []);
var documentsArr = [];
Student.controller('InternshipViewController', ['$scope', '$http', function($scope, $http) {

	/* Get All Internships Expect Mine */
	var std_id = Alumni.getSessionValue("user_id");
	console.log(std_id);
	$http.post('/alumni/viewjob/getallinternships', std_id).then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.alldata = $scope.data.responseObject;
		}
		else {
			console.log("Client error while getting data");
		}
	});
	   
	
	$scope.ApplyInternship = function(ApplyInternship) {
		console.log(ApplyInternship);
		var std_id = Alumni.getSessionValue("user_id");

		var Apply = {
			std_id: std_id,
			id: ApplyInternship
		};

		console.log(Apply);

		$http.post('/alumni/viewjob/ApplyInternship', Apply).then(
			function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {
					alert("Internship already applied!!!");
					
				} else {   
					swal(
							{
								title: "Done",
								text: "Internship Applied Successfully!",
								type: "success"
							}, function() {
								Alumni.showEmployeeAllInternships();
							});
				}
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});
	};


}]);