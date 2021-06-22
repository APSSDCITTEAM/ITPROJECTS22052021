
var Student = angular.module('CreateRole', []);
var documentsArr = [];
Student.controller('CreateRolesController', ['$scope', '$http', function($scope, $http) {

	$scope.AddRole = function(CreateRole) {
		console.log(CreateRole);
		$http.post('/alumni/register/AddRole', CreateRole).then(
			function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {
					swal(
						{
							title: "Done!",
							text: "Roles Created Successfully!",
							type: "success"
						}, function() {
							Alumni.showAdminCreateRole();
						});
				} else {
					swal(
						{
							title: "Oops!",
							text: "Failed to create Roles!",
							type: "error"
						}, function() {
							Alumni.showAdminCreateRole();
						});
				}
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});
	};

	/* getting all roles */
	$http.get('/alumni/register/getallroles').then(function(response) {
		$scope.roledata = response.data;
		if ($scope.roledata.successful) {
			$scope.RolesData = $scope.roledata.responseObject;
			console.log($scope.RolesData);
		}
		else {
			console.log("Client error while getting data");
		}
	});

	/* getting data to popup */
	$scope.getRoleData = function(role_id) {
		console.log(role_id);
		/*alert(empid);*/
		$http.post('/alumni/register/getRoleData', role_id).then(
			function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {
					$scope.data = { object: $scope.data.responseObject };
				} else {
					swal(
						{
							title: "Oops!",
							text: "Error while getting data!",
							type: "error"
						}, function() {
							Alumni.showAdminCreateRole();
						});
				}
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});
	};

	/* update role data */
	$scope.updateRole = function(roleData) {
		console.log(roleData);
		$http.post('/alumni/register/updateRole', roleData).then(
			function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {
					swal(
						{
							title: "Done!",
							text: "Roles Updated Successfully!",
							type: "success"
						}, function() {
							$("#myModel").hide();
							$('.modal-backdrop').remove();
							Alumni.showAdminCreateRole();
						});


				} else {
					swal(
						{
							title: "Oops!",
							text: "Failed to Update Data!",
							type: "error"
						}, function() {
							Alumni.showAdminCreateRole();
						});
				}
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});
	};

	/* delete role data */
	$scope.DeleteRoleData = function(RoleData) {
		console.log(RoleData.role_id);
		$http.post('/alumni/register/DeleteRoleData', RoleData.role_id).then(
			function(response) {
				$scope.data = response.data;
				console.log($scope.data);
				if ($scope.data.successful) {
					/*location.reload();*/
					swal(
						{
							title: "Done!",
							text: "Roles Removed Successfully!",
							type: "success"
						}, function() {
							Alumni.showAdminCreateRole();
						});
				} else {
					swal(
						{
							title: "Oops!",
							text: "Failed to Delete Roles!",
							type: "error"
						}, function() {
							Alumni.showAdminCreateRole();
						});
				}
			}, function(errResponse) {
				console.error('Error while fetching notes');
			});
	};



}]);


