var Alumni = {

	showPage: function(path, targetDiv) {
		var jqxhr = jQuery.post(path, function(data) {
			jQuery("#" + targetDiv).html(data);
		});
	},

	showHomePage: function() {
		var path = "/alumni/html/home/Home.html";
		Alumni.showPage(path, "body-div");
	},

	showJobsPage: function() {
		var path = "/alumni/html/home/Jobs.html";
		Alumni.showPage(path, "body-div");
	},

	showInternshipsPage: function() {
		var path = "/alumni/html/home/Internships.html";
		Alumni.showPage(path, "body-div");
	},

	showDiscussionsPage: function() {
		var path = "/alumni/html/home/Discussions.html";
		Alumni.showPage(path, "body-div");
	},

	showLoginPage: function() {
		var path = "/alumni/html/home/Login.html";
		Alumni.showPage(path, "body-div");
	},

	showRegisterPage: function() {
		var path = "/alumni/html/home/Register.html";
		Alumni.showPage(path, "body-div");
	},

	showAdmin: function() {
		var path = "/alumni/html/dashboard/AdminHome.html";
		Alumni.showPage(path, "body-div");
	},

	showMD: function() {
		var path = "/alumni/html/dashboard/MDHome.html";
		Alumni.showPage(path, "body-div");
	},

	showED: function() {
		var path = "/alumni/html/dashboard/EDHome.html";
		Alumni.showPage(path, "body-div");
	},

	showCGM: function() {
		var path = "/alumni/html/dashboard/CGMHome.html";
		Alumni.showPage(path, "body-div");
	},

	showUser: function() {
		var path = "/alumni/html/dashboard/UserHome.html";
		Alumni.showPage(path, "body-div");
	},

	showAdminHomePage: function() {
		var path = "/alumni/html/admin/Home.html";
		Alumni.showPage(path, "admin-div");    
	},
	
	showRolesAssaignPage: function() {
		var path = "/alumni/html/admin/AssaignRole.html";
		Alumni.showPage(path, "admin-div");
	},
	
	showApprovalsPage: function() {
		var path = "/alumni/html/admin/approvals.html";
		Alumni.showPage(path, "admin-div");
	},
	
	showJobApprovalsPage: function() {
		var path = "/alumni/html/admin/JobApprovals.html";
		Alumni.showPage(path, "admin-div");
	},
	
	showJobActionPage: function() {
		var path = "/alumni/html/admin/JobAction.html";
		Alumni.showPage(path, "admin-div");
	},
	
	showEventCreationPage: function() {
		var path = "/alumni/html/admin/CreateEvent.html";
		Alumni.showPage(path, "admin-div");
	},
	
	showViewEventsPage: function() {
		var path = "/alumni/html/admin/ViewEvents.html";
		Alumni.showPage(path, "admin-div");
	},
	
	showEventActionPage: function() {
		var path = "/alumni/html/admin/EventAction.html";
		Alumni.showPage(path, "admin-div");
	},
	
	showInternshipActionPage: function() {
		var path = "/alumni/html/admin/InternshipAction.html";
		Alumni.showPage(path, "admin-div");
	},
	
	showInternshipsApprovalPage: function() {
		var path = "/alumni/html/admin/InternshipApprovals.html";
		Alumni.showPage(path, "admin-div");
	},

	showMDHomePage: function() {
		var path = "/alumni/html/md/Home.html";
		Alumni.showPage(path, "md-div");
	},

	showEDHomePage: function() {
		var path = "/alumni/html/ed/Home.html";
		Alumni.showPage(path, "ed-div");
	},

	showCGMHomePage: function() {
		var path = "/alumni/html/cgm/Home.html";
		Alumni.showPage(path, "cgm-div");
	},

	showUserHomePage: function() {
		var path = "/alumni/html/user/Home.html";
		Alumni.showPage(path, "user-div");
	},
	
	// Users Pages

	showJobPostPage: function() {
		var path = "/alumni/html/user/post-job.html";
		Alumni.showPage(path, "user-div");
	},

	showInternshipPostPage: function() {
		var path = "/alumni/html/user/post-internship.html";
		Alumni.showPage(path, "user-div");
	},
	
	showViewJobsPage: function() {
		var path = "/alumni/html/user/view-jobs.html";
		Alumni.showPage(path, "user-div");
	},

	showViewInternshipsPage: function() {
		var path = "/alumni/html/user/view-internships.html";
		Alumni.showPage(path, "user-div");
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
		Alumni.showHomePage();
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
			username: username,
			user_id: user_id,
		};
		return Alumni.post('/alumni/logins/loggedin', login) || false;
	}

};