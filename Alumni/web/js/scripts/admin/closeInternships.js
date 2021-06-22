var Student = angular.module('internAction', []);
Student.controller('InternActionController', ['$scope', '$http', function($scope, $http) {


	$http.post('/alumni/viewjob/getallOpenInterns').then(function(response) {
		$scope.opendata = response.data;
		if ($scope.opendata.successful) {
			
			var datalength = $scope.opendata.responseObject.length;
			if (datalength == 0) {
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else {
				document.getElementById("emptyrow").style.display = "none";
				$scope.allOpeninterns = $scope.opendata.responseObject;
				console.log($scope.allOpeninterns);
			}
			
			
		}
		else {
			console.log("Client error while getting data");
		}
	});

	/* update event data */
	$scope.changeInternStatus = function(InternData) {
		console.log(InternData.id);
		$http.post('/alumni/viewjob/changeInternStatus', InternData).then(
			function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {
					/*swal("Internship Closed Successfully");*/
					
					swal(
							{
								title: "Done",
								text: "Internship Closed Successfully!",
								type: "success"
							}, function() {
								Alumni.showAdminCloseInternships();
							});
					
				} else {
					alert("Data not updated");
				}
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});
	};


}]);