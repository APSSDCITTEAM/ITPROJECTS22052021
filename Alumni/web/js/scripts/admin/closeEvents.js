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

	$scope.changeEventStatus = function(EventData) {
		console.log(EventData.id);
		$http.post('/alumni/event/changeEventStatus', EventData.id).then(
			function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {
					/*swal("Event Closed Successfully");*/
					
					swal(
						{
							title: "Done",
							text: "Event Closed Successfully!",
							type: "success"
						}, function() {
							Alumni.showAdminCloseEvents();
						});
					
				} else {
					alert("Data not updated");
				}
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});
	};



}]);