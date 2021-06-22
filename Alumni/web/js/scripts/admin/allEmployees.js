var Employee = angular.module('approvals', []);
Employee.controller('ApprovalsController', ['$scope', '$http', function($scope, $http) {
	$.blockUI({
		message: '<img src="/alumni/assets/images/block_loader.gif" /><br><h6>Just a Moment....</h6>',
		css: {
			backgroundColor: 'transparent',
			color: '#fff',
			border: 'none'
		}
	});
	$http.get('/alumni/empapproval/getallusers').then(function(response) {
		$scope.alldata = response.data;
		if ($scope.alldata.successful) {
			var dataLength = $scope.alldata.responseObject.length;
			if (dataLength == 0) {
				setTimeout(function() {
					$.unblockUI();

				}, 3000);
				document.getElementById("emptyrow").style.display = "table-row";
			} else {
				setTimeout(function() {
					document.getElementById("emptyrow").style.display = "none";
					$.unblockUI();
				}, 3000);
				$scope.allEmployees = $scope.alldata.responseObject;
				console.log($scope.allEmployees);
			}
		} else {
			console.log("Client error while getting data");
		}
	});
}]);