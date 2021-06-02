var Student = angular.module('internAction', []);
Student.controller('InternActionController', ['$scope', '$http', function($scope, $http) {

	
	$http.post('/alumni/viewjob/getallOpenInterns').then(function(response) {
		$scope.opendata = response.data;
		if ($scope.opendata.successful) {
			$scope.allOpeninterns = $scope.opendata.responseObject;
			console.log($scope.allOpeninterns);
		}
		else {
			console.log("Client error while getting data");
		}
	});
	
	$http.post('/alumni/viewjob/getallClosedInterns').then(function(response) {
		$scope.Jobsdata = response.data;
		if ($scope.Jobsdata.successful) {
			$scope.allClosedinterns = $scope.Jobsdata.responseObject;
			console.log($scope.allClosedinterns);
		}
		else {
			console.log("Client error while getting data");
		}
	});
	
	/* update event data */
	$scope.changeInternStatus = function(InternData){
		console.log(InternData.id);   
		$http.post('/alumni/viewjob/changeInternStatus', InternData).then(
				function(response) {
					$scope.data = response.data;  
					if ($scope.data.successful) {
						swal("Internship Closed Successfully");
						Alumni.showInternshipActionPage();
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