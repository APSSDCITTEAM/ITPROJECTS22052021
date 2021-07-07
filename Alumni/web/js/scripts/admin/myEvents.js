var Student = angular.module('myEvents', []);
var documentsArr = [];
Student.controller('MyEventsViewController', ['$scope', '$http', function($scope, $http) {

	/* Get My Internships */
	var std_id = Alumni.getSessionValue("user_id");
	console.log(std_id);
	$http.post('/alumni/event/getmyEvents', std_id).then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.myEvents = $scope.data.responseObject;
		}
		else {
			console.log("Client error while getting data");
		}
	});
	
	/* get event applicants */
	$scope.getEventApplicants = function(id) {
		console.log(id);
		$http.post('/alumni/report/getEventApplicants', id).then(function(response) {
			$scope.jobdata = response.data;
			if ($scope.jobdata.successful) {

				var datalength = $scope.jobdata.responseObject.length;
				if (datalength == 0) {
					console.log(datalength);
					document.getElementById("emptyrow").style.display = "table-row";
					
				}
				else {
					document.getElementById("emptyrow").style.display = "none";
					$scope.EventApplicants = $scope.jobdata.responseObject.EventappliedData;
					console.log($scope.EventApplicants);
				}
				$("#eventsApplicants").show();
				$("#mainEventpage").hide();
				  
				
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};



}]);