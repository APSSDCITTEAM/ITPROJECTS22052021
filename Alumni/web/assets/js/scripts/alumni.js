var Alumni = {

	showPage: function(path, targetDiv) {
		var jqxhr = jQuery.post(path, function(data) {
			jQuery("#" + targetDiv).html(data);
		});
	},

	showHeader: function() {
		var path = "/alumni/html/header.html";
		Alumni.showPage(path, "header-div");
	},

	showHome: function() {
		window.location.reload();
	},

	showRegister: function() {
		var path = "/alumni/html/register.html";
		Alumni.showPage(path, "body-div");
	},

	showLogin: function() {
		var path = "/alumni/html/login.html";
		Alumni.showPage(path, "body-div");
	},

	showAdminHeader: function() {
		var path = "/alumni/html/adminHeader.html";
		Alumni.showPage(path, "header-div");
	},

	showStudentHeader: function() {
		var path = "/alumni/html/studentHeader.html";
		Alumni.showPage(path, "header-div");
	},

	showEmployeeHeader: function() {
		var path = "/alumni/html/employeeHeader.html";
		Alumni.showPage(path, "header-div");
	},

	/* Post Jobs */
	showEmployeeHeader_1: function() {
		var path = "/alumni/html/employee/postJobs.html";
		Alumni.showPage(path, "body-div");
	},

	/* Post Inernships */

	showEmployeeHeader_2: function() {
		var path = "/alumni/html/employee/postInternships.html";
		Alumni.showPage(path, "body-div");
	},

	/* View Jobs */

	showEmployeeHeader_3: function() {
		var path = "/alumni/html/employee/viewJobs.html";
		Alumni.showPage(path, "body-div");
	},

	/* View Internships */

	showEmployeeHeader_4: function() {
		var path = "/alumni/html/employee/viewInternships.html";
		Alumni.showPage(path, "body-div");
	},

	/* View My Jobs */

	showEmployeeHeader_5: function() {
		var path = "/alumni/html/employee/myJobs.html";
		Alumni.showPage(path, "body-div");
	},

	/* View My Internships */

	showEmployeeHeader_6: function() {
		var path = "/alumni/html/employee/myInternships.html";
		Alumni.showPage(path, "body-div");
	},

	/* Job Approvals */

	showJobApprovals: function() {
		var path = "/alumni/html/admin/jobApprovals.html";
		Alumni.showPage(path, "body-div");
	},

	/* Internships Approvals */

	showInternshipApprovals: function() {
		var path = "/alumni/html/admin/internshipApprovals.html";
		Alumni.showPage(path, "body-div");
	},

	/* View Events */

	showEmployeeHeader_9: function() {
		var path = "/alumni/html/employee/viewEvents.html";
		Alumni.showPage(path, "body-div");
	},

	showAssignRoles: function() {
		var path = "/alumni/html/admin/assignRoles.html";
		Alumni.showPage(path, "body-div");
	},

	showCreateEvents: function() {
		var path = "/alumni/html/admin/createEvents.html";
		Alumni.showPage(path, "body-div");
	},

	showViewEvents: function() {
		var path = "/alumni/html/admin/viewEvents.html";
		Alumni.showPage(path, "body-div");
	},

	showEmployeeHeader_12: function() {
		var path = "/alumni/html/admin/eventAction.html";
		Alumni.showPage(path, "body-div");
	},

	/* Job Actions */

	showEmployeeHeader_10: function() {
		var path = "/alumni/html/admin/jobActions.html";
		Alumni.showPage(path, "body-div");
	},

	/* Internship Actions */

	showEmployeeHeader_11: function() {
		var path = "/alumni/html/admin/internshipAction.html";
		Alumni.showPage(path, "body-div");
	},

	showAllStudents: function() {
		var path = "/alumni/html/admin/allStudents.html";
		Alumni.showPage(path, "body-div");
	},

	showActiveStudents: function() {
		var path = "/alumni/html/admin/activeStudents.html";
		Alumni.showPage(path, "body-div");
	},

	showStudentApprovals: function() {
		var path = "/alumni/html/admin/studentApproval.html";
		Alumni.showPage(path, "body-div");
	},

	showRejectedStudents: function() {
		var path = "/alumni/html/admin/rejectedStudents.html";
		Alumni.showPage(path, "body-div");
	},

	showAllEmployees: function() {
		var path = "/alumni/html/admin/allEmployees.html";
		Alumni.showPage(path, "body-div");
	},

	showActiveEmployees: function() {
		var path = "/alumni/html/admin/activeEmployees.html";
		Alumni.showPage(path, "body-div");
	},

	showEmployeeApprovals: function() {
		var path = "/alumni/html/admin/EmployeeApproval.html";
		Alumni.showPage(path, "body-div");
	},

	showRejectedEmployees: function() {
		var path = "/alumni/html/admin/rejectedEmployees.html";
		Alumni.showPage(path, "body-div");
	},

	showInternshipApplicants: function() {
		var path = "/alumni/html/employee/InternshipAppliedCandidates.html";
		Alumni.showPage(path, "body-div");
	},

	showJobs: function() {
		var path = "/alumni/html/employee/viewJobs.html";
		Alumni.showPage(path, "body-div");
	},

	showInternships: function() {
		var path = "/alumni/html/employee/viewInternships.html";
		Alumni.showPage(path, "body-div");
	},

	showEvents: function() {
		var path = "/alumni/html/admin/viewEvents.html";
		Alumni.showPage(path, "body-div");
	},
	
	showChangePassword: function(){
		var path = "/alumni/html/changePassword.html";
		Alumni.showPage(path, "body-div");
	},



	setSessionValue: function(key, value) {
		sessionStorage.setItem(key, value);
	},

	getSessionValue: function(key) {
		return sessionStorage.getItem(key);
	},

	removeSessionValue: function(key) {
		sessionStorage.removeItem(key);
	},

	logout: function() {

		var user_id = Alumni.getSessionValue("user_id") || "";
		Alumni.setSessionValue("username", null);
		Alumni.setSessionValue("password", null);
		Alumni.setSessionValue("roleid", null);
		Alumni.showHome();
	},

	post: function(url, data) {
		var responseData = null;

		jQuery.ajax({
			url: url,
			type: 'post',
			data: JSON.stringify(data), // Stringified Json Object
			dataType: 'json',
			async: false, // Cross-domain requests and dataType: "jsonp"
			// requests do not support synchronous operation
			cache: false, // This will force requested pages not to be cached
			// by the browser
			processData: false, // To avoid making query String instead of
			// JSON
			contentType: "application/json; charset=utf-8",
			success: function(data) {
				responseData = data;
			}
		});

		return responseData;
	},
  
	isUserLoggedIn: function() {

		var username = Alumni.getSessionValue("username") || "";
		var password = Alumni.getSessionValue("password") || "";
		var roleid = Alumni.getSessionValue("roleid") || "";
		var user_id = Alumni.getSessionValue("user_id") || "";
		var login = {
			username: username,
			password: password,
			roleid: roleid,
			user_id: user_id,
		};
		return Alumni.post('/alumni/logins/loggedin', login) || false;
	}

};