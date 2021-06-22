var Student = angular.module('allEvents', []);
var documentsArr = [];
Student.controller('EventsViewController', ['$scope', '$http', function($scope, $http) {

	
	$http.post('/alumni/event/getallEvents').then(function(response) {
		$scope.Eventsdata = response.data;
		if ($scope.Eventsdata.successful) {
			$scope.alldata = $scope.Eventsdata.responseObject;
			console.log($scope.alldata);
		}
		else {
			console.log("Client error while getting data");
		}
	});
	
	
	$scope.ApplyEvent = function(ApplyEvent) {
		console.log(ApplyEvent);
		var std_id = Alumni.getSessionValue("user_id");
		
		var Apply = {
			std_id: std_id,
			id: ApplyEvent
		};
		
		console.log(Apply);

		$http.post('/alumni/event/ApplyEvent', Apply).then(
			function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {
					swal("Event already applied!!!");
					
				} else {
					swal(
							{
								title: "Done",
								text: "Event Applied Successfully!",
								type: "success"
							}, function() {
								Alumni.showEmployeeAllEvents();
							});
				}
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});
	};
	
	
	

}]);