<link  rel="stylesheet" href="${pageContext.request.contextPath}/CssFolder/courseInformation.css" id = "courseInformationCSS_visible">
<script src="JavascriptFolder/courseInformation.js"></script>

<div id="courseInformation">
    <div class="header">
        <h1 id="courseInformation.courseName">NULL</h1>
        <button id="closeCourseButton" type="button" onclick="hideCourseInfo()">close</button>
    </div>
    <div class="container">
        <div id="courseInfoScreen">
            <h1>
                Description:
            </h1>
            <p id="courseInformation.description">NULL</p>
            <h1>
                Examiner:
            </h1>
            <p id="courseInformation.examiner">NULL</p>
            <h1>
                Credits:
            </h1>
            <p id="courseInformation.credit">7</p>
            <h1>Course code: </h1>
            <p id="courseInformation.courseCode">NULL</p>
        </div>
        <div id="courseKCList">
            <p>NULL</p>
        </div>
    </div>
    
</div>

<button type="button" onclick="showCourseInfo()"> Show course</button>

