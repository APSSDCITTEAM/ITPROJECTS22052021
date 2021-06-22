var Student = angular.module('InternshipReports', []);
var documentsArr = [];
Student.controller('InternshipReportsController', ['$scope', '$http', function($scope, $http) {

	$http.get('/alumni/report/getInternshipCount').then(function(response) {
		$scope.Eventdata = response.data;
			if ($scope.Eventdata.successful) {    
				$scope.Data = {object:$scope.Eventdata.responseObject};
				console.log($scope.Data);  
				
				$http.get('/alumni/report/getApprovedInternshipCount').then(function(response) {
					$scope.Approvedinternshipdata = response.data;
						if ($scope.Approvedinternshipdata.successful) {    
							$scope.ApprovedInternshipsData = {object:$scope.Approvedinternshipdata.responseObject};
							console.log($scope.ApprovedInternshipsData);
							
							$http.get('/alumni/report/getRejectedInternshipsCount').then(function(response) {
								$scope.Rejectedinternshipdata = response.data;
									if ($scope.Rejectedinternshipdata.successful) {    
										$scope.RejectedInternshipData = {object:$scope.Rejectedinternshipdata.responseObject};
										console.log($scope.RejectedInternshipData);
										
										$http.get('/alumni/report/getClosedInternshipCount').then(function(response) {
											$scope.Verifiedinternshipdata = response.data;
												if ($scope.Verifiedinternshipdata.successful) {    
													$scope.ClosedInternshipData = {object:$scope.Verifiedinternshipdata.responseObject};
													console.log($scope.ClosedInternshipData);
													
													$http.get('/alumni/report/getPendingInternshipCount').then(function(response) {
														$scope.pendinginternshipdata = response.data;
															if ($scope.pendinginternshipdata.successful) {    
																$scope.PendingInternshipData = {object:$scope.pendinginternshipdata.responseObject};
																console.log($scope.PendingInternshipData);
																
																var ctx = document.getElementById("myChart3").getContext('2d');
																a1 = Alumni.getSessionValue("a1");
																a2 = Alumni.getSessionValue("a2");
																a3 = Alumni.getSessionValue("a3");
																a4 = Alumni.getSessionValue("a4");
																a5 = Alumni.getSessionValue("a5");
																var chartdata = [a1,a2,a3,a4,a5];
																console.log(a1);
																console.log(a2);
																console.log(a3);
																console.log(a4);
																console.log(a5);
																var myChart = new Chart(ctx, {  
																    type: 'doughnut',
																    data: {
																        datasets: [{
																            data: chartdata,
																            backgroundColor: [
																                '#247CE9',
																                '#63ed7a',
																                '#fc544b',
																                '#C2335E',
																                '#FA7428',
																            ],
																            label: 'Dataset 1'
																        }],
																        labels: [
																            'Total Count',
																            'Active Count',
																            'Rejected Count',
																            'Verified Count',
																            'Un Verified Count'
																        ],
																    },
																    options: {
																        responsive: true,
																        legend: {
																            position: 'bottom',
																        },
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