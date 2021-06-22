var Student = angular.module('ClosedJobs', []);
Student.controller('inActiveJobsController', ['$scope', '$http', function($scope, $http) {

	$http.get('/alumni/approval/getinActiveJobs').then(function(response) {
		$scope.inActivedata = response.data;
		if ($scope.inActivedata.successful) {
			
			var datalength = $scope.inActivedata.responseObject.length;
			if (datalength == 0){
				console.log(datalength);   
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else{
				document.getElementById("emptyrow").style.display = "none";
				$scope.InActiveJobs = $scope.inActivedata.responseObject;
				console.log($scope.InActiveJobs);
			}
			
		}
		else {
			console.log("Client error while getting data");
		}
	});


}]);