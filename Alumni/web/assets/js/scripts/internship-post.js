var Student = angular.module('internship', []);
var documentsArr = [];
Student.controller('internshipController', ['$scope', '$http', function($scope, $http) {

	$scope.CreateInternship = function(CreateInternship) {	
		console.log(CreateInternship);
		CreateInternship['std_id'] = Alumni.getSessionValue("user_id");
		console.log(CreateInternship);
		$http.post('/alumni/postjob/CreateInternship',CreateInternship).then(  
				function(response) {    
					$scope.data = response.data;           
					if ($scope.data.successful) {
						swal("Internship Created Successfully");
						
					} else {
						alert("Data not inserted");    
					}   
				}, function(errResponse) {
					console.error('Error while fetching notes');
				});
		};

}]);