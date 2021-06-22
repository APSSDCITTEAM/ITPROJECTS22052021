var Student = angular.module('OpenEventReports', []);
Student.controller('OpenEventController', ['$scope', '$http', function($scope, $http) {

	
	$http.post('/alumni/event/getallOpenEvents').then(function(response) {
		$scope.opendata = response.data;
		if ($scope.opendata.successful) {
			
			var datalength = $scope.opendata.responseObject.length;
			if (datalength == 0) {
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else {
				document.getElementById("emptyrow").style.display = "none";
				$scope.allOpenEvents = $scope.opendata.responseObject;
				console.log($scope.allOpenEvents);
			}
			
		}  
		else {
			console.log("Client error while getting data");
		}
	});
	
	/* getting event applicants */
	$scope.getEventApplicants = function(id) {
		console.log(id);
		$http.post('/alumni/report/getEventApplicants', id).then(function(response) {
			$scope.Eventdata = response.data;
			if ($scope.Eventdata.successful) {
				
				var datalength = $scope.Eventdata.responseObject.length;
				if (datalength == 0) {
					console.log(datalength);
					document.getElementById("emptyrow").style.display = "table-row";
				}
				else {
					document.getElementById("emptyrow").style.display = "none";
					$scope.allOpenEventsApplicants = $scope.Eventdata.responseObject.EventappliedData;
					console.log($scope.allOpenEventsApplicants);
				}
				
				$("#activestudents").hide();
				$("#activeEventsApplicants").show();
				
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};
	
	
	
	
}]);