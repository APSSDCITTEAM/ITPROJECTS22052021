/*var Student = angular.module('StudentRegister', []);
var documentsArr = [];
Student.controller('StudentRegisterController', ['$scope', '$http', function($scope, $http) {

	$scope.StudentRegister = function(StudentData) {
		console.log(StudentData);
		$http.post('/alumni/register/studentRegister', StudentData).then(
			function(response) {
				$scope.addjob = response.data;
				if ($scope.addjob.successful) {
					
				} else {
					alert("Data not inserted");
				}
			}, function() {
				console.error('Error while fetching notes');
			});
	};

	$scope.uploadFiles = function(e) {
		var k = 0;
		for (var i = 0; i < e.files.length; i++) {
			var singleFileInfo = e.files[i];
			(function(singleFileInfo) {
				var fileReader;
				fileReader = new FileReader();
				fileReader.onload = function(e) {
					var fileName1 = singleFileInfo.name;
					filesize = singleFileInfo.size;
					var fileDetails = fileName1.split(".");
					var fileName = "ccic_" + (k + 1) + "." + fileDetails[1];
					var binaryString = e.target.result;
					var base64 = btoa(binaryString);
					var fileModel =
					{
						fileName: fileName,
						base64String: base64.toString(),
						name: fileName
					};
					documentsArr[k] = fileModel;
					k++;
				};
				fileReader.readAsBinaryString(e.files[i]);
			})(singleFileInfo);
		}

	}

}]);*/


var Student = angular.module('StudentRegister', []);
var documentsArr = [];
Student.controller('StudentRegisterController', ['$scope', '$http', function($scope, $http) {

	$scope.StudentRegister = function(UserData) {

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
		var documents = {};
		UserData.base64String = documentsArr[0].base64String;
		UserData.fileName = documentsArr[0].fileName;
		UserData.name = documentsArr[0].name;
		console.log(UserData);
		UserData['std_id'] = Math.floor(Math.random() * 100000) + 1;
		console.log(UserData);
		$http.post('/alumni/register/studentRegister', UserData).then(
			function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {
					swal("ALumni Register Successfully");

				} else {
					swal("Data not inserted");
				}
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});


	};


	/* for document upload */
	$scope.uploadFiles = function(e) {
		var k = 0;
		for (var i = 0; i < e.files.length; i++) {
			var singleFileInfo = e.files[i];
			(function(singleFileInfo) {
				var fileReader;
				fileReader = new FileReader();
				fileReader.onload = function(e) {
					var fileName1 = singleFileInfo.name;
					filesize = singleFileInfo.size;
					var fileDetails = fileName1.split(".");
					var fileName = "alumniphotos" + (k + 1) + "." + fileDetails[1];
					var binaryString = e.target.result;
					var base64 = btoa(binaryString);
					var fileModel =
					{
						fileName: fileName,
						base64String: base64.toString(),
						name: fileName
					};
					documentsArr[k] = fileModel;
					k++;
				};
				fileReader.readAsBinaryString(e.files[i]);
			})(singleFileInfo);
		}

	}

}]);