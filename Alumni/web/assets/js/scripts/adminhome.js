var studentdetails = angular.module('StudentDetails', []);

studentdetails.controller('StudentDetailsController', ['$http','$scope', function($http, $scope) {
	
		
			// View Data from Database
			$http.post('/alumni/register/getAllAlumnisData').then(function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {   
					$scope.userdetails = $scope.data.responseObject;
				} else {
					alert("Can't view the Data");
				}
			}, function(errResponse) {
				console.error('Error while viewing notes');
			});

			
			
	}]);

		
		
