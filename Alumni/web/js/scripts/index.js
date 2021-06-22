var Student = angular.module('index', []);
var documentsArr = [];
Student.controller('IndexPageController', ['$scope', '$http', function($scope, $http) {

	/* getting recent jobs */
	$http.get('/alumni/index/getallRecentjobs').then(function(response) {
		$scope.recentdata = response.data;
		if ($scope.recentdata.successful) {
			$scope.RecentJobs = $scope.recentdata.responseObject;
			console.log($scope.RecentJobs);
			
		}
		else {
			console.log("Client error while getting data");
		}
	});
	
	
	/* getting count of employees alumni's */
	$http.get('/alumni/index/getMembersCount').then(function(response) {
		$scope.memberdata = response.data;
			if ($scope.memberdata.successful) {    
				$scope.mdata = {object:$scope.memberdata.responseObject};
				console.log("............... conunt of members ................");
				console.log($scope.mdata);
				
				$http.get('/alumni/index/getJobsCount').then(function(response) {
					$scope.Jobsdata = response.data;
						if ($scope.Jobsdata.successful) {    
							$scope.jData = {object:$scope.Jobsdata.responseObject};
							console.log("............... conunt of Jobs ................");
							console.log($scope.jData);
							
							$http.get('/alumni/index/getInternsCount').then(function(response) {
								$scope.interndata = response.data;
									if ($scope.interndata.successful) {    
										$scope.InternData = {object:$scope.interndata.responseObject};
										console.log("............... conunt of Internships ................");
										console.log($scope.InternData);
										
										$http.get('/alumni/index/getEventsCount').then(function(response) {
											$scope.Eventdata = response.data;
												if ($scope.Eventdata.successful) {    
													$scope.EData = {object:$scope.Eventdata.responseObject};
													console.log("............... conunt of Events ................");
													console.log($scope.EData);
												}
											else      
											{
												console.log("Client error while getting data");  
											}  
										});
										
									}
								else      
								{
									console.log("Client error while getting data");  
								}  
							});
							
						}
					else      
					{
						console.log("Client error while getting data");  
					}  
				});
				
			}
		else      
		{
			console.log("Client error while getting data");  
		}  
	});
	
	
	
	
	
	
}]);