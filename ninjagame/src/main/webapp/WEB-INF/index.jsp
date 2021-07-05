<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ninja game</title>

	    <style>
	    
	    .boxed {
	    	overflow: scroll;
			border: 1px solid green;
			font-size: 30px;
	        height: 500px;
	        width: 100%;
		}
			    
	    .red {
	    	color: red;
	    }
	    
	    .green {
	    	color: green;
	    }
        .wrapper {
            padding: 20px;
            margin: 15px 0;
        }
        .container1 {
        	  display: flex;
			  align-items: center;
			  justify-content: space-evenly;
        }
        .smallBox {
        	border: 1px solid green;
        	height: 300px;
        	width: 300px;
        	justify-content: center;
        }
 
    </style>
</head>
	
<body>
	
	<div class = "top"> 
		<h1> Your Gold: <c:out value="${gold}"/></h1>
		
		<form action = "/invalidate">
				<button> RESET! </button>
		</form>
	</div>
	<div class = "container1"> 
		<div class = "smallBox">
			<h1>Farm</h1>
			<form method="POST" action="/farm">
				<input type = "submit">
			</form>
		</div>
		
		
		<div class = "smallBox">
			<h1>Cave</h1>
			<form method="POST" action="/cave">
				<input type = "submit">
			</form>
		</div>
		
		<div class = "smallBox">
			<h1>House</h1>
			<form method="POST" action="/house">
				<input type = "submit">
			</form>
		</div>
		
		<div class = "smallBox">
			<h1>Casino!</h1>
			<form method="POST" action="/casino">
				<input type = "submit">
			</form>
		</div>
		
	</div>
	
	
	<div class = "wrapper">
	<h1>Activities: </h1>
	
		<div class = "boxed">
		
			<c:forEach items="${activities}" var="activityObject">

					<c:if test="${activityObject.gain}"> 
						<p class = "green">
							<c:out value="${activityObject.text}"/>
							<c:out value="${activityObject.date}"/>
						</p>
					</c:if>
				
					<c:if test="${!activityObject.gain}"> 
						<p class = "red">
							<c:out value="${activityObject.text}"/>
							<c:out value="${activityObject.date}"/>
						</p>
					</c:if>
					
			</c:forEach>
			
		</div>
		
	</div>
	
	
</body>
</html>