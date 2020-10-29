<%-- 
    Document   : logoff
    Created on : 29/08/2017, 19:27:24
    Author     : Home
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
<%      session.invalidate();
        response.sendRedirect(request.getContextPath()+"/index.jsp");                 
        
%>
</html>
