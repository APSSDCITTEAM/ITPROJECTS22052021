var Student = angular.module('JobAction', []);
Student.controller('JobActionController', ['$scope', '$http', function($scope, $http) {


	$http.post('/alumni/viewjob/getallOpenJobs').then(function(response) {
		$scope.opendata = response.data;
		if ($scope.opendata.successful) {
			
			var datalength = $scope.opendata.responseObject.length;
			if (datalength == 0) {
				console.log(datalength);
				document.getElementById("emptyrow").style.display = "table-row";
			}
			else {
				document.getElementById("emptyrow").style.display = "none";
				$scope.allOpenJobs = $scope.opendata.responseObject;
				console.log($scope.allOpenJobs);
			}			
			
		}
		else {
			console.log("Client error while getting data");
		}
	});


	/* update event data */
	$scope.changeJobStatus = function(JobData) {
		console.log(JobData.id);
		$http.post('/alumni/viewjob/changeJobStatus', JobData).then(
			function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {
					/*swal("Job Closed Successfully");*/
					
					swal(
						{
							title: "Done",
							text: "Job Closed Successfully!",
							type: "success"
						}, function() {
							Alumni.showAdminCloseJobs();
						});
					
				} else {
					alert("Data not updated");
				}
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});
	};


}]);