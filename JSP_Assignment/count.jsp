<%@ page import = "java.io.*,java.util.*" %>

<html>
   <head>
      <title>Application object in JSP</title>
   </head>
   
   <body>
      <ul>
         <li><p><b>Name:</b>
            <%= request.getParameter("name")%>
         </p></li>
         <li><p><b>Age:</b>
            <%= request.getParameter("age")%>
         </p></li>
      </ul>
      <%
         Integer count = (Integer)application.getAttribute("hitCounter");
         if( count ==null || count == 0 ) {
            out.println("Welcome!");
            count = 1;
         } else {
            out.println("Welcome back!");
            count += 1;
         }
         application.setAttribute("hitCounter", count);
      %>
         <p>Number of times page accessed: <%= count%></p>
   
   </body>
</html>