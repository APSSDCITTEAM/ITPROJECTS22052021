var Student = angular.module('activeInternshipReports', []);
Student.controller('ActiveInternshipsController', ['$scope', '$http', function($scope, $http) {


	$http.get('/alumni/approval/getApprovedInternships').then(function(response) {
		$scope.approveddata = response.data;
		if ($scope.approveddata.successful) {
			
			var datalength = $scope.approveddata.responseObject.length;
			if (datalength == 0){
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else{
				document.getElementById("emptyrow").style.display = "none";
				$scope.ApprovedInternships = $scope.approveddata.responseObject;
				console.log($scope.ApprovedInternships);
			}
			
		}
		else {
			console.log("Client error while getting data");
		}
	});
	
	
	/* Individual Job applicants */
	$scope.getInternsData = function(id) {
		console.log(id);
		$http.post('/alumni/report/getInternsData', id).then(function(response) {
			$scope.jobdata = response.data;
			if ($scope.jobdata.successful) {
				
				var datalength = $scope.jobdata.responseObject.length;
				if (datalength == 0){
					console.log(datalength);
					document.getElementById("emptyrow").style.display = "table-row";
				}
				else{
					document.getElementById("emptyrow").style.display = "none";
					$scope.InternApplicants = $scope.jobdata.responseObject.InternData;
					console.log($scope.InternApplicants);
					
					$("#activestudents").hide();
					$("#individualjobdata").show();
					
				}
				
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};
	
	

}]);