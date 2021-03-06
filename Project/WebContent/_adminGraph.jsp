<script src="https://unpkg.com/konva@4.1.6/konva.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin_graph_javascript/kAnvas.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin_graph_javascript/types.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin_graph_javascript/functions.js"></script>


<style>

#outerContainer {
	display: none;  /* This must be set to flex when visible. */
}
#GKcontainer {
    background-color: #e0e0e0;
    width: 80%;
    height: 80%;
    position: fixed;
    left: 50%;
    top: 50%;
    transform: translateX(-50%) translateY(-50%);
    flex-flow: column;
    overflow: auto;
    border-radius: 50pt;
  	z-index: 1;
}

#closeBtn {
    position: fixed;
    top: 0;
    right: 50pt;
    width:50pt;
}
#saveBtn {
    position: fixed;
    top: 0;
    right: 150pt;
    width: 50pt;
}

button {
	min-width:0;
}

.container-fluid button {
	min-width: 300;
}

</style>

<div class="container" id="outerContainer">
	
	
		<div class="container" id="GKcontainer">
			<div class="row" style="margin-left:50px;">
				<div id="lost_kcs"></div>
			</div> <div class="row" style="margin-left:50px;">
				<div id="kc_info" style="margin-left:50px;"> </br> </div>
			</div> 
			<div class="row">
				<div id="g_container" class="container" style="overflow-x: scroll;overflow-y: scroll; max-width: 2000px; max-height: 800px;"></div>
				 
				<div id="command_log" style:"display:none;"></div>   
				<button id="saveBtn" class="btn btn-primary" onclick="save()" action="post">Save</button> 
				<button id="closeBtn" class="btn btn-danger" onclick="hideit()">Cancel</button>
			</div>
		</div>
	
</div>
    
<script>
/*
 * 
 */

function hideit() {
	document.getElementById("command_log").innerHTML = "";
	document.getElementById("outerContainer").style.display = "none";
	
	if(window.state !== "undefined") {
		window.stage.destroyChildren();
	}
	
	window.data = new Object();
	window.initialized = false;
}

function save() {
	
	
	
	var str = document.getElementById("command_log").innerHTML;
	
	var arr = str.split(";;;");
	
	console.log(arr);
	
	for(var i = 0; i < arr.length -1; i++) {
		t = arr[i].split(";");
		
		console.log(t);
		
		if(t[0] == "ADD") {
			GKaddCourse(t[1], t[2], t[3]);
		} else if(t[0] == "DELETE") {
			GKdeleteCourse(t[1], t[2], t[3]);
		}
	}
	
	hideit();
}

function GKaddCourse(courseCode, courseYear, courseLp) {
	
	if(courseLp == "ONE") {
		courseLp = 1;
	} else if(courseLp == "TWO") {
		courseLp = 2;
	} else if(courseLp == "THREE") {
		courseLp = 3;
	} else if(courseLp == "FOUR") {
		courseLp = 4;
	} 
	
	var pLP = 1;
	if(window.program.lp == "ONE") {
		pLP = 1;
	} else if(window.program.lp == "TWO") {
		pLP = 2;
	} else if(window.program.lp == "THREE") {
		pLP = 3;
	} else if(window.program.lp == "FOUR") {
		pLP = 4;
	} 
	
	$.ajax({
		url : 'admin',
		type : "POST",
		data : {
			head : "PROGRAM",
			method : "ADD_COURSE",
			programCode : window.program.code,
			programStartYear : window.program.year,
			programStartLP : pLP,
			courseCode : courseCode,
			courseYear : courseYear,
			courseLP : courseLp
			
		},
		success : function(response) {
			document.getElementById("log").innerHTML += "ADD COURSE " + courseCode + " TO PROGRAM " + window.program.code  +"</br>";
			document.getElementById("output").innerHTML += response + "</br>";
		}

	});
}

function GKdeleteCourse(courseCode, courseYear, courseLp) {
	
	if(courseLp == "ONE") {
		courseLp = 1;
	} else if(courseLp == "TWO") {
		courseLp = 2;
	} else if(courseLp == "THREE") {
		courseLp = 3;
	} else if(courseLp == "FOUR") {
		courseLp = 4;
	} 
	
	var pLP = 1;
	if(window.program.lp == "ONE") {
		pLP = 1;
	} else if(window.program.lp == "TWO") {
		pLP = 2;
	} else if(window.program.lp == "THREE") {
		pLP = 3;
	} else if(window.program.lp == "FOUR") {
		pLP = 4;
	} 
	
	$.ajax({
		url : 'admin',
		type : "POST",
		data : {
			head : "PROGRAM",
			method : "REMOVE_COURSE",
			programCode : window.program.code,
			programStartYear : window.program.year,
			programStartLP : pLP,
			courseCode : courseCode,
			courseYear : courseYear,
			courseLP : courseLp
			
		},
		success : function(response) {
			document.getElementById("log").innerHTML += "REMOVE COURSE " + courseCode + " FROM PROGRAM " + window.program.code  +"</br>";
			document.getElementById("output").innerHTML += response + "</br>";
		}

	});
}


function graphModifyCourse() {
	var input = prompt("programCode;year;lp");
	
	var data = input.split(";");
	
	if(data.length == 3) {
	
		$.ajax({
			url : '/GetProgram/getCourses',
			type : "GET",
			data : {
				code : data[0],
				startyear : data[1],
				startperiod : data[2]
			},
			success : function(response) {
				//document.getElementById("log").innerHTML += "Read in program " + data[0] + "</br>";
				//document.getElementById("output").innerHTML += response + "</br>";
				
				console.log("type of response = " + typeof response);
				readIn(response);
			}

		});
		
		
	} else {
		document.getElementById("log").innerHTML += "Invalid input : " + input  + "</br>";
	}
	
}

</script>