var Student = angular.module('viewEvents', []);
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
	
	/* getting Event view page details */
	$scope.vieweventData=function(id){      
		console.log(id);
	 $http.post('/alumni/event/vieweventData',id).then(function (response) {
		 $scope.viewEventdata = response.data;
		 if ($scope.viewEventdata.successful) {
			 $scope.viewEvent = {object:$scope.viewEventdata.responseObject};
			 console.log($scope.viewEvent);
			 console.log("Successful");
		 } else {    
			 //alert("Error while getting data");
			 console.log("error") 
		 }
	 }, function (errResponse) {
		 console.error('Error while fetching notes');         
	 });   
	}
	
	/* getting view pop up data */
	$scope.getEventPopdata = function(id){
		console.log(id);
		$http.post('/alumni/event/getEventPopdata', id).then(
		function(response) {
			$scope.popData = response.data;
			if ($scope.popData.successful) {
				$scope.updateEvent={object:$scope.popData.responseObject};
				console.log($scope.updateEvent);
			} else {
				alert("Error while getting data");
			}
		}, function(errResponse) {
			console.error('Error while fetching notes');
		});
	};
	
	/* update event data */
	$scope.UpdateEventData = function(EventData){
		console.log(EventData);   
		$http.post('/alumni/event/UpdateEventData', EventData).then(
				function(response) {
					$scope.data = response.data;  
					if ($scope.data.successful) {
						swal("Event Successfully Updated");
						Alumni.showAdminAllEvents();						
					} else {
						alert("Data not updated");
					}
				}, function(errResponse) {
					console.error('Error while fetching notes');
				});
	};
	
	/* deleting event */
	$scope.DeleteEvent = function(DeleteEvent) {   
		console.log(DeleteEvent.id);
		$http.post('/alumni/event/DeleteEvent', DeleteEvent.id).then(
				function(response) {
					$scope.data = response.data;
					console.log($scope.data);
					if ($scope.data.successful) {  
						swal("Event removed Successfully");
						Alumni.showAdminAllEvents();
					} else {
						alert("Data not Deleted");
					}
				}, function(errResponse) {
					console.error('Error while fetching notes');
				});
	};

	

}]);