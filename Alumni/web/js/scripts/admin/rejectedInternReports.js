var Student = angular.module('rejectedInternReports', []);
Student.controller('RejectedInternsController', ['$scope', '$http', function($scope, $http) {

	$http.get('/alumni/approval/getRejectedInternshipsData').then(function(response) {
		$scope.rejecteddata = response.data;
		if ($scope.rejecteddata.successful) {
			
			var datalength = $scope.rejecteddata.responseObject.length;
			if (datalength == 0){
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else{
				document.getElementById("emptyrow").style.display = "none";
				$scope.RejectedInterns = $scope.rejecteddata.responseObject;
				console.log($scope.RejectedInterns);
			}
			
		}
		else {
			console.log("Client error while getting data");
		}
	});

}]);