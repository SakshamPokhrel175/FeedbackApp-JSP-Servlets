<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <%@ include file="comp/links.jsp" %>
  </head>
  <body>
  <%@include file="header.jsp" %>
    
    <div class="content_container py-4 d-flex flex-column justify-content-center align-items-center">
        
        <h3 class="text-white">Fill the feedback form</h3>

		<form id="feedbackForm" action="<%= application.getContextPath()%>/feedbackservlet" method="post" class="mt-3 text-white">
			<div class="mb-3">
				<!--Email  -->
				<label for="exampleInputEmail1" class="form-label">Email
					address</label> 
					<input type="email" name="email" placeholder="Enter here" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp" required>
				<div id="emailHelp" class="form-text text-white">We'll never share your
					email with anyone else.</div>
			</div>
			<!--COntact  -->
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Phone Number</label>
				<input type="number" name="phone" placeholder="Enter here" class="form-control"
					id="exampleInputPassword1" required>
			</div>
			
			<!--Message  -->
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Your feedback Message</label>
				<textarea rows="10" cols="" name="feedback_message" placeholder="Enter here" class="form-control" required></textarea>
			</div>
			
			<div class="container text-center">
				<button type="submit" class="btn btn-warning">Submit</button>
				<button type="reset" class="btn btn-light">Reset</button>
			</div>
			
		</form>


	</div>
    
    
    <%@include file="script.jsp" %>
  </body>
</html>	