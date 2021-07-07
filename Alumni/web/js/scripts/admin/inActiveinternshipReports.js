var Student = angular.module('inActiveinternshipReports', []);
Student.controller('inActiveinternshipController', ['$scope', '$http', function($scope, $http) {

	/* Individual Job applicants */
	$scope.getInternsData = function(id) {
		console.log(id);
		$http.post('/alumni/report/getInternsData', id).then(function(response) {
			$scope.interndata = response.data;
			if ($scope.interndata.successful) {
				$scope.InternApplicants = $scope.interndata.responseObject.InternData;
				console.log($scope.InternApplicants);
				$("#InactiveInterns").hide();
				$("#individualInternsdata").show();
				
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};
	
	$http.get('/alumni/approval/getinActiveInternships').then(function(response) {
		$scope.rejecteddata = response.data;
		if ($scope.rejecteddata.successful) {
			
			var datalength = $scope.rejecteddata.responseObject.length;
			if (datalength == 0){
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else{
				document.getElementById("emptyrow").style.display = "none";
				$scope.InactiveInterns = $scope.rejecteddata.responseObject;
				console.log($scope.InactiveInterns);
			}
			
		}
		else {
			console.log("Client error while getting data");
		}
	});
	

}]);