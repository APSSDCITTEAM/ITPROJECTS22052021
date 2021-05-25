var Student = angular.module('EventAction', []);
Student.controller('EventActionController', ['$scope', '$http', function($scope, $http) {

	
	$http.post('/alumni/event/getallOpenEvents').then(function(response) {
		$scope.opendata = response.data;
		if ($scope.opendata.successful) {
			$scope.allOpenEvents = $scope.opendata.responseObject;
			console.log($scope.allOpenEvents);
		}
		else {
			console.log("Client error while getting data");
		}
	});
	
	$http.post('/alumni/event/getallClosedEvents').then(function(response) {
		$scope.Eventsdata = response.data;
		if ($scope.Eventsdata.successful) {
			$scope.allClosedEvents = $scope.Eventsdata.responseObject;
			console.log($scope.allClosedEvents);
		}
		else {
			console.log("Client error while getting data");
		}
	});
	
	/* update event data */
	$scope.changeEventStatus = function(EventData){
		console.log(EventData.id);   
		$http.post('/alumni/event/changeEventStatus', EventData).then(
				function(response) {
					$scope.data = response.data;  
					if ($scope.data.successful) {
						swal("Event Closed Successfully");
						Alumni.showEventActionPage();
						/*$("#myModel").hide();
						$('.modal-backdrop').remove();*/
						
					} else {
						alert("Data not updated");
					}
				}, function(errResponse) {
					console.error('Error while fetching notes');
				});
	};
	

}]);