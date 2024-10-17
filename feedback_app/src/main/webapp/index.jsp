<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <%@ include file="comp/links.jsp" %>
  </head>
  <body>
  
    
     <div style="height:80vh" class="content_container py-4 d-flex flex-column justify-content-center align-items-center">
        <a href="<%= application.getContextPath()%>/feedback.jsp" class="btn btn-light" >Give us Feedback</a>
    </div>
    
    
    <%@include file="script.jsp" %>
  </body>
</html>	