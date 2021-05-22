var LoginModule = angular.module('LoginModule', [])
LoginModule.controller('LoginController', ['$http', '$scope', function($http, $scope) {
	var self = this;
	$scope.login = function(user) {
		console.log(user);
		$http.post('/alumni/logins/login', user).then(function(response) {
			console.log(response.data);
			$scope.data = response.data;

			if ($scope.data.successful) {

				Alumni.setSessionValue("username", $scope.data.responseObject.username.replace(/\s+/g, ''));
				Alumni.setSessionValue("name", $scope.data.responseObject.name);
				Alumni.setSessionValue("password", $scope.data.responseObject.password);
				Alumni.setSessionValue("roleid", $scope.data.responseObject.roleid);
				Alumni.setSessionValue("user_id", $scope.data.responseObject.user_id);

				var a = Alumni.getSessionValue("user_id");
				console.log(".............................");
				console.log(a);
				console.log(".............................");

				if ((Alumni.getSessionValue("roleid") == 1)) {
					/*alert(Alumni.getSessionValue("username"));*/
					Alumni.showMD();
				}
				else if ((Alumni.getSessionValue("roleid") == 2)) {
					/*alert(Alumni.getSessionValue("username"));*/
					Alumni.showED();
				}
				else if ((Alumni.getSessionValue("roleid") == 3)) {
					/*alert(Alumni.getSessionValue("username"));*/
					Alumni.showCGM();
				}
				else if ((Alumni.getSessionValue("roleid") == 4)) {
					/*alert(Alumni.getSessionValue("username"));*/
					Alumni.showAdmin();
				}
				else if ((Alumni.getSessionValue("roleid") == 5)) {
					/*alert(Alumni.getSessionValue("username"));*/
					Alumni.showUser();
				}
				else {
					Alumni.showLoginPage();
				}
			} else {

				Alumni.showError($scope.data.errorMessage);
				var message = "<div class=\"alert alert-danger\"><strong>Error: </strong>" + $scope.data.errorMessage + "</div>";
				jQuery("#errorDiv").html(message);
				$("#errorDiv").show();
				$("#errorDiv").html("<b style='margin-left: 28%;font-size: medium;color:blue'>Note:</b> Invalid login credentials");
				console.log('Error while validating user');
			}
		}, function(errResponse) {
			console.error('Error while fetching notes');
		});
	};



	$scope.createLogin = function(totalObj) {

		if (totalObj == null || totalObj == undefined || totalObj == "") {
			swal("Fill all details!");
		}
		else if (totalObj.name == null || totalObj.name == undefined || totalObj.name == "") {
			swal("Enter Name");
		}
		else if (totalObj.email == null || totalObj.email == undefined || totalObj.email == "") {
			swal("Enter Email");
		}

		else if (totalObj.employee_id == null || totalObj.employee_id == undefined || totalObj.employee_id == "") {
			swal("Enter Employee ID");
		}
		else {

			$http.post('/alumni/logins/createLogin', totalObj).then(function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {
					$scope.credentials = $scope.data.responseObject;
					if ($scope.credentials.userStatus == null || $scope.credentials.userStatus == undefined
						|| $scope.credentials.userStatus == "") {
						$("#loginsDiv").show();
						swal("Login credentials created successfully!!!");
					}
					else {
						swal($scope.credentials.userStatus);
						$("#msgDiv").show();
					}

					$scope.data = { object: totalObj };
				}
				else {
					console.log("Client error while getting data");

				}
			},
				function(response) {
					swal($scope.data.errorMessage);
					console.log("Server error while getting data");
					jQuery("#glyphiconid").hide();
				});
		}
	};

}]);