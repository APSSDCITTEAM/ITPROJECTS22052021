var Alumni = {

    showPage: function(path, targetDiv) {
        var jqxhr = jQuery.post(path, function(data) {
            jQuery("#" + targetDiv).html(data);
        });
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

    showHome: function() {
        window.location.href = "/alumni/home";
    },

    showRegister: function() {
        var path = "/alumni/mainpage/register.html";
        Alumni.showPage(path, "body-div");
    },

    showJobs: function() {
        var path = "/alumni/mainpage/jobs.html";
        Alumni.showPage(path, "body-div");
    },

    showInternships: function() {
        var path = "/alumni/mainpage/internships.html";
        Alumni.showPage(path, "body-div");
    },

    showEvents: function() {
        var path = "/alumni/mainpage/events.html";
        Alumni.showPage(path, "body-div");
    },

    showVolunteers: function() {
        var path = "/alumni/mainpage/volunteers.html";
        Alumni.showPage(path, "body-div");
    },

    showChangePassword: function() {
        var path = "/alumni/mainpage/changePassword.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showLogin: function() {
        var path = "/alumni/mainpage/login.html";
        Alumni.showPage(path, "body-div");
    },


    /* Admin Dashboard Start */

    showAdminDashboard: function() {
        window.location.href = "/alumni/admin";
    },

    showAdminDashboardHome: function() {
        var path = "/alumni/user/admin/dashboard.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAllStudents: function() {
        var path = "/alumni/user/admin/allStudents.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showActiveStudents: function() {
        var path = "/alumni/user/admin/activeStudents.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showStudentApprovals: function() {
        var path = "/alumni/user/admin/studentApprovals.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showUnVerifiedStudents: function() {
        var path = "/alumni/user/admin/unVerifiedStudents.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAllEmployees: function() {
        var path = "/alumni/user/admin/allEmployees.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showActiveEmployees: function() {
        var path = "/alumni/user/admin/activeEmployees.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showEmployeeApprovals: function() {
        var path = "/alumni/user/admin/employeeApprovals.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showUnVerifiedEmployees: function() {
        var path = "/alumni/user/admin/unVerifiedEmployees.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminPostJob: function() {
        var path = "/alumni/user/admin/postJob.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminMyJobs: function() {
        var path = "/alumni/user/admin/MyJobs.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminAllJobs: function() {
        var path = "/alumni/user/admin/allJobs.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminActiveJobs: function() {
        var path = "/alumni/user/admin/activeJobs.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminInActiveJobs: function() {
        var path = "/alumni/user/admin/inactiveJobs.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminCloseJobs: function() {
        var path = "/alumni/user/admin/closeJobs.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminJobApprovals: function() {
        var path = "/alumni/user/admin/jobApprovals.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminPostInternship: function() {
        var path = "/alumni/user/admin/postInternships.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminMyInternships: function() {
        var path = "/alumni/user/admin/MyInternships.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminAllInternships: function() {
        var path = "/alumni/user/admin/allInternships.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminActiveInternships: function() {
        var path = "/alumni/user/admin/activeInternships.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminInActiveInternships: function() {
        var path = "/alumni/user/admin/inactiveInternships.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminCloseInternships: function() {
        var path = "/alumni/user/admin/closeInternships.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminInternshipApprovals: function() {
        var path = "/alumni/user/admin/internshipApprovals.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminCreateEvent: function() {
        var path = "/alumni/user/admin/createEvent.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminAllEvents: function() {
        var path = "/alumni/user/admin/allEvents.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminActiveEvents: function() {
        var path = "/alumni/user/admin/activeEvents.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminInActiveEvents: function() {
        var path = "/alumni/user/admin/inactiveEvents.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminCloseEvents: function() {
        var path = "/alumni/user/admin/closeEvents.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminAllUserRole: function() {
        var path = "/alumni/user/admin/allUserRole.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminCreateRole: function() {
        var path = "/alumni/user/admin/createRole.html";
        Alumni.showPage(path, "admin-body-div");
    },
    
    showAdminVolunteerships: function() {
        var path = "/alumni/user/admin/allVolunteerships.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminAssignRole: function() {
        var path = "/alumni/user/admin/assignRole.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminRemoveRole: function() {
        var path = "/alumni/user/admin/removeRole.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminStudentReport: function() {
        var path = "/alumni/user/admin/studentReports.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showActivestudentReportsPage: function() {
        var path = "/alumni/user/admin/activeStudentsReport.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showVerifiedStudentsReportsPage: function() {
        var path = "/alumni/user/admin/verifiedStudentsReport.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showUnverifiedstudentsReportsPage: function() {
        var path = "/alumni/user/admin/unVerifiedStudentsReport.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showRejectedstudentsReportsPage: function() {
        var path = "/alumni/user/admin/rejectedStudentsReport.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminEmployeeReport: function() {
        var path = "/alumni/user/admin/employeeReports.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showActiveEmployeeReport: function() {
        var path = "/alumni/user/admin/activeEmployeeReports.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showRejectedEmployeeReport: function() {
        var path = "/alumni/user/admin/rejectedEmployeeReports.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showVerifiedEmployeeReport: function() {
        var path = "/alumni/user/admin/verifiedEmployeeReports.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showUnVerifiedEmployeeReport: function() {
        var path = "/alumni/user/admin/unverifiedEmployeeReports.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminJobReport: function() {
        var path = "/alumni/user/admin/jobReports.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showActiveJobReport: function() {
        var path = "/alumni/user/admin/activeJobReports.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showInActiveJobReport: function() {
        var path = "/alumni/user/admin/inactiveJobReports.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showRejectedJobReport: function() {
        var path = "/alumni/user/admin/rejectedJobReports.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showPendingJobReport: function() {
        var path = "/alumni/user/admin/pendingJobReports.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminInternshipReport: function() {
        var path = "/alumni/user/admin/internshipsReports.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showActiveInternshipReport: function() {
        var path = "/alumni/user/admin/activeInternshipsReports.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showInActiveInternshipsReport: function() {
        var path = "/alumni/user/admin/inActiveinternshipReports.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showRejectedInternshipsReport: function() {
        var path = "/alumni/user/admin/rejectedinternshipReports.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showPendingInternshipsReport: function() {
        var path = "/alumni/user/admin/pendinginternshipReports.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminEventReport: function() {
        var path = "/alumni/user/admin/eventReports.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showOpenEventReport: function() {
        var path = "/alumni/user/admin/openEventReports.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showClosedEventReport: function() {
        var path = "/alumni/user/admin/closedEventReports.html";
        Alumni.showPage(path, "admin-body-div");
    },

    showAdminVolunteerReport: function() {
        var path = "/alumni/user/admin/volunteerReports.html";
        Alumni.showPage(path, "admin-body-div");
    },

    /* Admin Dashboard End */

    /* Employee Dashboard Start */

    showEmployeeDashboard: function() {
        window.location.href = "/alumni/employee";
    },

    showEmployeeDashboardHome: function() {
        var path = "/alumni/user/employee/dashboard.html";
        Alumni.showPage(path, "employee-body-div");
    },

    showEmployeePostJob: function() {
        var path = "/alumni/user/employee/postJob.html";
        Alumni.showPage(path, "employee-body-div");
    },

    showEmployeeMyJobs: function() {
        var path = "/alumni/user/employee/MyJobs.html";
        Alumni.showPage(path, "employee-body-div");
    },

    showEmployeeAllJobs: function() {
        var path = "/alumni/user/employee/allJobs.html";
        Alumni.showPage(path, "employee-body-div");
    },

    showEmployeePostInternship: function() {
        var path = "/alumni/user/employee/postInternships.html";
        Alumni.showPage(path, "employee-body-div");
    },

    showEmployeeMyInternships: function() {
        var path = "/alumni/user/employee/MyInternships.html";
        Alumni.showPage(path, "employee-body-div");
    },

    showEmployeeAllInternships: function() {
        var path = "/alumni/user/employee/allInternships.html";
        Alumni.showPage(path, "employee-body-div");
    },

    showEmployeeAllEvents: function() {
        var path = "/alumni/user/employee/allEvents.html";
        Alumni.showPage(path, "employee-body-div");   
    },

    showEmployeePostVolunteership: function() {
        var path = "/alumni/user/employee/postVolunteerships.html";
        Alumni.showPage(path, "employee-body-div");
    },

    showEmployeeMyVolunteerships: function() {
        var path = "/alumni/user/employee/MyVolunteerships.html";
        Alumni.showPage(path, "employee-body-div");
    },

    showEmployeeAllVolunteerships: function() {
        var path = "/alumni/user/employee/allVolunteerships.html";
        Alumni.showPage(path, "employee-body-div");
    },

    showEmployeeChangePassword: function() {
        var path = "/alumni/mainpage/changePassword.html";
        Alumni.showPage(path, "employee-body-div");
    },

    /* Employee Dashboard End */

    /* Student Dashboard Start */

    showStudentDashboard: function() {
        window.location.href = "/alumni/student";
    },

    showStudentDashboardHome: function() {
        var path = "/alumni/user/student/dashboard.html";
        Alumni.showPage(path, "student-body-div");
    },

    showStudentAllJobs: function() {
        var path = "/alumni/user/student/allJobs.html";
        Alumni.showPage(path, "student-body-div");
    },

    showStudentAllInternships: function() {
        var path = "/alumni/user/student/allInternships.html";
        Alumni.showPage(path, "student-body-div");
    },

    showStudentAllEvents: function() {
        var path = "/alumni/user/student/allEvents.html";
        Alumni.showPage(path, "student-body-div");
    },

    showStudentAllVolunteerships: function() {
        var path = "/alumni/user/student/allVolunteerships.html";
        Alumni.showPage(path, "student-body-div");
    },

    showStudentChangePassword: function() {
        var path = "/alumni/mainpage/changePassword.html";
        Alumni.showPage(path, "student-body-div");
    },

    /* Student Dashboard End */

    /* MD Dashboard Start */

    showMDDashboard: function() {
        window.location.href = "/alumni/md";
    },

    /* MD Dashboard End*/

    /* ED Dashboard Start */

    showEDDashboard: function() {
        window.location.href = "/alumni/ed";
    },
    /* ED Dashboard End*/

    /* ED Dashboard Start */

    showCGMDashboard: function() {
        window.location.href = "/alumni/cgm";
    },
    /* ED Dashboard End*/

    showLogout: function() {

        var user_id = Alumni.getSessionValue("user_id") || "";
        Alumni.setSessionValue("username", null);
        Alumni.setSessionValue("password", null);
        Alumni.setSessionValue("roleid", null);
        Alumni.setSessionValue("page_id", 3);
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