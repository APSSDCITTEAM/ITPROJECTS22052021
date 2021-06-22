var Student = angular.module('jobpost', []);
var documentsArr = [];
Student.controller('JobPostController', ['$scope', '$http', function($scope, $http) {

	$scope.CreateJob = function(CreateJob) {	
		console.log(CreateJob);
		CreateJob['std_id'] = Alumni.getSessionValue("user_id");
		
		console.log(CreateJob);
		$http.post('/alumni/postjob/CreateJob',CreateJob).then(  
				function(response) {    
					$scope.data = response.data;           
					if ($scope.data.successful) {
						/*swal("Job Created Successfully");*/
						swal(
								{
									title: "Done",
									text: "Job Created Successfully!",
									type: "success"
								}, function() {
									Alumni.showAdminPostJob();
								});
					} else {
						alert("Data not inserted");    
					}   
				}, function(errResponse) {
					console.error('Error while fetching notes');
				});
		};

}]);