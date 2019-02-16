<%-- 
    Document   : SearchIfsc
    Created on : Feb 16, 2019, 12:44:23 PM
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
               <form action="ResultIfsc" method="POST" enctype="multipart/form-data">
        <pre>    
        IFSC     <input type="text" name="ifsc"/>
                    <input type="submit" value="Search"/>
        
        </pre>
        </form>
        
        
    </body>
</html>
