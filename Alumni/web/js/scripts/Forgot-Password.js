var ForgotPasswordModule = angular.module('ForgotPasswordModule', [])
ForgotPasswordModule.controller('ForgotPasswordController', ['$http', '$scope', function($http, $scope) {

	$scope.SendOtp = function(RegisterData) {
		$.blockUI({
			message: '<img src="/alumni/assets/images/block_loader.gif" /><br><h6>Just a Moment....</h6>',
			css: {
				backgroundColor: 'transparent',
				color: '#fff',
				border: 'none'
			}
		});
		var otp = Math.floor((Math.random() * 1000000) + 1);
		console.log(RegisterData);
		var details = {
			email: RegisterData.username,
			otp: otp
		}
		console.log(details);
		$http.post('/alumni/register/sendotp', details).then(function(response) {
			console.log(response.data);
			$scope.opendata = response.data;
			console.log($scope.opendata);
			if ($scope.opendata.successful) {
				setTimeout(function() {
					$.unblockUI();

				}, 3000);
				$('#form-login-username').prop('readonly', true);
				/*document.getElementById("form-login-username").readonly = true;*/
				document.getElementById("otp-field").style.display = "block";
				document.getElementById("sendOtpBTN").style.display = "none";
				document.getElementById("verifyOtpBTN").style.display = "block";


				/*swal(
					{
						title: "Oops!",
						text: "Email Id Already Exists! Please Login",
						type: "warning"
					}, function() {
						Alumni.showLogin();
					});*/
				/*document.getElementById("registerBTN").disabled = true;*/
			} else {
				setTimeout(function() {
					$.unblockUI();
					swal(
						{
							title: "Oops!",
							text: "No Such Email Exists",
							type: "warning"
						}, function() {
							Alumni.showLogin();
						});

				}, 3000);

			}
		}, function(errResponse) {
			console.error('Error while fetching notes');
		});
	};

	$scope.VerifyOtp = function(RegisterData) {
		$.blockUI({
			message: '<img src="/alumni/assets/images/block_loader.gif" /><br><h6>Just a Moment....</h6>',
			css: {
				backgroundColor: 'transparent',
				color: '#fff',
				border: 'none'
			}
		});

		console.log(RegisterData);
		var details = {
			email: RegisterData.username,
			otp: RegisterData.otp
		}
		console.log(details);
		$http.post('/alumni/register/verifyotp', details).then(function(response) {
			console.log(response.data);
			$scope.opendata = response.data;
			console.log($scope.opendata);
			if ($scope.opendata.successful) {
				setTimeout(function() {
					$.unblockUI();

				}, 3000);
				 $('#form-login-username').prop('readonly', true);
				 $('#form-login-otp').prop('readonly', true);
				/*document.getElementById("form-login-username").readonly = true;*/
				/*document.getElementById("form-login-otp").readonly = true;*/
				document.getElementById("password-field").style.display = "block";
				document.getElementById("verifyOtpBTN").style.display = "none";
				document.getElementById("updatePasswordBTN").style.display = "block";
			} else {
				setTimeout(function() {
					$.unblockUI();
					swal(
						{
							title: "Oops!",
							text: "Wrong OTP",
							type: "warning"
						}, function() {
							Alumni.showLogin();
						});

				}, 3000);

			}
		}, function(errResponse) {
			console.error('Error while fetching notes');
		});
	};

	$scope.UpdatePassword = function(RegisterData) {
		$.blockUI({
			message: '<img src="/alumni/assets/images/block_loader.gif" /><br><h6>Just a Moment....</h6>',
			css: {
				backgroundColor: 'transparent',
				color: '#fff',
				border: 'none'
			}
		});

		console.log(RegisterData);
		var details = {
			email: RegisterData.username,
			password: RegisterData.password
		}
		console.log(details);
		$http.post('/alumni/register/updatePassword', details).then(function(response) {
			console.log(response.data);
			$scope.opendata = response.data;
			console.log($scope.opendata);
			if ($scope.opendata.successful) {
				setTimeout(function() {
					$.unblockUI();
					swal(
						{
							title: "Done!",
							text: "Password Updated Successfully",
							type: "success"
						}, function() {
							Alumni.showLogin();
						});
				}, 3000);
			} else {
				setTimeout(function() {
					$.unblockUI();
					swal(
						{
							title: "Oops!",
							text: "Wrong OTP",
							type: "warning"
						}, function() {
							
						});

				}, 3000);

			}
		}, function(errResponse) {
			console.error('Error while fetching notes');
		});
	};



}]);