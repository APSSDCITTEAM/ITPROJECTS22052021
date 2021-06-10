var Student = angular.module('ChangePassword', []);
var documentsArr = [];
Student.controller('ChangePasswordController', ['$scope', '$http', function($scope, $http) {

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
	
	$scope.getPassword = function(){
		var user_id = Alumni.getSessionValue("user_id");
		console.log(user_id);
		$http.post('/alumni/logins/getPassword',user_id).then(
			function(response) {
			$scope.opendata = response.data;
			if ($scope.opendata.successful) {
				$scope.data = {object : $scope.opendata.responseObject};
				console.log($scope.data);
			}
			else {
				console.log("Client error while getting data");
			}
		});
	};

}]);