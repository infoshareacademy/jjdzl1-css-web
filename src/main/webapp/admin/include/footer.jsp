<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
        java.util.Date date = new java.util.Date();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
%>
<footer class="container-fluid w-100 py-2 bg-dark">
        <div class="container">
                <p class="m-0 text-center text-white"><img src="../img/css-logo.png" width="35" height="35" class="d-inline-block mr-1" alt=""> Copyright &copy; 2018-<%= thisYear %> by <b>CSS Group</b></p>
        </div>
        <!-- /.container -->
</footer>