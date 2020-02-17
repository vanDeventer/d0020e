/*
 *  Creating a user
 */

function user_create() {
	var input = prompt("username;password");
	
	var data = input.split(";");
	
	if(data.lenght == 2) {
	
		$.ajax({
			url : 'admin',
			type : "POST",
			data : {
				head : "USER",
				method : "CREATE",
				username : data[0],
				password : data[1]
			},
			success : function(response) {
				document.getElementById("log").innerHTML += "CREATE USER " + data[0];
				document.getElementById("output").innerHTML += response + "</br>";
			}

		});
		
		
	} else {
		document.getElementById("log").innerHTML += "Invalid input : " + input  + "</br>";
	}
	
}

/*
 * Deleteing a user
 */

function user_delete() {
	var input = prompt("username");

	$.ajax({
		url : 'admin',
		type : "POST",
		data : {
			head : "USER",
			method : "DELETE",
			username : input
		},
		success : function(response) {
			document.getElementById("log").innerHTML += "DELETE USER " + input;
			document.getElementById("output").innerHTML += response + "</br>";
		}

	});
		
	
}

/*
 *  Change password for user
 */

function user_modify_password() {
	var input = prompt("username;newPassword");
	
	var data = input.split(";");
	
	if(data.length == 2 ){
		
		$.ajax({
			url : 'admin',
			type : "POST",
			data : {
				head : "USER",
				method : "MODIFY_PASSWORD",
				username : data[0],
				newpassword : data[1]
			},
			success : function(response) {
				document.getElementById("log").innerHTML += "CHANGE PASSWORD FOR USER : " + data[0] + "</br>";
				document.getElementById("output").innerHTML += response + "</br>";
			}

		});
		
	} else {
		document.getElementById("log").innerHTML += "Invalid input " + input + "</br>";
	}

}

/*
 *  Change username for user
 */
function user_modify_username() {
	var input = prompt("username;newusername");
	
	var data = input.split(";");
	
	if(data.length == 2 ){
		
		$.ajax({
			url : 'admin',
			type : "POST",
			data : {
				head : "USER",
				method : "MODIFY_USERNAME",
				username : data[0],
				newusername : data[1]
			},
			success : function(response) {
				document.getElementById("log").innerHTML += "CHANGE USERNAME FOR USER : " + data[0] +  "to :" + data[1] + "</br>";
				document.getElementById("output").innerHTML += response + "</br>";
			}

		});
		
	} else {
		document.getElementById("log").innerHTML += "Invalid input " + input + "</br>";
	}

}


/*
 * Give a user access to modify a course
 */

function user_set_course_relation() {
	var input = prompt("username;courseCode;LP(1-4);year");
	
	var data = input.split(";");
	
	if(data.length == 4 ){
		
		$.ajax({
			url : 'admin',
			type : "POST",
			data : {
				head : "USER",
				method : "SET_RELATION_TO_COURSE",
				username : data[0],
				courseCode : data[1],
				lp : data[2],
				year : data[3]
			},
			success : function(response) {
				document.getElementById("log").innerHTML += "CREATE REALATION BETWEEN USER "+ data[0] + " and the course "+ data[1] +"</br>";
				document.getElementById("output").innerHTML += response + "</br>";
			}

		});
		
	} else {
		document.getElementById("log").innerHTML += "Invalid input " + input + "</br>";
	}

}

/*
 * Remove access to modify a course from user
 */
function user_delete_course_relation() {
	var input = prompt("username;courseCode;LP(1-4);year");
	
	var data = input.split(";");
	
	if(data.length == 4 ){
		
		$.ajax({
			url : 'admin',
			type : "POST",
			data : {
				head : "USER",
				method : "DELETE_RELATION_TO_COURSE",
				username : data[0],
				courseCode : data[1],
				lp : data[2],
				year : data[3]
			},
			success : function(response) {
				document.getElementById("log").innerHTML += "DELETE REALATION BETWEEN USER "+ data[0] + " and the course "+ data[1] +"</br>";
				document.getElementById("output").innerHTML += response + "</br>";
			}

		});
		
	} else {
		document.getElementById("log").innerHTML += "Invalid input " + input + "</br>";
	}

}


// END USER FUNCTIONS


// COURSE FUNCTIONS
/*
 * Create a new course
 */
function course_create() {
	var input = prompt("coursename;coursecode;LP(1-4);year;credits;examiner;description");
	
	var data = input.split(";");
	
	if(data.length == 7 ){
		
		$.ajax({
			url : 'admin',
			type : "POST",
			data : {
				head : "COURSE",
				method : "CREATE",
				courseName : data[0],
				courseCode : data[1],
				lp : data[2],
				year : data[3],
				credits : data[4],
				examiner : data[5],
				description : data[6]
			},
			success : function(response) {
				document.getElementById("log").innerHTML += "CREATE COURSE " + data[0]  +"</br>";
				document.getElementById("output").innerHTML += response + "</br>";
			}

		});
		
	} else {
		document.getElementById("log").innerHTML += "Invalid input " + input + "</br>";
	}
}
/*
 * Modify Course
 * 
 * Don't know how to do this in a gr8 way
 */
function course_modify() {
	var input = prompt("newcoursename;coursecode;LP(1-4);year;newcredits;newexaminer;newdescription \n This was not great...");
	
	var data = input.split(";");
	
	if(data.length == 7 ){
		
		$.ajax({
			url : 'admin',
			type : "POST",
			data : {
				head : "COURSE",
				method : "MODIFY",
				courseName : data[0],
				courseCode : data[1],
				lp : data[2],
				year : data[3],
				credits : data[4],
				examiner : data[5],
				description : data[6]
			},
			success : function(response) {
				document.getElementById("log").innerHTML += "MODIFY COURSE " + data[0]  +"</br>";
				document.getElementById("output").innerHTML += response + "</br>";
			}

		});
		
	} else {
		document.getElementById("log").innerHTML += "Invalid input " + input + "</br>";
	}
}

/*
 * Delete Course
 */
function course_delete() {
	var input = prompt("courseCode;lp(1-4);year");
	
	var data = input.split(";");
	
	if(data.length == 3 ){
		
		$.ajax({
			url : 'admin',
			type : "POST",
			data : {
				head : "COURSE",
				method : "DELETE",
				courseCode : data[0],
				lp : data[1],
				year : data[2]
			},
			success : function(response) {
				document.getElementById("log").innerHTML += "DELETE COURSE with code " + data[0]  +"</br>";
				document.getElementById("output").innerHTML += response + "</br>";
			}

		});
		
	} else {
		document.getElementById("log").innerHTML += "Invalid input " + input + "</br>";
	}
}

// END COURSE FUNCTION

// KC FUNCTIONS
/*
 * Create a new course
 */
function course_create() {
	var input = prompt("coursename;coursecode;LP(1-4);year;credits;examiner;description");
	
	var data = input.split(";");
	
	if(data.length == 7 ){
		
		$.ajax({
			url : 'admin',
			type : "POST",
			data : {
				head : "COURSE",
				method : "CREATE",
				courseName : data[0],
				courseCode : data[1],
				lp : data[2],
				year : data[3],
				credits : data[4],
				examiner : data[5],
				description : data[6]
			},
			success : function(response) {
				document.getElementById("log").innerHTML += "CREATE COURSE " + data[0]  +"</br>";
				document.getElementById("output").innerHTML += response + "</br>";
			}

		});
		
	} else {
		document.getElementById("log").innerHTML += "Invalid input " + input + "</br>";
	}
}
/*
 * Modify Course
 * 
 * Don't know how to do this in a gr8 way
 */
function course_modify() {
	var input = prompt("newcoursename;coursecode;LP(1-4);year;newcredits;newexaminer;newdescription \n This was not great...");
	
	var data = input.split(";");
	
	if(data.length == 7 ){
		
		$.ajax({
			url : 'admin',
			type : "POST",
			data : {
				head : "COURSE",
				method : "MODIFY",
				courseName : data[0],
				courseCode : data[1],
				lp : data[2],
				year : data[3],
				credits : data[4],
				examiner : data[5],
				description : data[6]
			},
			success : function(response) {
				document.getElementById("log").innerHTML += "MODIFY COURSE " + data[0]  +"</br>";
				document.getElementById("output").innerHTML += response + "</br>";
			}

		});
		
	} else {
		document.getElementById("log").innerHTML += "Invalid input " + input + "</br>";
	}
}

/*
 * Delete Course
 */
function course_delete() {
	var input = prompt("courseCode;lp(1-4);year");
	
	var data = input.split(";");
	
	if(data.length == 3 ){
		
		$.ajax({
			url : 'admin',
			type : "POST",
			data : {
				head : "COURSE",
				method : "DELETE",
				courseCode : data[0],
				lp : data[1],
				year : data[2]
			},
			success : function(response) {
				document.getElementById("log").innerHTML += "DELETE COURSE with code " + data[0]  +"</br>";
				document.getElementById("output").innerHTML += response + "</br>";
			}

		});
		
	} else {
		document.getElementById("log").innerHTML += "Invalid input " + input + "</br>";
	}
}

