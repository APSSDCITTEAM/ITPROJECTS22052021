var Student = angular.module('CreateEvent', []);
var documentsArr = [];
Student.controller('EventCreationController', ['$scope', '$http', function($scope, $http) {

	$scope.CreateEvent = function(CreateEvent) {	
		console.log(CreateEvent);
		CreateEvent['std_id'] = Alumni.getSessionValue("user_id");
		console.log(CreateEvent);
		$http.post('/alumni/event/CreateEvent',CreateEvent).then(  
				function(response) {    
					$scope.data = response.data;           
					if ($scope.data.successful) {
						swal("Event Created Successfully");						
					} else {
						alert("Data not inserted");    
					}   
				}, function(errResponse) {
					console.error('Error while fetching notes');
				});
		};

}]);