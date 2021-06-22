var Student = angular.module('StudentRegister', []);
var documentsArr = [];
Student.controller('StudentRegisterController', ['$scope', '$http', function($scope, $http) {
	
	$scope.StudentRegister = function(UserData) {
		$.blockUI({
			message: '<img src="/alumni/assets/images/block_loader.gif" /><br><h6>Just a Moment....</h6>',
			css: {
				backgroundColor: 'transparent',
				color: '#fff',
				border: 'none'
			}
		});

		/*if(UserData==null || UserData=='' ||UserData==undefined)
		  {
				swal("Enter all details!");
		  }
		else if(UserData.username == null || UserData.username == '' || UserData.username== undefined)
		  {
				swal("Enter username!");
		  }
		 else if(UserData.first_name == null || UserData.first_name == '' || UserData.first_name == undefined)
		  {
				swal("Enter FirstName!");
		  }
		else if(UserData.last_name == null || UserData.last_name == '' || UserData.last_name== undefined)
		  {
				swal("Enter LastName!");
		  }
		 else if(UserData.password == null || UserData.password  == '' || UserData.password  == undefined)
		  {
				swal("Enter Password!");
		  }
		 else if(UserData.email == null || UserData.email  == '' || UserData.email  == undefined)
		  {
				swal("Enter EmailID!");
		  }
		 else{    */
		console.log(UserData);
		$http.post('/alumni/register/studentRegister', UserData).then(
			function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {

					setTimeout(function() {
						$.unblockUI();
						swal(
							{
								title: "Registered Successfully!",
								text: "Please check Mail for next process!",
								type: "success"
							}, function() {
								Alumni.showRegister();
							});

					}, 3000);

				} else {
					swal("Data not inserted");
				}
			},
			function(errResponse) {
				console.error('Error while fetching notes');
			});

	};

	$scope.checkMail = function(RegisterData) {
		console.log(RegisterData);
		var details = {
			email: RegisterData.email
		}
		console.log(details);
		$http.post('/alumni/register/checkMail', details).then(function(response) {
			console.log(response.data);
			$scope.opendata = response.data;

			if ($scope.opendata.successful) {
				swal(
					{
						title: "Oops!",
						text: "Email Id Already Exists! Please Login",
						type: "warning"
					}, function() {
						Alumni.showLogin();
					});
				/*document.getElementById("registerBTN").disabled = true;*/
			} else {
				console.log("email new");
				document.getElementById("registerBTN").disabled = false;
			}
		}, function(errResponse) {
			console.error('Error while fetching notes');
		});
	};

	$scope.checkMobile = function(RegisterData) {
		console.log(RegisterData);
		var details = {
			mobile_no: RegisterData.mobile_no
		}
		console.log(details);
		$http.post('/alumni/register/checkMobile', details).then(function(response) {
			console.log(response.data);
			$scope.opendata = response.data;

			if ($scope.opendata.successful) {
				swal(
					{
						title: "Oops!",
						text: "Mobile No Already Exists! Please Login",
						type: "warning"
					}, function() {
						Alumni.showLogin();
					});
				document.getElementById("registerBTN").disabled = true;
			} else {
				console.log("mobile new");
				document.getElementById("registerBTN").disabled = false;
			}
		}, function(errResponse) {
			console.error('Error while fetching notes');
		});
	};




}]);