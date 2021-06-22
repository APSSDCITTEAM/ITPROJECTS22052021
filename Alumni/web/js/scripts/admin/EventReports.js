var Student = angular.module('EventReports', []);
var documentsArr = [];
Student.controller('EventsReportsController', ['$scope', '$http', function($scope, $http) {

	/* getting total events count */
	$http.get('/alumni/report/getEventsCount').then(function(response) {
		$scope.Eventdata = response.data;
			if ($scope.Eventdata.successful) {    
				$scope.EventsData = {object:$scope.Eventdata.responseObject};
				console.log($scope.EventsData);
				
				$http.get('/alumni/report/getOpenEventsCount').then(function(response) {
					$scope.openEventdata = response.data;
						if ($scope.openEventdata.successful) {    
							$scope.OpenEventsData = {object:$scope.openEventdata.responseObject};
							console.log($scope.OpenEventsData);
							
							$http.get('/alumni/report/getClosedEventsCount').then(function(response) {
								$scope.closedeventdata = response.data;
									if ($scope.closedeventdata.successful) {    
										$scope.ClosedEventData = {object:$scope.closedeventdata.responseObject};
										console.log($scope.ClosedEventData);
										
										var ctx = document.getElementById("myChart3").getContext('2d');
										a1 = Alumni.getSessionValue("a1");
										a2 = Alumni.getSessionValue("a2");
										a3 = Alumni.getSessionValue("a3");
										var chartdata = [a1,a2,a3];
										console.log(a1);
										console.log(a2);
										console.log(a3);
										var myChart = new Chart(ctx, {  
										    type: 'doughnut',
										    data: {
										        datasets: [{
										            data: chartdata,
										            backgroundColor: [
										                '#247CE9',
										                '#63ed7a',
										                '#fc544b',
										            ],
										            label: 'Dataset 1'
										        }],
										        labels: [
										            'Total Count',
										            'Active Count',
										            'In-Active Count',
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
	
	

}]);