<%-- 
    Document   : SearchName
    Created on : Feb 16, 2019, 12:45:53 PM
    Author     : manoj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
           <form action="ResultName" method="POST" enctype="multipart/form-data">
        <pre>    
         Name     <input type="text" name="name"/>
         City     <input type="text" name="city"/>
                    <input type="submit" value="Search"/>
        
        </pre>
        </form>    
        
        
    </body>
</html>
