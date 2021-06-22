var Student = angular.module('ChangePassword', []);
var documentsArr = [];
Student.controller('changePasswordController', ['$scope', '$http', function($scope, $http) {

	$scope.ChangePassword = function(PasswordData){
		console.log(PasswordData);
		PasswordData['user_id'] = Alumni.getSessionValue("user_id");
		console.log(PasswordData.user_id);
		$http.post('/alumni/logins/ChangePassword', PasswordData).then(
				function(response) {
					$scope.data = response.data;  
					if ($scope.data.successful) {
						swal("Password Changed Successfully");
						Alumni.showChangePassword();
						/*$("#myModel").hide();*/
						/*$('.modal-backdrop').remove();*/
						   
					} else {
						alert("Data not updated");
					}
				}, function(errResponse) {
					console.error('Error while fetching notes');
				});
	};
	
	$scope.matchPassword = function(PasswordMatch) {
		console.log(PasswordMatch);
		var details = {
				user_id : Alumni.getSessionValue("user_id"),
				password : PasswordMatch.oldpassword
		}
		console.log(details);
		$http.post('/alumni/logins/matchPassword', details).then(function(response) {
			console.log(response.data);
			$scope.opendata = response.data;

			if ($scope.opendata.successful) {
				console.log("..................... Password Matched .....................");
				document.getElementById("changePassword").disabled = false;
				document.getElementById("changePassword").className = "btn btn-success float-right";
			} else {
				swal(
					{
						title: "Oops!",
						text: "Wrong Password!",
						type: "error"
					}, function() {
						document.getElementById("changePassword").disabled = true;
						document.getElementById("changePassword").className = "btn btn-dark btn-disabled float-right";
						
					});
				

			}
		}, function(errResponse) {
			console.error('Error while fetching notes');
		});
	};
	
	
	
	
	
	
	
	
	

}]);