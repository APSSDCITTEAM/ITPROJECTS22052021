var Student = angular.module('intership', []);
var documentsArr = [];
Student.controller('InternshipViewController', ['$scope', '$http', function($scope, $http) {

	/* Get All Jobs Expect Mine */
	var std_id = Alumni.getSessionValue("user_id");
	console.log(std_id);
	$http.post('/alumni/viewjob/getallinternships', std_id).then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.alldata = $scope.data.responseObject;
		}
		else {
			console.log("Client error while getting data");
		}
	});

	/* Get My Internships Only */
	var std_id = Alumni.getSessionValue("user_id");
	console.log(std_id);
	$http.post('/alumni/viewjob/getmyinternships', std_id).then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.myinterns = $scope.data.responseObject;
		}
		else {
			console.log("Client error while getting data");
		}
	});

	/* Get All Internships */
	$http.get('/alumni/viewjob/getallinternshipshome').then(function(response) {
		$scope.data = response.data;
		if ($scope.data.successful) {
			$scope.homedata = $scope.data.responseObject;
		}
		else {
			console.log("Client error while getting data");
		}
	});

	$scope.ApplyInternship = function(ApplyInternship) {
		console.log(ApplyInternship);
		var std_id = Alumni.getSessionValue("user_id");

		var Apply = {
			std_id: std_id,
			id: ApplyInternship
		};

		console.log(Apply);

		$http.post('/alumni/viewjob/ApplyInternship', Apply).then(
			function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {
					swal("Internship Applied Successfully");
				} else {
					alert("Data not inserted");
				}
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});
	};

	/* Get My Internships Applicants */
	/*$scope.InternApplicants = function(id) {
		console.log(id);
		$http.post('/alumni/viewjob/InternshipApplicants', id).then(
			function(response) {    
				$scope.applieddata = response.data;
			    if($scope.applieddata.successful)
			    	{
			    	$scope.AppliedCandidates = $scope.applieddata.responseObject;
					console.log($scope.AppliedCandidates);
					$("#myInternshipsDiv").hide();
					$("#myInternshipsApplicantsDiv").show();
			    	}
			    else
				{
					console.log("Client error while getting data");  
				}
				
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});
	};*/

	
	$scope.InternApplicants = function(id) {
		console.log(id);
		$http.post('/alumni/viewjob/InternshipApplicants',id).then(function(response) {
			$scope.applieddata = response.data;
			if($scope.applieddata.successful)
			{   
				$scope.AppliedCandidates = $scope.applieddata.responseObject.appliedInterns;
				console.log($scope.AppliedCandidates);  
				$("#myInternshipsDiv").hide();
				$("#myInternshipsApplicantsDiv").show();
			}   
			else      
			{   
				console.log("Client error while getting data");  
			}
		});
	};



}]);