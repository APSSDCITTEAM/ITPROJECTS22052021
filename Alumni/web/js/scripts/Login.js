var LoginModule = angular.module('LoginModule', [])
LoginModule.controller('LoginController', ['$http', '$scope', function($http, $scope) {
	var self = this;
	$scope.login = function(user) {
		console.log(user);
		$.blockUI({
			message: '<img src="/alumni/assets/images/block_loader.gif" /><br><h6>Just a Moment....</h6>',
			css: {
				backgroundColor: 'transparent',
				color: '#fff',
				border: 'none'
			}
		});
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


				var details = {
					user_id: Alumni.getSessionValue("user_id"),
				}
				$http.post('/alumni/viewjob/UpdateJobStatusbyDate', details).then(
					function(response) {
						$scope.data = response.data;
						if ($scope.data.successful) {

							$http.post('/alumni/viewjob/UpdateInternStatusbyDate', details).then(
								function(response) {
									$scope.data = response.data;
									if ($scope.data.successful) {
										
										$http.post('/alumni/event/UpdateEventStatusbyDate',details).then(
											function(response) {
												$scope.eventdata = response.data;  
												if ($scope.eventdata.successful) {
												} else {
													alert("Data not updated");
												}
											}, function(errResponse) {
												console.error('Error while fetching notes');
											});
										
									} else {
										alert("Data not updated");
									}
								}, function(errResponse) {
									console.error('Error while fetching notes');
								});

						} else {
							alert("Data not updated");
						}
					}, function(errResponse) {
						console.error('Error while fetching notes');
					});

				if ((Alumni.getSessionValue("roleid") == 2)) {
					setTimeout(function() {
						$.unblockUI();
						Alumni.showMDDashboard();
					}, 3000);
				}
				else if ((Alumni.getSessionValue("roleid") == 3)) {
					setTimeout(function() {
						$.unblockUI();
						Alumni.showEDDashboard();
					}, 3000);
				}
				else if ((Alumni.getSessionValue("roleid") == 4)) {
					setTimeout(function() {
						$.unblockUI();
						Alumni.showCGMDashboard();
					}, 3000);
				}
				else if ((Alumni.getSessionValue("roleid") == 1)) {
					setTimeout(function() {
						$.unblockUI();
						Alumni.showAdminDashboard();
					}, 3000);
				}
				else if ((Alumni.getSessionValue("roleid") == 6)) {
					setTimeout(function() {
						$.unblockUI();
						Alumni.showStudentDashboard();
					}, 3000);
				}
				else if ((Alumni.getSessionValue("roleid") == 5)) {
					setTimeout(function() {
						$.unblockUI();
						Alumni.showEmployeeDashboard();
					}, 3000);
				}
				else {
					Alumni.showHome();
				}
			} else {
				swal(
					{
						title: "Oops!",
						text: "Wrong Username or Password!",
						type: "error"
					}, function() {
						Alumni.showHome();
					});

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