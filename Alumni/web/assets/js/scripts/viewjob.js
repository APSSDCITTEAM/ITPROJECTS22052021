var Student = angular.module('jobview', []);
var documentsArr = [];
Student.controller('JobViewController', ['$scope', '$http', function($scope, $http) {


	/* Get All Jobs Expect Mine */
	var std_id = Alumni.getSessionValue("user_id");
	console.log(std_id);
	$http.post('/alumni/viewjob/getalljobs', std_id).then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.alldata = $scope.data.responseObject;
		}
		else {
			console.log("Client error while getting data");
		}
	});


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


	/* Get All Jobs */
	$http.get('/alumni/viewjob/getalljobshome').then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.homedata = $scope.data.responseObject;
			console.log($scope.homedata);
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
					swal("job Applied Successfully");
				} else {
					alert("Data not inserted");
				}
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});
	};


}]);