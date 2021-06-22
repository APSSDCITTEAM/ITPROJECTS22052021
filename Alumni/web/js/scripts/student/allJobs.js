var Student = angular.module('jobview', []);
var documentsArr = [];
Student.controller('JobViewController', ['$scope', '$http', function($scope, $http) {

	/* Get All Jobs Expect Mine */
	var std_id = Alumni.getSessionValue("user_id");
	console.log(std_id);
	$http.post('/alumni/viewjob/getalljobs', std_id).then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.alljobs = $scope.data.responseObject;
			console.log($scope.alldata);
		}
		else {
			console.log("Client error while getting data");
		}
	});
	
	$scope.Applyjob = function(Applyjob) {
		console.log(Applyjob);
		var std_id = Alumni.getSessionValue("user_id");
		
		var Apply = {
			std_id: std_id,
			id: Applyjob
		};
		
		console.log(Apply);

		$http.post('/alumni/viewjob/Applyjob', Apply).then(
			function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {
					alert("job already applied!!!");
					/*swal("Job Applied Successfully");*/
					
				} else {
					/*swal("Job Applied Succesfully");*/
					swal(
							{
								title: "Done",
								text: "Job Applied Successfully!",
								type: "success"
							}, function() {
								Alumni.showStudentAllJobs();
							});
				}
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});
	};
	

}]);