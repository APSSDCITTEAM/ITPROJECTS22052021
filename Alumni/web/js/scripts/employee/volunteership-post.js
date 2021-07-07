var Student = angular.module('volunteership', []);
var documentsArr = [];
Student.controller('VolunteershipController', ['$scope', '$http', function($scope, $http) {

	$scope.CreateVolunteership = function(CreateVolunteership) {	
		console.log(CreateVolunteership);
		CreateVolunteership['std_id'] = Alumni.getSessionValue("user_id");
		
		console.log(CreateVolunteership);
		$http.post('/alumni/postjob/CreateVolunteership',CreateVolunteership).then(  
				function(response) {    
					$scope.data = response.data;           
					if ($scope.data.successful) {
						/*swal("Volunteership Created Successfully");*/	
						
						swal(
							{
								title: "Done!",
								text: "Volunteership Uploaded Successfully!",
								type: "success"
							}, function() {
								Alumni.showEmployeePostVolunteership();
							});
						
					} else {
						alert("Data not inserted");    
					}   
				}, function(errResponse) {
					console.error('Error while fetching notes');
				});
		};

}]);