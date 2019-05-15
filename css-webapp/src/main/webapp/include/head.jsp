<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Rezerwacja samochodów">
        <meta name="keywords" content="samochód, rezerwacja">
        <meta name="author" content="CSS Group">
        <meta http-equiv="X-Ua-Compatible" content="IE=edge">
    
        <title>CarSharingSystem - <%= request.getParameter("title") %></title>
    
        <!-- Styles - Bootstrap core and custom -->
        <link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">
        <script type="text/javascript" src="${pageContext.request.contextPath}/vendor/scripts/navactive.js"></script>
</head>