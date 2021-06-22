var Student = angular.module('AssignRole', []);
var documentsArr = [];
Student.controller('RoleCreationController', ['$scope', '$http', function($scope, $http) {

	$scope.CreateRole = function(CreateRole) {	
		console.log(CreateRole);
		/*CreateJob['std_id'] = Alumni.getSessionValue("user_id");*/
		/*console.log(CreateJob);*/
		$http.post('/alumni/register/CreateRole',CreateRole).then(  
				function(response) {    
					$scope.data = response.data;           
					if ($scope.data.successful) {
						/*swal("Role Assigned Successfully");*/
						
						swal(
							{
								title: "Done",
								text: "Role Assigned Successfully!",
								type: "success"
							}, function() {
								Alumni.showAdminAssignRole();
							});
						
					} else {
						alert("Data not inserted");    
					}   
				}, function(errResponse) {
					console.error('Error while fetching notes');
				});
		};

}]);