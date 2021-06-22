var Student = angular.module('ClosedEventReports', []);
Student.controller('ClosedEventController', ['$scope', '$http', function($scope, $http) {

	$http.post('/alumni/event/getallClosedEvents').then(function(response) {
		$scope.Eventsdata = response.data;
		if ($scope.Eventsdata.successful) {
			
			var datalength = $scope.Eventsdata.responseObject.length;
			if (datalength == 0) {
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else {
				document.getElementById("emptyrow").style.display = "none";
				$scope.allClosedEvents = $scope.Eventsdata.responseObject;
				console.log($scope.allClosedEvents);
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
				$("#closedEventsApplicants").show();
				
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};

	
}]);